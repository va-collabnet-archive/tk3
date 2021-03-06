package org.ihtsdo.cc.concept;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.cc.LanguageSortPrefs.LANGUAGE_SORT_PREF;
import org.ihtsdo.cc.P;
import org.ihtsdo.cc.ReferenceConcepts;
import org.ihtsdo.cc.relationship.group.RelGroupVersion;
import org.ihtsdo.cern.colt.map.OpenIntIntHashMap;
import org.ihtsdo.tk.api.*;
import org.ihtsdo.tk.api.blueprint.ConceptCB;
import org.ihtsdo.tk.api.blueprint.InvalidCAB;
import org.ihtsdo.tk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.tk.api.changeset.ChangeSetGenerationThreadingPolicy;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.constraint.*;
import org.ihtsdo.tk.api.coordinate.EditCoordinate;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.cs.ChangeSetPolicy;
import org.ihtsdo.tk.api.cs.ChangeSetWriterThreading;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.api.media.MediaChronicleBI;
import org.ihtsdo.tk.api.media.MediaVersionBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.tk.api.relationship.group.RelGroupChronicleBI;
import org.ihtsdo.tk.api.relationship.group.RelGroupVersionBI;
import org.ihtsdo.tk.binding.HistoricalRelType;
import org.ihtsdo.tk.binding.SnomedMetadataRf1;
import org.ihtsdo.tk.binding.SnomedMetadataRf2;
import org.ihtsdo.tk.spec.ConceptSpec;
import org.ihtsdo.tk.spec.ValidationException;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ihtsdo.tk.Ts;

public class ConceptVersion implements ConceptVersionBI, Comparable<ConceptVersion> {
   private static NidSetBI classifierCharacteristics;

   //~--- fields --------------------------------------------------------------

   private Concept        concept;
   NidListBI              fsnOrder;
   NidListBI              preferredOrder;
   NidListBI              synonymOrder;
   private ViewCoordinate vc;

   //~--- constructors --------------------------------------------------------

   public ConceptVersion(Concept concept, ViewCoordinate coordinate) {
      super();

      if (concept == null) {
         throw new IllegalArgumentException();
      }

      this.concept = concept;
      this.vc      = new ViewCoordinate(UUID.randomUUID(), coordinate.getName() + " clone", coordinate);
   }

   //~--- methods -------------------------------------------------------------

   @Override
   public boolean addAnnotation(RefexChronicleBI<?> annotation) throws IOException {
      return concept.addAnnotation(annotation);
   }

   @Override
   public void cancel() throws IOException {
      concept.cancel();
   }

   private boolean checkConceptVersionConstraint(int cNid, ConceptSpec constraint,
           ConstraintCheckType checkType)
           throws IOException, ContradictionException {
      switch (checkType) {
      case EQUALS :
         return P.s.getConceptVersion(vc, cNid).getNid() == constraint.get(vc).getNid();

      case IGNORE :
         return true;

      case KIND_OF :
         return P.s.getConceptVersion(vc, cNid).isKindOf(constraint.get(vc));

      default :
         throw new UnsupportedOperationException("Illegal ConstraintCheckType: " + checkType);
      }
   }

   private boolean checkTextConstraint(String text, String constraint, ConstraintCheckType checkType) {
      switch (checkType) {
      case EQUALS :
         return text.equals(constraint);

      case IGNORE :
         return true;

      case REGEX :
         Pattern pattern = Pattern.compile(constraint);
         Matcher matcher = pattern.matcher(text);

         return matcher.find();

      default :
         throw new UnsupportedOperationException("Illegal ConstraintCheckType: " + checkType);
      }
   }

   @Override
   public boolean commit(ChangeSetGenerationPolicy changeSetPolicy,
                         ChangeSetGenerationThreadingPolicy changeSetWriterThreading)
           throws IOException {
      return concept.commit(changeSetPolicy, changeSetWriterThreading);
   }

   public void commit(ChangeSetPolicy changeSetPolicy, ChangeSetWriterThreading changeSetWriterThreading)
           throws IOException {
      concept.commit(changeSetPolicy, changeSetWriterThreading);
   }

   @Override
   public int compareTo(ConceptVersion o) {
      return getNid() - o.getNid();
   }

   @Override
   public boolean equals(Object obj) {
      if (obj instanceof ConceptVersion) {
         ConceptVersion another = (ConceptVersion) obj;

         if (concept.nid != another.concept.nid) {
            return false;
         }

         if (vc == another.vc) {
            return true;
         }

         return vc.equals(another.vc);
      }

      return false;
   }

   @Override
   public int hashCode() {
      return concept.hashCode;
   }

   @Override
   public boolean makeAdjudicationAnalogs(EditCoordinate ec, ViewCoordinate vc) throws Exception {
      return concept.makeAdjudicationAnalogs(ec, vc);
   }

   @Override
   public ConceptCB makeBlueprint() throws IOException, ContradictionException, InvalidCAB {
      return concept.makeBlueprint(vc);
   }

   @Override
   public ConceptCB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB {
      return concept.makeBlueprint(vc);
   }

   @Override
   public void processComponentChronicles(ProcessComponentChronicleBI processor) throws Exception {
      concept.processComponentChronicles(processor);
   }

   @Override
   public boolean satisfies(ConstraintBI constraint, ConstraintCheckType subjectCheck,
                            ConstraintCheckType propertyCheck, ConstraintCheckType valueCheck)
           throws IOException, ContradictionException {
      if (RelConstraintOutgoing.class.isAssignableFrom(constraint.getClass())) {
         return testRels(constraint, subjectCheck, propertyCheck, valueCheck, getRelsOutgoingActive());
      } else if (RelConstraintIncoming.class.isAssignableFrom(constraint.getClass())) {
         return testRels(constraint, subjectCheck, propertyCheck, valueCheck, getRelsIncomingActive());
      } else if (DescriptionConstraint.class.isAssignableFrom(constraint.getClass())) {
         DescriptionConstraint dc = (DescriptionConstraint) constraint;

         for (DescriptionVersionBI desc : getDescsActive()) {
            if (checkConceptVersionConstraint(desc.getConceptNid(), dc.getConceptSpec(), subjectCheck)
                    && checkConceptVersionConstraint(desc.getTypeNid(), dc.getDescTypeSpec(), propertyCheck)
                    && checkTextConstraint(desc.getText(), dc.getText(), valueCheck)) {
               return true;
            }
         }

         return false;
      }

      throw new UnsupportedOperationException("Can't handle constraint of type: " + constraint);
   }

   private static void setupClassifierCharacteristics() {
      if (classifierCharacteristics == null) {
         NidSetBI temp = new NidSet();

         try {
            temp.add(P.s.getNidForUuids(SnomedMetadataRf1.DEFINED_RF1.getUuids()));
            temp.add(P.s.getNidForUuids(SnomedMetadataRf1.DEFINING_CHARACTERISTIC_TYPE_RF1.getUuids()));
            temp.add(
                P.s.getNidForUuids(SnomedMetadataRf1.INFERRED_DEFINING_CHARACTERISTIC_TYPE_RF1.getUuids()));
            temp.add(SnomedMetadataRf2.INFERRED_RELATIONSHIP_RF2.getLenient().getConceptNid());
         } catch (ValidationException e) {
            throw new RuntimeException(e);
         } catch (IOException e) {
            throw new RuntimeException(e);
         }

         classifierCharacteristics = temp;
      }
   }

   private void setupFsnOrder() {
      if (fsnOrder == null) {
         NidListBI newList = new NidList();

         newList.add(ReferenceConcepts.FULLY_SPECIFIED_RF1.getNid());
         newList.add(ReferenceConcepts.FULLY_SPECIFIED_RF2.getNid());
         fsnOrder = newList;
      }
   }

   private void setupPreferredOrder() {
      if (preferredOrder == null) {
         NidListBI newList = new NidList();

         newList.add(ReferenceConcepts.PREFERRED_ACCEPTABILITY_RF1.getNid());
         newList.add(ReferenceConcepts.PREFERRED_RF1.getNid());
         newList.add(ReferenceConcepts.PREFERRED_ACCEPTABILITY_RF2.getNid());
         newList.add(ReferenceConcepts.SYNONYM_RF1.getNid());
         newList.add(ReferenceConcepts.SYNONYM_RF2.getNid());
         preferredOrder = newList;
      }
   }

   @Override
   public boolean stampIsInRange(int min, int max) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   private boolean testRels(ConstraintBI constraint, ConstraintCheckType subjectCheck,
                            ConstraintCheckType propertyCheck, ConstraintCheckType valueCheck,
                            Collection<? extends RelationshipVersionBI> rels)
           throws IOException, ContradictionException {
      RelConstraint rc = (RelConstraint) constraint;

      for (RelationshipVersionBI rel : rels) {
         if (checkConceptVersionConstraint(rel.getOriginNid(), rc.getOriginSpec(), subjectCheck)
                 && checkConceptVersionConstraint(rel.getTypeNid(), rc.getRelTypeSpec(), propertyCheck)
                 && checkConceptVersionConstraint(rel.getDestinationNid(), rc.getDestinationSpec(),
                    valueCheck)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public String toLongString() {
      return concept.toLongString();
   }

   @Override
   public String toString() {
      return concept.toString() + "\n\nviewCoordinate:\n" + vc;
   }

   @Override
   public String toUserString() {
      return concept.toString();
   }

   @Override
   public String toUserString(TerminologySnapshotDI snapshot) throws IOException, ContradictionException {
      if (getPreferredDescription() != null) {
         return getPreferredDescription().getText();
      }

      return concept.getText();
   }

   @Override
   public boolean versionsEqual(ViewCoordinate vc1, ViewCoordinate vc2, Boolean compareAuthoring) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public Collection<? extends IdBI> getAdditionalIds() throws IOException {
      return concept.getAdditionalIds();
   }

   @Override
   public Collection<? extends IdBI> getAllIds() throws IOException {
      return concept.getAllIds();
   }

   @Override
   public Set<Integer> getAllNidsForVersion() throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Set<Integer> getAllStampNids() throws IOException {
      return concept.getAllStampNids();
   }

   @Override
   public Collection<? extends RefexChronicleBI<?>> getAnnotations() throws IOException {
      return concept.getAnnotations();
   }

   @Override
   public int getAuthorNid() {
      try {
         return getConAttrs().getAuthorNid();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public ConceptChronicleBI getChronicle() {
      return concept;
   }

   @Override
   public ComponentChroncileBI<?> getComponent(int nid) throws IOException {
      return (ComponentChroncileBI<?>) concept.getComponent(nid);
   }

   @Override
   public ConAttrVersionBI getConAttrs() throws IOException {
      return concept.getConceptAttributes();
   }

   @Override
   public ConAttrVersionBI getConAttrsActive() throws IOException, ContradictionException {
      return concept.getConceptAttributes().getVersion(vc);
   }

   @Override
   public int getConceptNid() {
      return concept.getConceptNid();
   }

   public Collection<Integer> getConceptNidsAffectedByCommit() throws IOException {
      return concept.getConceptNidsAffectedByCommit();
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz)
           throws IOException {
      return concept.getCurrentAnnotationMembers(xyz);
   }

   @Override
   public <T extends RefexVersionBI<?>> Collection<T> getCurrentAnnotationMembers(ViewCoordinate xyz,
           Class<T> cls)
           throws IOException {
      return concept.getCurrentAnnotationMembers(xyz, cls);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz,
           int refexNid)
           throws IOException {
      return concept.getCurrentAnnotationMembers(xyz, refexNid);
   }

   @Override
   public <T extends RefexVersionBI<?>> Collection<T> getCurrentAnnotationMembers(ViewCoordinate xyz,
           int refexNid, Class<T> cls)
           throws IOException {
      return concept.getCurrentAnnotationMembers(xyz, refexNid, cls);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefexMembers(int refsetNid) throws IOException {
      return concept.getCurrentRefexMembers(vc, refsetNid);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefexMembers(ViewCoordinate xyz, int refsetNid)
           throws IOException {
      return concept.getCurrentRefexMembers(xyz, refsetNid);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz) throws IOException {
      return concept.getCurrentRefexes(xyz);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz, int refsetNid)
           throws IOException {
      return concept.getCurrentRefexMembers(xyz, refsetNid);
   }

   @Override
   public RefexChronicleBI<?> getCurrentRefsetMemberForComponent(int componentNid) throws IOException {
      return concept.getCurrentRefsetMemberForComponent(vc, componentNid);
   }

   @Override
   public RefexVersionBI<?> getCurrentRefsetMemberForComponent(ViewCoordinate vc, int componentNid)
           throws IOException {
      return concept.getCurrentRefsetMemberForComponent(vc, componentNid);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefsetMembers() throws IOException {
      return concept.getCurrentRefsetMembers(vc);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefsetMembers(ViewCoordinate vc)
           throws IOException {
      return concept.getCurrentRefsetMembers(vc);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefsetMembers(ViewCoordinate vc, Long cutoffTime)
           throws IOException {
      return concept.getCurrentRefsetMembers(vc, cutoffTime);
   }

   @Override
   public Collection<? extends DescriptionChronicleBI> getDescs() throws IOException {
      return concept.getDescriptions();
   }

   @Override
   public Collection<? extends DescriptionVersionBI> getDescsActive() throws IOException {
      Collection<DescriptionVersionBI> returnValues = new ArrayList<>();

      for (DescriptionChronicleBI desc : getDescs()) {
         returnValues.addAll(desc.getVersions(vc));
      }

      return returnValues;
   }

   @Override
   public Collection<? extends DescriptionVersionBI> getDescsActive(int typeNid) throws IOException {
      return getDescsActive(new NidSet(new int[] { typeNid }));
   }

   @Override
   public Collection<? extends DescriptionVersionBI> getDescsActive(NidSetBI typeNids) throws IOException {
      Collection<DescriptionVersionBI> results = new ArrayList<>();

      for (DescriptionVersionBI d : getDescsActive()) {
         if (typeNids.contains(d.getTypeNid())) {
            results.add(d);
         }
      }

      return results;
   }

   @Override
   public ConceptChronicleBI getEnclosingConcept() {
      return concept;
   }

   @Override
   public Collection<? extends DescriptionVersionBI> getFsnDescsActive() throws IOException {
      setupFsnOrder();

      return getDescsActive(new NidSet(fsnOrder.getListArray()));
   }

   @Override
   public DescriptionVersionBI getFullySpecifiedDescription() throws IOException, ContradictionException {
      setupFsnOrder();

      return concept.getDesc(fsnOrder, vc.getLangPrefList(), vc.getAllowedStatusNids(), vc.getPositionSet(),
                             LANGUAGE_SORT_PREF.getPref(vc.getLangSort()), vc.getPrecedence(),
                             vc.getContradictionManager());
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getInactiveRefexes(ViewCoordinate xyz) throws IOException {
      return concept.getInactiveRefexes(xyz);
   }

   @Override
   public long getLastModificationSequence() {
      return concept.getLastModificationSequence();
   }

   @Override
   public Collection<? extends MediaChronicleBI> getMedia() throws IOException {
      return concept.getImages();
   }

   @Override
   public Collection<? extends MediaVersionBI> getMediaActive() throws IOException, ContradictionException {
      Collection<MediaVersionBI> returnValues = new ArrayList<>();

      for (MediaChronicleBI media : getMedia()) {
         returnValues.addAll(media.getVersions(vc));
      }

      return returnValues;
   }

   @Override
   public int getModuleNid() {
      try {
         return getConAttrs().getModuleNid();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public int getNid() {
      return concept.getNid();
   }

   @Override
   public Collection<List<Integer>> getNidPathsToRoot() throws IOException {
      return getNidPathsToRootNoAdd(new ArrayList<Integer>());
   }

   private Collection<List<Integer>> getNidPathsToRoot(List<Integer> nidPath) throws IOException {
      nidPath.add(this.getNid());

      return getNidPathsToRootNoAdd(nidPath);
   }

   private Collection<List<Integer>> getNidPathsToRootNoAdd(List<Integer> nidPath) throws IOException {
      TreeSet<List<Integer>> pathList = new TreeSet<>(new Comparator<List<Integer>>() {
         @Override
         public int compare(List<Integer> o1, List<Integer> o2) {
            if (o1.size() != o2.size()) {
               return o1.size() - o2.size();
            }

            int size = o1.size();

            for (int i = 0; i < size; i++) {
               if (o1.get(i) != o2.get(i)) {
                  return o1.get(i) - o2.get(i);
               }
            }

            return 0;
         }
      });

      try {
         Collection<? extends ConceptVersionBI> parents = getRelsOutgoingDestinationsActiveIsa();

         if (parents.isEmpty()) {
            pathList.add(nidPath);
         } else {
            for (ConceptVersionBI parent : parents) {
               pathList.addAll(((ConceptVersion) parent).getNidPathsToRoot(new ArrayList(nidPath)));
            }
         }
      } catch (ContradictionException ex) {
         Concept.logger.log(Level.SEVERE, "Contradiction exception.", ex);
      }

      return pathList;
   }

   @Override
   public int getPathNid() {
      try {
         return getConAttrs().getPathNid();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public PositionBI getPosition() throws IOException {
      throw new UnsupportedOperationException();
   }

   @Override
   public Set<PositionBI> getPositions() throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Collection<? extends DescriptionVersionBI> getPrefDescsActive() throws IOException {
      setupPreferredOrder();

      return getDescsActive(new NidSet(preferredOrder.getListArray()));
   }

   @Override
   public DescriptionVersionBI getPreferredDescription() throws IOException, ContradictionException {
      setupPreferredOrder();

      return concept.getDesc(preferredOrder, vc.getLangPrefList(), vc.getAllowedStatusNids(),
                             vc.getPositionSet(), LANGUAGE_SORT_PREF.getPref(vc.getLangSort()),
                             vc.getPrecedence(), vc.getContradictionManager());
   }

   @Override
   public UUID getPrimUuid() {
      return concept.getPrimUuid();
   }

   @Override
   public ConceptVersionBI getPrimordialVersion() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Collection<? extends RefexChronicleBI<?>> getRefexMembers(int refsetNid) throws IOException {
      return concept.getRefexMembers(refsetNid);
   }

   @Override
   public Collection<? extends RefexChronicleBI<?>> getRefexes() throws IOException {
      return concept.getRefexes();
   }

   @Override
   @Deprecated
   public Collection<? extends RefexChronicleBI<?>> getRefexes(int refsetNid) throws IOException {
      return concept.getRefexMembers(refsetNid);
   }

   @Override
   public RefexChronicleBI<?> getRefsetMemberForComponent(int componentNid) throws IOException {
      return concept.getRefsetMemberForComponent(componentNid);
   }

   @Override
   public Collection<? extends RefexChronicleBI<?>> getRefsetMembers() throws IOException {
      return concept.getRefsetMembers();
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getRefsetMembersActive() throws IOException {
      return concept.getCurrentRefsetMembers(vc);
   }

   @Override
   public Collection<? extends RelGroupVersionBI> getRelGroups() throws IOException, ContradictionException {
      ArrayList<RelGroupVersionBI> results = new ArrayList<>();

      for (RelGroupChronicleBI rgc : concept.getRelGroups(vc)) {
         RelGroupVersionBI rgv = new RelGroupVersion(rgc, vc);

         if (rgv.getRels().size() > 0) {
            results.add(rgv);
         }
      }

      return results;
   }

   @Override
   public Collection<? extends RelGroupVersionBI> getRelGroups(ViewCoordinate vc)
           throws IOException, ContradictionException {
      return concept.getRelGroups(vc);
   }

   @Override
   public Collection<? extends RelationshipChronicleBI> getRelsIncoming() throws IOException {
      return concept.getRelsIncoming();
   }

   @Override
   public Collection<? extends RelationshipVersionBI> getRelsIncomingActive()
           throws IOException, ContradictionException {
      Collection<RelationshipVersionBI> returnValues = new ArrayList<>();

      for (RelationshipChronicleBI rel : getRelsIncoming()) {
         returnValues.addAll(rel.getVersions(vc));
      }

      return returnValues;
   }

   @Override
   public Collection<? extends RelationshipVersionBI> getRelsIncomingActiveIsa()
           throws IOException, ContradictionException {
      Collection<RelationshipVersionBI> returnValues = new ArrayList<>();

      for (RelationshipChronicleBI rel : getRelsIncoming()) {
         for (RelationshipVersionBI rv : rel.getVersions(vc)) {
            if (vc.getIsaTypeNids().contains(rv.getTypeNid())) {
               returnValues.add(rv);
            }
         }
      }

      return returnValues;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsIncomingOrigins() throws IOException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsIncoming()) {
         for (RelationshipVersionBI relv : rel.getVersions()) {
            ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getOriginNid());

            conceptSet.add(cv);
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsIncomingOrigins(int typeNid) throws IOException {
      return getRelsIncomingOrigins(new NidSet(new int[] { typeNid }));
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsIncomingOrigins(NidSetBI typeNids)
           throws IOException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsIncoming()) {
         for (RelationshipVersionBI relv : rel.getVersions()) {
            if (typeNids.contains(relv.getTypeNid())) {
               ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getOriginNid());

               conceptSet.add(cv);
            }
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsIncomingOriginsActive()
           throws IOException, ContradictionException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsIncoming()) {
         for (RelationshipVersionBI relv : rel.getVersions(vc)) {
            ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getOriginNid());

            conceptSet.add(cv);
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsIncomingOriginsActive(int typeNid)
           throws IOException, ContradictionException {
      return getRelsIncomingOriginsActive(new NidSet(new int[] { typeNid }));
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsIncomingOriginsActive(NidSetBI typeNids)
           throws IOException, ContradictionException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsIncoming()) {
         for (RelationshipVersionBI relv : rel.getVersions(vc)) {
            if (typeNids.contains(relv.getTypeNid())) {
               ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getOriginNid());

               conceptSet.add(cv);
            }
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsIncomingOriginsActiveIsa()
           throws IOException, ContradictionException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsIncoming()) {
         for (RelationshipVersionBI relv : rel.getVersions(vc)) {
            if (vc.getIsaTypeNids().contains(relv.getTypeNid())) {
               ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getOriginNid());

               conceptSet.add(cv);
            }
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsIncomingOriginsIsa() throws IOException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsIncoming()) {
         for (RelationshipVersionBI relv : rel.getVersions()) {
            if (vc.getIsaTypeNids().contains(relv.getTypeNid())) {
               ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getOriginNid());

               conceptSet.add(cv);
            }
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends RelationshipChronicleBI> getRelsOutgoing() throws IOException {
      setupClassifierCharacteristics();

      Collection<? extends RelationshipChronicleBI> allRels = concept.getRelsOutgoing();
      Collection<RelationshipChronicleBI>           results = new ArrayList<>(allRels.size());

      switch (vc.getRelationshipAssertionType()) {
      case INFERRED :
         for (RelationshipChronicleBI rc : allRels) {
            for (RelationshipVersionBI<?> rv : rc.getVersions()) {
               if (classifierCharacteristics.contains(rv.getCharacteristicNid())) {
                  results.add(rc);

                  break;
               }
            }
         }

         return results;

      case INFERRED_THEN_STATED :
         return allRels;

      case STATED :
         for (RelationshipChronicleBI rc : allRels) {
            for (RelationshipVersionBI<?> rv : rc.getVersions()) {
               if (!classifierCharacteristics.contains(rv.getCharacteristicNid())) {
                  results.add(rc);

                  break;
               }
            }
         }

         return results;

      default :
         throw new RuntimeException("Can't handle: " + vc.getRelationshipAssertionType());
      }
   }

   @Override
   public Collection<? extends RelationshipVersionBI> getRelsOutgoingActive()
           throws IOException, ContradictionException {
      Collection<RelationshipVersionBI> returnValues = new ArrayList<>();

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         returnValues.addAll(rel.getVersions(vc));
      }

      return returnValues;
   }

   @Override
   public Collection<? extends RelationshipVersionBI> getRelsOutgoingActiveIsa()
           throws IOException, ContradictionException {
      Collection<RelationshipVersionBI> returnValues = new ArrayList<>();

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         for (RelationshipVersionBI rv : rel.getVersions(vc)) {
            if (vc.getIsaTypeNids().contains(rv.getTypeNid())) {
               returnValues.add(rv);
            }
         }
      }

      return returnValues;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsOutgoingDestinations() throws IOException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         for (RelationshipVersionBI relv : rel.getVersions()) {
            ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getDestinationNid());

            conceptSet.add(cv);
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsOutgoingDestinations(int typeNid) throws IOException {
      return getRelsOutgoingDestinations(new NidSet(new int[] { typeNid }));
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsOutgoingDestinations(NidSetBI typeNids)
           throws IOException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         for (RelationshipVersionBI relv : rel.getVersions()) {
            if (typeNids.contains(relv.getTypeNid())) {
               ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getDestinationNid());

               conceptSet.add(cv);
            }
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsOutgoingDestinationsActive()
           throws IOException, ContradictionException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         for (RelationshipVersionBI relv : rel.getVersions(vc)) {
            ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getDestinationNid());

            conceptSet.add(cv);
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsOutgoingDestinationsActive(int typeNid)
           throws IOException, ContradictionException {
      return getRelsOutgoingDestinationsActive(new NidSet(new int[] { typeNid }));
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsOutgoingDestinationsActive(NidSetBI typeNids)
           throws IOException, ContradictionException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         for (RelationshipVersionBI relv : rel.getVersions(vc)) {
            if (typeNids.contains(relv.getTypeNid())) {
               ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getDestinationNid());

               conceptSet.add(cv);
            }
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsOutgoingDestinationsActiveIsa()
           throws IOException, ContradictionException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         for (RelationshipVersionBI relv : rel.getVersions(vc)) {
            if (vc.getIsaTypeNids().contains(relv.getTypeNid())) {
               ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getDestinationNid());

               conceptSet.add(cv);
            }
         }
      }

      return conceptSet;
   }

   @Override
   public Collection<? extends ConceptVersionBI> getRelsOutgoingDestinationsIsa() throws IOException {
      HashSet<ConceptVersionBI> conceptSet = new HashSet<>();

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         for (RelationshipVersionBI relv : rel.getVersions()) {
            if (vc.getIsaTypeNids().contains(relv.getTypeNid())) {
               ConceptVersionBI cv = P.s.getConceptVersion(vc, relv.getDestinationNid());

               conceptSet.add(cv);
            }
         }
      }

      return conceptSet;
   }

   @Override
   public int[] getRelsOutgoingDestinationsNidsActiveIsa() throws IOException {
      OpenIntIntHashMap nidList = new OpenIntIntHashMap(10);

      for (RelationshipChronicleBI rel : getRelsOutgoing()) {
         for (RelationshipVersionBI relv : rel.getVersions(vc)) {
            if (vc.getIsaTypeNids().contains(relv.getTypeNid())) {
               nidList.put(relv.getDestinationNid(), relv.getDestinationNid());
            }
         }
      }

      return nidList.keys().elements();
   }

   @Override
   public int getStampNid() {
      throw new UnsupportedOperationException("Not supported.");
   }

   @Override
   public int getStatusNid() {
      try {
         return getConAttrs().getStatusNid();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public Collection<? extends DescriptionVersionBI> getSynonyms() throws IOException {
      if (synonymOrder == null) {
         synonymOrder = new NidList();
         synonymOrder.add(ReferenceConcepts.ACCEPTABLE_ACCEPTABILITY.getNid());
         synonymOrder.add(ReferenceConcepts.SYNONYM_RF1.getNid());
         synonymOrder.add(ReferenceConcepts.SYNONYM_RF2.getNid());
      }

      throw new UnsupportedOperationException();
   }

   @Override
   public long getTime() {
      try {
         return getConAttrs().getTime();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public List<UUID> getUUIDs() {
      return concept.getUUIDs();
   }

   @Override
   public ConceptVersionBI getVersion(ViewCoordinate c) {
      return concept.getVersion(c);
   }

   @Override
   public Collection<? extends ConceptVersionBI> getVersions() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Collection<? extends ConceptVersionBI> getVersions(ViewCoordinate c) {
      return concept.getVersions();
   }

   @Override
   public ViewCoordinate getViewCoordinate() {
      return vc;
   }

   @Override
   public boolean hasAnnotationMemberActive(int refsetNid) throws IOException {
      return concept.hasCurrentAnnotationMember(vc, refsetNid);
   }

   @Override
   public boolean hasChildren() throws IOException, ContradictionException {
      Collection<? extends RelationshipVersionBI> children = this.getRelsIncomingActive();

      if (children.isEmpty()) {
         return false;
      }

      return true;
   }

   @Override
   public boolean hasCurrentAnnotationMember(ViewCoordinate xyz, int refsetNid) throws IOException {
      return concept.hasCurrentAnnotationMember(xyz, refsetNid);
   }

   @Override
   public boolean hasCurrentRefexMember(ViewCoordinate xyz, int refsetNid) throws IOException {
      return concept.hasCurrentRefexMember(xyz, refsetNid);
   }

   @Override
   public boolean hasCurrentRefsetMemberForComponent(ViewCoordinate vc, int componentNid) throws IOException {
      return concept.hasCurrentRefsetMemberForComponent(vc, componentNid);
   }

   @Override
   public boolean hasHistoricalRels() throws IOException, ContradictionException {
      boolean                                       history = false;
      Collection<? extends RelationshipChronicleBI> outRels = getRelsOutgoing();

      if (outRels != null) {
         NidSet historicalTypeNids = new NidSet();

         for (ConceptSpec spec : HistoricalRelType.getHistoricalTypes()) {
            historicalTypeNids.add(spec.getStrict(vc).getNid());
         }

         for (RelationshipChronicleBI outRel : outRels) {
            RelationshipVersionBI<?> vOutRel = outRel.getVersion(vc);

            if (vOutRel != null) {
               if (historicalTypeNids.contains(vOutRel.getTypeNid())) {
                  history = true;

                  break;
               }
            }
         }
      }

      return history;
   }

   @Override
   public boolean hasRefexMemberActive(int refsetNid) throws IOException {
      return concept.hasCurrentRefexMember(vc, refsetNid);
   }

   @Override
   public boolean hasRefsetMemberForComponentActive(int componentNid) throws IOException {
      return concept.hasCurrentRefsetMemberForComponent(vc, componentNid);
   }

   @Override
   public boolean isActive() throws IOException {
      try {
         if (getConAttrsActive() == null) {
            return false;
         }

         return true;
      } catch (ContradictionException ex) {
         for (ConAttrVersionBI version : concept.getConceptAttributes().getVersions(vc)) {
            if (vc.getAllowedStatusNids().contains(version.getStatusNid())) {
               return true;
            }
         }
      }

      return false;
   }

   @Override
   public boolean isActive(NidSetBI allowedStatusNids) throws IOException {
      ViewCoordinate tempVc = new ViewCoordinate(UUID.randomUUID(), "isActive temp", vc);

      tempVc.getAllowedStatusNids().clear();
      tempVc.getAllowedStatusNids().addAll(allowedStatusNids.getSetValues());

      try {
         if (concept.getConceptAttributes().getVersion(tempVc) == null) {
            return false;
         }

         if ((allowedStatusNids == null) || (allowedStatusNids.size() == 0)) {
            return true;
         }

         return allowedStatusNids.contains(getConAttrsActive().getStatusNid());
      } catch (ContradictionException ex) {
         for (ConAttrVersionBI version : concept.getConceptAttributes().getVersions(tempVc)) {
            if (allowedStatusNids.contains(version.getStatusNid())) {
               return true;
            }
         }
      }

      return false;
   }

   @Override
   public boolean isActive(ViewCoordinate vc) throws IOException {
      return isActive(vc.getAllowedStatusNids());
   }

   @Override
   public boolean isAnnotationStyleRefex() throws IOException {
      return concept.isAnnotationStyleRefex();
   }

   @Override
   public boolean isBaselineGeneration() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public boolean isChildOf(ConceptVersionBI possibleParent) throws IOException {
      for (int nid : getRelsOutgoingDestinationsNidsActiveIsa()) {
         if (nid == possibleParent.getNid()) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean isKindOf(ConceptVersionBI possibleKind) throws IOException, ContradictionException {
      return Ts.get().isKindOf(getNid(), possibleKind.getNid(), vc);
   }

   @Override
   public boolean isLeaf() throws IOException {
      return P.s.getPossibleChildren(concept.nid, vc).length == 0;
   }

   // TODO
   @Override
   public boolean isMember(int collectionNid) throws IOException {
      boolean isMember = false;

      try {
         Collection<? extends RefexChronicleBI<?>> refexes =
            concept.getConceptAttributes().getCurrentRefexes(vc);

         if (refexes != null) {
            for (RefexChronicleBI<?> refex : refexes) {
               if (refex.getRefexNid() == collectionNid) {
                  return true;
               }
            }
         }

         return isMember;
      } catch (Exception e) {
         throw new IOException(e);    // AceLog.getAppLog().alertAndLogException(e);
      }
   }

   @Override
   public boolean isUncommitted() {
      return concept.isUncommitted();
   }

    @Override
    public boolean isAnnotationIndex() throws IOException {
        return concept.isAnnotationIndex();
    }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setAnnotationStyleRefex(boolean annotationStyleRefset) {
      concept.setAnnotationStyleRefex(annotationStyleRefset);
   }
}
