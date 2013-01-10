package org.ihtsdo.ttk.cacco.cc.lucene;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.apache.lucene.index.MergePolicy;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.NidBitSetItrBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.cacco.cc.P;
import org.ihtsdo.ttk.cacco.cc.component.IdentifierSet;
import org.ihtsdo.ttk.cacco.cc.concept.Concept;
import org.ihtsdo.ttk.cacco.cc.description.Description;
import org.ihtsdo.ttk.helpers.thread.NamedThreadFactory;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class LuceneManager {
    protected static final Logger              logger              = Logger.getLogger(Concept.class.getName());
    private static NidBitSetBI                 uncommittedDescNids = new IdentifierSet();
    protected static DescriptionIndexGenerator descIndexer         = null;
    public final static Version                version             = Version.LUCENE_40;
    private static ReentrantReadWriteLock      rwl                 = new ReentrantReadWriteLock();
    private static Semaphore                   initSemaphore       = new Semaphore(1);
    private static Semaphore                   luceneWriterPermit  = new Semaphore(50);
    private static ExecutorService             luceneWriterService =
        Executors.newFixedThreadPool(1, new NamedThreadFactory(new ThreadGroup("Lucene group"), "Lucene writer"));
    public static Directory        descLuceneMutableDir;
    public static Directory        descLuceneReadOnlyDir;
    protected static IndexSearcher descSearcher;
    protected static IndexWriter   descWriter;

    public static void commitDescriptionsToLucene() throws InterruptedException {
        luceneWriterPermit.acquire();

        IdentifierSet descNidsToCommit = new IdentifierSet((IdentifierSet) uncommittedDescNids);

        uncommittedDescNids.clear();
        luceneWriterService.execute(new DescLuceneWriter(descNidsToCommit));
    }

    public static void commitDescriptionsToLucene(Concept c) throws InterruptedException, IOException {
        luceneWriterPermit.acquire();

        IdentifierSet descNidsToCommit = new IdentifierSet();

        for (int dnid : c.getDescriptionNids()) {
            descNidsToCommit.setMember(dnid);
            uncommittedDescNids.setNotMember(dnid);
        }

        luceneWriterService.execute(new DescLuceneWriter(descNidsToCommit));
    }

    public static void addUncommittedDescNid(int dNid) {
        uncommittedDescNids.setMember(dNid);
    }

    public static void close() {
        IndexSearcher searcher;
        IndexWriter   writer;

        writer   = descWriter;
        searcher = descSearcher;

        // Only do if not first time called
        if (searcher != null) {
            try {
                searcher.getIndexReader().close();
                searcher = null;
            } catch (Throwable e) {
                logger.log(Level.SEVERE, "Exception during lucene searcher close", e);
            }
        }

        if (writer != null) {
            try {
                writer.commit();
                writer.close(true);
                writer = null;
            } catch (Throwable e) {
                logger.log(Level.SEVERE, "Exception during lucene writer close", e);
            }
        }

        descWriter   = writer;
        descSearcher = searcher;
        logger.info("Shutting down luceneWriterService.");
        luceneWriterService.shutdown();
        logger.info("Awaiting termination of luceneWriterService.");

        try {
            luceneWriterService.awaitTermination(90, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }
    }

    public static void createLuceneIndex() throws Exception {
        createLuceneIndex(null);
    }

    public static void createLuceneIndex(ViewCoordinate viewCoord) throws Exception {
        IndexWriter writer;

        init();
        writer = descWriter;

        if (writer == null) {
            DescriptionLuceneManager.descLuceneMutableDirFile.mkdirs();
            descLuceneMutableDir = setupWriter(DescriptionLuceneManager.descLuceneMutableDirFile, descLuceneMutableDir);
        }

        descIndexer = new DescriptionIndexGenerator(writer);
        P.s.iterateConceptDataInSequence(descIndexer);
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
                    descLuceneReadOnlyDir = initDirectory(DescriptionLuceneManager.descLuceneReadOnlyDirFile, false);
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
        IndexSearcher searcherCopy;
        IndexSearcher searcher;

        init();

        int matchLimit = getMatchLimit();

        rwl.readLock().lock();

        try {
            searcherCopy = descSearcher;

            IndexReader    readOnlySearcher = null;
            TtkMultiReader mr               = null;

            if (searcherCopy == null) {
                try {
                    readOnlySearcher = DirectoryReader.open(descLuceneReadOnlyDir);
                } catch (java.io.FileNotFoundException e) {

                    // ignore not accesible readonly
                }

                if (readOnlySearcher != null) {
                    IndexReader mutableSearcher = DirectoryReader.open(descLuceneMutableDir);

                    mr           = new TtkMultiReader(readOnlySearcher, mutableSearcher);
                    searcherCopy = new IndexSearcher(mr);
                    searcherCopy.setSimilarity(new ShortTextSimilarity());
                    descSearcher = searcherCopy;
                } else {
                    IndexSearcher mutableSearcher = new IndexSearcher(DirectoryReader.open(descLuceneMutableDir));

                    searcherCopy = mutableSearcher;
                    searcherCopy.setSimilarity(new ShortTextSimilarity());
                    descSearcher = searcherCopy;
                }
            }

            TopDocs topDocs = searcherCopy.search(q, null, matchLimit);

            // Suppress duplicates in the read-only index
            List<ScoreDoc>   newDocs    = new ArrayList<>(topDocs.scoreDocs.length);
            HashSet<Integer> ids        = new HashSet<>(topDocs.scoreDocs.length);
            String           searchTerm = "dnid";

            searcher = searcherCopy;

            if (mr != null) {
                for (ScoreDoc sd : topDocs.scoreDocs) {
                    if (!mr.isFirstIndex(sd.doc)) {
                        newDocs.add(sd);

                        Document d   = searcher.doc(sd.doc);
                        int      nid = Integer.parseInt(d.get(searchTerm));

                        ids.add(nid);
                    }
                }
            }

            for (ScoreDoc sd : topDocs.scoreDocs) {
                if ((mr == null) || mr.isFirstIndex(sd.doc)) {
                    Document d   = searcher.doc(sd.doc);
                    int      nid = Integer.parseInt(d.get(searchTerm));

                    if (!ids.contains(nid)) {
                        newDocs.add(sd);
                    }
                }
            }

            // Lucene match explainer code, useful to tweak the lucene score, uncomment for debug purposes only
//          for (ScoreDoc sd : newDocs) {
//             Document d = searcher.doc(sd.doc);
//             I_DescriptionVersioned desc = null;
//             try {
//                desc = Terms.get().getDescription(Integer.valueOf(d.get("dnid")), 
//                      Integer.valueOf(d.get("cnid")));
//             } catch (NumberFormatException e) {
//                e.printStackTrace();
//             } catch (TerminologyException e) {
//                e.printStackTrace();
//             }
//             if (desc != null) {
//                System.out.println("-------------------------" + desc.getText());
//             } else {
//                System.out.println("------------------------- Null");
//             }
//             System.out.println(searcher.explain(q,sd.doc).toString());
//          }
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

        IndexWriter       writer;
        IndexWriterConfig config      = new IndexWriterConfig(version, new StandardAnalyzer(version));
        MergePolicy       mergePolicy = new LogByteSizeMergePolicy();

        config.setMergePolicy(mergePolicy);
        config.setSimilarity(new ShortTextSimilarity());

        if (new File(luceneDirFile, "segments.gen").exists()) {
            writer = new IndexWriter(luceneDir, config);
        } else {
            writer = new IndexWriter(luceneDir, config);
        }

        descWriter = writer;

        return luceneDir;
    }

    public static void writeToLucene(Collection items) throws IOException {
        writeToLucene(items, null);
    }

    public static synchronized void writeToLucene(Collection items, ViewCoordinate viewCoord) throws IOException {
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

    public static int getMatchLimit() {
        return DescriptionLuceneManager.matchLimit;
    }

    public static void setLuceneRootDir(File root) throws IOException {
        IndexSearcher searcher;
        IndexWriter   writer;

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
        }

        if (searcher != null) {
            searcher.getIndexReader().close();
        }

        descLuceneMutableDir  = null;
        descLuceneReadOnlyDir = null;
    }

    public static void setMatchLimit(int limit) {
        DescriptionLuceneManager.matchLimit = limit;
    }

    private static class DescLuceneWriter implements Runnable {
        private int           batchSize = 200;
        private IdentifierSet descNidsToWrite;

        public DescLuceneWriter(IdentifierSet descNidsToCommit) {
            super();
            this.descNidsToWrite = descNidsToCommit;
        }

        @Override
        public void run() {
            try {
                ArrayList<Description> toIndex = new ArrayList<>(batchSize + 1);
                NidBitSetItrBI         idItr   = descNidsToWrite.iterator();
                int                    count   = 0;

                while (idItr.next()) {
                    count++;

                    Description d = (Description) P.s.getComponent(idItr.nid());

                    toIndex.add(d);

                    if (count > batchSize) {
                        count = 0;
                        LuceneManager.writeToLucene(toIndex);
                        toIndex = new ArrayList<>(batchSize + 1);
                    }
                }

                LuceneManager.writeToLucene(toIndex);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
            }

            luceneWriterPermit.release();
        }
    }


    protected static class ShortTextSimilarity extends DefaultSimilarity {
        public ShortTextSimilarity() {}

        @Override
        public float coord(int overlap, int maxOverlap) {
            return 1.0f;
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
