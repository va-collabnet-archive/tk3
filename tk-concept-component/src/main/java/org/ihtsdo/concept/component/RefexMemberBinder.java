package org.ihtsdo.concept.component;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.concept.component.refex.RefexMemberFactory;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;


import org.ihtsdo.concept.Concept;
import org.ihtsdo.concept.I_BindConceptComponents;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import org.ihtsdo.cc.P;
import org.ihtsdo.concept.component.refex.RefexMember;
import org.ihtsdo.concept.component.refex.RefexRevision;

public class RefexMemberBinder extends TupleBinding<Collection<RefexMember<?, ?>>>
        implements I_BindConceptComponents {
   public static AtomicInteger encountered                   = new AtomicInteger();
   public static AtomicInteger written                       = new AtomicInteger();
   private static int          maxReadOnlyStatusAtPositionId = P.s.getMaxReadOnlySap();

   //~--- fields --------------------------------------------------------------

   RefexMemberFactory                    factory = new RefexMemberFactory();
   private Concept                        enclosingConcept;
   private Collection<RefexMember<?, ?>> refsetMemberList;

   //~--- constructors --------------------------------------------------------

   public RefexMemberBinder(Concept concept) {
      this.enclosingConcept = concept;
   }

   //~--- methods -------------------------------------------------------------

   @SuppressWarnings("unchecked")
   @Override
   public Collection<RefexMember<?, ?>> entryToObject(TupleInput input) {
      assert enclosingConcept != null;

      int                                  listSize = input.readInt();
      Collection<RefexMember<?, ?>>       newRefsetMemberList;
      HashMap<Integer, RefexMember<?, ?>> nidToRefsetMemberMap = null;

      if (refsetMemberList != null) {
         newRefsetMemberList  = refsetMemberList;
         nidToRefsetMemberMap = new HashMap<>(listSize);

         for (RefexMember<?, ?> component : refsetMemberList) {
            nidToRefsetMemberMap.put(component.nid, component);
         }
      } else {
         newRefsetMemberList = new ArrayList<>(listSize);
      }

      for (int index = 0; index < listSize; index++) {
         int typeNid = input.readInt();

         input.mark(8);

         int nid = input.readInt();

         input.reset();

         Object component = Concept.componentsCRHM.get(nid);

         if ((component == null) || (component instanceof RefexMember)) {
            RefexMember<?, ?> refsetMember = (RefexMember<?, ?>) component;

            if ((refsetMember != null) && (refsetMember.getTime() == Long.MIN_VALUE)) {
               refsetMember = null;
               Concept.componentsCRHM.remove(nid);
            }

            if ((nidToRefsetMemberMap != null) && nidToRefsetMemberMap.containsKey(nid)) {
               if (refsetMember == null) {
                  refsetMember = nidToRefsetMemberMap.get(nid);

                  RefexMember<?, ?> oldMember = (RefexMember<?,
                                                    ?>) Concept.componentsCRHM.putIfAbsent(nid, refsetMember);

                  if (oldMember != null) {
                     refsetMember = oldMember;

                     if (nidToRefsetMemberMap != null) {
                        nidToRefsetMemberMap.put(nid, refsetMember);
                     }
                  }
               }

               refsetMember.readComponentFromBdb(input);
            } else {
               try {
                  if (refsetMember == null) {
                     refsetMember = factory.create(nid, typeNid, enclosingConcept.getNid(), input);

                     if (refsetMember.getTime() != Long.MIN_VALUE) {
                        RefexMember<?, ?> oldMember = (RefexMember<?,
                                                          ?>) Concept.componentsCRHM.putIfAbsent(nid,
                                                             refsetMember);

                        if (oldMember != null) {
                           refsetMember = oldMember;

                           if (nidToRefsetMemberMap != null) {
                              nidToRefsetMemberMap.put(nid, refsetMember);
                           }
                        }
                     }
                  } else {
                     refsetMember.merge(factory.create(nid, typeNid, enclosingConcept.getNid(), input));
                  }
               } catch (IOException e) {
                  throw new RuntimeException(e);
               }

               if (refsetMember.getTime() != Long.MIN_VALUE) {
                  newRefsetMemberList.add(refsetMember);
               }
            }
         } else {
            StringBuilder sb = new StringBuilder();

            sb.append("Refset member has nid: ").append(nid);
            sb.append(" But another component has same nid:\n").append(component);

            try {
                    sb.append("Refset member: \n").append(factory.create(nid, typeNid, enclosingConcept.getNid(), input));
            } catch (IOException ex) {
               ConceptComponent.logger.log(Level.WARNING, ex.getMessage(), ex);
            }
               ConceptComponent.logger.log(Level.SEVERE, 
                       "Nid overlap discovered. See log for more info.", 
                       new Exception(sb.toString()));

          }
      }

      return newRefsetMemberList;
   }

   @Override
   public void objectToEntry(Collection<RefexMember<?, ?>> list, TupleOutput output) {
      List<RefexMember<?, ?>> refsetMembersToWrite = new ArrayList<>(list.size());

      for (RefexMember<?, ?> refsetMember : list) {
         encountered.incrementAndGet();
         assert refsetMember.primordialSapNid != Integer.MAX_VALUE;

         if ((refsetMember.primordialSapNid > maxReadOnlyStatusAtPositionId)
                 && (refsetMember.getTime() != Long.MIN_VALUE)) {
            refsetMembersToWrite.add(refsetMember);
         } else {
            if (refsetMember.revisions != null) {
               for (RefexRevision<?, ?> r : refsetMember.revisions) {
                  if ((r.getStatusAtPositionNid() > maxReadOnlyStatusAtPositionId)
                          && (r.getTime() != Long.MIN_VALUE)) {
                     refsetMembersToWrite.add(refsetMember);

                     break;
                  }
               }
            }
         }
      }

      output.writeInt(refsetMembersToWrite.size());    // List size

      for (RefexMember<?, ?> refsetMember : refsetMembersToWrite) {
         written.incrementAndGet();
         output.writeInt(refsetMember.getTypeNid());
         refsetMember.writeComponentToBdb(output, maxReadOnlyStatusAtPositionId);
      }
   }

   @Override
   public void setupBinder(Concept enclosingConcept) {
      this.enclosingConcept = enclosingConcept;
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public Concept getEnclosingConcept() {
      return enclosingConcept;
   }

   //~--- set methods ---------------------------------------------------------

   public void setEnclosingConcept(Concept enclosingConcept) {
      this.enclosingConcept = enclosingConcept;
   }

   public void setTermComponentList(Collection<RefexMember<?, ?>> componentList) {
      this.refsetMemberList = componentList;
   }
}
