package org.ihtsdo.ttk.bdb;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.ihtsdo.ttk.api.ComponentChroncileBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.blueprint.ConAttrAB;
import org.ihtsdo.ttk.api.blueprint.DescCAB;

import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.ttk.api.blueprint.RelCAB;
import org.ihtsdo.ttk.api.TerminologyBuilderBI;
import org.ihtsdo.ttk.api.blueprint.ConceptCB;
import org.ihtsdo.ttk.api.blueprint.MediaCAB;
import org.ihtsdo.ttk.api.conattr.ConAttrChronicleBI;
import org.ihtsdo.ttk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.description.DescriptionChronicleBI;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;
import org.ihtsdo.ttk.api.media.MediaChronicleBI;
import org.ihtsdo.ttk.api.media.MediaVersionBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.attributes.ConceptAttributes;
import org.ihtsdo.ttk.concept.cc.attributes.ConceptAttributesRevision;
import org.ihtsdo.ttk.concept.cc.component.RevisionSet;
import org.ihtsdo.ttk.concept.cc.concept.Concept;
import org.ihtsdo.ttk.concept.cc.description.Description;
import org.ihtsdo.ttk.concept.cc.description.DescriptionRevision;
import org.ihtsdo.ttk.concept.cc.media.Media;
import org.ihtsdo.ttk.concept.cc.media.MediaRevision;
import org.ihtsdo.ttk.concept.cc.refex.RefexMember;
import org.ihtsdo.ttk.concept.cc.refex.RefexMemberFactory;
import org.ihtsdo.ttk.concept.cc.refex.RefexRevision;
import org.ihtsdo.ttk.concept.cc.relationship.Relationship;
import org.ihtsdo.ttk.concept.cc.relationship.RelationshipRevision;

public class BdbTermBuilder implements TerminologyBuilderBI {

    EditCoordinate ec;
    ViewCoordinate vc;

    public BdbTermBuilder(EditCoordinate ec, ViewCoordinate vc) {
        this.ec = ec;
        this.vc = vc;
    }

    @Override
    public RefexChronicleBI<?> construct(RefexCAB blueprint)
            throws IOException, InvalidCAB, ContradictionException {
        RefexMember<?, ?> refex = getRefex(blueprint);
        if (refex != null) {
            return updateRefex(refex, blueprint);
        }
        RefexChronicleBI<?> annot = createRefex(blueprint);
        ComponentChroncileBI<?> component = P.s.getComponent(annot.getReferencedComponentNid());
        component.addAnnotation(annot);
        return annot;
    }

    public ConceptAttributes getConAttr(ConAttrAB blueprint) throws IOException, InvalidCAB {
        ConceptAttributes cac = (ConceptAttributes) P.s.getConcept(blueprint.getComponentUuid()).getConAttrs();
        if (cac == null) {
            throw new InvalidCAB("ConAttrAB can only be used for amendment, not creation."
                    + " Use ConceptCB instead. " + blueprint);
        }
        return cac;
    }

    private RefexChronicleBI<?> updateRefex(RefexMember<?, ?> member,
            RefexCAB blueprint) throws InvalidCAB, IOException, ContradictionException {
        for (int pathNid : ec.getEditPaths().getSetValues()) {
            RefexRevision refexRevision =
                    member.makeAnalog(blueprint.getInt(RefexProperty.STATUS_UUID),
                    Long.MAX_VALUE,
                    ec.getAuthorNid(),
                    ec.getModuleNid(),
                    pathNid);
            try {
                blueprint.setPropertiesExceptSap(refexRevision);
            } catch (PropertyVetoException ex) {
                throw new InvalidCAB("Refex: " + member
                        + "\n\nRefexAmendmentSpec: " + blueprint, ex);
            }
        }
        for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
            construct(annotBp);
        }
        return member;
    }

    private RefexMember<?, ?> getRefex(RefexCAB blueprint)
            throws InvalidCAB, IOException {
        if (P.s.hasUuid(blueprint.getMemberUUID())) {
            ComponentChroncileBI<?> component =
                    P.s.getComponent(blueprint.getMemberUUID());
            if (component == null) {
                return null;
            }
            if (blueprint.getMemberType()
                    == TK_REFEX_TYPE.classToType(component.getClass())) {
                return (RefexMember<?, ?>) component;
            } else {
                throw new InvalidCAB(
                        "Component exists of different type: "
                        + component + "\n\nRefexCAB: " + blueprint);
            }
        }
        return null;
    }

    @Override
    public RefexChronicleBI<?> constructIfNotCurrent(RefexCAB blueprint)
            throws IOException, InvalidCAB, ContradictionException {
        RefexMember<?, ?> refex = getRefex(blueprint);
        if (refex != null) {
            if (refex.getStamp() == -1) {
                return reCreateRefex(refex, blueprint);
            } else {
                boolean current = false;
                for (RefexVersionBI refexv : refex.getVersions(vc)) {
                    if (blueprint.validate(refexv)) {
                        current = true;
                        break;
                    }
                }
                if (current) {
                    return refex;
                }
                return updateRefex(refex, blueprint);
            }
        }

        return createRefex(blueprint);
    }

    private RefexChronicleBI<?> reCreateRefex(RefexMember<?, ?> refex,
            RefexCAB blueprint)
            throws IOException, InvalidCAB {
        return RefexMemberFactory.reCreate(blueprint, refex, ec);
    }

    private RefexChronicleBI<?> createRefex(RefexCAB blueprint)
            throws IOException, InvalidCAB, ContradictionException {
        for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
            construct(annotBp);
        }
        return RefexMemberFactory.create(blueprint, ec);
    }

    private RelationshipChronicleBI getRel(RelCAB blueprint)
            throws InvalidCAB, IOException {
        if (P.s.hasUuid(blueprint.getComponentUuid())) {
            ComponentChroncileBI<?> component =
                    P.s.getComponent(blueprint.getComponentUuid());
            if (component == null) {
                return null;
            }
            if (component instanceof RelationshipChronicleBI) {
                return (RelationshipChronicleBI) component;
            } else {
                throw new InvalidCAB(
                        "Component exists of different type: "
                        + component + "\n\nRelCAB: " + blueprint);
            }
        }
        return null;
    }

    @Override
    public RelationshipChronicleBI construct(RelCAB blueprint) throws IOException, InvalidCAB, ContradictionException {
        RelationshipChronicleBI relc = getRel(blueprint);

        if (relc == null) {
            Concept c = (Concept) P.s.getConcept(blueprint.getSourceNid());
            Relationship r = new Relationship();
            Bdb.gVersion.incrementAndGet();
            r.enclosingConceptNid = c.getNid();
            r.nid = Bdb.uuidToNid(blueprint.getComponentUuid());
            Bdb.getNidCNidMap().setCNidForNid(c.getNid(), r.nid);
            r.setPrimordialUuid(blueprint.getComponentUuid());
            try {
                r.setDestinationNid(blueprint.getDestNid());
            } catch (PropertyVetoException ex) {
                throw new IOException(ex);
            }
            r.setTypeNid(blueprint.getTypeNid());
            r.setRefinabilityNid(blueprint.getRefinabilityNid());
            r.setCharacteristicNid(blueprint.getCharacteristicNid());
            r.primordialStamp = Integer.MIN_VALUE;
            r.setGroup(blueprint.getGroup());
            for (int p : ec.getEditPaths().getSetValues()) {
                if (r.primordialStamp == Integer.MIN_VALUE) {
                    r.primordialStamp =
                            Bdb.getStampDb().getSapNid(blueprint.getStatusNid(), Long.MAX_VALUE,
                            ec.getAuthorNid(), ec.getModuleNid(), p);
                } else {
                    if (r.revisions == null) {
                        r.revisions = new RevisionSet(r.primordialStamp);
                    }
                    r.revisions.add((RelationshipRevision) r.makeAnalog(blueprint.getStatusNid(),
                            Long.MAX_VALUE,
                            ec.getAuthorNid(),
                            ec.getModuleNid(),
                            p));
                }
            }
            c.getRelsOutgoing().add(r);
            for (int p : ec.getEditPaths().getSetValues()) {
                for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
                    construct(annotBp);
                }
            }
            return r;
        } else {
            Relationship r = (Relationship) relc;
            for (int p : ec.getEditPaths().getSetValues()) {
                RelationshipRevision rv = r.makeAnalog(blueprint.getStatusNid(),
                        Long.MAX_VALUE,
                        ec.getAuthorNid(),
                        ec.getModuleNid(),
                        p);
                if (r.getDestinationNid() != blueprint.getDestNid()) {
                    throw new InvalidCAB(
                            "r.getDestinationNid() != spec.getDestNid(): "
                            + r.getDestinationNid() + " : " + blueprint.getDestNid());
                }
                rv.setTypeNid(blueprint.getTypeNid());
                rv.setRefinabilityNid(blueprint.getRefinabilityNid());
                rv.setCharacteristicNid(blueprint.getCharacteristicNid());
            }
            for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
                construct(annotBp);
            }
        }
        return relc;
    }

    @Override
    public RelationshipChronicleBI constructIfNotCurrent(RelCAB blueprint) throws IOException, InvalidCAB, ContradictionException {
        RelationshipChronicleBI relc = getRel(blueprint);
        if (relc == null) {
            return construct(blueprint);
        }
        Collection<? extends RelationshipVersionBI> relvs = relc.getVersions(vc);
        for (RelationshipVersionBI rv : relvs) {
            if (!blueprint.validate(rv)) {
                return construct(blueprint);
            }
        }
        return relc;
    }

    private DescriptionChronicleBI getDesc(DescCAB blueprint)
            throws InvalidCAB, IOException {
        if (P.s.hasUuid(blueprint.getComponentUuid())) {
            ComponentChroncileBI<?> component =
                    P.s.getComponent(blueprint.getComponentUuid());
            if (component == null) {
                return null;
            }
            if (component instanceof DescriptionChronicleBI) {
                return (DescriptionChronicleBI) component;
            } else {
                throw new InvalidCAB(
                        "Component exists of different type: "
                        + component + "\n\nDescCAB: " + blueprint);
            }
        }
        return null;
    }

    @Override
    public DescriptionChronicleBI constructIfNotCurrent(DescCAB blueprint) throws IOException,
            InvalidCAB, ContradictionException {
        DescriptionChronicleBI desc = getDesc(blueprint);
        if (desc == null) {
            return construct(blueprint);
        }
        Collection<? extends DescriptionVersionBI> descvs = desc.getVersions(vc);
        for (DescriptionVersionBI dv : descvs) {
            if (!blueprint.validate(dv)) {
                return construct(blueprint);
            }
        }
        return desc;
    }

    @Override
    public DescriptionChronicleBI construct(DescCAB blueprint) throws IOException, InvalidCAB, ContradictionException {
        DescriptionChronicleBI desc = getDesc(blueprint);

        if (desc == null) {
            int conceptNid = blueprint.getConceptNid();
            Concept c = (Concept) P.s.getConcept(blueprint.getConceptNid());
            Description d = new Description();
            Bdb.gVersion.incrementAndGet();
            d.enclosingConceptNid = c.getNid();
            d.nid = Bdb.uuidToNid(blueprint.getComponentUuid());
            Bdb.getNidCNidMap().setCNidForNid(c.getNid(), d.nid);
            d.setPrimordialUuid(blueprint.getComponentUuid());
            d.setTypeNid(blueprint.getTypeNid());
            d.primordialStamp = Integer.MIN_VALUE;
            d.setLang(blueprint.getLang());
            d.setText(blueprint.getText());
            d.setInitialCaseSignificant(blueprint.isInitialCaseSignificant());
            for (int p : ec.getEditPaths().getSetValues()) {
                if (d.primordialStamp == Integer.MIN_VALUE) {
                    d.primordialStamp =
                            Bdb.getStampDb().getSapNid(blueprint.getStatusNid(), Long.MAX_VALUE, ec.getAuthorNid(),
                            ec.getModuleNid(), p);
                } else {
                    if (d.revisions == null) {
                        d.revisions = new RevisionSet(d.primordialStamp);
                    }
                    d.revisions.add((DescriptionRevision) d.makeAnalog(blueprint.getStatusNid(),
                            Long.MAX_VALUE,
                            ec.getAuthorNid(),
                            ec.getModuleNid(),
                            p));
                }
            }
            c.getDescriptions().add(d);
            for (int p : ec.getEditPaths().getSetValues()) {
                for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
                    construct(annotBp);
                }
            }
            return d;
        } else {
            Description d = (Description) desc;
            for (int p : ec.getEditPaths().getSetValues()) {
                DescriptionRevision dr = d.makeAnalog(blueprint.getStatusNid(),
                        Long.MAX_VALUE,
                        ec.getAuthorNid(),
                        ec.getModuleNid(),
                        p);
                dr.setTypeNid(blueprint.getTypeNid());
                dr.setText(blueprint.getText());
                dr.setLang(blueprint.getLang());
                dr.setInitialCaseSignificant(blueprint.isInitialCaseSignificant());
                for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
                    construct(annotBp);
                }
            }
        }
        return desc;
    }

    private MediaChronicleBI getMedia(MediaCAB blueprint)
            throws InvalidCAB, IOException {
        if (P.s.hasUuid(blueprint.getComponentUuid())) {
            ComponentChroncileBI<?> component =
                    P.s.getComponent(blueprint.getComponentUuid());
            if (component == null) {
                return null;
            }
            if (component instanceof MediaChronicleBI) {
                return (MediaChronicleBI) component;
            } else {
                throw new InvalidCAB(
                        "Component exists of different type: "
                        + component + "\n\nMediaCAB: " + blueprint);
            }
        }
        return null;
    }

    @Override
    public MediaChronicleBI constructIfNotCurrent(MediaCAB blueprint) throws IOException,
            InvalidCAB, ContradictionException {
        MediaChronicleBI mediaC = getMedia(blueprint);
        if (mediaC == null) {
            return construct(blueprint);
        }
        Collection<? extends MediaVersionBI> mediaV = mediaC.getVersions(vc);
        for (MediaVersionBI dv : mediaV) {
            if (!blueprint.validate(dv)) {
                return construct(blueprint);
            }
        }
        return mediaC;
    }

    @Override
    public MediaChronicleBI construct(MediaCAB blueprint) throws IOException, InvalidCAB, ContradictionException {
        MediaChronicleBI imgC = getMedia(blueprint);

        if (imgC == null) {
            Concept c = (Concept) P.s.getConcept(blueprint.getConceptNid());
            Media img = new Media();
            Bdb.gVersion.incrementAndGet();
            img.enclosingConceptNid = c.getNid();
            img.nid = Bdb.uuidToNid(blueprint.getComponentUuid());
            Bdb.getNidCNidMap().setCNidForNid(c.getNid(), img.nid);
            img.setPrimordialUuid(blueprint.getComponentUuid());
            img.setTypeNid(blueprint.getTypeNid());
            img.setFormat(blueprint.getFormat());
            img.setImage(blueprint.getDataBytes());
            img.setTextDescription(blueprint.getTextDescription());
            img.primordialStamp = Integer.MIN_VALUE;
            for (int p : ec.getEditPaths().getSetValues()) {
                if (img.primordialStamp == Integer.MIN_VALUE) {
                    img.primordialStamp =
                            Bdb.getStampDb().getSapNid(blueprint.getStatusNid(), Long.MAX_VALUE, ec.getAuthorNid(),
                            ec.getModuleNid(), p);
                } else {
                    if (img.revisions == null) {
                        img.revisions = new RevisionSet(img.primordialStamp);
                    }
                    img.revisions.add((MediaRevision) img.makeAnalog(blueprint.getStatusNid(),
                            Long.MAX_VALUE,
                            ec.getAuthorNid(),
                            ec.getModuleNid(),
                            p));
                }
            }
            c.getMedia().add(img);
            for (int p : ec.getEditPaths().getSetValues()) {
                for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
                    construct(annotBp);
                }
            }
            return img;
        } else {
            Media img = (Media) imgC;
            for (int p : ec.getEditPaths().getSetValues()) {
                MediaRevision imgR = img.makeAnalog(blueprint.getStatusNid(),
                        Long.MAX_VALUE,
                        ec.getAuthorNid(),
                        ec.getModuleNid(),
                        p);
                imgR.setTypeNid(blueprint.getTypeNid());
                imgR.setTextDescription(blueprint.getTextDescription());
                for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
                    construct(annotBp);
                }
            }
        }

        return imgC;
    }

    private ConceptChronicleBI getConcept(ConceptCB blueprint)
            throws InvalidCAB, IOException {
        if (P.s.hasUuid(blueprint.getComponentUuid())) {
            ComponentChroncileBI<?> component =
                    P.s.getComponent(blueprint.getComponentUuid());
            if (component == null) {
                return null;
            }
            if (component instanceof ConceptChronicleBI) {
                return (ConceptChronicleBI) component;
            } else {
                throw new InvalidCAB(
                        "Component exists of different type: "
                        + component + "\n\nConceptCAB: " + blueprint);
            }
        }
        return null;
    }

    @Override
    public ConceptChronicleBI constructIfNotCurrent(ConceptCB blueprint)
            throws IOException, InvalidCAB, ContradictionException {
        ConceptChronicleBI cc = getConcept(blueprint);
        if (cc == null) {
            return construct(blueprint);
        } else {
            Concept concept = Bdb.getConceptForComponent(cc.getNid());
            if (concept.isCanceled() || concept.getPrimUuid().toString().length() == 0
                    || concept.getConAttrs().getVersions().isEmpty()) {
                return construct(blueprint);
            } else {
                throw new InvalidCAB(
                        "Concept already exists: "
                        + cc + "\n\nConceptCAB cannot be used for update: " + blueprint);
            }
        }
    }

    @Override
    public ConceptChronicleBI construct(ConceptCB blueprint) throws IOException, InvalidCAB, ContradictionException {

        int cNid = Bdb.uuidToNid(blueprint.getComponentUuid());
        Bdb.getNidCNidMap().setCNidForNid(cNid, cNid);
        Concept newC = Concept.get(cNid);
        newC.setAnnotationStyleRefex(blueprint.isAnnotation());

        ConceptAttributes a = null;
        if (newC.getConceptAttributes() == null) {
            a = new ConceptAttributes();
            a.nid = cNid;
            a.enclosingConceptNid = cNid;
            newC.setConceptAttributes(a);
        } else if (newC.isCanceled()) {
            a = newC.getConceptAttributes();
            for (int pathNid : ec.getEditPaths().getSetValues()) {
                a.resetUncommitted(blueprint.getStatusNid(), ec.getAuthorNid(), pathNid, ec.getModuleNid());
            }
            a.nid = cNid;
            a.enclosingConceptNid = cNid;
        } else {
            throw new InvalidCAB("Concept already exists:\n" + blueprint + "\n\n" + newC);
        }

        a.setDefined(blueprint.isDefined());
        a.setPrimordialUuid(blueprint.getComponentUuid());

        boolean primoridal = true;
        for (int p : ec.getEditPaths().getSetValues()) {
            if (primoridal) {
                primoridal = false;
                a.primordialStamp =
                        Bdb.getStampDb().getSapNid(blueprint.getStatusNid(), Long.MAX_VALUE, ec.getAuthorNid(),
                            ec.getModuleNid(), p);
            } else {
                if (a.revisions == null) {
                    a.revisions = new RevisionSet(a.primordialStamp);
                }
                a.revisions.add((ConceptAttributesRevision) a.makeAnalog(blueprint.getStatusNid(),
                        Long.MAX_VALUE,
                        ec.getAuthorNid(),
                        ec.getModuleNid(),
                        p));
            }
        }

        List<DescCAB> fsnBps = blueprint.getFsnCABs();
        List<DescCAB> prefBps = blueprint.getPrefCABs();
        List<DescCAB> descBps = blueprint.getDescCABs();
        List<RelCAB> relBps = blueprint.getRelCABs();
        List<MediaCAB> mediaBps = blueprint.getMediaCABs();

        if (blueprint.getConAttrAB() != null) {
            for (RefexCAB annot : blueprint.getConAttrAB().getAnnotationBlueprints()) {
                this.construct(annot);
            }
        }

        for (DescCAB fsnBp : fsnBps) {
            this.construct(fsnBp);
        }
        for (DescCAB prefBp : prefBps) {
            this.construct(prefBp);
        }
        for (DescCAB descBp : descBps) {
            if (fsnBps.contains(descBp) || prefBps.contains(descBp)) {
                continue;
            } else {
                this.construct(descBp);
            }
        }
        for (RelCAB relBp : relBps) {
            this.construct(relBp);
        }
        for (MediaCAB mediaBp : mediaBps) {
            this.construct(mediaBp);
        }
        return newC;
    }

    @Override
    public ConAttrChronicleBI construct(ConAttrAB blueprint) throws IOException, InvalidCAB, ContradictionException {
        ConceptAttributes cac = getConAttr(blueprint);
        for (ConAttrVersionBI cav : cac.getVersions(vc)) {
            for (int p : ec.getEditPaths().getSetValues()) {

                if (cac.revisions == null) {
                    cac.revisions =
                            new RevisionSet(cac.primordialStamp);
                }
                ConceptAttributesRevision r = (ConceptAttributesRevision) cac.makeAnalog(blueprint.getStatusNid(),
                        Long.MAX_VALUE,
                        ec.getAuthorNid(),
                        ec.getModuleNid(),
                        p);
                cac.revisions.add(r);
            }
        }
        for (int p : ec.getEditPaths().getSetValues()) {
            for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
                construct(annotBp);
            }
        }

        return cac;
    }

    @Override
    public ConAttrChronicleBI constructIfNotCurrent(ConAttrAB blueprint) throws IOException, InvalidCAB {
        ConceptAttributes cac = getConAttr(blueprint);
        for (ConAttrVersionBI cav : cac.getVersions(vc)) {
            if (blueprint.validate(cav)) {
                return cac;
            }
            for (int p : ec.getEditPaths().getSetValues()) {

                if (cac.revisions == null) {
                    cac.revisions =
                            new RevisionSet(cac.primordialStamp);
                }
                ConceptAttributesRevision r = (ConceptAttributesRevision) cac.makeAnalog(blueprint.getStatusNid(),
                        Long.MAX_VALUE,
                        ec.getAuthorNid(),
                        ec.getModuleNid(),
                        p);
                cac.revisions.add(r);

            }
        }

        return cac;
    }

    @Override
    public EditCoordinate getEditCoordinate() {
        return ec;
    }
}
