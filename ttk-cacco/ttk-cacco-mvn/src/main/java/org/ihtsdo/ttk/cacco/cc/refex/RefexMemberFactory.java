package org.ihtsdo.ttk.cacco.cc.refex;

import java.beans.PropertyVetoException;
import java.io.IOException;

import org.ihtsdo.ttk.cacco.cc.refex.type_boolean.BooleanMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_long.LongMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_nid.NidMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_nid_nid.NidNidMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_nid_nid_nid.NidNidNidMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_nid_nid_string.NidNidStringMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_nid_float.NidFloatMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_nid_int.NidIntMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_nid_long.NidLongMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_nid_string.NidStringMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_int.IntMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_membership.MembershipMember;
import org.ihtsdo.ttk.cacco.cc.refex.type_string.StringMember;
import org.ihtsdo.ttk.dto.component.refex.TkRefexAbstractMember;
import org.ihtsdo.ttk.dto.component.refex.type_boolean.TkRefexBooleanMember;
import org.ihtsdo.ttk.dto.component.refex.type_long.TkRefexLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid.TkRefexUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid.TkRefexUuidUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_float.TkRefexUuidFloatMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_int.TkRefexUuidIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_long.TkRefexUuidLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_string.TkRefexUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_int.TkRefexIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_member.TkRefexMember;
import org.ihtsdo.ttk.dto.component.refex.type_string.TkRefexStringMember;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.cacco.cc.P;
import org.ihtsdo.ttk.cacco.cc.concept.Concept;
import org.ihtsdo.ttk.cacco.cc.refex.type_array_of_bytearray.ArrayOfByteArrayMember;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.ComponentChroncileBI;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.dto.component.refex.type_array_of_bytearray.TkRefexArrayOfByteArrayMember;

public class RefexMemberFactory {

    public static RefexMember<?, ?> reCreate(RefexCAB res, RefexMember<?, ?> member, EditCoordinate ec) throws IOException, InvalidCAB {
        Concept refexColCon = (Concept) P.s.getConcept(res.getRefexColNid());
        member.refsetNid = refexColCon.getNid();
        member.nid = P.s.getNidForUuids(res.getMemberUUID());
        if (refexColCon.isAnnotationStyleRefex()) {
            int rcNid = P.s.getNidForUuids(res.getRcUuid());
            member.enclosingConceptNid = P.s.getConceptNidForNid(rcNid);
            P.s.setConceptNidForNid(member.enclosingConceptNid, member.nid);
            ComponentChroncileBI<?> component = P.s.getComponent(res.getRcUuid());
        } else {
            member.enclosingConceptNid = refexColCon.getNid();
            P.s.setConceptNidForNid(member.enclosingConceptNid, member.nid);
            refexColCon.getData().add(member);
        }
        for (int i = 0; i < ec.getEditPaths().size(); i++) {
            if (i == 0) {
                member.setStatusAtPositionNid(
                        P.s.getStamp(res.getInt(RefexProperty.STATUS_NID),
                        Long.MAX_VALUE,
                        ec.getAuthorNid(),
                        ec.getModuleNid(),
                        ec.getEditPaths().getSetValues()[i]));
                member.setPrimordialUuid(res.getMemberUUID());
                try {
                    res.setPropertiesExceptSap(member);
                } catch (PropertyVetoException ex) {
                    throw new InvalidCAB("RefexAmendmentSpec: " + res, ex);
                }

            } else {
                member.makeAnalog(res.getInt(RefexProperty.STATUS_NID),
                        Long.MAX_VALUE,
                        ec.getAuthorNid(),
                        ec.getModuleNid(),
                        ec.getEditPaths().getSetValues()[i]);
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
            case ARRAY_BYTEARRAY:
                return new ArrayOfByteArrayMember(enclosingConceptNid, input);

            default:
                throw new UnsupportedOperationException(
                        "Can't handle member type: " + memberType + " " + 
                        Ts.get().getConceptForNid(nid).toLongString());
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

            case ARRAY_BYTEARRAY:
                return new ArrayOfByteArrayMember((TkRefexArrayOfByteArrayMember) refsetMember, enclosingConceptNid);

            default:
                throw new UnsupportedOperationException(
                        "Can't handle member type: " + refsetMember.getType());
        }
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
            case ARRAY_BYTEARRAY:
                return new ArrayOfByteArrayMember();

            default:
                throw new UnsupportedOperationException(
                        "Can't handle member type: " + res.getMemberType());
        }

    }
}
