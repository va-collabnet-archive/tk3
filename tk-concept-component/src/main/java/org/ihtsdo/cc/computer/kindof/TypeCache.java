package org.ihtsdo.cc.computer.kindof;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.cc.P;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.concept.ConceptVersion;
import org.ihtsdo.tk.api.ConceptFetcherBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.KindOfCacheBI;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.NidSet;
import org.ihtsdo.tk.api.NidSetBI;
import org.ihtsdo.tk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.tk.api.RelAssertionType;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.io.Serializable;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class TypeCache
        implements ProcessUnfetchedConceptDataBI, Runnable, KindOfCacheBI, Serializable {
   private static int            cacheCount = 1;
   protected static final Logger logger     = Logger.getLogger(TypeCache.class.getName());

   //~--- fields --------------------------------------------------------------

   protected int                               maxSubtypeIterations = 500;
   private boolean                             ready                = false;
   private transient CountDownLatch            latch                = new CountDownLatch(1);
   private boolean                             cancelled            = false;
   protected ViewCoordinate                    coordinate;
   protected ViewCoordinate                    inferredThenStatedViewCoordinate;
   protected ViewCoordinate                    inferredViewCoordinate;
   protected ViewCoordinate                    statedViewCoordinate;
   protected ConcurrentHashMap<Integer, int[]> typeMap;
   protected NidSetBI                          types;

   //~--- constructors --------------------------------------------------------

   public TypeCache() {
      super();
   }

   //~--- methods -------------------------------------------------------------

   public void addParents(int cNid, NidBitSetBI parentNidSet) {
      int[] parents = typeMap.get(cNid);

      if (parents != null) {
         for (int parentNid : parents) {
            if (!parentNidSet.isMember(parentNid)) {
               parentNidSet.setMember(parentNid);
               addParents(parentNid, parentNidSet);
            }
         }
      }
   }

   @Override
   public boolean continueWork() {
      return true;
   }

   @Override
   public abstract void processUnfetchedConceptData(int cNid, ConceptFetcherBI fcfc) throws Exception;

   @Override
   public void run() {
      int cacheNum = cacheCount++;

      logger.log(Level.INFO, "Starting cache setup: {0} {1}", new Object[] { cacheNum,
              this.getClass().getSimpleName() });

      long startTime = System.currentTimeMillis();

      try {
         P.s.iterateConceptDataInParallel(this);
      } catch (Exception e) {
         logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
         TypeCache.this.cancelled = true;
      }

      latch.countDown();
      ready = !cancelled;

      long elapsedTime = System.currentTimeMillis() - startTime;

      logger.log(Level.INFO, "Finished cache setup: {0} in: {1}", new Object[] { cacheNum, elapsedTime });
   }

   /*
    * (non-Javadoc) @see
    * org.ihtsdo.db.bdb.computer.kindof.I_CacheKindOfRels#setup(org.ihtsdo.tk.api.Coordinate)
    */
   @Override
   public void setup(ViewCoordinate coordinate) throws Exception {
      this.coordinate                       = coordinate;
      this.statedViewCoordinate             = new ViewCoordinate(UUID.randomUUID(), "tempStatedVc", coordinate);
      this.inferredViewCoordinate           = new ViewCoordinate(UUID.randomUUID(), "tempInferredVc", coordinate);
      this.inferredThenStatedViewCoordinate = new ViewCoordinate(UUID.randomUUID(),
              "tempInferredThenStatedVc", coordinate);
      this.statedViewCoordinate.setRelAssertionType(RelAssertionType.STATED);
      this.inferredViewCoordinate.setRelAssertionType(RelAssertionType.INFERRED);
      this.inferredThenStatedViewCoordinate.setRelAssertionType(RelAssertionType.INFERRED_THEN_STATED);
      this.types = coordinate.getIsaTypeNids();
      typeMap    = new ConcurrentHashMap<>(P.s.getConceptCount());
      KindOfComputer.kindOfComputerService.execute(this);
   }

   @Override
   public void updateCache(ConceptChronicleBI c) throws IOException, ContradictionException {
      boolean        inferredChanges = false;
      ConceptVersion civ             = new ConceptVersion((Concept) c, inferredViewCoordinate);

      for (RelationshipChronicleBI loopRel : civ.getRelsOutgoing()) {
         if (loopRel.isUncommitted()) {
            inferredChanges = true;

            break;
         }
      }

      if (inferredChanges) {
         updateCacheUsingInferredThenStatedView(c);
      } else {
         updateCacheUsingStatedView(c);
      }
   }

   protected void updateCacheUsingInferredThenStatedView(ConceptChronicleBI c)
           throws IOException, ContradictionException {
      ConceptVersion cv        = new ConceptVersion((Concept) c, inferredThenStatedViewCoordinate);
      NidSet         parentSet = new NidSet();

      for (RelationshipVersionBI<?> relv : cv.getRelsOutgoingActive()) {
         if (types.contains(relv.getTypeNid())) {
            parentSet.add(relv.getDestinationNid());
         }
      }

      typeMap.put(c.getNid(), parentSet.getSetValues());
   }

   protected void updateCacheUsingStatedView(ConceptChronicleBI c)
           throws IOException, ContradictionException {
      ConceptVersion cv        = new ConceptVersion((Concept) c, statedViewCoordinate);
      NidSet         parentSet = new NidSet();

      for (RelationshipVersionBI<?> relv : cv.getRelsOutgoingActive()) {
         if (types.contains(relv.getTypeNid())) {
            parentSet.add(relv.getDestinationNid());
         }
      }

      typeMap.put(c.getNid(), parentSet.getSetValues());
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public CountDownLatch getLatch() {
      if (latch == null) {
         latch = new CountDownLatch(0);
      }

      return latch;
   }

   public boolean isCancelled() {
      return cancelled;
   }

   /*
    * (non-Javadoc) @see org.ihtsdo.db.bdb.computer.kindof.I_CacheKindOfRels#isKindOf(int, int)
    */
   @Override
   public boolean isKindOf(int childNid, int parentNid) throws Exception {
      int     subtypeIterations = 0;
      boolean result            = isKindOfNoLatch(childNid, parentNid, subtypeIterations);

      cancelled = false;

      return result;
   }

   protected boolean isKindOfNoLatch(int childNid, int parentNid, int subtypeIterations) {
      if (!cancelled) {
         if (childNid == parentNid) {
            return true;
         }

         subtypeIterations++;

         if (subtypeIterations >= maxSubtypeIterations) {
            cancelled = true;

            String message = "Infinite loop prevented. [TypeCache] Cause: "
                             + "Existing cycle between childNid==" + childNid + " parentNid==" + parentNid;

            logger.log(Level.SEVERE, message, new Exception(message));

            return false;
         }

         int[] parents = (int[]) typeMap.get(childNid);

         if (parents != null) {
            for (int pNid : parents) {
               if (isKindOfNoLatch(pNid, parentNid, subtypeIterations)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean isReady() {
      return ready;
   }

   //~--- set methods ---------------------------------------------------------

   public void setCancelled(boolean cancelled) {
      this.cancelled = cancelled;
   }
}
