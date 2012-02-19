package org.ihtsdo.lucene;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.FieldInvertState;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.search.DefaultSimilarity;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Similarity;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.temp.AceLog;
import org.ihtsdo.temp.SearchResult;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.*;

public abstract class LuceneManager {
   protected static DescriptionIndexGenerator descIndexer   = null;
   public final static Version                version       = Version.LUCENE_30;
   private static ReentrantReadWriteLock      rwl           = new ReentrantReadWriteLock();
   private static Semaphore                   initSemaphore = new Semaphore(1);
   public static Directory                    descLuceneMutableDir;
   public static Directory                    descLuceneReadOnlyDir;
   protected static ParallelMultiSearcher     descSearcher;
   protected static IndexWriter               descWriter;

   //~--- methods -------------------------------------------------------------

   public static void close() {
      ParallelMultiSearcher searcher;
      IndexWriter           writer;

      writer   = descWriter;
      searcher = descSearcher;

      // Only do if not first time called
      if (searcher != null) {
         try {
            searcher.close();
            searcher = null;
         } catch (Throwable e) {
            AceLog.getAppLog().alertAndLogException(e);
         }
      }

      if (writer != null) {
         try {
            writer.commit();
            writer.close(true);
            writer = null;
         } catch (Throwable e) {
            AceLog.getAppLog().alertAndLogException(e);
         }
      }

      descWriter   = writer;
      descSearcher = searcher;
   }

   public static void createLuceneIndex() throws Exception {
      createLuceneIndex(null);
   }

   public static void createLuceneIndex(ViewCoordinate viewCoord) throws Exception {
      IndexWriter writer;

      Similarity.setDefault(new ShortTextSimilarity());
      init();
      writer = descWriter;

      if (writer == null) {
         DescriptionLuceneManager.descLuceneMutableDirFile.mkdirs();
         descLuceneMutableDir = setupWriter(DescriptionLuceneManager.descLuceneMutableDirFile,
                                            descLuceneMutableDir);
      }

      writer.setUseCompoundFile(true);
      writer.setMergeFactor(15);
      writer.setMaxMergeDocs(Integer.MAX_VALUE);
      writer.setMaxBufferedDocs(1000);
      descIndexer = new DescriptionIndexGenerator(writer);
      Bdb.getConceptDb().iterateConceptDataInSequence(descIndexer);
      writer.optimize();
      writer.commit();
   }

   public static boolean indexExists() {
      return DescriptionLuceneManager.descLuceneMutableDirFile.exists();
   }

   public static void init() throws IOException {

      // Only do if not first time
      if (descLuceneReadOnlyDir == null) {
         initSemaphore.acquireUninterruptibly();

         try {
            if (descLuceneReadOnlyDir == null) {
               descLuceneReadOnlyDir = initDirectory(DescriptionLuceneManager.descLuceneReadOnlyDirFile,
                       false);
            }
         } finally {
            initSemaphore.release();
         }
      }

      if (descLuceneMutableDir == null) {
         initSemaphore.acquireUninterruptibly();

         try {
            if (descLuceneMutableDir == null) {
               descLuceneMutableDir = initDirectory(DescriptionLuceneManager.descLuceneMutableDirFile, true);
            }
         } finally {
            initSemaphore.release();
         }
      }
   }

   private static Directory initDirectory(File luceneDirFile, boolean mutable)
           throws IOException, CorruptIndexException, LockObtainFailedException {
      Directory luceneDir;

      if (luceneDirFile.exists()) {
         luceneDir = new SimpleFSDirectory(luceneDirFile);

         if (mutable) {
            setupWriter(luceneDirFile, luceneDir);
         }
      } else {
         luceneDirFile.mkdirs();
         luceneDir = new SimpleFSDirectory(luceneDirFile);

         if (mutable) {
            setupWriter(luceneDirFile, luceneDir);
         }
      }

      return luceneDir;
   }

   public static SearchResult search(Query q) throws CorruptIndexException, IOException {
      ParallelMultiSearcher searcherCopy;
      ParallelMultiSearcher searcher;

      init();

      int matchLimit = getMatchLimit();

      rwl.readLock().lock();

      try {
         searcherCopy = descSearcher;
         searcher     = descSearcher;

         if (searcherCopy == null) {
            IndexSearcher readOnlySearcher = null;

            try {
               readOnlySearcher = new IndexSearcher(IndexReader.open(descLuceneReadOnlyDir));
            } catch (java.io.FileNotFoundException e) {

               // ignore not accesible readonly
            }

            if (readOnlySearcher != null) {
               readOnlySearcher.setSimilarity(new ShortTextSimilarity());

               IndexSearcher mutableSearcher = new IndexSearcher(IndexReader.open(descLuceneMutableDir));

               mutableSearcher.setSimilarity(new ShortTextSimilarity());
               searcherCopy = new ParallelMultiSearcher(readOnlySearcher, mutableSearcher);
               searcherCopy.setSimilarity(new ShortTextSimilarity());
               descSearcher = searcherCopy;
            } else {
               IndexSearcher mutableSearcher = new IndexSearcher(IndexReader.open(descLuceneMutableDir));

               mutableSearcher.setSimilarity(new ShortTextSimilarity());
               searcherCopy = new ParallelMultiSearcher(mutableSearcher);
               searcherCopy.setSimilarity(new ShortTextSimilarity());
               descSearcher = searcherCopy;
            }
         }

         TopDocs topDocs = searcherCopy.search(q, null, matchLimit);

         // Suppress duplicates in the read-only index
         List<ScoreDoc>   newDocs    = new ArrayList<ScoreDoc>(topDocs.scoreDocs.length);
         HashSet<Integer> ids        = new HashSet<Integer>(topDocs.scoreDocs.length);
         String           searchTerm = "dnid";

         searcher = searcherCopy;

         for (ScoreDoc sd : topDocs.scoreDocs) {
            int index = searcherCopy.subSearcher(sd.doc);

            if (index == 1) {
               newDocs.add(sd);

               Document d   = searcher.doc(sd.doc);
               int      nid = Integer.parseInt(d.get(searchTerm));

               ids.add(nid);
            }
         }

         for (ScoreDoc sd : topDocs.scoreDocs) {
            int index = searcherCopy.subSearcher(sd.doc);

            if (index == 0) {
               Document d   = searcher.doc(sd.doc);
               int      nid = Integer.parseInt(d.get(searchTerm));

               if (!ids.contains(nid)) {
                  newDocs.add(sd);
               }
            }
         }

         // Lucene match explainer code, useful to tweak the lucene score, uncomment for debug purposes only
//       for (ScoreDoc sd : newDocs) {
//          Document d = searcher.doc(sd.doc);
//          I_DescriptionVersioned desc = null;
//          try {
//             desc = Terms.get().getDescription(Integer.valueOf(d.get("dnid")), 
//                   Integer.valueOf(d.get("cnid")));
//          } catch (NumberFormatException e) {
//             e.printStackTrace();
//          } catch (TerminologyException e) {
//             e.printStackTrace();
//          }
//          if (desc != null) {
//             System.out.println("-------------------------" + desc.getText());
//          } else {
//             System.out.println("------------------------- Null");
//          }
//          System.out.println(searcher.explain(q,sd.doc).toString());
//       }
         topDocs.scoreDocs = newDocs.toArray(new ScoreDoc[newDocs.size()]);
         topDocs.totalHits = topDocs.scoreDocs.length;

         return new SearchResult(topDocs, searcherCopy);
      } finally {
         rwl.readLock().unlock();
      }
   }

   protected static Directory setupWriter(File luceneDirFile, Directory luceneDir)
           throws IOException, CorruptIndexException, LockObtainFailedException {
      if (luceneDir == null) {
         luceneDir = new SimpleFSDirectory(luceneDirFile);
      }

      luceneDir.clearLock("write.lock");

      IndexWriter writer;

      if (new File(luceneDirFile, "segments.gen").exists()) {
         writer = new IndexWriter(luceneDir, new StandardAnalyzer(version), false, MaxFieldLength.UNLIMITED);
      } else {
         writer = new IndexWriter(luceneDir, new StandardAnalyzer(version), true, MaxFieldLength.UNLIMITED);
      }

      descWriter = writer;
      descWriter.setSimilarity(new ShortTextSimilarity());

      return luceneDir;
   }

   public static void writeToLucene(Collection items) throws IOException {
      writeToLucene(items, null);
   }

   public static synchronized void writeToLucene(Collection items, ViewCoordinate viewCoord)
           throws IOException {
      init();

      try {
         rwl.writeLock().lock();
         DescriptionLuceneManager.writeToLuceneNoLock(items);
      } catch (IOException e) {
         throw new IOException(e);
      } finally {
         rwl.writeLock().unlock();
      }
   }

   //~--- get methods ---------------------------------------------------------

   public static int getMatchLimit() {
      return DescriptionLuceneManager.matchLimit;
   }

   //~--- set methods ---------------------------------------------------------

   public static void setLuceneRootDir(File root) {
      ParallelMultiSearcher searcher;
      IndexWriter           writer;

      DescriptionLuceneManager.descLuceneMutableDirFile = new File(root,
              DescriptionLuceneManager.descMutableDirectorySuffix);
      DescriptionLuceneManager.descLuceneReadOnlyDirFile = new File(root,
              DescriptionLuceneManager.descReadOnlyDirectorySuffix);
      searcher = descSearcher;
      writer   = descWriter;

      if (writer != null) {
         try {
            writer.close(true);
         } catch (CorruptIndexException ex) {
            throw new RuntimeException(ex);
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }

         writer = null;
      }

      if (searcher != null) {
         try {
            searcher.close();
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }

         searcher = null;
      }

      descLuceneMutableDir  = null;
      descLuceneReadOnlyDir = null;
   }

   public static void setMatchLimit(int limit) {
      DescriptionLuceneManager.matchLimit = limit;
   }

   //~--- inner classes -------------------------------------------------------

   protected static class ShortTextSimilarity extends DefaultSimilarity {
      public ShortTextSimilarity() {}

      //~--- methods ----------------------------------------------------------

        @Override
      public float computeNorm(String field, FieldInvertState state) {
         return (float) (1.0 / (state.getLength() * 5));
      }

        @Override
      public float coord(int overlap, int maxOverlap) {
         return 1.0f;
      }

        @Override
      public float idf(int docFreq, int numDocs) {
         return (float) 1.0;
      }

        @Override
      public float tf(float freq) {
         return 1.0f;
      }

        @Override
      public float tf(int freq) {
         return 1.0f;
      }
   }
}
