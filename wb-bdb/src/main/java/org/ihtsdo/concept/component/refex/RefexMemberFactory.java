package org.ihtsdo.concept.component.refex;

import java.beans.PropertyVetoException;
import java.io.IOException;

import org.ihtsdo.concept.component.refex.type_boolean.BooleanMember;
import org.ihtsdo.concept.component.refex.type_long.LongMember;
import org.ihtsdo.concept.component.refex.type_nid.NidMember;
import org.ihtsdo.concept.component.refex.type_nid_nid.NidNidMember;
import org.ihtsdo.concept.component.refex.type_nid_nid_nid.NidNidNidMember;
import org.ihtsdo.concept.component.refex.type_nid_nid_string.NidNidStringMember;
import org.ihtsdo.concept.component.refex.type_nid_float.NidFloatMember;
import org.ihtsdo.concept.component.refex.type_nid_int.NidIntMember;
import org.ihtsdo.concept.component.refex.type_nid_long.NidLongMember;
import org.ihtsdo.concept.component.refex.type_nid_string.NidStringMember;
import org.ihtsdo.concept.component.refex.type_int.IntMember;
import org.ihtsdo.concept.component.refex.type_membership.MembershipMember;
import org.ihtsdo.concept.component.refex.type_string.StringMember;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_boolean.TkRefexBooleanMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringMember;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.concept.Concept;
import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ComponentChroncileBI;
import org.ihtsdo.tk.api.blueprint.InvalidCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.EditCoordinate;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;

public class RefexMemberFactory {

    public static RefexMember<?, ?> reCreate(RefexCAB res, RefexMember<?, ?> member, EditCoordinate ec) throws IOException, InvalidCAB {
        Concept refexColCon = (Concept) Ts.get().getConcept(res.getRefexColNid());
        member.refsetNid = refexColCon.getNid();
        member.nid = Bdb.uuidToNid(res.getMemberUUID());
        if (refexColCon.isAnnotationStyleRefex()) {
            int rcNid = Ts.get().getNidForUuids(res.getRcUuid());
            member.enclosingConceptNid = Ts.get().getConceptNidForNid(rcNid);
            Bdb.getNidCNidMap().setCNidForNid(member.enclosingConceptNid, member.nid);
            ComponentChroncileBI<?> component = Ts.get().getComponent(res.getRcUuid());
        } else {
            member.enclosingConceptNid = refexColCon.getNid();
            Bdb.getNidCNidMap().setCNidForNid(member.enclosingConceptNid, member.nid);
            refexColCon.getData().add(member);
        }
        for (int i = 0; i < ec.getEditPaths().size(); i++) {
            if (i == 0) {
                member.setStatusAtPositionNid(
                        Bdb.getSapNid(res.getInt(RefexProperty.STATUS_NID),
                        ec.getAuthorNid(),
                        ec.getEditPaths().getSetValues()[i],
                        Long.MAX_VALUE));
                member.setPrimordialUuid(res.getMemberUUID());
                try {
                    res.setPropertiesExceptSap(member);
                } catch (PropertyVetoException ex) {
                    throw new InvalidCAB("RefexAmendmentSpec: " + res, ex);
                }

            } else {
                member.makeAnalog(res.getInt(RefexProperty.STATUS_NID),
                        ec.getAuthorNid(),
                        ec.getEditPaths().getSetValues()[i],
                        Long.MAX_VALUE);
            }

        }
        return member;
    }

    @SuppressWarnings("rawtypes")
    public RefexMember create(int nid, int typeToken, int enclosingConceptNid,
            TupleInput input) throws IOException {
        TK_REFEX_TYPE memberType = TK_REFEX_TYPE.getFromToken(typeToken);
        switch (memberType) {
            case BOOLEAN:
                return new BooleanMember(enclosingConceptNid, input);
            case CID:
                return new NidMember(enclosingConceptNid, input);
            case CID_CID:
                return new NidNidMember(enclosingConceptNid, input);
            case CID_CID_CID:
                return new NidNidNidMember(enclosingConceptNid, input);
            case CID_CID_STR:
                return new NidNidStringMember(enclosingConceptNid, input);
            case CID_INT:
                return new NidIntMember(enclosingConceptNid, input);
            case CID_STR:
                return new NidStringMember(enclosingConceptNid, input);
            case INT:
                return new IntMember(enclosingConceptNid, input);
            case CID_FLOAT:
                return new NidFloatMember(enclosingConceptNid, input);
            case MEMBER:
                return new MembershipMember(enclosingConceptNid, input);
            case STR:
                return new StringMember(enclosingConceptNid, input);
            case CID_LONG:
                return new NidLongMember(enclosingConceptNid, input);
            case LONG:
                return new LongMember(enclosingConceptNid, input);

            default:
                throw new UnsupportedOperationException(
                        "Can't handle member type: " + memberType);
        }
    }

    public static RefexMember<?, ?> create(TkRefexAbstractMember<?> refsetMember, int enclosingConceptNid) throws IOException {
        switch (refsetMember.getType()) {
            case BOOLEAN:
                return new BooleanMember((TkRefexBooleanMember) refsetMember, enclosingConceptNid);
            case CID:
                return new NidMember((TkRefexUuidMember) refsetMember, enclosingConceptNid);
            case CID_CID:
                return new NidNidMember((TkRefexUuidUuidMember) refsetMember, enclosingConceptNid);
            case CID_CID_CID:
                return new NidNidNidMember((TkRefexUuidUuidUuidMember) refsetMember, enclosingConceptNid);
            case CID_CID_STR:
                return new NidNidStringMember((TkRefexUuidUuidStringMember) refsetMember, enclosingConceptNid);
            case CID_INT:
                return new NidIntMember((TkRefexUuidIntMember) refsetMember, enclosingConceptNid);
            case CID_STR:
                return new NidStringMember((TkRefexUuidStringMember) refsetMember, enclosingConceptNid);
            case INT:
                return new IntMember((TkRefexIntMember) refsetMember, enclosingConceptNid);
            case CID_FLOAT:
                return new NidFloatMember((TkRefexUuidFloatMember) refsetMember, enclosingConceptNid);
            case MEMBER:
                return new MembershipMember((TkRefexMember) refsetMember, enclosingConceptNid);
            case STR:
                return new StringMember((TkRefexStringMember) refsetMember, enclosingConceptNid);
            case CID_LONG:
                return new NidLongMember((TkRefexUuidLongMember) refsetMember, enclosingConceptNid);
            case LONG:
                return new LongMember((TkRefexLongMember) refsetMember, enclosingConceptNid);

            default:
                throw new UnsupportedOperationException(
                        "Can't handle member type: " + refsetMember.getType());
        }
    }

    public static RefexMember<?, ?> createNoTx(RefexCAB res,
            EditCoordinate ec, long time)
            throws IOException, InvalidCAB {
        RefexMember<?, ?> member = createBlank(res);
        Concept refexColCon = (Concept) Ts.get().getConcept(res.getRefexColNid());
        int refexNid = Bdb.uuidToNid(res.getMemberUUID());
        member.nid = refexNid;
        if (refexColCon.isAnnotationStyleRefex()) {
            int rcNid = Ts.get().getNidForUuids(res.getRcUuid());
            member.enclosingConceptNid = Ts.get().getConceptNidForNid(rcNid);
            Bdb.getNidCNidMap().setCNidForNid(member.enclosingConceptNid, refexNid);
            Ts.get().getComponent(res.getRcUuid()).addAnnotation(member);
        } else {
            member.enclosingConceptNid = refexColCon.getNid();
            Bdb.getNidCNidMap().setCNidForNid(member.enclosingConceptNid, refexNid);
            refexColCon.getData().add(member);
        }
        for (int i = 0; i < ec.getEditPaths().size(); i++) {
            if (i == 0) {
                member.setStatusAtPositionNid(
                        Bdb.getSapNid(res.getInt(RefexProperty.STATUS_NID),
                        ec.getAuthorNid(),
                        ec.getEditPaths().getSetValues()[i],
                        time));
                member.setPrimordialUuid(res.getMemberUUID());
                try {
                    res.setPropertiesExceptSap(member);
                } catch (PropertyVetoException ex) {
                    throw new InvalidCAB("RefexAmendmentSpec: " + res, ex);
                }

            } else {
                member.makeAnalog(res.getInt(RefexProperty.STATUS_NID),
                        ec.getAuthorNid(),
                        ec.getEditPaths().getSetValues()[i],
                        time);
            }

        }
        if (refexColCon.isAnnotationStyleRefex()) {
            int rcNid = Ts.get().getNidForUuids(res.getRcUuid());
            Bdb.getConceptDb().writeConcept(
                    Bdb.getConcept(Bdb.getNidCNidMap().getCNid(rcNid)));
        } else {
            Bdb.getConceptDb().writeConcept(refexColCon);
        }
        return member;
    }

    public static RefexMember<?, ?> create(RefexCAB res,
            EditCoordinate ec)
            throws IOException, InvalidCAB {
        RefexMember<?, ?> member = createBlank(res);
        return reCreate(res, member, ec);
    }

    private static RefexMember<?, ?> createBlank(RefexCAB res) {
        switch (res.getMemberType()) {
            case BOOLEAN:
                return new BooleanMember();
            case CID:
                return new NidMember();
            case CID_CID:
                return new NidNidMember();
            case CID_CID_CID:
                return new NidNidNidMember();
            case CID_CID_STR:
                return new NidNidStringMember();
            case CID_INT:
                return new NidIntMember();
            case CID_STR:
                return new NidStringMember();
            case INT:
                return new IntMember();
            case CID_FLOAT:
                return new NidFloatMember();
            case MEMBER:
                return new MembershipMember();
            case STR:
                return new StringMember();
            case CID_LONG:
                return new NidLongMember();
            case LONG:
                return new LongMember();

            default:
                throw new UnsupportedOperationException(
                        "Can't handle member type: " + res.getMemberType());
        }

    }
}
