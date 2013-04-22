package org.ihtsdo.ttk.concept.cc.refex;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;

import org.ihtsdo.ttk.api.ComponentChroncileBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.blueprint.InvalidBlueprintException;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexProperty;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.concept.Concept;
import org.ihtsdo.ttk.concept.cc.refex.type_array_of_bytearray.ArrayOfByteArrayMember;
import org.ihtsdo.ttk.concept.cc.refex.type_boolean.BooleanMember;
import org.ihtsdo.ttk.concept.cc.refex.type_int.IntMember;
import org.ihtsdo.ttk.concept.cc.refex.type_long.LongMember;
import org.ihtsdo.ttk.concept.cc.refex.type_membership.MembershipMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid.NidMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_boolean.NidBooleanMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_float.NidFloatMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_int.NidIntMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_long.NidLongMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid.NidNidMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid.NidNidNidMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_float.NidNidNidFloatMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_int.NidNidNidIntMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_long.NidNidNidLongMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_string.NidNidNidStringMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_string.NidNidStringMember;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_string.NidStringMember;
import org.ihtsdo.ttk.concept.cc.refex.type_string.StringMember;
import org.ihtsdo.ttk.dto.component.refex.TkRefexAbstractMember;
import org.ihtsdo.ttk.dto.component.refex.type_array_of_bytearray.TkRefexArrayOfByteArrayMember;
import org.ihtsdo.ttk.dto.component.refex.type_boolean.TkRefexBooleanMember;
import org.ihtsdo.ttk.dto.component.refex.type_int.TkRefexIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_long.TkRefexLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_member.TkRefexMember;
import org.ihtsdo.ttk.dto.component.refex.type_string.TkRefexStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid.TkRefexUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_boolean.TkRefexUuidBooleanMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_float.TkRefexUuidFloatMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_int.TkRefexUuidIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_long.TkRefexUuidLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_string.TkRefexUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid.TkRefexUuidUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_float.TkRefexUuidUuidUuidFloatMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_int.TkRefexUuidUuidUuidIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_long.TkRefexUuidUuidUuidLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_string.TkRefexUuidUuidUuidStringMember;

import static org.ihtsdo.ttk.api.TK_REFEX_TYPE.CID_CID_CID_FLOAT;
import static org.ihtsdo.ttk.api.TK_REFEX_TYPE.CID_CID_CID_INT;
import static org.ihtsdo.ttk.api.TK_REFEX_TYPE.CID_CID_CID_LONG;
import static org.ihtsdo.ttk.api.TK_REFEX_TYPE.CID_CID_CID_STRING;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

/**
 * Class description
 *
 *
 * @version        Enter version here..., 13/03/27
 * @author         Enter your name here...
 */
public class RefexMemberFactory {

   /**
    * Method description
    *
    *
    * @param res
    * @param ec
    *
    * @return
    *
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public static RefexMember<?, ?> create(RefexCAB res, EditCoordinate ec)
           throws IOException, InvalidBlueprintException {
      RefexMember<?, ?> member = createBlank(res);

      return reCreate(res, member, ec);
   }

   /**
    * Method description
    *
    *
    * @param refsetMember
    * @param enclosingConceptNid
    *
    * @return
    *
    * @throws IOException
    */
   public static RefexMember<?, ?> create(TkRefexAbstractMember<?> refsetMember, int enclosingConceptNid)
           throws IOException {
      switch (refsetMember.getType()) {
      case BOOLEAN :
         return new BooleanMember((TkRefexBooleanMember) refsetMember, enclosingConceptNid);

      case CID :
         return new NidMember((TkRefexUuidMember) refsetMember, enclosingConceptNid);

      case CID_CID :
         return new NidNidMember((TkRefexUuidUuidMember) refsetMember, enclosingConceptNid);

      case CID_CID_CID :
         return new NidNidNidMember((TkRefexUuidUuidUuidMember) refsetMember, enclosingConceptNid);

      case CID_CID_STR :
         return new NidNidStringMember((TkRefexUuidUuidStringMember) refsetMember, enclosingConceptNid);

      case CID_INT :
         return new NidIntMember((TkRefexUuidIntMember) refsetMember, enclosingConceptNid);

      case CID_STR :
         return new NidStringMember((TkRefexUuidStringMember) refsetMember, enclosingConceptNid);

      case INT :
         return new IntMember((TkRefexIntMember) refsetMember, enclosingConceptNid);

      case CID_FLOAT :
         return new NidFloatMember((TkRefexUuidFloatMember) refsetMember, enclosingConceptNid);

      case MEMBER :
         return new MembershipMember((TkRefexMember) refsetMember, enclosingConceptNid);

      case STR :
         return new StringMember((TkRefexStringMember) refsetMember, enclosingConceptNid);

      case CID_LONG :
         return new NidLongMember((TkRefexUuidLongMember) refsetMember, enclosingConceptNid);

      case LONG :
         return new LongMember((TkRefexLongMember) refsetMember, enclosingConceptNid);

      case ARRAY_BYTEARRAY :
         return new ArrayOfByteArrayMember((TkRefexArrayOfByteArrayMember) refsetMember, enclosingConceptNid);

      case CID_CID_CID_FLOAT :
         return new NidNidNidFloatMember((TkRefexUuidUuidUuidFloatMember) refsetMember, enclosingConceptNid);

      case CID_CID_CID_INT :
         return new NidNidNidIntMember((TkRefexUuidUuidUuidIntMember) refsetMember, enclosingConceptNid);

      case CID_CID_CID_LONG :
         return new NidNidNidLongMember((TkRefexUuidUuidUuidLongMember) refsetMember, enclosingConceptNid);

      case CID_CID_CID_STRING :
         return new NidNidNidStringMember((TkRefexUuidUuidUuidStringMember) refsetMember,
                                          enclosingConceptNid);

      case CID_BOOLEAN :
         return new NidBooleanMember((TkRefexUuidBooleanMember) refsetMember, enclosingConceptNid);

      default :
         throw new UnsupportedOperationException("Can't handle member type: " + refsetMember.getType());
      }
   }

   /**
    * Method description
    *
    *
    * @param nid
    * @param typeToken
    * @param enclosingConceptNid
    * @param input
    *
    * @return
    *
    * @throws IOException
    */
   @SuppressWarnings("rawtypes")
   public RefexMember create(int nid, int typeToken, int enclosingConceptNid, TupleInput input)
           throws IOException {
      TK_REFEX_TYPE memberType = TK_REFEX_TYPE.getFromToken(typeToken);

      switch (memberType) {
      case BOOLEAN :
         return new BooleanMember(enclosingConceptNid, input);

      case CID :
         return new NidMember(enclosingConceptNid, input);

      case CID_CID :
         return new NidNidMember(enclosingConceptNid, input);

      case CID_CID_CID :
         return new NidNidNidMember(enclosingConceptNid, input);

      case CID_CID_STR :
         return new NidNidStringMember(enclosingConceptNid, input);

      case CID_INT :
         return new NidIntMember(enclosingConceptNid, input);

      case CID_STR :
         return new NidStringMember(enclosingConceptNid, input);

      case INT :
         return new IntMember(enclosingConceptNid, input);

      case CID_FLOAT :
         return new NidFloatMember(enclosingConceptNid, input);

      case MEMBER :
         return new MembershipMember(enclosingConceptNid, input);

      case STR :
         return new StringMember(enclosingConceptNid, input);

      case CID_LONG :
         return new NidLongMember(enclosingConceptNid, input);

      case LONG :
         return new LongMember(enclosingConceptNid, input);

      case ARRAY_BYTEARRAY :
         return new ArrayOfByteArrayMember(enclosingConceptNid, input);

      case CID_CID_CID_FLOAT :
         return new NidNidNidFloatMember(enclosingConceptNid, input);

      case CID_CID_CID_INT :
         return new NidNidNidIntMember(enclosingConceptNid, input);

      case CID_CID_CID_LONG :
         return new NidNidNidLongMember(enclosingConceptNid, input);

      case CID_CID_CID_STRING :
         return new NidNidNidStringMember(enclosingConceptNid, input);

      case CID_BOOLEAN :
         return new NidBooleanMember(enclosingConceptNid, input);

      default :
         throw new UnsupportedOperationException("Can't handle member type: " + memberType + " "
             + Ts.get().getConceptForNid(nid).toLongString());
      }
   }

   /**
    * Method description
    *
    *
    * @param res
    *
    * @return
    */
   private static RefexMember<?, ?> createBlank(RefexCAB res) {
      switch (res.getMemberType()) {
      case BOOLEAN :
         return new BooleanMember();

      case CID :
         return new NidMember();

      case CID_CID :
         return new NidNidMember();

      case CID_CID_CID :
         return new NidNidNidMember();

      case CID_CID_STR :
         return new NidNidStringMember();

      case CID_INT :
         return new NidIntMember();

      case CID_STR :
         return new NidStringMember();

      case INT :
         return new IntMember();

      case CID_FLOAT :
         return new NidFloatMember();

      case MEMBER :
         return new MembershipMember();

      case STR :
         return new StringMember();

      case CID_LONG :
         return new NidLongMember();

      case LONG :
         return new LongMember();

      case ARRAY_BYTEARRAY :
         return new ArrayOfByteArrayMember();

      case CID_CID_CID_FLOAT :
         return new NidNidNidFloatMember();

      case CID_CID_CID_INT :
         return new NidNidNidIntMember();

      case CID_CID_CID_LONG :
         return new NidNidNidLongMember();

      case CID_CID_CID_STRING :
         return new NidNidNidStringMember();

      case CID_BOOLEAN :
         return new NidBooleanMember();

      default :
         throw new UnsupportedOperationException("Can't handle member type: " + res.getMemberType());
      }
   }

   /**
    * Method description
    *
    *
    * @param blueprint
    * @param member
    * @param ec
    *
    * @return
    *
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public static RefexMember<?, ?> reCreate(RefexCAB blueprint, RefexMember<?, ?> member, EditCoordinate ec)
           throws IOException, InvalidBlueprintException {
      Concept refexColCon = (Concept) P.s.getConcept(blueprint.getRefexCollectionUuid());

      member.refexExtensionNid = refexColCon.getNid();
      member.nid               = P.s.getNidForUuids(blueprint.getMemberUUID());

      if (refexColCon.isAnnotationStyleRefex()) {
         int rcNid = P.s.getNidForUuids(blueprint.getReferencedComponentUuid());

         member.enclosingConceptNid = P.s.getConceptNidForNid(rcNid);
         P.s.setConceptNidForNid(member.enclosingConceptNid, member.nid);

         ComponentChroncileBI<?> component = blueprint.getReferencedComponent();
         if (component == null) {
             component = P.s.getComponent(blueprint.getReferencedComponentUuid());
         }

         if (component == null) {
            throw new InvalidBlueprintException("Component for annotation is null. Blueprint: " + blueprint);
         }

         component.addAnnotation(member);
         if (refexColCon.isAnnotationIndex()) {
             // TODO: add support for indexed annotations...
             throw new UnsupportedOperationException();
         }
      } else {
         member.enclosingConceptNid = refexColCon.getNid();
         P.s.setConceptNidForNid(member.enclosingConceptNid, member.nid);
         refexColCon.getData().add(member);
      }

      for (int i = 0; i < ec.getEditPaths().size(); i++) {
         if (i == 0) {
            member.setStatusAtPositionNid(P.s.getStamp(blueprint.getInt(RefexProperty.STATUS_ID), Long.MAX_VALUE,
                ec.getAuthorNid(), ec.getModuleNid(), ec.getEditPaths().getSetValues()[i]));
            member.setPrimordialUuid(blueprint.getMemberUUID());

            try {
               blueprint.setPropertiesExceptSap(member);
            } catch (PropertyVetoException ex) {
               throw new InvalidBlueprintException("RefexAmendmentSpec: " + blueprint, ex);
            }
         } else {
            member.makeAnalog(blueprint.getInt(RefexProperty.STATUS_ID), Long.MAX_VALUE, ec.getAuthorNid(),
                              ec.getModuleNid(), ec.getEditPaths().getSetValues()[i]);
         }
      }

      return member;
   }
}