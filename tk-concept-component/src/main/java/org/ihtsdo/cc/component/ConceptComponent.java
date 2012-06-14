package org.ihtsdo.cc.component;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.cc.refex.RefexMemberFactory;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.identifier.IdentifierVersion;
import org.ihtsdo.cc.identifier.IdentifierVersionLong;
import org.ihtsdo.cc.identifier.IdentifierVersionString;
import org.ihtsdo.cc.identifier.IdentifierVersionUuid;
import org.ihtsdo.cc.refex.RefexMember;
import org.ihtsdo.cc.P;
import org.ihtsdo.cc.refex.RefexRevision;
import org.ihtsdo.cc.NidPairForRefset;
import org.ihtsdo.helper.time.TimeHelper;
import org.ihtsdo.tk.api.*;
import org.ihtsdo.tk.api.coordinate.EditCoordinate;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.binding.TermAux;
import org.ihtsdo.tk.dto.concept.component.TkComponent;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierLong;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierString;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierUuid;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.hash.Hashcode;

public abstract class ConceptComponent<R extends Revision<R, C>, C extends ConceptComponent<R, C>>
        implements ComponentBI, ComponentVersionBI, IdBI, AnalogBI, AnalogGeneratorBI<R>, Comparable<ConceptComponent> {    
    
    protected static final Logger logger = Logger.getLogger(ConceptComponent.class.getName());

    
    private static AtomicBoolean fixAlert = new AtomicBoolean(false);
    private static AnnotationWriter annotationWriter = new AnnotationWriter();
    //~--- fields --------------------------------------------------------------
    protected ArrayList<IdentifierVersion> additionalIdVersions;
    public ConcurrentSkipListSet<RefexMember<?, ?>> annotations;
    public int enclosingConceptNid;
    public int nid;
    protected long primordialLsb;
    /**
     * primordial: first created or developed
     *
     */
    protected long primordialMsb;
    /**
     * primordial: first created or developed Sap = status, author, position; position = path, time;
     */
    public int primordialStampNid;
    public RevisionSet<R, C> revisions;

    //~--- constructors --------------------------------------------------------
    public ConceptComponent() {
        super();
    }

    protected ConceptComponent(int enclosingConceptNid, TupleInput input) throws IOException {
        super();
        this.enclosingConceptNid = enclosingConceptNid;
        readComponentFromBdb(input);

        int cNid = P.s.getConceptNidForNid(nid);

        if (cNid == Integer.MAX_VALUE) {
            P.s.setConceptNidForNid(this.enclosingConceptNid, this.nid);
        } else if (cNid != this.enclosingConceptNid) {
            P.s.resetConceptNidForNid(this.enclosingConceptNid, this.nid);

            if (fixAlert.compareAndSet(true, false)) {
                logger.log(Level.SEVERE, "a. Datafix warning. See log for details.", 
                        new Exception(String.format("a-Datafix: cNid %s %s incorrect for: %s %s should have been: {4}{5}", 
                        cNid, P.s.getUuidsForNid(cNid), this.nid, P.s.getUuidsForNid(this.nid), 
                            this.enclosingConceptNid, P.s.getUuidsForNid(this.enclosingConceptNid))));
            }

        }

        assert nid != Integer.MAX_VALUE : "Processing nid: " + enclosingConceptNid;
    }

    // TODO move the EComponent constructors to a helper class or factory class...
    // So that the size of this class is kept limited ?
    protected ConceptComponent(TkComponent<?> eComponent, int enclosingConceptNid) throws IOException {
        super();
        assert eComponent != null;
        this.nid = P.s.getNidForUuids(eComponent.primordialUuid);
        assert this.nid != Integer.MAX_VALUE : "Processing nid: " + enclosingConceptNid;
        this.enclosingConceptNid = enclosingConceptNid;

        int cNid = P.s.getConceptNidForNid(nid);

        if (cNid == Integer.MAX_VALUE) {
            P.s.setConceptNidForNid(this.enclosingConceptNid, this.nid);
        } else if (cNid != this.enclosingConceptNid) {
            P.s.resetConceptNidForNid(this.enclosingConceptNid, this.nid);
            if (fixAlert.compareAndSet(true, false)) {
                logger.log(Level.SEVERE, "b. Datafix warning. See log for details.", 
                        new Exception(String.format("b-Datafix: cNid %s %s incorrect for: %s %s should have been: {4}{5}", 
                        cNid, P.s.getUuidsForNid(cNid), this.nid, P.s.getUuidsForNid(this.nid), 
                            this.enclosingConceptNid, P.s.getUuidsForNid(this.enclosingConceptNid))));
            }
        }

        this.primordialStampNid = P.s.getSapNid(eComponent);
        assert primordialStampNid > 0 : " Processing nid: " + enclosingConceptNid;
        this.primordialMsb = eComponent.getPrimordialComponentUuid().getMostSignificantBits();
        this.primordialLsb = eComponent.getPrimordialComponentUuid().getLeastSignificantBits();
        convertId(eComponent.additionalIds);
        assert nid != Integer.MAX_VALUE : "Processing nid: " + enclosingConceptNid;

        if (eComponent.getAnnotations() != null) {
            this.annotations = new ConcurrentSkipListSet<>();

            for (TkRefexAbstractMember<?> eAnnot : eComponent.getAnnotations()) {
                RefexMember<?, ?> annot = RefexMemberFactory.create(eAnnot, enclosingConceptNid);

                this.annotations.add(annot);
            }
        }
    }

    //~--- enums ---------------------------------------------------------------
    public enum IDENTIFIER_PART_TYPES {

        LONG(1), STRING(2), UUID(3);
        private int partTypeId;

        //~--- constructors -----------------------------------------------------
        IDENTIFIER_PART_TYPES(int partTypeId) {
            this.partTypeId = partTypeId;
        }

        //~--- methods ----------------------------------------------------------
        public static IDENTIFIER_PART_TYPES readType(TupleInput input) {
            int partTypeId = input.readByte();

            switch (partTypeId) {
                case 1:
                    return LONG;

                case 2:
                    return STRING;

                case 3:
                    return UUID;
            }

            throw new UnsupportedOperationException("partTypeId: " + partTypeId);
        }

        public void writeType(TupleOutput output) {
            output.writeByte(partTypeId);
        }

        //~--- get methods ------------------------------------------------------
        public static IDENTIFIER_PART_TYPES getType(Class<?> denotationClass) {
            if (UUID.class.isAssignableFrom(denotationClass)) {
                return UUID;
            } else if (Long.class.isAssignableFrom(denotationClass)) {
                return LONG;
            } else if (String.class.isAssignableFrom(denotationClass)) {
                return STRING;
            }

            throw new UnsupportedOperationException(denotationClass.toString());
        }
    }

    //~--- methods -------------------------------------------------------------
    @SuppressWarnings("rawtypes")
    @Override
    public boolean addAnnotation(RefexChronicleBI annotation) throws IOException {
        if (annotations == null) {
            annotations = new ConcurrentSkipListSet<>(new Comparator<RefexChronicleBI>() {

                @Override
                public int compare(RefexChronicleBI t, RefexChronicleBI t1) {
                    return t.getNid() - t1.getNid();
                }
            });
        }

        modified();
        P.s.xrefAnnotation(annotation);

        return annotations.add((RefexMember<?, ?>) annotation);
    }

    abstract protected void addComponentNids(Set<Integer> allNids);

    public boolean addIdVersion(IdentifierVersion srcId) {
        if (additionalIdVersions == null) {
            additionalIdVersions = new ArrayList<>();
        }

        boolean returnValue = additionalIdVersions.add(srcId);

        Concept c = getEnclosingConcept();

        c.modified();

        return returnValue;
    }

    @Override
    public boolean addLongId(Long longId, int authorityNid, int statusNid, EditCoordinate ec, long time) {
        IdentifierVersionLong v = null;

        for (int path : ec.getEditPaths().getSetValues()) {
            v = new IdentifierVersionLong(statusNid, time, ec.getAuthorNid(), ec.getModuleNid(), path, 
                     authorityNid, longId);
        }

        return addIdVersion(v);
    }

    public final boolean addMutablePart(R version) {
        return addRevision(version);
    }

    public static void addNidToBuffer(Appendable buf, int nidToConvert) {
        try {
            if ((nidToConvert != 0) && P.s.getConceptNidForNid(nidToConvert) == nidToConvert) {
                buf.append("\"");
                buf.append(P.s.getConcept(nidToConvert).toString());
                buf.append("\" [");
                buf.append(Integer.toString(nidToConvert));
                buf.append("]");
            } else {
                buf.append(Integer.toString(nidToConvert));
            }
        } catch (IOException e) {
            try {
                buf.append(e.getLocalizedMessage());
                logger.log(Level.WARNING, e.getLocalizedMessage(), e);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public final boolean addRevision(R r) {
        assert r != null;

        boolean returnValue;
        Concept c = getEnclosingConcept();

        assert c != null : "Can't find concept for: " + r;

        if (revisions == null) {
            revisions = new RevisionSet(primordialStampNid);
            returnValue = revisions.add(r);
        } else {
            returnValue = revisions.add(r);
        }

        r.primordialComponent = (C) this;
        c.modified();
        clearVersions();

        return returnValue;
    }

    public final boolean addRevisionNoRedundancyCheck(R r) {
        return addRevision(r);
    }

    public boolean addStringId(String stringId, int authorityNid, int statusNid,
            long time, int authorNid, int moduleNid, int pathNid) {
        IdentifierVersionString v = new IdentifierVersionString(statusNid, time, authorNid, moduleNid, pathNid,
                stringId, authorityNid);

        return addIdVersion(v);
    }

    public static void addTextToBuffer(Appendable buf, int nidToConvert) {
        try {
            if ((nidToConvert != 0) && P.s.getConceptNidForNid(nidToConvert) == nidToConvert) {
                buf.append(P.s.getConcept(nidToConvert).toString());
            } else {
                buf.append(Integer.toString(nidToConvert));
            }
        } catch (IOException e) {
            try {
                buf.append(e.getLocalizedMessage());
            } catch (IOException ex) {
                logger.log(Level.WARNING, ex.getLocalizedMessage(), ex);
            }
        }
    }

    public boolean addUuidId(UUID uuidId, int authorityNid, int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
        IdentifierVersionUuid v = new IdentifierVersionUuid(statusNid, time,
                authorNid, moduleNid, pathNid, authorityNid, uuidId);

        return addIdVersion(v);
    }

    protected String assertionString() {
        try {
            return P.s.getConcept(enclosingConceptNid).toLongString();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return toString();
    }

    public void cancel() {
        clearVersions();

        if (this.getTime() == Long.MAX_VALUE) {
            this.primordialStampNid = -1;
        }

        if (additionalIdVersions != null) {
            List<IdentifierVersion> toRemove = new ArrayList<>();

            for (IdentifierVersion idv : additionalIdVersions) {
                if (idv.getTime() == Long.MAX_VALUE) {
                    toRemove.add(idv);
                    idv.setTime(Long.MIN_VALUE);
                    idv.setStampNid(-1);
                }
            }

            if (toRemove.size() > 0) {
                for (IdentifierVersion idv : toRemove) {
                    additionalIdVersions.remove(idv);
                }
            }
        }

        if (revisions != null) {
            List<R> toRemove = new ArrayList<>();

            for (R r : revisions) {
                if (r.getTime() == Long.MAX_VALUE) {
                    toRemove.add(r);
                }
            }

            if (toRemove.size() > 0) {
                for (R r : toRemove) {
                    revisions.remove(r);
                }
            }
        }

        if (annotations != null) {
            List<Object> toRemove = new ArrayList<>();

            for (RefexMember<?, ?> a : annotations) {
                a.clearVersions();

                if (a.getTime() == Long.MAX_VALUE) {
                    toRemove.add(a);
                } else if (a.revisions != null) {
                    for (RefexRevision rv : a.revisions) {
                        List<RefexRevision> revToRemove = new ArrayList<>();

                        if (rv.getTime() == Long.MAX_VALUE) {
                            revToRemove.add(rv);
                        }

                        a.revisions.removeAll(revToRemove);
                    }
                }
            }

            if (toRemove.size() > 0) {
                for (Object r : toRemove) {
                    annotations.remove((RefexMember<?, ?>) r);
                }
            }
        }
    }

    protected void clearAnnotationVersions() {
        if (annotations != null) {
            for (RefexMember<?, ?> rm : annotations) {
                rm.clearVersions();
            }
        }
    }

    public abstract void clearVersions();

    public boolean conceptComponentFieldsEqual(ConceptComponent<R, C> another) {
        if (this.nid != another.nid) {
            return false;
        }

        if (this.primordialStampNid != another.primordialStampNid) {
            return false;
        }

        if (this.primordialLsb != another.primordialLsb) {
            return false;
        }

        if (this.primordialMsb != another.primordialMsb) {
            return false;
        }

        if ((this.additionalIdVersions != null) && (another.additionalIdVersions == null)) {
            return false;
        }

        if ((this.additionalIdVersions == null) && (another.additionalIdVersions != null)) {
            return false;
        }

        if (this.additionalIdVersions != null) {
            if (this.additionalIdVersions.equals(another.additionalIdVersions) == false) {
                return false;
            }
        }

        if ((this.revisions != null) && (another.revisions == null)) {
            return false;
        }

        if ((this.revisions == null) && (another.revisions != null)) {
            return false;
        }

        if (this.revisions != null) {
            if (this.revisions.equals(another.revisions) == false) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int compareTo(ConceptComponent o) {
        return this.nid - o.nid;
    }

    public boolean containsSapt(int sapt) {
        if (primordialStampNid == sapt) {
            return true;
        }

        if (revisions != null) {
            for (Revision r : revisions) {
                if (r.stampNid == sapt) {
                    return true;
                }
            }
        }

        return false;
    }

    public final void convertId(List<TkIdentifier> list) throws IOException {
        if ((list == null) || list.isEmpty()) {
            return;
        }

        additionalIdVersions = new ArrayList<>(list.size());

        for (TkIdentifier idv : list) {
            Object denotation = idv.getDenotation();

            switch (IDENTIFIER_PART_TYPES.getType(denotation.getClass())) {
                case LONG:
                    additionalIdVersions.add(new IdentifierVersionLong((TkIdentifierLong) idv));

                    break;

                case STRING:
                    additionalIdVersions.add(new IdentifierVersionString((TkIdentifierString) idv));

                    break;

                case UUID:
                    additionalIdVersions.add(new IdentifierVersionUuid((TkIdentifierUuid) idv));

                    break;

                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (ConceptComponent.class.isAssignableFrom(obj.getClass())) {
            ConceptComponent<?, ?> another = (ConceptComponent<?, ?>) obj;

            return this.nid == another.nid;
        }

        return false;
    }

    @Override
    public boolean versionsEqual(ViewCoordinate vc1, ViewCoordinate vc2, Boolean compareAuthoring) {
        List<? extends Version> versions1 = getVersions(vc1);
        List<? extends Version> versions2 = getVersions(vc2);

        if (versions1.size() != versions2.size()) {
            return false;
        } else if (versions1.size() == 1 && versions2.size() == 1) {
            for (Version v1 : versions1) {
                for (Version v2 : versions2) {
                    if (v1 == v2) {
                        return true;
                    }

                    if (v1.getStatusNid() != v2.getStatusNid()) {
                        return false;
                    }

                    if (compareAuthoring) {
                        if (v1.getAuthorNid() != v2.getAuthorNid()) {
                            return false;
                        }

                        if (v1.getPathNid() != v2.getPathNid()) {
                            return false;
                        }
                    }

                    if (v1.getTime() != v2.getTime()) {
                        return false;
                    }

                    if (v1.fieldsEqual(v2)) {
                        return false;
                    }
                }
            }
        } else {
            int foundCount = 0;
            for (Version v1 : versions1) {
                for (Version v2 : versions2) {
                    if (v1 == v2) {
                        foundCount++;
                    } else if (v1.getStatusNid() != v2.getStatusNid()) {
                        continue;
                    } else if (v1.getTime() != v2.getTime()) {
                        continue;
                    } else if (compareAuthoring
                            && (v1.getAuthorNid() != v2.getAuthorNid())) {
                        continue;
                    } else if (compareAuthoring
                            && (v1.getPathNid() != v2.getPathNid())) {
                        continue;
                    } else if (v1.fieldsEqual(v2)) {
                        foundCount++;
                    }
                }
            }
            if (foundCount != versions1.size()) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean fieldsEqual(ConceptComponent<R, C> another);

    @Override
    public int hashCode() {
        return Hashcode.compute(new int[]{nid, primordialStampNid});
    }

    public boolean makeAdjudicationAnalogs(EditCoordinate ec, ViewCoordinate vc) throws IOException {
        boolean changed = false;
        List<? extends Version> versions = this.getVersions(vc.getVcWithAllStatusValues());

        if (ec.getEditPaths().getSetValues().length != 1) {
            throw new IOException("Edit paths != 1: " + ec.getEditPaths().getSetValues().length + " " + Arrays.asList(ec));
        }

        int pathNid = ec.getEditPaths().getSetValues()[0];
        if (versions.size() == 1) {
            for (Version cv : versions) {
                if (!cv.isBaselineGeneration() && (cv.getPathNid() != pathNid)
                        && (cv.getTime() != Long.MAX_VALUE)) {
                    changed = true;
                    cv.makeAnalog(cv.getStatusNid(), Long.MAX_VALUE, ec.getModuleNid(), ec.getAuthorNid(), pathNid);
                }
            }
        } else if (versions.size() > 1) {
            List<? extends Version> resolution = vc.getContradictionManager().resolveVersions(versions);

            if (versions.size() > 0) {
                for (Version cv : resolution) {
                    cv.makeAnalog(cv.getStatusNid(), Long.MAX_VALUE, ec.getModuleNid(), ec.getAuthorNid(), pathNid);
                    changed = true;
                }
            }
        }

        // don't adjudicate ids
        // annotations
        if (annotations != null) {
            for (RefexMember<?, ?> a : annotations) {
                boolean annotationChanged = a.makeAdjudicationAnalogs(ec, vc);
                changed = changed || annotationChanged;
            }
        }

        return changed;
    }

    public ConceptComponent<R, C> merge(C another) throws IOException {
        Set<Integer> versionSapNids = getVersionStampNids();

        // merge versions
        for (ConceptComponent<R, C>.Version v : another.getVersions()) {
            if ((v.getStampNid() != -1) && !versionSapNids.contains(v.getStampNid())) {
                addRevision((R) v.getRevision());
            }
        }

        Set<Integer> identifierStampNids = getIdStampNids();

        // merge identifiers
        if (another.additionalIdVersions != null) {
            if (this.additionalIdVersions == null) {
                this.additionalIdVersions = another.additionalIdVersions;
            } else {
                for (IdentifierVersion idv : another.additionalIdVersions) {
                    
                    if ((idv.getStampNid() != -1) && !identifierStampNids.contains(idv.getStampNid())) {
                        this.additionalIdVersions.add(idv);
                    }
                }
            }
        }

        Set<Integer> annotationSapNids = getAnnotationStampNids();

        // merge annotations
        if (another.annotations != null) {
            if (this.annotations == null) {
                this.annotations = another.annotations;
            } else {
                HashMap<Integer, RefexMember<?, ?>> anotherAnnotationMap = new HashMap<>();

                for (RefexChronicleBI annotation : another.annotations) {
                    anotherAnnotationMap.put(annotation.getNid(), (RefexMember<?, ?>) annotation);
                }

                for (RefexMember annotation : this.annotations) {
                    RefexMember<?, ?> anotherAnnotation = anotherAnnotationMap.remove(annotation.getNid());

                    if (anotherAnnotation != null) {
                        for (RefexMember.Version annotationVersion : anotherAnnotation.getVersions()) {
                            if ((annotationVersion.getStampNid() != -1)
                                    && !annotationSapNids.contains(annotationVersion.getStampNid())) {
                                annotation.addRevision(annotationVersion.getRevision());
                            }
                        }
                    }
                }

                this.annotations.addAll(anotherAnnotationMap.values());
            }
        }

        return this;
    }

    /**
     * Call when data has changed, so concept updates it's version.
     */
    protected void modified() {
        try {
            if (enclosingConceptNid != Integer.MIN_VALUE) {
                
                if (P.s != null && P.s.hasConcept(enclosingConceptNid)) {
                    Concept c = (Concept) P.s.getConcept(enclosingConceptNid);

                    if (c != null) {
                        c.modified();
                    }
                }
            } else {
                logger.log(Level.WARNING, "No enclosingConceptNid for: {0}", this);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    private void readAnnotationsFromBdb(TupleInput input) {
        annotations = annotationWriter.entryToObject(input, enclosingConceptNid);
    }

    public final void readComponentFromBdb(TupleInput input) {
        this.nid = input.readInt();
        this.primordialMsb = input.readLong();
        this.primordialLsb = input.readLong();
        this.primordialStampNid = input.readInt();
        assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
        readIdentifierFromBdb(input);
        readAnnotationsFromBdb(input);
        readFromBdb(input);
    }

    public abstract void readFromBdb(TupleInput input);

    private void readIdentifierFromBdb(TupleInput input) {

        // nid, list size, and conceptNid are read already by the binder...
        int listSize = input.readShort();

        if (listSize != 0) {
            additionalIdVersions = new ArrayList<>(listSize);
        }

        for (int i = 0; i < listSize; i++) {
            switch (IDENTIFIER_PART_TYPES.readType(input)) {
                case LONG:
                    IdentifierVersionLong idvl = new IdentifierVersionLong(input);

                    if (idvl.getTime() != Long.MIN_VALUE) {
                        additionalIdVersions.add(idvl);
                    }

                    break;

                case STRING:
                    IdentifierVersionString idvs = new IdentifierVersionString(input);

                    if (idvs.getTime() != Long.MIN_VALUE) {
                        additionalIdVersions.add(idvs);
                    }

                    break;

                case UUID:
                    IdentifierVersionUuid idvu = new IdentifierVersionUuid(input);

                    if (idvu.getTime() != Long.MIN_VALUE) {
                        additionalIdVersions.add(idvu);
                    }

                    break;

                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public final boolean readyToWrite() {
        assert nid != Integer.MAX_VALUE : assertionString();
        assert nid != 0 : assertionString();
        assert readyToWriteComponent();

        if (revisions != null) {
            for (R r : revisions) {
                assert r.readyToWrite();
            }
        }

        if (annotations != null) {
            for (RefexMember<?, ?> m : annotations) {
                assert m.readyToWrite();
            }
        }

        if (additionalIdVersions != null) {
            for (IdentifierVersion idv : additionalIdVersions) {
                assert idv.readyToWrite();
            }
        }

        return true;
    }

    public abstract boolean readyToWriteComponent();

    public boolean removeRevision(R r) {
        boolean changed = false;

        if (revisions != null) {
            changed = revisions.remove(r);
            clearVersions();            
        }

        return changed;
    }

    public final void resetUncommitted(int statusNid, int authorNid, int pathNid, int moduleNid) {
        if (getTime() != Long.MIN_VALUE) {
            throw new UnsupportedOperationException("Cannot resetUncommitted if time != Long.MIN_VALUE");
        }

        this.primordialStampNid = P.s.getSapNid(statusNid, Long.MAX_VALUE, authorNid, moduleNid, pathNid);
        assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
        this.getEnclosingConcept().setIsCanceled(false);
        this.clearVersions();
    }

    @Override
    public boolean stampIsInRange(int min, int max) {
        if ((primordialStampNid >= min) && (primordialStampNid <= max)) {
            return true;
        }

        if (annotations != null) {
            for (RefexChronicleBI<?> a : annotations) {
                for (RefexVersionBI<?> av : a.getVersions()) {
                    if (av.stampIsInRange(min, max)) {
                        return true;
                    }
                }
            }
        }

        if (additionalIdVersions != null) {
            for (IdentifierVersion id : additionalIdVersions) {
                if (id.stampIsInRange(min, max)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();

        buf.append("nid:");
        buf.append(nid);
        buf.append(" pUuid:");
        buf.append(new UUID(primordialMsb, primordialLsb));
        buf.append(" stamp: ");

        if (primordialStampNid == Integer.MIN_VALUE) {
            buf.append("Integer.MIN_VALUE");
        } else {
            buf.append(primordialStampNid);
        }

        if (primordialStampNid > 0) {
            try {
                buf.append(" s:");
                ConceptComponent.addNidToBuffer(buf, getStatusNid());
                buf.append(" t: ");
                buf.append(TimeHelper.formatDate(getTime()));
                buf.append(" ");
                buf.append(getTime());
                buf.append(" a:");
                ConceptComponent.addNidToBuffer(buf, getAuthorNid());
                buf.append(" m:");
                ConceptComponent.addNidToBuffer(buf, getModuleNid());
                buf.append(" p:");
                ConceptComponent.addNidToBuffer(buf, getPathNid());
            } catch (Throwable e) {
                buf.append(" !!! Invalid stampNid. Cannot compute status, time, author, module, path. !!! ");
                buf.append(e.getLocalizedMessage());
            }
        } else {
            buf.append(" !!! Invalid stampNid. Cannot compute status, time, author, module, path. !!! ");
        }

        buf.append(" extraVersions: ");
        buf.append(revisions);
        buf.append(" xtraIds:");
        buf.append(additionalIdVersions);
        buf.append(" annotations:");
        buf.append(annotations);
        buf.append("};");

        return buf.toString();
    }

    @Override
    public abstract String toUserString();

    @Override
    public String toUserString(TerminologySnapshotDI snapshot) throws IOException, ContradictionException {
        return toUserString();
    }

    /**
     * Test method to check to see if two objects are equal in all respects.
     *
     * @param another
     * @return either a zero length String, or a String containing a description of the validation failures.
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public String validate(ConceptComponent<?, ?> another) throws IOException {
        assert another != null;

        StringBuilder buf = new StringBuilder();
        String validationResults;

        if (this.nid != another.nid) {
            buf.append("\tConceptComponent.nid not equal: \n" + "\t\tthis.nid = ").append(this.nid).append("\n"
                    + "\t\tanother.nid = ").append(another.nid).append("\n");
        }

        if (this.primordialStampNid != another.primordialStampNid) {
            buf.append("\tConceptComponent.primordialSapNid not equal: \n"
                    + "\t\tthis.primordialSapNid = ").append(this.primordialStampNid).append("\n"
                    + "\t\tanother.primordialSapNid = ").append(another.primordialStampNid).append("\n");
        }

        if (this.primordialMsb != another.primordialMsb) {
            buf.append("\tConceptComponent.primordialMsb not equal: \n"
                    + "\t\tthis.primordialMsb = ").append(this.primordialMsb).append("\n"
                    + "\t\tanother.primordialMsb = ").append(another.primordialMsb).append("\n");
        }

        if (this.primordialLsb != another.primordialLsb) {
            buf.append("\tConceptComponent.primordialLsb not equal: \n"
                    + "\t\tthis.primordialLsb = ").append(this.primordialLsb).append("\n"
                    + "\t\tanother.primordialLsb = ").append(another.primordialLsb).append("\n");
        }

        if (this.additionalIdVersions != null) {
            if (this.additionalIdVersions.equals(another.additionalIdVersions) == false) {
                buf.append(
                        "\tConceptComponent.additionalIdentifierParts not equal: \n"
                        + "\t\tthis.additionalIdentifierParts = ").append(this.additionalIdVersions).append(
                        "\n" + "\t\tanother.additionalIdentifierParts = ").append(
                        another.additionalIdVersions).append("\n");
            }
        }

        if (this.revisions != null) {
            if (this.revisions.equals(another.revisions) == false) {
                if (this.revisions.size() != another.revisions.size()) {
                    buf.append("\trevision.size() not equal");
                } else {
                    Iterator<R> thisRevItr = this.revisions.iterator();
                    Iterator<R> anotherRevItr = (Iterator<R>) another.revisions.iterator();

                    while (thisRevItr.hasNext()) {
                        R thisRevision = thisRevItr.next();
                        R anotherRevision = anotherRevItr.next();

                        validationResults = thisRevision.validate(anotherRevision);

                        if (validationResults.length() != 0) {
                            buf.append("\tRevision[").append(thisRevision).append(", ").append(
                                    anotherRevision).append("] not equal: \n");
                            buf.append(validationResults);
                        }
                    }
                }
            }
        }

        if (buf.length() != 0) {

            // Add a sentinal mark to indicate we reach the top of the hierarchy
            buf.append("\t----------------------------\n");
        }

        return buf.toString();
    }

    public final int versionCount() {
        if (revisions == null) {
            return 1;
        }

        return revisions.size() + 1;
    }

    private void writeAnnotationsToBdb(TupleOutput output, int maxReadOnlyStatusAtPositionNid) {
        annotationWriter.objectToEntry(annotations, output, maxReadOnlyStatusAtPositionNid);
    }

    public final void writeComponentToBdb(TupleOutput output, int maxReadOnlyStatusAtPositionNid) {
        assert nid != 0;
        assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
        assert primordialStampNid != Integer.MAX_VALUE;
        output.writeInt(nid);
        output.writeLong(primordialMsb);
        output.writeLong(primordialLsb);
        output.writeInt(primordialStampNid);
        writeIdentifierToBdb(output, maxReadOnlyStatusAtPositionNid);
        writeAnnotationsToBdb(output, maxReadOnlyStatusAtPositionNid);
        writeToBdb(output, maxReadOnlyStatusAtPositionNid);
    }

    private void writeIdentifierToBdb(TupleOutput output, int maxStampNid) {
        List<IdentifierVersion> partsToWrite = new ArrayList<>();

        if (additionalIdVersions != null) {
            for (IdentifierVersion p : additionalIdVersions) {
                if ((p.getStampNid() > maxStampNid) && (p.getTime() != Long.MIN_VALUE)) {
                    partsToWrite.add(p);
                }
            }
        }

        // Start writing
        output.writeShort(partsToWrite.size());

        for (IdentifierVersion p : partsToWrite) {
            p.getType().writeType(output);
            p.writeIdPartToBdb(output);
        }
    }

    public abstract void writeToBdb(TupleOutput output, int maxReadOnlyStatusAtPositionNid);

    //~--- get methods ---------------------------------------------------------
    public ArrayList<IdentifierVersion> getAdditionalIdentifierParts() {
        return additionalIdVersions;
    }

    @Override
    public Collection<? extends IdBI> getAdditionalIds() {
        return getAdditionalIdentifierParts();
    }

    @Override
    public Collection<? extends IdBI> getAllIds() {
        return getIdVersions();
    }

    @Override
    public Set<Integer> getAllNidsForId() throws IOException {
        HashSet<Integer> allNids = new HashSet<>();

        allNids.add(nid);
        allNids.add(getStatusNid());
        allNids.add(getAuthorNid());
        allNids.add(getPathNid());

        return allNids;
    }

    @Override
    public Set<Integer> getAllNidsForVersion() throws IOException {
        HashSet<Integer> allNids = new HashSet<>();

        allNids.add(nid);
        allNids.add(getStatusNid());
        allNids.add(getAuthorNid());
        allNids.add(getPathNid());
        addComponentNids(allNids);

        return allNids;
    }

    public Set<Integer> getAllStampNids() throws IOException {
        return getComponentStampNids();
    }

    public Set<Integer> getAnnotationStampNids() {
        int size = 0;

        if (annotations != null) {
            size = size + annotations.size();
        }

        HashSet<Integer> sapNids = new HashSet<>(size);

        if (annotations != null) {
            for (RefexChronicleBI<?> annotation : annotations) {
                for (RefexVersionBI<?> av : annotation.getVersions()) {
                    sapNids.add(av.getStampNid());
                }
            }
        }

        return sapNids;
    }

    @Override
    public Collection<? extends RefexChronicleBI<?>> getAnnotations() {
        if (annotations == null) {
            return Collections.unmodifiableCollection(new ArrayList<RefexChronicleBI<?>>());
        }

        return Collections.unmodifiableCollection(annotations);
    }

    public ConcurrentSkipListSet<? extends RefexChronicleBI<?>> getAnnotationsMod() {
        return annotations;
    }

    @Override
    public int getAuthorNid() {
        return P.s.getAuthorNidForSapNid(primordialStampNid);
    }
    
    static int authorityNid = Integer.MAX_VALUE;

    @Override
    public final int getAuthorityNid() {
        try {
            return TermAux.GENERATED_UUID.getLenient().getConceptNid();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ComponentChroncileBI getChronicle() {
        return (ComponentChroncileBI) this;
    }

    public Set<Integer> getComponentStampNids() throws IOException {
        int size = 1;

        if (revisions != null) {
            size = size + revisions.size();
        }

        if (additionalIdVersions != null) {
            size = size + additionalIdVersions.size();
        }

        if (annotations != null) {
            size = size + annotations.size();
        }

        HashSet<Integer> stampNids = new HashSet<>(size);

        stampNids.addAll(getVersionStampNids());
        stampNids.addAll(getIdStampNids());
        stampNids.addAll(getAnnotationStampNids());

        return stampNids;
    }

    @Override
    public int getConceptNid() {
        return enclosingConceptNid;
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz)
            throws IOException {
        if (annotations == null) {
            return Collections.unmodifiableCollection(new ArrayList<RefexVersionBI<?>>());
        }

        Collection<RefexVersionBI<?>> returnValues = new ArrayList<>();

        for (RefexChronicleBI<?> refex : annotations) {
            for (RefexVersionBI<?> version : refex.getVersions(xyz)) {
                returnValues.add(version);
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz,
            int refexNid)
            throws IOException {
        Collection<RefexVersionBI<?>> returnValues = new ArrayList<>();

        if (annotations != null) {
            for (RefexChronicleBI<?> refex : annotations) {
                if (refex.getRefexNid() == refexNid) {
                    for (RefexVersionBI<?> version : refex.getVersions(xyz)) {
                        returnValues.add(version);
                    }
                }
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentAnnotations(ViewCoordinate xyz)
            throws IOException {
        return getCurrentAnnotationMembers(xyz);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentAnnotations(ViewCoordinate xyz, int refexNid)
            throws IOException {
        return getCurrentAnnotationMembers(xyz, refexNid);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentRefexMembers(ViewCoordinate xyz, int refsetNid)
            throws IOException {
        Collection<? extends RefexChronicleBI<?>> refexes = getRefexMembers(refsetNid);
        List<RefexVersionBI<?>> returnValues =
                new ArrayList<>(refexes.size());

        for (RefexChronicleBI<?> refex : refexes) {
            for (RefexVersionBI<?> version : refex.getVersions(xyz)) {
                returnValues.add(version);
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz) throws IOException {
        Collection<? extends RefexChronicleBI<?>> refexes = getRefexes();
        List<RefexVersionBI<?>> returnValues =
                new ArrayList<>(refexes.size());

        for (RefexChronicleBI<?> refex : refexes) {
            for (RefexVersionBI<?> version : refex.getVersions(xyz)) {
                returnValues.add(version);
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz, int refsetNid)
            throws IOException {
        return getCurrentRefexMembers(xyz, refsetNid);
    }

    @Override
    public final Object getDenotation() {
        return new UUID(primordialMsb, primordialLsb);
    }
    public Concept getEnclosingConcept() {
        try {
            return Concept.get(enclosingConceptNid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Integer> getIdStampNids() {
        int size = 1;

        if (additionalIdVersions != null) {
            size = size + additionalIdVersions.size();
        }

        HashSet<Integer> stampNids = new HashSet<>(size);

        assert primordialStampNid != 0;
        stampNids.add(primordialStampNid);

        if (additionalIdVersions != null) {
            for (IdentifierVersion id : additionalIdVersions) {
                stampNids.add(id.getStampNid());
            }
        }

        return stampNids;
    }

    public final List<IdBI> getIdVersions() {
        List<IdBI> returnValues = new ArrayList<>();

        if (additionalIdVersions != null) {
            returnValues.addAll(additionalIdVersions);
        }

        returnValues.add(this);

        return Collections.unmodifiableList(returnValues);
    }

    @Override
    public Collection<? extends RefexVersionBI<?>> getInactiveRefexes(ViewCoordinate xyz) throws IOException {
        Collection<? extends RefexVersionBI<?>> currentRefexes = new HashSet(getCurrentRefexes(xyz));
        Collection<? extends RefexChronicleBI<?>> refexes = getRefexes();
        List<RefexVersionBI<?>> returnValues =
                new ArrayList<>(refexes.size());
        ViewCoordinate allStatus = xyz.getVcWithAllStatusValues();

        allStatus.setAllowedStatusNids(null);

        for (RefexChronicleBI<?> refex : refexes) {
            for (RefexVersionBI<?> version : refex.getVersions(allStatus)) {
                if (!currentRefexes.contains(version)) {
                    returnValues.add(version);
                }
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }
    
    @Override
    public int getModuleNid() {
        return P.s.getModuleNidForSapNid(primordialStampNid);
    }

    public final int getMutablePartCount() {
        return revisions.size();
    }

    @Override
    public final int getNid() {
        return nid;
    }

    @Override
    public final int getPathNid() {
        return P.s.getPathNidForSapNid(primordialStampNid);
    }

    @Override
    public PositionBI getPosition() throws IOException {
        return new Position(getTime(), P.s.getPath(getPathNid()));
    }

    public Set<PositionBI> getPositions() throws IOException {
        List<? extends Version> localVersions = getVersions();
        Set<PositionBI> positions = new HashSet<>(localVersions.size());

        for (Version v : localVersions) {
            positions.add(v.getPosition());
        }

        return positions;
    }

    @Override
    public UUID getPrimUuid() {
        return new UUID(primordialMsb, primordialLsb);
    }

    protected int getPrimordialStatusAtPositionNid() {
        return primordialStampNid;
    }

    @Override
    public Collection<? extends RefexChronicleBI<?>> getRefexMembers(int refsetNid) throws IOException {
        Collection<? extends RefexChronicleBI<?>> r = getRefexes();
        List<RefexChronicleBI<?>> returnValues = new ArrayList<>(r.size());

        for (RefexChronicleBI<?> rcbi : r) {
            if (rcbi.getRefexNid() == refsetNid) {
                returnValues.add(rcbi);
            }
        }

        return returnValues;
    }

    @Override
    public Collection<? extends RefexChronicleBI<?>> getRefexes() throws IOException {
        List<NidPairForRefset> pairs = P.s.getRefexPairs(nid);
        List<RefexChronicleBI<?>> returnValues = new ArrayList<>(pairs.size());
        HashSet<Integer> addedMembers = new HashSet<>();

        if ((pairs != null) && !pairs.isEmpty()) {
            for (NidPairForRefset pair : pairs) {
                RefexChronicleBI<?> ext = (RefexChronicleBI<?>) P.s.getComponent(pair.getMemberNid());

                if ((ext != null) && !addedMembers.contains(ext.getNid())) {
                    addedMembers.add(ext.getNid());
                    returnValues.add(ext);
                }
            }
        }

        ComponentBI component = this;

        if (component instanceof Concept) {
            component = ((Concept) component).getConceptAttributes();
        }

        ComponentChroncileBI<?> cc = (ComponentChroncileBI<?>) component;
        Collection<? extends RefexChronicleBI<?>> fetchedAnnotations = cc.getAnnotations();

        if (fetchedAnnotations != null) {
            for (RefexChronicleBI<?> annotation : fetchedAnnotations) {
                if (addedMembers.contains(annotation.getNid()) == false) {
                    returnValues.add(annotation);
                    addedMembers.add(annotation.getNid());
                }
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }

    @Override
    @Deprecated
    public Collection<? extends RefexChronicleBI<?>> getRefexes(int refsetNid) throws IOException {
        return getRefexMembers(refsetNid);
    }

    public Set<Integer> getRefsetMemberSapNids() throws IOException {
        List<NidPairForRefset> pairs = P.s.getRefexPairs(nid);

        if ((pairs == null) || pairs.isEmpty()) {
            return new HashSet<>(0);
        }

        HashSet<Integer> returnValues = new HashSet<>(pairs.size());

        for (NidPairForRefset pair : pairs) {
            RefexChronicleBI<?> ext = (RefexChronicleBI<?>) P.s.getComponent(pair.getMemberNid());

            if (ext != null) {
                for (RefexVersionBI<?> refexV : ext.getVersions()) {
                    returnValues.add(refexV.getStampNid());
                }

                returnValues.addAll(((ConceptComponent) ext).getRefsetMemberSapNids());
            }
        }

        return returnValues;
    }

    public Collection<? extends RefexChronicleBI<?>> getRefsetMembers() throws IOException {
        List<NidPairForRefset> pairs = P.s.getRefexPairs(nid);

        if ((pairs == null) || pairs.isEmpty()) {
            return new ArrayList<>(0);
        }

        List<RefexChronicleBI<?>> returnValues = new ArrayList<>(pairs.size());
        HashSet<Integer> addedMembers = new HashSet<>();

        for (NidPairForRefset pair : pairs) {
            RefexChronicleBI<?> ext = (RefexChronicleBI<?>) P.s.getComponent(pair.getMemberNid());

            if ((ext != null) && !addedMembers.contains(ext.getNid())) {
                addedMembers.add(ext.getNid());
                returnValues.add(ext);
            }
        }

        return Collections.unmodifiableCollection(returnValues);
    }

    @Override
    public int getStampNid() {
        return primordialStampNid;
    }

    @Override
    public final int getStatusNid() {
        return P.s.getStatusNidForSapNid(primordialStampNid);
    }

    @Override
    public final long getTime() {
        return P.s.getTimeForSapNid(primordialStampNid);
    }

    @Override
    public final List<UUID> getUUIDs() {
        List<UUID> returnValues = new ArrayList<>();

        returnValues.add(new UUID(primordialMsb, primordialLsb));

        if (additionalIdVersions != null) {
            for (IdentifierVersion idv : additionalIdVersions) {
                if (IdentifierVersionUuid.class.isAssignableFrom(idv.getClass())) {
                    IdentifierVersionUuid uuidPart = (IdentifierVersionUuid) idv;

                    returnValues.add(uuidPart.getUuid());
                }
            }
        }

        return returnValues;
    }

    protected abstract IntArrayList getVariableVersionNids();

    public HashMap<Integer, ConceptComponent<R, C>.Version> getVersionSapMap() {
        int size = 1;

        if (revisions != null) {
            size = size + revisions.size();
        }

        HashMap<Integer, ConceptComponent<R, C>.Version> sapMap = new HashMap<>(size);

        for (Version v : getVersions()) {
            sapMap.put(v.getStampNid(), v);
        }

        return sapMap;
    }

    public Set<Integer> getVersionStampNids() {
        int size = 1;

        if (revisions != null) {
            size = size + revisions.size();
        }

        HashSet<Integer> sapNids = new HashSet<>(size);

        assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
        sapNids.add(primordialStampNid);

        if (revisions != null) {
            for (R r : revisions) {
                sapNids.add(r.stampNid);
            }
        }

        return sapNids;
    }

    public abstract List<? extends Version> getVersions();

    public abstract List<? extends Version> getVersions(ViewCoordinate c);

    @Override
    public boolean hasCurrentAnnotationMember(ViewCoordinate xyz, int refsetNid) throws IOException {
        Collection<? extends RefexChronicleBI<?>> members = getCurrentAnnotationMembers(xyz, refsetNid);

        for (RefexChronicleBI<?> refex : members) {
            for (RefexVersionBI<?> version : refex.getVersions(xyz)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasCurrentRefexMember(ViewCoordinate xyz, int refsetNid) throws IOException {
        Collection<? extends RefexChronicleBI<?>> refexes = getRefexMembers(refsetNid);

        if (!refexes.isEmpty()) {
            return true;
        }

        return false;
    }

    public final boolean hasRevision(R r) {
        if (revisions == null) {
            return false;
        }

        return revisions.contains(r);
    }

    @Override
    public boolean isActive(NidSetBI allowedStatusNids) {
        return allowedStatusNids.contains(getStatusNid());
    }

    @Override
    public boolean isActive(ViewCoordinate vc) {
        return isActive(vc.getAllowedStatusNids());
    }

    @Override
    public boolean isBaselineGeneration() {
        return primordialStampNid <= P.s.getMaxReadOnlySap();
    }

    public static boolean isCanceled(TupleInput input) {
        int nid = input.readInt();
        int primordialSapNid = input.readInt();

        return primordialSapNid == -1;
    }

    @Override
    public boolean isUncommitted() {
        if (this.getTime() == Long.MAX_VALUE) {
            return true;
        }

        if (additionalIdVersions != null) {
            for (IdentifierVersion idv : additionalIdVersions) {
                if (idv.getTime() == Long.MAX_VALUE) {
                    return true;
                }
            }
        }

        if (revisions != null) {
            for (R r : revisions) {
                if (r.getTime() == Long.MAX_VALUE) {
                    return true;
                }
            }
        }

        if (annotations != null) {
            for (RefexChronicleBI<?> r : annotations) {
                if (r.isUncommitted()) {
                    return true;
                }
            }
        }

        return false;
    }

    //~--- set methods ---------------------------------------------------------
    @Override
    public void setAuthorNid(int authorNid) {
        if (getTime() != Long.MAX_VALUE) {
            throw new UnsupportedOperationException(
                    "Cannot change status if time != Long.MAX_VALUE; Use makeAnalog instead.");
        }

        if (authorNid != getAuthorNid()) {
            this.primordialStampNid = P.s.getSapNid(getStatusNid(), Long.MAX_VALUE, authorNid, getModuleNid(), getPathNid());
            assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
            modified();
        }
    }
    
    @Override
    public final void setModuleNid(int moduleId) {
        if (getTime() != Long.MAX_VALUE) {
            throw new UnsupportedOperationException(
                    "Cannot change status if time != Long.MAX_VALUE; Use makeAnalog instead.");
        }

        if (moduleId != this.getModuleNid()) {
            this.primordialStampNid = P.s.getSapNid(getStatusNid(), Long.MAX_VALUE, getAuthorNid(), 
                    moduleId, getPathNid());
            assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
        }
    }

    @Override
    public final void setNid(int nid) throws PropertyVetoException {
        if ((this.getStampNid() != Integer.MAX_VALUE) && (this.getTime() != Long.MAX_VALUE) && (this.nid != nid)
                && (this.nid != Integer.MAX_VALUE)) {
            throw new PropertyVetoException("nid", null);
        }

        this.nid = nid;
    }
    
    @Override
    public final void setPathNid(int pathId) {
        if (getTime() != Long.MAX_VALUE) {
            throw new UnsupportedOperationException(
                    "Cannot change status if time != Long.MAX_VALUE; Use makeAnalog instead.");
        }

        if (pathId != getPathNid()) {
            this.primordialStampNid = P.s.getSapNid(getStatusNid(), Long.MAX_VALUE, getAuthorNid(),
                    getModuleNid(), pathId);
            assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
            modified();
        }
    }

    public void setPrimordialUuid(UUID pUuid) {
        this.primordialMsb = pUuid.getMostSignificantBits();
        this.primordialLsb = pUuid.getLeastSignificantBits();
    }

    public void setStatusAtPositionNid(int sapNid) {
        this.primordialStampNid = sapNid;
        assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
        modified();
    }

    @Override
    public final void setStatusNid(int statusId) {
        if (getTime() != Long.MAX_VALUE) {
            throw new UnsupportedOperationException(
                    "Cannot change status if time != Long.MAX_VALUE; Use makeAnalog instead.");
        }

        if (statusId != this.getStatusNid()) {
            this.primordialStampNid = P.s.getSapNid(statusId, Long.MAX_VALUE, getAuthorNid(),
                    getModuleNid(), getPathNid());
            assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
        }
    }

    @Override
    public final void setTime(long time) {
        if (getTime() != Long.MAX_VALUE) {
            throw new UnsupportedOperationException(
                    "Cannot change status if time != Long.MAX_VALUE; Use makeAnalog instead.");
        }

        if (time != getTime()) {
            this.primordialStampNid = P.s.getSapNid(getStatusNid(), time, getAuthorNid(),
                    getModuleNid(), getPathNid());
            assert primordialStampNid != 0 : "Processing nid: " + enclosingConceptNid;
        }
    }


    public abstract class Version implements ComponentVersionBI, AnalogGeneratorBI<R> {

        protected ComponentVersionBI cv;

        //~--- constructors -----------------------------------------------------
        public Version(ComponentVersionBI cv) {
            super();
            this.cv = cv;
        }

        //~--- methods ----------------------------------------------------------
        public Concept getEnclosingConcept() {
            return ConceptComponent.this.getEnclosingConcept();
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean addAnnotation(RefexChronicleBI annotation) throws IOException {
            return ConceptComponent.this.addAnnotation(annotation);
        }

        public boolean addLongId(Long longId, int authorityNid, int statusNid, EditCoordinate ec, long time) {
            return ConceptComponent.this.addLongId(longId, authorityNid, statusNid, ec, time);
        }
//
//        @Override
//        public boolean addLongId(Long longId, int authorityNid, int statusNid, int pathNid, long time) {
//            return ConceptComponent.this.addLongId(longId, authorityNid, statusNid, pathNid, time);
//        }

//        @Override
//        public boolean addStringId(String stringId, int authorityNid, int statusNid, int pathNid, long time) {
//            return ConceptComponent.this.addStringId(stringId, authorityNid, statusNid, pathNid, time);
//        }
//
//        @Override
//        public boolean addUuidId(UUID uuidId, int authorityNid, int statusNid, int pathNid, long time) {
//            return ConceptComponent.this.addUuidId(uuidId, authorityNid, statusNid, pathNid, time);
//        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (Version.class.isAssignableFrom(obj.getClass())) {
                Version another = (Version) obj;

                if ((this.getNid() == another.getNid()) && (this.getStampNid() == another.getStampNid())) {
                    return true;
                }
            }

            return false;
        }

        public abstract boolean fieldsEqual(ConceptComponent<R, C>.Version another);

        @Override
        public boolean versionsEqual(ViewCoordinate vc1, ViewCoordinate vc2,
                Boolean compareAuthoring) {
            return ConceptComponent.this.versionsEqual(vc1, vc2, compareAuthoring);
        }

        @Override
        public int hashCode() {
            return Hashcode.compute(new int[]{this.getStampNid(), nid});
        }

        public boolean makeAdjudicationAnalogs(EditCoordinate ec, ViewCoordinate vc) throws IOException {
            return ConceptComponent.this.makeAdjudicationAnalogs(ec, vc);
        }

        @Override
        public boolean stampIsInRange(int min, int max) {
            return cv.stampIsInRange(min, max);
        }

        @Override
        public String toString() {
            return "Version: " + cv.toString();
        }

        @Override
        public String toUserString() {
            return cv.toUserString();
        }

        @Override
        public String toUserString(TerminologySnapshotDI snapshot) throws IOException, ContradictionException {
            return cv.toUserString(snapshot);
        }

        //~--- get methods ------------------------------------------------------
        public List<IdentifierVersion> getAdditionalIdentifierParts() {
            if (additionalIdVersions == null) {
                return Collections.unmodifiableList(new ArrayList<IdentifierVersion>());
            }

            return Collections.unmodifiableList(additionalIdVersions);
        }

        @Override
        public Collection<? extends IdBI> getAdditionalIds() {
            return ConceptComponent.this.getAdditionalIds();
        }

        @Override
        public Collection<? extends IdBI> getAllIds() {
            return ConceptComponent.this.getIdVersions();
        }

        @Override
        public Set<Integer> getAllNidsForVersion() throws IOException {
            return cv.getAllNidsForVersion();
        }

        public Set<Integer> getAllStampNids() throws IOException {
            return ConceptComponent.this.getAllStampNids();
        }

        @Override
        public Collection<? extends RefexChronicleBI<?>> getAnnotations() {
            return ConceptComponent.this.getAnnotations();
        }

        @Override
        public int getAuthorNid() {
            return cv.getAuthorNid();
        }

        @Override
        public ComponentChroncileBI getChronicle() {
            return ConceptComponent.this.getChronicle();
        }

        @Override
        public int getConceptNid() {
            return enclosingConceptNid;
        }

        @Override
        public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz)
                throws IOException {
            return ConceptComponent.this.getCurrentAnnotationMembers(xyz);
        }

        @Override
        public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz,
                int refexNid)
                throws IOException {
            return ConceptComponent.this.getCurrentAnnotationMembers(xyz, refexNid);
        }

        @Override
        public Collection<? extends RefexVersionBI<?>> getCurrentAnnotations(ViewCoordinate xyz)
                throws IOException {
            return getCurrentAnnotationMembers(xyz);
        }

        @Override
        public Collection<? extends RefexVersionBI<?>> getCurrentAnnotations(ViewCoordinate xyz, int refexNid)
                throws IOException {
            return getCurrentAnnotationMembers(xyz, refexNid);
        }

        @Override
        public Collection<? extends RefexVersionBI<?>> getCurrentRefexMembers(ViewCoordinate xyz, int refsetNid)
                throws IOException {
            return ConceptComponent.this.getCurrentRefexMembers(xyz, refsetNid);
        }

        @Override
        public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz)
                throws IOException {
            return ConceptComponent.this.getCurrentRefexes(xyz);
        }

        @Override
        public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz, int refsetNid)
                throws IOException {
            return ConceptComponent.this.getCurrentRefexMembers(xyz, refsetNid);
        }

        @Override
        public Collection<? extends RefexVersionBI<?>> getInactiveRefexes(ViewCoordinate xyz)
                throws IOException {
            return ConceptComponent.this.getInactiveRefexes(xyz);
        }

        @Override
        public int getNid() {
            return nid;
        }

        @Override
        public int getPathNid() {
            return cv.getPathNid();
        }

        @Override
        public PositionBI getPosition() throws IOException {
            return cv.getPosition();
        }

        public Set<PositionBI> getPositions() throws IOException {
            return ConceptComponent.this.getPositions();
        }

        @Override
        public UUID getPrimUuid() {
            return new UUID(primordialMsb, primordialLsb);
        }
        
        @Override
        public int getModuleNid() {
            return cv.getModuleNid();
        }

        @Override
        public Collection<? extends RefexChronicleBI<?>> getRefexMembers(int refsetNid) throws IOException {
            return ConceptComponent.this.getRefexMembers(refsetNid);
        }

        @Override
        public Collection<? extends RefexChronicleBI<?>> getRefexes() throws IOException {
            return ConceptComponent.this.getRefexes();
        }

        @Override
        @Deprecated
        public Collection<? extends RefexChronicleBI<?>> getRefexes(int refsetNid) throws IOException {
            return ConceptComponent.this.getRefexMembers(refsetNid);
        }

        public R getRevision() {
            if (cv == ConceptComponent.this) {
                return makeAnalog(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid());
            }

            return (R) cv;
        }

        @Override
        public int getStampNid() {
            return cv.getStampNid();
        }

        @Override
        public int getStatusNid() {
            return cv.getStatusNid();
        }

        @Override
        public long getTime() {
            return cv.getTime();
        }

        @Override
        public List<UUID> getUUIDs() {
            return ConceptComponent.this.getUUIDs();
        }

        public abstract IntArrayList getVariableVersionNids();

//        @Override
//        public List<? extends I_IdPart> getVisibleIds(PositionSet viewpointSet) {
//            return ConceptComponent.this.getVisibleIds(viewpointSet);
//        }
//
//        @Override
//        public List<? extends I_IdPart> getVisibleIds(PositionSet viewpointSet, int... authorityNids) {
//            return ConceptComponent.this.getVisibleIds(viewpointSet, authorityNids);
//        }

        @Override
        public boolean hasCurrentAnnotationMember(ViewCoordinate xyz, int refsetNid) throws IOException {
            return ConceptComponent.this.hasCurrentAnnotationMember(xyz, refsetNid);
        }

        @Override
        public boolean hasCurrentRefexMember(ViewCoordinate xyz, int refsetNid) throws IOException {
            return ConceptComponent.this.hasCurrentRefexMember(xyz, refsetNid);
        }

//        @Override
//        public boolean hasExtensions() throws IOException {
//            return ConceptComponent.this.hasExtensions();
//        }

        @Override
        public boolean isActive(NidSetBI allowedStatusNids) throws IOException {
            return cv.isActive(allowedStatusNids);
        }

        @Override
        public boolean isActive(ViewCoordinate vc) throws IOException {
            return isActive(vc.getAllowedStatusNids());
        }

        @Override
        public boolean isBaselineGeneration() {
            return cv.isBaselineGeneration();
        }

        @Override
        public boolean isUncommitted() {
            return getTime() == Long.MAX_VALUE;
        }

        //~--- set methods ------------------------------------------------------
        public void setAuthorNid(int authorNid) throws PropertyVetoException {
            ((AnalogBI) cv).setAuthorNid(authorNid);
        }

        public final void setNid(int nid) throws PropertyVetoException {
            ((AnalogBI) cv).setNid(nid);
        }

        public void setPathNid(int pathId) throws PropertyVetoException {
            ((AnalogBI) cv).setPathNid(pathId);
        }
        
        public void setModuleNid(int moduleNid) throws PropertyVetoException {
            ((AnalogBI) cv).setModuleNid(moduleNid);
        }

        public void setStatusNid(int statusNid) throws PropertyVetoException {
            ((AnalogBI) cv).setStatusNid(statusNid);
        }

        public void setTime(long time) throws PropertyVetoException {
            ((AnalogBI) cv).setTime(time);
        }
    }
}
