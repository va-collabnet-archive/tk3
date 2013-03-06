package org.ihtsdo.ttk.concept.cc.concept;

import org.ihtsdo.ttk.api.PositionSetBI;
import org.ihtsdo.ttk.api.ProcessComponentChronicleBI;
import org.ihtsdo.ttk.api.NidListBI;
import org.ihtsdo.ttk.api.Precedence;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.ContradictionManagerBI;
import org.ihtsdo.ttk.api.ComponentChroncileBI;
import org.ihtsdo.ttk.api.NidSet;
import org.ihtsdo.ttk.api.NidSetBI;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.RelAssertionType;
import org.ihtsdo.ttk.api.PositionBI;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ihtsdo.ttk.concept.jsr166y.ConcurrentReferenceHashMap;
import org.ihtsdo.ttk.concept.cc.LanguageSortPrefs.LANGUAGE_SORT_PREF;
import org.ihtsdo.ttk.concept.cc.NidPair;
import org.ihtsdo.ttk.concept.cc.NidPairForRefex;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.ReferenceConcepts;
import org.ihtsdo.ttk.concept.cc.attributes.ConceptAttributes;
import org.ihtsdo.ttk.concept.cc.change.LastChange;
import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.concept.processor.AdjudicationAnalogCreator;
import org.ihtsdo.ttk.concept.cc.concept.processor.VersionFlusher;
import org.ihtsdo.ttk.concept.cc.description.Description;
import org.ihtsdo.ttk.concept.cc.description.Description.Version;
import org.ihtsdo.ttk.concept.cc.lucene.LuceneManager;
import org.ihtsdo.ttk.concept.cc.media.Media;
import org.ihtsdo.ttk.concept.cc.refex.RefexMember;
import org.ihtsdo.ttk.concept.cc.refex.RefexMemberFactory;
import org.ihtsdo.ttk.concept.cc.relationship.Relationship;
import org.ihtsdo.ttk.concept.cc.relationship.group.RelGroupChronicle;
import org.ihtsdo.ttk.concept.cc.relationship.group.RelGroupVersion;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.blueprint.ConceptCB;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.ttk.api.changeset.ChangeSetGenerationThreadingPolicy;
import org.ihtsdo.ttk.api.conattr.ConAttrChronicleBI;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.conflict.IdentifyAllConflictStrategy;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate.LANGUAGE_SORT;
import org.ihtsdo.ttk.api.cs.ChangeSetPolicy;
import org.ihtsdo.ttk.api.cs.ChangeSetWriterThreading;
import org.ihtsdo.ttk.api.description.DescriptionChronicleBI;
import org.ihtsdo.ttk.api.id.IdBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.ttk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.api.relationship.group.RelGroupChronicleBI;
import org.ihtsdo.ttk.api.relationship.group.RelGroupVersionBI;
import org.ihtsdo.ttk.api.metadata.binding.SnomedMetadataRfx;
import org.ihtsdo.ttk.dto.TkConcept;
import org.ihtsdo.ttk.dto.component.attribute.TkConceptAttributes;
import org.ihtsdo.ttk.dto.component.description.TkDescription;
import org.ihtsdo.ttk.dto.component.media.TkMedia;
import org.ihtsdo.ttk.dto.component.refex.TkRefexAbstractMember;
import org.ihtsdo.ttk.dto.component.relationship.TkRelationship;
import org.ihtsdo.ttk.api.hash.Hashcode;

public class Concept implements ConceptChronicleBI, Comparable<Concept> {

    protected static final Logger logger = Logger.getLogger(Concept.class.getName());
    public static ReferenceType refType = ReferenceType.WEAK;
    private static int fsXmlDescNid = Integer.MIN_VALUE;
    private static int fsDescNid = Integer.MIN_VALUE;
    public static ConcurrentReferenceHashMap<Integer, Object> componentsCRHM;
    public static ConcurrentReferenceHashMap<Integer, Concept> conceptsCRHM;
    private static NidSet rf1LangRefexNidSet;
    private static NidSet rf2LangRefexNidSet;
    private static List<TkRefexAbstractMember<?>> unresolvedAnnotations;

    //~--- static initializers -------------------------------------------------
    static {
        init();
    }
    //~--- fields --------------------------------------------------------------
    private boolean canceled = false;
    NidSetBI allowedStatus;
    NidSetBI allowedTypes;
    ContradictionManagerBI contradictionManager;
    private I_ManageConceptData data;
    protected int hashCode;
    protected int nid;
    PositionSetBI positions;
    Precedence precedencePolicy;

    //~--- constructors --------------------------------------------------------
    private Concept(int nid) throws IOException {
        super();
        assert nid != Integer.MAX_VALUE : "nid == Integer.MAX_VALUE";
        this.nid = nid;
        this.hashCode = Hashcode.compute(nid);

        switch (refType) {
            case SOFT:
            case WEAK:
                data = new ConceptDataSimpleReference(this);

                break;

            case STRONG:
                throw new UnsupportedOperationException();

            default:
                throw new UnsupportedOperationException("Can't handle reference type: " + refType);
        }
    }

    private Concept(int nid, NidDataInMemory conceptData) throws IOException {
        super();
        assert nid != Integer.MAX_VALUE : "nid == Integer.MAX_VALUE";
        this.nid = nid;
        this.hashCode = Hashcode.compute(nid);

        switch (refType) {
            case SOFT:
            case WEAK:
                this.data = new ConceptDataSimpleReference(this, conceptData);

                break;

            case STRONG:
                throw new UnsupportedOperationException();

            default:
                throw new UnsupportedOperationException("Can't handle reference type: " + refType);
        }
    }

    /**
     * For use in testing/test cases only.
     *
     * @param nid
     * @param editable
     * @param roBytes
     * @param mutableBytes
     * @throws IOException
     */
    protected Concept(int nid, byte[] roBytes, byte[] mutableBytes) throws IOException {
        this.nid = nid;
        this.hashCode = Hashcode.compute(nid);
        data = new ConceptDataSimpleReference(this, roBytes, mutableBytes);
    }

    //~--- methods -------------------------------------------------------------
    @Override
    public boolean addAnnotation(RefexChronicleBI<?> annotation) throws IOException {
        return getConceptAttributes().addAnnotation(annotation);
    }

    public boolean addMemberNid(int nid) throws IOException {
        Set<Integer> memberNids = data.getMemberNids();

        if (!memberNids.contains(nid)) {
            memberNids.add(nid);
            modified();

            return true;
        }

        return false;
    }

    @Override
    public void cancel() throws IOException {
        LastChange.touchComponents(getConceptNidsAffectedByCommit());
        data.cancel();

        if (P.s.forget(getConceptAttributes())) {
            canceled = true;
        }
    }

    private void collectPossibleKindOf(NidSetBI isATypes, NidBitSetBI possibleKindOfConcepts, int cNid)
            throws IOException {
        for (int cNidForOrigin : P.s.getDestRelOriginNids(cNid, isATypes)) {
            if (possibleKindOfConcepts.isMember(cNidForOrigin) == false) {
                possibleKindOfConcepts.setMember(cNidForOrigin);
                collectPossibleKindOf(isATypes, possibleKindOfConcepts, cNidForOrigin);
            }
        }
    }

    @Override
    public boolean commit(ChangeSetGenerationPolicy changeSetPolicy,
            ChangeSetGenerationThreadingPolicy changeSetWriterThreading)
            throws IOException {
        this.modified();

        return P.s.commit(this, ChangeSetPolicy.get(changeSetPolicy),
                ChangeSetWriterThreading.get(changeSetWriterThreading));
    }

    public boolean commit(ChangeSetPolicy changeSetPolicy, ChangeSetWriterThreading changeSetWriterThreading)
            throws IOException {
        return P.s.commit(this, changeSetPolicy, changeSetWriterThreading);
    }

    @Override
    public int compareTo(Concept o) {
        return getNid() - o.getNid();
    }

    private void diet() {
        data.diet();
    }

    public static void disableComponentsCRHM() {
        componentsCRHM = new ConcurrentReferenceHashMap<Integer, Object>(ConcurrentReferenceHashMap.ReferenceType.STRONG,
                ConcurrentReferenceHashMap.ReferenceType.WEAK) {
            @Override
            public Object put(Integer key, Object value) {
                return null;
            }

            @Override
            public void putAll(Map<? extends Integer, ? extends Object> m) {
                // nothing to do;
            }

            @Override
            public Object putIfAbsent(Integer key, Object value) {
                return null;
            }

            @Override
            public boolean replace(Integer key, Object oldValue, Object newValue) {
                return false;
            }

            @Override
            public Object replace(Integer key, Object value) {
                return false;
            }
        };
    }

    public static void enableComponentsCRHM() {
        componentsCRHM = new ConcurrentReferenceHashMap<>(ConcurrentReferenceHashMap.ReferenceType.STRONG,
                ConcurrentReferenceHashMap.ReferenceType.WEAK);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (Concept.class.isAssignableFrom(obj.getClass())) {
            Concept another = (Concept) obj;

            return nid == another.nid;
        }

        return false;
    }

    public void flushVersions() throws Exception {
        processComponentChronicles(new VersionFlusher());
    }

    private void formatCollection(StringBuffer buff, Collection<?> list) {
        if ((list != null) && (list.size() > 0)) {
            buff.append("[\n");

            for (Object obj : list) {
                buff.append("   ");
                buff.append(obj);
                buff.append(",\n");
            }

            buff.append("]");
        } else {
            buff.append("[]");
        }
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    private static void init() {
        conceptsCRHM = new ConcurrentReferenceHashMap<>(ConcurrentReferenceHashMap.ReferenceType.STRONG,
                ConcurrentReferenceHashMap.ReferenceType.WEAK);
        componentsCRHM = new ConcurrentReferenceHashMap<>(ConcurrentReferenceHashMap.ReferenceType.STRONG,
                ConcurrentReferenceHashMap.ReferenceType.WEAK);
        unresolvedAnnotations = new ArrayList<>();
        fsXmlDescNid = Integer.MIN_VALUE;
        fsDescNid = Integer.MIN_VALUE;
        rf1LangRefexNidSet = new NidSet();
        rf1LangRefexNidSet.add(ReferenceConcepts.FULLY_SPECIFIED_RF1.getNid());
        rf1LangRefexNidSet.add(ReferenceConcepts.PREFERRED_RF1.getNid());
        rf1LangRefexNidSet.add(ReferenceConcepts.SYNONYM_RF1.getNid());
        rf2LangRefexNidSet = new NidSet();
        rf2LangRefexNidSet.add(ReferenceConcepts.FULLY_SPECIFIED_RF2.getNid());
        rf2LangRefexNidSet.add(ReferenceConcepts.SYNONYM_RF2.getNid());
        rf2LangRefexNidSet.add(ReferenceConcepts.FULLY_SPECIFIED_RF1.getNid());
        rf2LangRefexNidSet.add(ReferenceConcepts.PREFERRED_RF1.getNid());
        rf2LangRefexNidSet.add(ReferenceConcepts.SYNONYM_RF1.getNid());
    }

    @Override
    public boolean makeAdjudicationAnalogs(EditCoordinate ec, ViewCoordinate vc) throws Exception {
        AdjudicationAnalogCreator aac = new AdjudicationAnalogCreator(ec, vc);

        processComponentChronicles(aac);

        return aac.isComponentChanged();
    }

    public ConceptCB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB {
        ConceptVersion cv = getVersion(vc);
        UUID[] uuidArray = new UUID[cv.getRelsOutgoingDestinationsActiveIsa().size()];
        int index = 0;

        for (ConceptVersionBI parent : cv.getRelsOutgoingDestinationsActiveIsa()) {
            uuidArray[index] = parent.getPrimUuid();
            index++;
        }

        ConceptCB cab = new ConceptCB(getVersion(vc), UUID.randomUUID());

        return cab;
    }

    public static Concept mergeAndWrite(TkConcept eConcept, Set<ConceptChronicleBI> indexedAnnotationConcepts)
            throws IOException {
        int conceptNid = P.s.getNidForUuids(eConcept.getPrimordialUuid());

        assert conceptNid != Integer.MAX_VALUE : "no conceptNid for uuids";

        Concept c = get(conceptNid);

        mergeWithEConcept(eConcept, c, true, indexedAnnotationConcepts);
        P.s.addUncommittedNoChecks(c);

        return c;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Concept mergeWithEConcept(TkConcept eConcept, Concept c, boolean updateLucene,
            Set<ConceptChronicleBI> indexedAnnotationConcepts)
            throws IOException {
        if (c.isAnnotationStyleRefex() == false) {
            c.setAnnotationStyleRefex(eConcept.isAnnotationStyleRefex());
        }

        TkConceptAttributes eAttr = eConcept.getConceptAttributes();

        if (eAttr != null) {
            if (c.getConceptAttributes() == null) {
                setAttributesFromEConcept(c, eAttr);
            } else {
                ConceptAttributes ca = c.getConceptAttributes();

                ca.merge(new ConceptAttributes(eAttr, c), indexedAnnotationConcepts);
            }
        }

        if ((eConcept.getDescriptions() != null) && !eConcept.getDescriptions().isEmpty()) {
            if ((c.getDescriptions() == null) || c.getDescriptions().isEmpty()) {
                setDescriptionsFromEConcept(eConcept, c);
            } else {
                Set<Integer> currentDNids = c.data.getDescNids();

                for (TkDescription ed : eConcept.getDescriptions()) {
                    int dNid = P.s.getNidForUuids(ed.primordialUuid);

                    if (currentDNids.contains(dNid)) {
                        Description d = c.getDescription(dNid);

                        d.merge(new Description(ed, c), indexedAnnotationConcepts);
                    } else {
                        c.getDescriptions().add(new Description(ed, c));
                    }
                }
            }

            if (updateLucene) {
                LuceneManager.writeToLucene(c.getDescriptions());
            }
        }

        if ((eConcept.getRelationships() != null) && !eConcept.getRelationships().isEmpty()) {
            if ((c.getNativeSourceRels() == null) || c.getNativeSourceRels().isEmpty()) {
                setRelationshipsFromEConcept(eConcept, c);
            } else {
                Set<Integer> currentSrcRelNids = c.data.getSrcRelNids();

                for (TkRelationship er : eConcept.getRelationships()) {
                    int rNid = P.s.getNidForUuids(er.primordialUuid);

                    if (currentSrcRelNids.contains(rNid)) {
                        Relationship r = c.getRelationship(rNid);

                        r.merge(new Relationship(er, c), indexedAnnotationConcepts);
                    } else {
                        c.getNativeSourceRels().add(new Relationship(er, c));
                    }
                }
            }
        }

        if ((eConcept.getMedia() != null) && !eConcept.getMedia().isEmpty()) {
            if ((c.getImages() == null) || c.getImages().isEmpty()) {
                setImagesFromEConcept(eConcept, c);
            } else {
                Set<Integer> currentImageNids = c.data.getImageNids();

                for (TkMedia eImg : eConcept.getMedia()) {
                    int iNid = P.s.getNidForUuids(eImg.primordialUuid);

                    if (currentImageNids.contains(iNid)) {
                        Media img = c.getImage(iNid);

                        img.merge(new Media(eImg, c), indexedAnnotationConcepts);
                    } else {
                        c.getImages().add(new Media(eImg, c));
                    }
                }
            }
        }

        if ((eConcept.getRefsetMembers() != null) && !eConcept.getRefsetMembers().isEmpty()) {
            if (c.isAnnotationStyleRefex()) {
                for (TkRefexAbstractMember<?> er : eConcept.getRefsetMembers()) {
                    ConceptComponent cc;
                    Object referencedComponent = P.s.getComponent(er.getComponentUuid());

                    if (referencedComponent != null) {
                        if (referencedComponent instanceof Concept) {
                            cc = ((Concept) referencedComponent).getConceptAttributes();
                        } else {
                            cc = (ConceptComponent) referencedComponent;
                        }

                        RefexMember r = (RefexMember) P.s.getComponent(er.getPrimordialComponentUuid());

                        if (r == null) {
                            cc.addAnnotation(RefexMemberFactory.create(er, P.s.getConceptNidForNid(cc.getNid())));
                        } else {
                            r.merge((RefexMember) RefexMemberFactory.create(er,
                                    P.s.getConceptNidForNid(cc.getNid())), indexedAnnotationConcepts);
                        }
                    } else {
                        unresolvedAnnotations.add(er);
                    }
                }
            } else {
                if ((c.getRefsetMembers() == null) || c.getRefsetMembers().isEmpty()) {
                    setRefsetMembersFromEConcept(eConcept, c);
                } else {
                    Set<Integer> currentMemberNids = c.data.getMemberNids();

                    for (TkRefexAbstractMember<?> er : eConcept.getRefsetMembers()) {
                        int rNid = P.s.getNidForUuids(er.primordialUuid);
                        RefexMember<?, ?> r = c.getRefsetMember(rNid);

                        if (currentMemberNids.contains(rNid) && (r != null)) {
                            r.merge((RefexMember) RefexMemberFactory.create(er, c.getNid()), indexedAnnotationConcepts);
                        } else {
                            c.getRefsetMembers().add(RefexMemberFactory.create(er, c.getNid()));
                        }
                    }
                }
            }
        }

        return c;
    }

    public void modified() {
        data.modified();
    }

    public void modified(long sequence) {
        data.modified(sequence);
    }

    private static Concept populateFromEConcept(TkConcept eConcept, Concept c) throws IOException {
        if (eConcept.getConceptAttributes() != null) {
            setAttributesFromEConcept(c, eConcept.getConceptAttributes());
        }

        if (eConcept.getDescriptions() != null) {
            setDescriptionsFromEConcept(eConcept, c);
        }

        if (eConcept.getRelationships() != null) {
            setRelationshipsFromEConcept(eConcept, c);
        }

        if (eConcept.getMedia() != null) {
            setImagesFromEConcept(eConcept, c);
        }

        if (eConcept.getRefsetMembers() != null) {
            setRefsetMembersFromEConcept(eConcept, c);
        }

        return c;
    }

    @Override
    public void processComponentChronicles(ProcessComponentChronicleBI processor) throws Exception {
        if (getConceptAttributes() != null) {
            processor.process(getConceptAttributes());
        }

        if (getDescriptions() != null) {
            for (ComponentChroncileBI cc : getDescriptions()) {
                processor.process(cc);
            }
        }

        if (getNativeSourceRels() != null) {
            for (ComponentChroncileBI cc : getNativeSourceRels()) {
                processor.process(cc);
            }
        }

        if (getImages() != null) {
            for (ComponentChroncileBI cc : getImages()) {
                processor.process(cc);
            }
        }

        if (getRefsetMembers() != null) {
            for (ComponentChroncileBI cc : getRefsetMembers()) {
                processor.process(cc);
            }
        }
    }

    public boolean readyToWrite() {
        assert nid != Integer.MAX_VALUE : "nid == Integer.MAX_VALUE";
        assert data.readyToWrite() : toLongString();

        return true;
    }

    public static void reset() {
        init();
    }

    public void resetNidData() {
        data.resetNidData();
    }

    public static void resolveUnresolvedAnnotations(Set<ConceptChronicleBI> indexedAnnotationConcepts) throws IOException {
        List<TkRefexAbstractMember<?>> cantResolve = new ArrayList<>();

        for (TkRefexAbstractMember<?> er : unresolvedAnnotations) {
            ConceptComponent cc;
            Object referencedComponent = P.s.getComponent(er.getComponentUuid());

            if (referencedComponent != null) {
                if (referencedComponent instanceof Concept) {
                    cc = ((Concept) referencedComponent).getConceptAttributes();
                } else {
                    cc = (ConceptComponent) referencedComponent;
                }

                RefexMember r = (RefexMember) P.s.getComponent(er.getPrimordialComponentUuid());

                if (r == null) {
                    cc.addAnnotation(RefexMemberFactory.create(er, P.s.getConceptNidForNid(cc.getNid())));
                } else {
                    r.merge((RefexMember) RefexMemberFactory.create(er, P.s.getConceptNidForNid(cc.getNid())),
                            indexedAnnotationConcepts);
                }
            }
        }

        if (!cantResolve.isEmpty()) {
            logger.log(Level.SEVERE, "Can't resolve annotations on import",
                    new Exception("Can't resolve some annotations on import: " + cantResolve));
        }
    }

    /**
     * Returns a longer - more complete - string representation of the object.
     *
     * @return
     */
    @Override
    public String toLongString() {
        StringBuffer buff = new StringBuffer();

        try {
            buff.append("\nConcept: \"");
            buff.append(getText());
            buff.append("\" nid: ");
            buff.append(nid);
            buff.append(" annotationRefset: ");
            buff.append(isAnnotationStyleRefex());
            buff.append(" annotationIndex: ");
            buff.append(isAnnotationIndex());
            buff.append("\n  data version: ");
            buff.append(getDataVersion());
            buff.append("\n write version: ");
            buff.append(getWriteVersion());
            buff.append("\n uncommitted: ");
            buff.append(isUncommitted());
            buff.append("\n unwritten: ");
            buff.append(isUnwritten());
            buff.append("\n attributes: ");
            buff.append(getConceptAttributes());
            buff.append("\n descriptions: ");
            formatCollection(buff, getDescriptions());
            buff.append("\n srcRels: ");
            formatCollection(buff, getNativeSourceRels());
            buff.append("\n images: ");
            formatCollection(buff, getImages());

            if (!isAnnotationStyleRefex()) {
                buff.append("\n refset members: ");
                formatCollection(buff, getExtensions());
            }

            buff.append("\n desc nids: ");
            buff.append(data.getDescNids());
            buff.append("\n src rel nids: ");
            buff.append(data.getSrcRelNids());
            buff.append("\n member nids: ");
            buff.append(data.getMemberNids());
            buff.append("\n image nids: ");
            buff.append(data.getImageNids());
            buff.append("\n");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException ", e);
        }

        return buff.toString();
    }

    @Override
    public String toString() {
        try {
            if (!isCanceled()) {
                return getText();
            }

            return "canceled concept";
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception in toString().", ex);

            return ex.toString();
        }
    }

    @Override
    public String toUserString() {
        try {
            if (!isCanceled()) {
                return getText();
            }

            return "canceled concept";
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception in toUserSTring()", ex);

            return ex.toString();
        }
    }

    public void updateXrefs() throws IOException {
        for (RefexMember<?, ?> m : getRefsetMembers()) {
            NidPairForRefex npr = NidPair.getRefexNidMemberNidPair(m.getRefexNid(), m.getNid());

            P.s.addXrefPair(m.referencedComponentNid, npr);
        }
    }

    //~--- get methods ---------------------------------------------------------
    public static Concept get(InputStream is) throws IOException {
        DataInputStream dis = new DataInputStream(is);
        int nid = dis.readInt();

        assert nid != Integer.MAX_VALUE : "nid == Integer.MAX_VALUE";

        Concept c = conceptsCRHM.get(nid);
        NidDataInMemory ndim = new NidDataInMemory(is);

        if (c == null) {
            Concept newC = new Concept(nid, ndim);

            c = conceptsCRHM.putIfAbsent(nid, newC);

            if (c == null) {
                c = newC;
            }
        }

        return c;
    }

    public static Concept get(int nid) throws IOException {
        assert nid != Integer.MAX_VALUE : "nid == Integer.MAX_VALUE";

        boolean newConcept = false;
        Concept c = conceptsCRHM.get(nid);

        if (c == null) {
            Concept newC = new Concept(nid);

            c = conceptsCRHM.putIfAbsent(nid, newC);

            if (c == null) {
                c = newC;
                newConcept = true;
            }
        }

        conceptsCRHM.put(nid, c);

        return c;
    }

    public static Concept get(TkConcept eConcept, Set<ConceptChronicleBI> indexedAnnotationConcepts)
            throws IOException {
        int conceptNid;
        if (P.s.hasUuid(eConcept.getPrimordialUuid())) {
            conceptNid = P.s.getNidForUuids(eConcept.getPrimordialUuid());
        } else if (eConcept.getConceptAttributes() != null) {
            conceptNid = P.s.getNidForUuids(eConcept.getConceptAttributes().getUuids());
        } else {
            conceptNid = P.s.getNidForUuids(eConcept.getPrimordialUuid());
        }

        P.s.setConceptNidForNid(conceptNid, conceptNid);
        assert conceptNid != Integer.MAX_VALUE : "no conceptNid for uuids";

        Concept c = get(conceptNid);

        // return populateFromEConcept(eConcept, c);
        try {
            return mergeWithEConcept(eConcept, c, false, indexedAnnotationConcepts);
        } catch (Throwable t) {
            System.out.println(t.getLocalizedMessage());
            logger.log(Level.SEVERE, "Cannot merge with eConcept: \n" + eConcept, t);
        }

        return null;
    }

    public static Concept get(int nid, byte[] roBytes, byte[] mutableBytes) throws IOException {
        assert nid != Integer.MAX_VALUE : "nid == Integer.MAX_VALUE";

        Concept c = conceptsCRHM.get(nid);

        if (c == null) {
            Concept newC = new Concept(nid, roBytes, mutableBytes);

            c = conceptsCRHM.putIfAbsent(nid, newC);

            if (c == null) {
                c = newC;
            }
        }

        return c;
    }

    @Override
    public Collection<? extends IdBI> getAdditionalIds() throws IOException {
        return getConAttrs().getAdditionalIds();
    }

    @Override
    public Collection<? extends IdBI> getAllIds() throws IOException {
        return getConAttrs().getAllIds();
    }

    public Collection<Integer> getAllNids() throws IOException {
        return data.getAllNids();
    }

    public Collection<? extends RelGroupChronicleBI> getAllRelGroups() throws IOException {
        ArrayList<RelGroupChronicleBI> results = new ArrayList<>();
        Map<Integer, HashSet<RelationshipChronicleBI>> statedGroupMap = new HashMap<>();
        Map<Integer, HashSet<RelationshipChronicleBI>> inferredGroupMap = new HashMap<>();

        for (RelationshipChronicleBI r : getRelsOutgoing()) {

            // Inferred
            for (RelationshipVersionBI rv : r.getVersions()) {
                int group = rv.getGroup();

                if (group > 0) {
                    if (rv.isInferred()) {
                        HashSet<RelationshipChronicleBI> relsInGroup = inferredGroupMap.get(group);

                        if (relsInGroup == null) {
                            relsInGroup = new HashSet<>();
                            inferredGroupMap.put(group, relsInGroup);
                        }

                        relsInGroup.add(r);
                    } else {
                        HashSet<RelationshipChronicleBI> relsInGroup = statedGroupMap.get(group);

                        if (relsInGroup == null) {
                            relsInGroup = new HashSet<>();
                            statedGroupMap.put(group, relsInGroup);
                        }

                        relsInGroup.add(r);
                    }
                }
            }
        }

        for (Entry<Integer, HashSet<RelationshipChronicleBI>> groupEntry : statedGroupMap.entrySet()) {
            results.add(new RelGroupChronicle(this, groupEntry.getKey(), groupEntry.getValue()));
        }

        for (Entry<Integer, HashSet<RelationshipChronicleBI>> groupEntry : inferredGroupMap.entrySet()) {
            results.add(new RelGroupChronicle(this, groupEntry.getKey(), groupEntry.getValue()));
        }

        return results;
    }

    @Override
    public Set<Integer> getAllStamps() throws IOException {
        Set<Integer> sapNids = new HashSet<>();

        if (getConceptAttributes() != null) {
            sapNids.addAll(getConceptAttributes().getComponentStamps());
        }

        if (getDescriptions() != null) {
            for (Description d : getDescriptions()) {
                sapNids.addAll(d.getComponentStamps());
            }
        }

        if (getRelsOutgoing() != null) {
            for (Relationship r : getNativeSourceRels()) {
                sapNids.addAll(r.getComponentStamps());
            }
        }

        if (getImages() != null) {
            for (Media i : getImages()) {
                sapNids.addAll(i.getComponentStamps());
            }
        }

        return sapNids;
    }

    @Override
    public Collection<? extends RefexChronicleBI<?>> getAnnotations() throws IOException {
        return getConceptAttributes().getAnnotations();
    }

    @Override
    public ComponentChroncileBI<?> getComponent(int nid) throws IOException {
        return data.getComponent(nid);
    }

    @Override
    public ConAttrChronicleBI getConAttrs() throws IOException {
        return getConceptAttributes();
    }

    public Collection<ConceptAttributes.Version> getConceptAttrVersions(NidSetBI allowedStatus,
            PositionSetBI viewPositions, Precedence precedence, ContradictionManagerBI contradictionMgr)
            throws IOException {
        if (isCanceled()) {
            return new ArrayList<>();
        }

        List<ConceptAttributes.Version> versions = new ArrayList<>(2);

        versions.addAll(getConceptAttributes().getVersions(allowedStatus, viewPositions, precedence,
                contradictionMgr));

        return versions;
    }

    public ConceptAttributes getConceptAttributes() throws IOException {
        if (data != null) {
            return data.getConceptAttributes();
        }

        return null;
    }

    public ArrayList<ConceptAttributes> getConceptAttributesList() throws IOException {
        ArrayList<ConceptAttributes> returnList = new ArrayList<>(1);

        returnList.add(getConceptAttributes());

        return returnList;
    }

    @Override
    public int getConceptNid() {
        return nid;
    }

    public Collection<Integer> getConceptNidsAffectedByCommit() throws IOException {
        return data.getConceptNidsAffectedByCommit();
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate vc)
            throws IOException {
        return getConceptAttributes().getCurrentAnnotationMembers(vc);
    }

    @Override
    public <T extends RefexVersionBI<?>> Collection<T> getCurrentAnnotationMembers(ViewCoordinate xyz,
            Class<T> cls)
            throws IOException {
        return getConceptAttributes().getCurrentAnnotationMembers(xyz, cls);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz,
            int refexNid)
            throws IOException {
        if (getConceptAttributes() != null) {
            return getConceptAttributes().getCurrentAnnotationMembers(xyz, refexNid);
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public <T extends RefexVersionBI<?>> Collection<T> getCurrentAnnotationMembers(ViewCoordinate xyz,
            int refexNid, Class<T> cls)
            throws IOException {
        return getConceptAttributes().getCurrentAnnotationMembers(xyz, refexNid, cls);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentRefexMembers(ViewCoordinate xyz, int refsetNid)
            throws IOException {
        if (getConceptAttributes() != null) {
            return getConceptAttributes().getCurrentRefexMembers(xyz, refsetNid);
        }

        return new ArrayList<>(0);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz) throws IOException {
        if (getConceptAttributes() != null) {
            return getConceptAttributes().getCurrentRefexes(xyz);
        }

        return new ArrayList<>(0);
    }

    @Override
    @Deprecated
    public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz, int refsetNid)
            throws IOException {
        return getCurrentRefexMembers(xyz, refsetNid);
    }

    @Override
    public RefexVersionBI<?> getCurrentRefsetMemberForComponent(ViewCoordinate vc, int componentNid)
            throws IOException {
        if (isCanceled()) {
            return null;
        }

        RefexChronicleBI<?> member = getRefsetMemberForComponent(componentNid);

        for (RefexVersionBI version : member.getVersions(vc)) {
            return version;
        }

        return null;
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentRefsetMembers(ViewCoordinate vc)
            throws IOException {
        Collection<? extends RefexChronicleBI<?>> refexes = getRefsetMembers();
        List<RefexVersionBI<?>> returnValues = new ArrayList<>(refexes.size());

        for (RefexChronicleBI<?> refex : refexes) {
            for (RefexVersionBI<?> version : refex.getVersions(vc)) {
                returnValues.add(version);
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentRefsetMembers(ViewCoordinate vc, Long cuttoffTime)
            throws IOException {
        ConcurrentSkipListSet<RefexMember<?, ?>> refsetMembers = getRefsetMembers();
        List<RefexVersionBI<?>> returnValues = new ArrayList<>(refsetMembers.size());

        for (RefexMember refex : refsetMembers) {
            for (Object o : refex.getVersions(vc, cuttoffTime)) {
                RefexVersionBI version = (RefexVersionBI) o;

                returnValues.add(version);
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }

    public I_ManageConceptData getData() {
        return data;
    }

    public long getDataVersion() {
        return data.getLastChange();
    }

    public Description.Version getDesc(NidListBI typePrefOrder, NidListBI langPrefOrder,
            NidSetBI allowedStatus, PositionSetBI positionSet,
            LANGUAGE_SORT_PREF sortPref, Precedence precedencePolicy,
            ContradictionManagerBI contradictionManager)
            throws IOException {
        Description.Version result;

        switch (sortPref) {
            case TYPE_B4_LANG:
                result = getTypePreferredDesc(getDescriptionVersions(allowedStatus,
                        new NidSet(typePrefOrder.getListArray()), positionSet, precedencePolicy,
                        contradictionManager), typePrefOrder, langPrefOrder, allowedStatus, positionSet, true);

                if (result != null) {
                    return result;
                }

                if ((getDescs() != null) && (getDescs().size() > 0)) {
                    return (Version) getDescs().iterator().next().getVersions().iterator().next();
                }

                return null;

            case LANG_REFEX:
                result = getRefexSpecifiedDesc(getDescriptionVersions(allowedStatus,
                        new NidSet(typePrefOrder.getListArray()), positionSet, precedencePolicy,
                        contradictionManager), typePrefOrder, langPrefOrder, allowedStatus, positionSet);

                if (result != null) {
                    return result;
                }

                return getDesc(typePrefOrder, langPrefOrder, allowedStatus, positionSet,
                        LANGUAGE_SORT_PREF.TYPE_B4_LANG, precedencePolicy, contradictionManager);

            case RF2_LANG_REFEX:
                result = getRf2RefexSpecifiedDesc(getDescriptionVersions(allowedStatus,
                        new NidSet(typePrefOrder.getListArray()), positionSet, precedencePolicy,
                        contradictionManager), typePrefOrder, langPrefOrder, allowedStatus, positionSet);

                if (result != null) {
                    return result;
                }

                return getDesc(typePrefOrder, langPrefOrder, allowedStatus, positionSet,
                        LANGUAGE_SORT_PREF.LANG_REFEX, precedencePolicy, contradictionManager);

            default:
                throw new IOException("Can't handle sort type: " + sortPref);
        }
    }

    public Description getDescription(int nid) throws IOException {
        if (isCanceled()) {
            return null;
        }

        for (Description d : getDescriptions()) {
            if (d.getNid() == nid) {
                return d;
            }
        }

        throw new IOException("No description: " + nid + " " + P.s.getUuidsForNid(nid) + " found in\n"
                + toLongString());
    }

    public Set<Integer> getDescriptionNids() throws IOException {
        return data.getDescNids();
    }

    public Collection<Description.Version> getDescriptionVersions(NidSetBI allowedStatus,
            NidSetBI allowedTypes, PositionSetBI viewPositions, Precedence precedence,
            ContradictionManagerBI contradictionMgr)
            throws IOException {
        if (isCanceled()) {
            return new ConcurrentSkipListSet<>(new ComponentComparator());
        }

        Collection<Description> descriptions = getDescriptions();
        List<Description.Version> versions = new ArrayList<>(descriptions.size());

        for (Description d : descriptions) {
            versions.addAll(d.getVersions(allowedStatus, allowedTypes, viewPositions, precedence,
                    contradictionMgr));
        }

        return versions;
    }

    public Collection<Description> getDescriptions() throws IOException {
        if (isCanceled()) {
            return new ConcurrentSkipListSet<>(new ComponentComparator());
        }

        return data.getDescriptions();
    }

    @Override
    public Collection<? extends DescriptionChronicleBI> getDescs() throws IOException {
        return getDescriptions();
    }

    public Collection<Relationship> getDestRels(NidSetBI allowedTypes) throws IOException {
        if (isCanceled()) {
            return new ArrayList<>();
        }

        return data.getDestRels(allowedTypes);
    }

    @Override
    public Concept getEnclosingConcept() {
        return this;
    }

    public RefexMember<?, ?> getExtension(int componentNid) throws IOException {
        if (isCanceled()) {
            return null;
        }

        return data.getRefsetMemberForComponent(componentNid);
    }

    public Collection<RefexMember<?, ?>> getExtensions() throws IOException {
        if (isCanceled()) {
            return new ArrayList<>();
        }

        return data.getRefsetMembers();
    }

    public static Concept getIfInMap(int nid) {
        return conceptsCRHM.get(nid);
    }

    public Media getImage(int nid) throws IOException {
        if (isCanceled()) {
            return null;
        }

        for (Media i : data.getImages()) {
            if (i.getNid() == nid) {
                return i;
            }
        }

        return null;
    }

    public Collection<Media> getImages() throws IOException {
        return data.getImages();
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getInactiveRefexes(ViewCoordinate xyz) throws IOException {
        return getConceptAttributes().getInactiveRefexes(xyz);
    }

    @Override
    public long getLastModificationSequence() {
        return data.getLastChange();
    }

    @Override
    public Collection<Media> getMedia() throws IOException {
        return getImages();
    }

    public Collection<Media.Version> getMediaVersions(NidSetBI allowedStatus, NidSetBI allowedTypes,
            PositionSetBI viewPositions, Precedence precedence, ContradictionManagerBI contradictionMgr)
            throws IOException {
        if (isCanceled()) {
            return new ConcurrentSkipListSet<>(new ComponentComparator());
        }

        Collection<Media> media = getImages();
        List<Media.Version> versions = new ArrayList<>(media.size());

        for (Media m : media) {
            versions.addAll(m.getVersions(allowedStatus, allowedTypes, viewPositions, precedence,
                    contradictionMgr));
        }

        return versions;
    }

    public Collection<Relationship> getNativeSourceRels() throws IOException {
        if (isCanceled()) {
            return new ConcurrentSkipListSet<>(new ComponentComparator());
        }

        return data.getSourceRels();
    }

    @Override
    public int getNid() {
        return nid;
    }

    @Override
    public Set<PositionBI> getPositions() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public NidBitSetBI getPossibleKindOfConcepts(NidSetBI isATypes) throws IOException {
        NidBitSetBI possibleKindOfConcepts = P.s.getEmptyNidSet();

        possibleKindOfConcepts.setMember(getNid());
        collectPossibleKindOf(isATypes, possibleKindOfConcepts, nid);

        return possibleKindOfConcepts;
    }

    private Description.Version getPreferredAcceptability(Collection<Description.Version> descriptions,
            int typePrefNid, ViewCoordinate vc, int langRefexNid)
            throws IOException {

        // get FSN
        Description.Version descOfType = null;

        for (Description.Version d : descriptions) {
            if (d.getTypeNid() == typePrefNid) {
                for (RefexVersionBI<?> refex : d.getCurrentRefexes(vc)) {
                    if (refex.getRefexNid() == langRefexNid) {
                        RefexNidVersionBI<?> langRefex = (RefexNidVersionBI<?>) refex;

                        if ((langRefex.getNid1() == ReferenceConcepts.PREFERRED_ACCEPTABILITY_RF1.getNid())
                                || (langRefex.getNid1()
                                == ReferenceConcepts.PREFERRED_ACCEPTABILITY_RF2.getNid())) {
                            return d;
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public UUID getPrimUuid() {
        try {
            if (getConceptAttributes() != null) {
                return getConceptAttributes().getPrimUuid();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return UUID.fromString("00000000-0000-0000-C000-000000000046");
    }

    @Override
    public ConceptVersionBI getPrimordialVersion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<? extends RefexChronicleBI<?>> getRefexMembers(int refsetNid) throws IOException {
        return getRefexes(refsetNid);
    }

    private Description.Version getRefexSpecifiedDesc(Collection<Description.Version> descriptions,
            NidListBI typePrefOrder, NidListBI langRefexOrder, NidSetBI allowedStatus,
            PositionSetBI positionSet)
            throws IOException {
        ViewCoordinate vc = new ViewCoordinate(UUID.randomUUID(), "getRefexSpecifiedDesc", Precedence.PATH,
                positionSet, allowedStatus, null, new IdentifyAllConflictStrategy(),
                Integer.MIN_VALUE, Integer.MIN_VALUE, RelAssertionType.STATED, langRefexOrder,
                LANGUAGE_SORT.LANG_REFEX);

        if (descriptions.size() > 0) {
            if (descriptions.size() > 1) {
                for (int typePrefNid : typePrefOrder.getListArray()) {
                    if ((langRefexOrder != null) && (langRefexOrder.getListValues() != null)) {
                        for (int langRefexNid : langRefexOrder.getListValues()) {
                            if (typePrefNid == ReferenceConcepts.FULLY_SPECIFIED_RF1.getNid()) {
                                Description.Version answer = getPreferredAcceptability(descriptions, typePrefNid, vc,
                                        langRefexNid);

                                if (answer != null) {
                                    return answer;
                                }
                            } else {

                                // get Preferred or other
                                Description.Version answer = getPreferredAcceptability(descriptions,
                                        ReferenceConcepts.SYNONYM_RF1.getNid(), vc,
                                        langRefexNid);

                                if (answer != null) {
                                    return answer;
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public Collection<? extends RefexChronicleBI<?>> getRefexes() throws IOException {
        return getConceptAttributes().getRefexes();
    }

    @Override
    @Deprecated
    public Collection<? extends RefexChronicleBI<?>> getRefexes(int refsetNid) throws IOException {
        return getConceptAttributes().getRefexMembers(refsetNid);
    }

    public RefexMember<?, ?> getRefsetMember(int memberNid) throws IOException {
        return data.getRefsetMember(memberNid);
    }

    @Override
    public RefexMember<?, ?> getRefsetMemberForComponent(int componentNid) throws IOException {
        if (isCanceled()) {
            return null;
        }

        return data.getRefsetMemberForComponent(componentNid);
    }

    @Override
    public ConcurrentSkipListSet<RefexMember<?, ?>> getRefsetMembers() throws IOException {
        return data.getRefsetMembers();
    }

    @Override
    public Collection<? extends RelGroupVersionBI> getRelGroups(ViewCoordinate vc) throws IOException {
        ArrayList<RelGroupVersionBI> results = new ArrayList<>();

        if (vc.getRelationshipAssertionType() == RelAssertionType.INFERRED_THEN_STATED) {
            ViewCoordinate tempVc = new ViewCoordinate(UUID.randomUUID(), "getRelGroups", vc);

            tempVc.setRelAssertionType(RelAssertionType.STATED);
            getRelGroups(tempVc, results);
            tempVc.setRelAssertionType(RelAssertionType.INFERRED);
            getRelGroups(tempVc, results);
        } else {
            getRelGroups(vc, results);
        }

        return results;
    }

    private void getRelGroups(ViewCoordinate vc, ArrayList<RelGroupVersionBI> results) throws IOException {
        Map<Integer, HashSet<RelationshipChronicleBI>> groupMap = new HashMap<>();
        ViewCoordinate tempVc = new ViewCoordinate(UUID.randomUUID(), "getRelGroups", vc);

        tempVc.setAllowedStatusNids(null);

        for (RelationshipChronicleBI r : getRelsOutgoing()) {
            for (RelationshipVersionBI rv : r.getVersions(tempVc)) {
                int group = rv.getGroup();

                if (group > 0) {
                    HashSet<RelationshipChronicleBI> relsInGroup = groupMap.get(group);

                    if (relsInGroup == null) {
                        relsInGroup = new HashSet<>();
                        groupMap.put(group, relsInGroup);
                    }

                    relsInGroup.add(r);
                }
            }
        }

        for (Entry<Integer, HashSet<RelationshipChronicleBI>> groupEntry : groupMap.entrySet()) {
            results.add(new RelGroupVersion(new RelGroupChronicle(this, groupEntry.getKey(),
                    groupEntry.getValue()), vc));
        }
    }

    public Relationship getRelationship(int relNid) throws IOException {
        for (Relationship r : getNativeSourceRels()) {
            if (r.getNid() == relNid) {
                return r;
            }
        }

        return null;
    }

    public Set<Integer> getRelationshipNids() throws IOException {
        return data.getSrcRelNidsReadOnly();
    }

    @Override
    public Collection<Relationship> getRelsIncoming() throws IOException {
        if (isCanceled()) {
            return new ArrayList<>();
        }

        return data.getDestRels();
    }

    @Override
    public Collection<Relationship> getRelsOutgoing() throws IOException {
        return getNativeSourceRels();
    }

    private Description.Version getRf2RefexSpecifiedDesc(Collection<Description.Version> descriptions,
            NidListBI typePrefOrder, NidListBI langRefexOrder, NidSetBI allowedStatus,
            PositionSetBI positionSet)
            throws IOException {
        ViewCoordinate vc = new ViewCoordinate(UUID.randomUUID(), "getRf2RefexSpecifiedDesc", Precedence.PATH,
                positionSet, allowedStatus, null, new IdentifyAllConflictStrategy(),
                Integer.MIN_VALUE, Integer.MIN_VALUE, RelAssertionType.STATED, langRefexOrder,
                LANGUAGE_SORT.RF2_LANG_REFEX);

        if (descriptions.size() > 0) {
            if (descriptions.size() > 1) {
                if ((langRefexOrder != null) && (langRefexOrder.getListValues() != null)) {
                    for (int langRefexNid : langRefexOrder.getListValues()) {
                        for (int typePrefNid : typePrefOrder.getListArray()) {
                            if (typePrefNid == ReferenceConcepts.FULLY_SPECIFIED_RF2.getNid()) {
                                Description.Version answer = getPreferredAcceptability(descriptions, typePrefNid, vc,
                                        langRefexNid);

                                if (answer != null) {
                                    return answer;
                                }
                            } else if (typePrefNid == ReferenceConcepts.SYNONYM_RF2.getNid()) {

                                // get Preferred or other
                                Description.Version answer = getPreferredAcceptability(descriptions,
                                        ReferenceConcepts.SYNONYM_RF2.getNid(), vc,
                                        langRefexNid);

                                if (answer != null) {
                                    return answer;
                                }
                            }
                        }
                    }
                }

                if ((langRefexOrder != null) && (langRefexOrder.getListValues() != null)) {
                    for (int langRefexNid : langRefexOrder.getListValues()) {
                        for (int typePrefNid : typePrefOrder.getListArray()) {
                            if (typePrefNid == ReferenceConcepts.FULLY_SPECIFIED_RF1.getNid()) {
                                Description.Version answer = getPreferredAcceptability(descriptions, typePrefNid, vc,
                                        langRefexNid);

                                if (answer != null) {
                                    return answer;
                                }
                            } else if (typePrefNid == ReferenceConcepts.SYNONYM_RF1.getNid()) {

                                // get Preferred or other
                                Description.Version answer = getPreferredAcceptability(descriptions,
                                        ReferenceConcepts.SYNONYM_RF1.getNid(), vc,
                                        langRefexNid);

                                if (answer != null) {
                                    return answer;
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    public Collection<Relationship.Version> getSrcRelVersions(NidSetBI allowedStatus, NidSetBI allowedTypes,
            PositionSetBI viewPositions, Precedence precedence, ContradictionManagerBI contradictionMgr)
            throws IOException {
        if (isCanceled()) {
            return new ArrayList<>();
        }

        Collection<Relationship> rels = getNativeSourceRels();
        List<Relationship.Version> versions = new ArrayList<>(rels.size());

        for (Relationship r : rels) {
            versions.addAll(r.getVersions(allowedStatus, allowedTypes, viewPositions, precedence,
                    contradictionMgr));
        }

        return versions;
    }

    /**
     * This method is for creating temporary concepts for unit testing only...
     *
     * @param eConcept
     * @return
     * @throws IOException
     */
    public static Concept getTempConcept(TkConcept eConcept) throws IOException {
        int conceptNid = P.s.getNidForUuids(eConcept.getConceptAttributes().getPrimordialComponentUuid());

        assert conceptNid != Integer.MAX_VALUE : "no conceptNid for uuids";

        return populateFromEConcept(eConcept, new Concept(conceptNid));
    }

    public String getText() {
        try {
            if (getDescriptions().size() > 0) {
                return getDescriptions().iterator().next().getText();
            }

            if (fsDescNid == Integer.MIN_VALUE) {
                fsDescNid = SnomedMetadataRfx.getDES_FULL_SPECIFIED_NAME_NID();
            }

            if (getDescriptions().size() > 0) {
                Description desc = getDescriptions().iterator().next();

                for (Description d : getDescriptions()) {
                    for (Description.Version part : d.getVersions()) {
                        if ((part.getTypeNid() == fsDescNid) || (part.getTypeNid() == fsXmlDescNid)) {
                            return part.getText();
                        }
                    }
                }

                return desc.getText();
            } else {
                int sequence = nid + Integer.MIN_VALUE;
                String errString = nid + " (" + sequence + ") " + " has no descriptions " + getUUIDs();

                getDescriptions();

                return errString;
            }
        } catch (IOException ex) {
            logger.log(Level.WARNING, "Exception getting text", ex);

            return ex.getLocalizedMessage();
        }
    }

    /*
     * (non-Javadoc) @see java.lang.Object#toString()
     */
    private Description.Version getTypePreferredDesc(Collection<Description.Version> descriptions,
            NidListBI typePrefOrder, NidListBI langPrefOrder, NidSetBI allowedStatus,
            PositionSetBI positionSet, boolean tryLang)
            throws IOException {
        if (descriptions.size() > 0) {
            if (descriptions.size() > 1) {
                List<Description.Version> matchedList = new ArrayList<>();

                for (int typeId : typePrefOrder.getListValues()) {
                    for (Description.Version d : descriptions) {
                        if (d.getTypeNid() == typeId) {
                            matchedList.add(d);

                            if (matchedList.size() == 2) {
                                break;
                            }
                        }
                    }

                    if (matchedList.size() > 0) {
                        return matchedList.get(0);
                    }
                }

                return descriptions.iterator().next();
            } else {
                return descriptions.iterator().next();
            }
        }

        return null;
    }

    @Override
    public List<UUID> getUUIDs() {
        try {
            if (getConceptAttributes() != null) {
                return getConceptAttributes().getUUIDs();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ArrayList<>();
    }

    public List<UUID> getUidsForComponent(int componentNid) throws IOException {
        if (getComponent(componentNid) != null) {
            return getComponent(componentNid).getUUIDs();
        }

        logger.log(Level.SEVERE, "Null component for concept.",
                new Exception("Null component: " + componentNid + " for concept: " + this.toLongString()));

        return new ArrayList<>();
    }

    public NidListBI getUncommittedNids() {
        return data.getUncommittedNids();
    }

    @Override
    public ConceptVersion getVersion(ViewCoordinate c) {
        return new ConceptVersion(this, c);
    }

    @Override
    public Collection<? extends ConceptVersionBI> getVersions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ConceptVersion> getVersions(ViewCoordinate c) {
        ArrayList<ConceptVersion> cvList = new ArrayList<>(1);

        cvList.add(new ConceptVersion(this, c));

        return cvList;
    }

    private long getWriteVersion() {
        return data.getLastWrite();
    }

    @Override
    public boolean hasCurrentAnnotationMember(ViewCoordinate xyz, int refexNid) throws IOException {
        if (getConceptAttributes() != null) {
            return getConceptAttributes().hasCurrentAnnotationMember(xyz, refexNid);
        }

        return false;
    }

    @Override
    public boolean hasCurrentRefexMember(ViewCoordinate xyz, int refsetNid) throws IOException {
        if (getConceptAttributes() != null) {
            return getConceptAttributes().hasCurrentRefexMember(xyz, refsetNid);
        }

        return false;
    }

    @Override
    public boolean hasCurrentRefsetMemberForComponent(ViewCoordinate vc, int componentNid) throws IOException {
        if (isCanceled()) {
            return false;
        }

        RefexMember<?, ?> member = getRefsetMemberForComponent(componentNid);

        if (member != null) {
            for (RefexVersionBI v : member.getVersions(vc)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasExtensionsForComponent(int nid) throws IOException {
        List<NidPairForRefex> refsetPairs = P.s.getRefexPairs(nid);

        if ((refsetPairs != null) && (refsetPairs.size() > 0)) {
            return true;
        }

        return false;
    }

    public boolean hasMediaExtensions() throws IOException {
        if ((data.getImageNids() == null) || data.getImageNids().isEmpty()) {
            return false;
        }

        for (int imageNid : data.getImageNids()) {
            if (hasExtensionsForComponent(imageNid)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isAnnotationIndex() throws IOException {
        return data.isAnnotationIndex();
    }

    @Override
    public boolean isAnnotationStyleRefex() throws IOException {
        return data.isAnnotationStyleRefex();
    }

    public boolean isCanceled() throws IOException {
        if (!canceled) {
            if ((getConAttrs() != null) && (getConAttrs().getPrimordialVersion().getTime() == Long.MIN_VALUE)) {
                canceled = true;
            }
        }

        return canceled;
    }

    public boolean isParentOf(Concept child, ViewCoordinate vc) throws IOException, ContradictionException {
        return Ts.get().isKindOf(child.nid, nid, vc);
    }

    public boolean isParentOfOrEqualTo(Concept child, ViewCoordinate vc)
            throws IOException, ContradictionException {
        if (child == this) {
            return true;
        }

        return isParentOf(child, vc);
    }

    @Override
    public boolean isUncommitted() {
        return data.isUncommitted();
    }

    public boolean isUnwritten() {
        return data.isUnwritten();
    }

    //~--- set methods ---------------------------------------------------------
    public void setAnnotationIndex(boolean annotationIndex) throws IOException {
        data.setAnnotationIndex(annotationIndex);
    }

    @Override
    public void setAnnotationStyleRefex(boolean annotationStyleRefset) {
        data.setAnnotationStyleRefset(annotationStyleRefset);
    }

    private static void setAttributesFromEConcept(Concept c, TkConceptAttributes eAttr) throws IOException {
        assert eAttr != null;

        ConceptAttributes attr = new ConceptAttributes(eAttr, c);

        c.data.set(attr);
    }

    public NidSetBI setCommitTime(long time) {
        return data.setCommitTime(time);
    }

    public void setConceptAttributes(ConceptAttributes attributes) throws IOException {
        assert attributes.nid != 0;
        nid = attributes.nid;
        data.set(attributes);
    }

    private static void setDescriptionsFromEConcept(TkConcept eConcept, Concept c) throws IOException {
        for (TkDescription eDesc : eConcept.getDescriptions()) {
            Description desc = new Description(eDesc, c);

            c.data.add(desc);
        }
    }

    private static void setImagesFromEConcept(TkConcept eConcept, Concept c) throws IOException {
        for (TkMedia eImage : eConcept.getMedia()) {
            Media img = new Media(eImage, c);

            c.data.add(img);
        }
    }

    public void setIsCanceled(boolean isCanceled) {
        canceled = isCanceled;
    }

    public void setLastWrite(long version) {
        data.setLastWrite(version);
    }

    private static void setRefsetMembersFromEConcept(TkConcept eConcept, Concept c) throws IOException {
        for (TkRefexAbstractMember<?> eRefsetMember : eConcept.getRefsetMembers()) {
            RefexMember<?, ?> refsetMember = RefexMemberFactory.create(eRefsetMember, c.getConceptNid());

            c.data.add(refsetMember);
        }
    }

    private static void setRelationshipsFromEConcept(TkConcept eConcept, Concept c) throws IOException {
        for (TkRelationship eRel : eConcept.getRelationships()) {
            Relationship rel = new Relationship(eRel, c);

            c.data.getSourceRels().add(rel);
        }
    }

    //~--- inner classes -------------------------------------------------------
    public static class Diet implements Runnable {

        long maxMemory;

        //~--- constructors -----------------------------------------------------
        public Diet(long maxMemory) {
            this.maxMemory = maxMemory;
        }

        //~--- methods ----------------------------------------------------------
        @Override
        public void run() {
            System.gc();

            double usedMemory = maxMemory - Runtime.getRuntime().freeMemory();
            double percentageUsed = ((double) usedMemory) / maxMemory;

            if (percentageUsed > 0.85) {
                for (int cNid : conceptsCRHM.keySet()) {
                    Concept c = conceptsCRHM.get(cNid);

                    if (c != null) {
                        c.diet();
                    }
                }

                usedMemory = maxMemory - Runtime.getRuntime().freeMemory();
                percentageUsed = ((double) usedMemory) / maxMemory;

                if (percentageUsed > 0.85) {
                    usedMemory = maxMemory - Runtime.getRuntime().freeMemory();
                    percentageUsed = ((double) usedMemory) / maxMemory;
                    logger.log(Level.INFO,
                            "Concept Diet + KindOfComputer.trimCache() finished recover memory. "
                            + "Percent used: {0}", percentageUsed);
                } else {
                    logger.log(Level.INFO, "Concept Diet finished recover memory. " + "Percent used: {0}",
                            percentageUsed);
                }
            } else {
                usedMemory = maxMemory - Runtime.getRuntime().freeMemory();
                percentageUsed = ((double) usedMemory) / maxMemory;
                logger.log(Level.INFO, "GC ONLY Diet finished recover memory. " + "Percent used: {0}",
                        percentageUsed);
            }
        }
    }
}
