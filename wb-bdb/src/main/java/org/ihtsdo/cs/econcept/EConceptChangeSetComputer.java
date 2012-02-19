package org.ihtsdo.cs.econcept;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.concept.Concept;
import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.ConceptComponent.IDENTIFIER_PART_TYPES;
import org.ihtsdo.concept.component.attributes.ConceptAttributes;
import org.ihtsdo.concept.component.description.Description;
import org.ihtsdo.concept.component.identifier.IdentifierVersion;
import org.ihtsdo.concept.component.identifier.IdentifierVersionLong;
import org.ihtsdo.concept.component.identifier.IdentifierVersionString;
import org.ihtsdo.concept.component.identifier.IdentifierVersionUuid;
import org.ihtsdo.concept.component.image.Image;
import org.ihtsdo.concept.component.refex.RefexMember;
import org.ihtsdo.concept.component.relationship.Relationship;
import org.ihtsdo.cs.I_ComputeEConceptForChangeSet;
import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.db.bdb.BdbCommitManager;
import org.ihtsdo.db.bdb.computer.ReferenceConcepts;
import org.ihtsdo.tk.api.NidSetBI;
import org.ihtsdo.tk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.tk.dto.concept.component.TkComponent;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes;
import org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributesRevision;
import org.ihtsdo.tk.dto.concept.component.description.TkDescription;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.media.TkMedia;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.ihtsdo.temp.AceLog;
import org.ihtsdo.tk.api.id.LongIdBI;
import org.ihtsdo.tk.api.id.StringIdBI;
import org.ihtsdo.tk.api.id.UuidIdBI;
import org.ihtsdo.tk.dto.concept.TkConcept;
import org.ihtsdo.tk.dto.concept.component.description.TkDescriptionRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierLong;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierString;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierUuid;
import org.ihtsdo.tk.dto.concept.component.media.TkMediaRevision;
import org.ihtsdo.tk.dto.concept.component.relationship.TkRelationshipRevision;

public class EConceptChangeSetComputer implements I_ComputeEConceptForChangeSet {
   private int                       minSapNid  = Integer.MIN_VALUE;
   private int                       maxSapNid  = Integer.MAX_VALUE;
   private int                       classifier = ReferenceConcepts.SNOROCKET.getNid();
   private NidSetBI                  commitSapNids;
   private ChangeSetGenerationPolicy policy;

   //~--- constructors --------------------------------------------------------

   public EConceptChangeSetComputer(ChangeSetGenerationPolicy policy, NidSetBI commitSapNids) {
      super();
      this.policy = policy;

      switch (policy) {
      case COMPREHENSIVE :
         maxSapNid = commitSapNids.getMax();

         break;

      case INCREMENTAL :
         if (!commitSapNids.contiguous()) {
            this.commitSapNids = commitSapNids;
         }

         maxSapNid = commitSapNids.getMax();
         minSapNid = commitSapNids.getMin();

         break;

      case MUTABLE_ONLY :
         maxSapNid = Integer.MAX_VALUE;
         minSapNid = Bdb.getSapDb().getReadOnlyMax() + 1;

         break;

      default :
         throw new RuntimeException("Can't handle policy: " + policy);
      }

      assert minSapNid <= maxSapNid : "Min not <= max; min: " + minSapNid + " max: " + maxSapNid;
   }

   //~--- methods -------------------------------------------------------------

   private TkConceptAttributes processConceptAttributes(Concept c, AtomicBoolean changed) throws IOException {
      TkConceptAttributes eca = null;

      for (ConceptAttributes.Version v : c.getConceptAttributes().getVersions()) {
         if (v.sapIsInRange(minSapNid, maxSapNid) && (v.getTime() != Long.MIN_VALUE)
                 && (v.getTime() != Long.MAX_VALUE)) {
            changed.set(true);

            if ((commitSapNids == null) || commitSapNids.contains(v.getSapNid())) {
               if (eca == null) {
                  eca = new TkConceptAttributes();
                  eca.setDefined(v.isDefined());
                  setupFirstVersion(eca, v);
               } else {
                  TkConceptAttributesRevision ecv = new TkConceptAttributesRevision();

                  ecv.setDefined(v.isDefined());
                  setupRevision(eca, v, ecv);
               }
            }
         }
      }

      return eca;
   }

   private List<TkDescription> processDescriptions(Concept c, AtomicBoolean changed) throws IOException {
      List<TkDescription> eDescriptions = new ArrayList<TkDescription>(c.getDescriptions().size());

      for (Description d : c.getDescriptions()) {
         TkDescription ecd = null;

         for (Description.Version v : d.getVersions()) {
            if (v.sapIsInRange(minSapNid, maxSapNid) && (v.getTime() != Long.MIN_VALUE)
                    && (v.getTime() != Long.MAX_VALUE)) {
               changed.set(true);

               if ((commitSapNids == null) || commitSapNids.contains(v.getSapNid())) {
                  if (ecd == null) {
                     ecd = new TkDescription();
                     eDescriptions.add(ecd);
                     ecd.setConceptUuid(Bdb.getPrimUuidForConcept(v.getConceptNid()));
                     ecd.setInitialCaseSignificant(v.isInitialCaseSignificant());
                     ecd.setLang(v.getLang());
                     ecd.setText(v.getText());
                     ecd.setTypeUuid(Bdb.getPrimUuidForConcept(v.getTypeNid()));
                     setupFirstVersion(ecd, v);
                  } else {
                     TkDescriptionRevision ecv = new TkDescriptionRevision();

                     ecv.setInitialCaseSignificant(v.isInitialCaseSignificant());
                     ecv.setLang(v.getLang());
                     ecv.setText(v.getText());
                     ecv.setTypeUuid(Bdb.getPrimUuidForConcept(v.getTypeNid()));
                     setupRevision(ecd, v, ecv);
                  }
               }
            }
         }
      }

      return eDescriptions;
   }

   private List<TkMedia> processMedia(Concept c, AtomicBoolean changed) throws IOException {
      List<TkMedia> eImages = new ArrayList<TkMedia>();

      for (Image img : c.getImages()) {
         TkMedia eImg = null;

         for (Image.Version v : img.getVersions()) {
            if (v.sapIsInRange(minSapNid, maxSapNid) && (v.getTime() != Long.MIN_VALUE)
                    && (v.getTime() != Long.MAX_VALUE)) {
               if ((commitSapNids == null) || commitSapNids.contains(v.getSapNid())) {
                  changed.set(true);

                  if (eImg == null) {
                     eImg = new TkMedia();
                     eImages.add(eImg);
                     eImg.setConceptUuid(Bdb.getPrimUuidForConcept(v.getConceptNid()));
                     eImg.setFormat(v.getFormat());
                     eImg.setDataBytes(v.getMedia());
                     eImg.setTextDescription(v.getTextDescription());
                     eImg.setTypeUuid(Bdb.getPrimUuidForConcept(v.getTypeNid()));
                     setupFirstVersion(eImg, v);
                  } else {
                     TkMediaRevision eImgR = new TkMediaRevision();

                     eImgR.setTextDescription(v.getTextDescription());
                     eImgR.setTypeUuid(Bdb.getPrimUuidForConcept(v.getTypeNid()));
                     setupRevision(eImg, v, eImgR);
                  }
               }
            }
         }
      }

      return eImages;
   }

   private List<TkRefexAbstractMember<?>> processRefsetMembers(Concept c, AtomicBoolean changed)
           throws IOException {
      List<TkRefexAbstractMember<?>> eRefsetMembers =
         new ArrayList<TkRefexAbstractMember<?>>(c.getRefsetMembers().size());
      Collection<RefexMember<?, ?>> membersToRemove = new ArrayList<RefexMember<?, ?>>();

      for (RefexMember<?, ?> member : c.getRefsetMembers()) {
         TkRefexAbstractMember<?> eMember = null;
         Concept                   concept = Bdb.getConceptForComponent(member.getReferencedComponentNid());

         if ((concept != null) &&!concept.isCanceled()) {
            for (RefexMember<?, ?>.Version v : member.getVersions()) {
               if (v.sapIsInRange(minSapNid, maxSapNid) && (v.getTime() != Long.MIN_VALUE)
                       && (v.getTime() != Long.MAX_VALUE)) {
                  if ((commitSapNids == null) || commitSapNids.contains(v.getSapNid())) {
                     changed.set(true);

                     if (eMember == null) {
                    	 try {
 	                        eMember = v.getERefsetMember();
 	
 	                        if (eMember != null) {
 	                           eRefsetMembers.add(eMember);
 	                           setupFirstVersion(eMember, v);
 	                        }
                  		} catch (Exception e) {
                 	        AceLog.getAppLog().info("Failed in getting Concept for: " + member.toString() + " and " + v.toString());
                 		}
                     } else {
                        TkRevision eRevision = v.getERefsetRevision();

                        setupRevision(eMember, v, eRevision);
                     }
                  }
               }
            }
         } else {
            member.primordialSapNid = -1;
            membersToRemove.add(member);
         }
      }

      if (!membersToRemove.isEmpty()) {
         BdbCommitManager.writeImmediate(c);
      }

      return eRefsetMembers;
   }

   private List<TkRelationship> processRelationships(Concept c, AtomicBoolean changed) throws IOException {
      List<TkRelationship> rels = new ArrayList<TkRelationship>(c.getRelsOutgoing().size());

      for (Relationship r : c.getRelsOutgoing()) {
         TkRelationship ecr = null;

         for (Relationship.Version v : r.getVersions()) {
            if (v.sapIsInRange(minSapNid, maxSapNid) && (v.getTime() != Long.MIN_VALUE)
                    && (v.getTime() != Long.MAX_VALUE) && (v.getAuthorNid() != classifier)) {
               if ((commitSapNids == null) || commitSapNids.contains(v.getSapNid())) {
                  try {
                     changed.set(true);

                     if (ecr == null) {
                        ecr = new TkRelationship();
                        rels.add(ecr);
                        ecr.setC1Uuid(Bdb.getPrimUuidForConcept(v.getC1Nid()));
                        ecr.setC2Uuid(Bdb.getPrimUuidForConcept(v.getC2Nid()));
                        ecr.setCharacteristicUuid(Bdb.getPrimUuidForConcept(v.getCharacteristicNid()));
                        ecr.setRefinabilityUuid(Bdb.getPrimUuidForConcept(v.getRefinabilityNid()));
                        ecr.setRelGroup(v.getGroup());
                        ecr.setTypeUuid(Bdb.getPrimUuidForConcept(v.getTypeNid()));
                        setupFirstVersion(ecr, v);
                     } else {
                        TkRelationshipRevision ecv = new TkRelationshipRevision();

                        ecv.setCharacteristicUuid(Bdb.getPrimUuidForConcept(v.getCharacteristicNid()));
                        ecv.setRefinabilityUuid(Bdb.getPrimUuidForConcept(v.getRefinabilityNid()));
                        ecv.setRelGroup(v.getGroup());
                        ecv.setTypeUuid(Bdb.getPrimUuidForConcept(v.getTypeNid()));
                        setupRevision(ecr, v, ecv);
                     }
                  } catch (AssertionError e) {
                     AceLog.getAppLog().alertAndLogException(new Exception(e.getLocalizedMessage() + "\n\n"
                             + c.toLongString(), e));

                     throw e;
                  }
               }
            }
         }
      }

      return rels;
   }

   @SuppressWarnings("unchecked")
   private void setupFirstVersion(TkComponent ec, ConceptComponent<?, ?>.Version v) throws IOException {
      ec.primordialUuid = v.getPrimUuid();
      ec.setPathUuid(Bdb.getPrimUuidForConcept(v.getPathNid()));
      ec.setStatusUuid(Bdb.getPrimUuidForConcept(v.getStatusNid()));
      ec.setAuthorUuid(Bdb.getPrimUuidForConcept(v.getAuthorNid()));
      ec.setTime(v.getTime());

      if (v.getAdditionalIdentifierParts() != null) {
         for (IdentifierVersion idv : v.getAdditionalIdentifierParts()) {
            TkIdentifier eIdv = null;

            if ((idv.getSapNid() >= minSapNid) && (idv.getSapNid() <= maxSapNid)
                    && (v.getTime() != Long.MIN_VALUE) && (v.getTime() != Long.MAX_VALUE)) {
               if (IdentifierVersionLong.class.isAssignableFrom(idv.getClass())) {
                  eIdv = new TkIdentifierLong();
               } else if (IdentifierVersionString.class.isAssignableFrom(idv.getClass())) {
                  eIdv = new TkIdentifierString();
               } else if (IdentifierVersionUuid.class.isAssignableFrom(idv.getClass())) {
                  eIdv = new TkIdentifierUuid();
               }

               eIdv.setDenotation(idv.getDenotation());
               eIdv.setAuthorityUuid(Bdb.getPrimUuidForConcept(idv.getAuthorityNid()));
               eIdv.setPathUuid(Bdb.getPrimUuidForConcept(idv.getPathNid()));
               eIdv.setStatusUuid(Bdb.getPrimUuidForConcept(idv.getStatusNid()));
               eIdv.setAuthorUuid(Bdb.getPrimUuidForConcept(idv.getAuthorNid()));
               eIdv.setTime(idv.getTime());
            }
         }
      }

      if (v.getAnnotations() != null) {
         HashMap<UUID, TkRefexAbstractMember<?>> annotationMap = new HashMap<UUID,
                                                                     TkRefexAbstractMember<?>>();

         if (ec.getAnnotations() != null) {
            for (TkRefexAbstractMember<?> member :
                    (Collection<TkRefexAbstractMember<?>>) ec.getAnnotations()) {
               annotationMap.put(member.getPrimordialComponentUuid(), member);
            }
         }

         for (RefexMember<?, ?> member : (Collection<RefexMember<?, ?>>) v.getAnnotations()) {
            TkRefexAbstractMember<?> eMember = null;
            Concept                   concept =
               Bdb.getConceptForComponent(member.getReferencedComponentNid());

            if ((concept != null) &&!concept.isCanceled()) {
               for (RefexMember<?, ?>.Version mv : member.getVersions()) {
                  if (mv.sapIsInRange(minSapNid, maxSapNid) && (mv.getTime() != Long.MIN_VALUE)
                          && (mv.getTime() != Long.MAX_VALUE)) {
                     if ((commitSapNids == null) || commitSapNids.contains(mv.getSapNid())) {
                        if (eMember == null) {
                           eMember = mv.getERefsetMember();

                           if (eMember != null) {
                              if (ec.getAnnotations() == null) {
                                 ec.setAnnotations(new ArrayList());
                              }

                              ec.getAnnotations().add(eMember);
                              setupFirstVersion(eMember, mv);
                           }
                        } else {
                           TkRevision eRevision = mv.getERefsetRevision();

                           setupRevision(eMember, mv, eRevision);
                        }
                     }
                  }
               }
            }
         }
      }

      if (v.getAdditionalIdentifierParts() != null) {
         for (IdentifierVersion idv : v.getAdditionalIdentifierParts()) {
            if (idv.sapIsInRange(minSapNid, maxSapNid)) {
               if (ec.getAdditionalIdComponents() == null) {
                  ec.setAdditionalIdComponents(new ArrayList<TkIdentifier>());
               }

               Object denotation = idv.getDenotation();

               switch (IDENTIFIER_PART_TYPES.getType(denotation.getClass())) {
               case LONG :
                  ec.additionalIds.add(new TkIdentifierLong((LongIdBI) idv));

                  break;

               case STRING :
                  ec.additionalIds.add(new TkIdentifierString((StringIdBI) idv));

                  break;

               case UUID :
                  ec.additionalIds.add(new TkIdentifierUuid((UuidIdBI) idv));

                  break;

               default :
                  throw new UnsupportedOperationException();
               }
            }
         }
      }
   }

   @SuppressWarnings("unchecked")
   private void setupRevision(TkComponent ec, ConceptComponent.Version v, TkRevision ev) throws IOException {
      if (ec.revisions == null) {
         ec.revisions = new ArrayList();
      }

      ev.setPathUuid(Bdb.getPrimUuidForConcept(v.getPathNid()));
      ev.setStatusUuid(Bdb.getPrimUuidForConcept(v.getStatusNid()));
      ev.setAuthorUuid(Bdb.getPrimUuidForConcept(v.getAuthorNid()));
      ev.setTime(v.getTime());
      ec.revisions.add(ev);
   }

   @Override
   public String toString() {
      return "EConceptChangeSetComputer: minSapNid: " + minSapNid + " maxSapNid: " + maxSapNid + " policy: "
             + policy;
   }

   //~--- get methods ---------------------------------------------------------

   /*
    * (non-Javadoc)
    * @see
    * org.ihtsdo.cs.I_ComputeEConceptForChangeSet#getEConcept(org.ihtsdo.concept
    * .Concept)
    */
   @Override
   public TkConcept getEConcept(Concept c) throws IOException {
      TkConcept      ec      = new TkConcept();
      AtomicBoolean changed = new AtomicBoolean(false);

      ec.setPrimordialUuid(c.getPrimUuid());
      ec.setConceptAttributes(processConceptAttributes(c, changed));
      ec.setDescriptions(processDescriptions(c, changed));
      ec.setRelationships(processRelationships(c, changed));
      ec.setImages(processMedia(c, changed));

      if (!c.isAnnotationStyleRefex()) {
         ec.setRefsetMembers(processRefsetMembers(c, changed));
      }

      if (changed.get()) {
         return ec;
      }

      return null;
   }
}
