package org.ihtsdo.ttk.dto.component;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ToolkitRefexType;
import org.ihtsdo.ttk.api.id.IdBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.uuid.UuidFactory;
import org.ihtsdo.ttk.dto.TtkConcept;
import org.ihtsdo.ttk.dto.component.identifier.IDENTIFIER_PART_TYPES;
import org.ihtsdo.ttk.dto.component.identifier.TkIdentifier;
import org.ihtsdo.ttk.dto.component.identifier.TkIdentifierLong;
import org.ihtsdo.ttk.dto.component.identifier.TkIdentifierString;
import org.ihtsdo.ttk.dto.component.identifier.TkIdentifierUuid;
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
import org.ihtsdo.ttk.dto.component.transformer.ComponentFields;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;

import javax.xml.bind.annotation.*;

/**
 * Class description
 *
 *
 * @param <V>
 *
 * @version        Enter version here..., 13/03/27
 * @author         Enter your name here...    
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TtkComponent<V extends TtkRevision> extends TtkRevision {

   /** Field description */
   private static final long serialVersionUID = 1;

   /** Field description */
   @XmlElementWrapper(name = "additional-ids")
   @XmlElement(name = "id")
   public List<TkIdentifier> additionalIds;

   /** Field description */
   @XmlElementWrapper(name = "annotations")
   @XmlElement(name = "refex")
   public List<TkRefexAbstractMember<?>> annotations;

   /** Field description */
   @XmlAttribute
   public UUID primordialUuid;

   /** Field description */
   @XmlElementWrapper(name = "revisions")
   @XmlElement(name = "revision")
   public List<V> revisions;

   /**
    * Constructs ...
    *
    */
   public TtkComponent() {
      super();
   }

   /**
    * Constructs ...
    *
    *
    * @param another
    *
    * @throws IOException
    */
   public TtkComponent(ComponentVersionBI another) throws IOException {
      super(another);

      Collection<? extends IdBI> anotherAdditionalIds = another.getAdditionalIds();

      if (anotherAdditionalIds != null) {
         this.additionalIds = new ArrayList<>(anotherAdditionalIds.size());
nextId:
         for (IdBI id : anotherAdditionalIds) {
            this.additionalIds.add((TkIdentifier) TkIdentifier.convertId(id));
         }
      }

      Collection<? extends RefexChronicleBI<?>> anotherAnnotations = another.getAnnotations();

      processAnnotations(anotherAnnotations);
      this.primordialUuid = another.getPrimordialUuid();
   }

   /**
    * Constructs ...
    *
    *
    * @param in
    * @param dataVersion
    *
    * @throws ClassNotFoundException
    * @throws IOException
    */
   public TtkComponent(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   /**
    * Constructs ...
    *
    *
    * @param another
    * @param transformer
    */
   public TtkComponent(TtkComponent<V> another, ComponentTransformerBI transformer) {
      super(another, transformer);

      if (another.additionalIds != null) {
         this.additionalIds = new ArrayList<>(another.additionalIds.size());

         for (TkIdentifier id : another.additionalIds) {
            this.additionalIds.add((TkIdentifier) id.makeTransform(transformer));
         }
      }

      if (another.annotations != null) {
         this.annotations = new ArrayList<>(another.annotations.size());

         for (TkRefexAbstractMember<?> r : another.annotations) {
            this.annotations.add((TkRefexAbstractMember<?>) r.makeTransform(transformer));
         }
      }

      this.primordialUuid = transformer.transform(another.primordialUuid, another,
          ComponentFields.PRIMORDIAL_UUID);

      if (another.revisions != null) {
         this.revisions = new ArrayList<>(another.revisions.size());

         for (V r : another.revisions) {
            this.revisions.add((V) r.makeTransform(transformer));
         }
      }
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EComponent</tt> object, and contains the same values, field by field,
    * as this <tt>EComponent</tt>.
    *
    * @param obj the object to compare with.
    * @return <code>true</code> if the objects are the same; <code>false</code>
    * otherwise.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (TtkComponent.class.isAssignableFrom(obj.getClass())) {
         TtkComponent<?> another = (TtkComponent<?>) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare primordialComponentUuid
         if (!this.primordialUuid.equals(another.primordialUuid)) {
            return false;
         }

         // Compare additionalIdComponents
         if (this.additionalIds == null) {
            if (another.additionalIds == null) {             // Equal!
            } else if (another.additionalIds.isEmpty()) {    // Equal!
            } else {
               return false;
            }
         } else if (!this.additionalIds.equals(another.additionalIds)) {
            return false;
         }

         // Compare extraVersions
         if (this.revisions == null) {
            if (another.revisions == null) {                 // Equal!
            } else if (another.revisions.isEmpty()) {        // Equal!
            } else {
               return false;
            }
         } else if (!this.revisions.equals(another.revisions)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this
    * <code>EComponent</code>.
    *
    * @return a hash code value for this <tt>EComponent</tt>.
    */
   @Override
   public int hashCode() {
      return Arrays.hashCode(new int[] { getPrimordialComponentUuid().hashCode(), statusUuid.hashCode(),
                                         pathUuid.hashCode(), (int) time, (int) (time >>> 32) });
   }

   /**
    * Method description
    *
    *
    * @param annotations
    *
    * @throws IOException
    */
   private void processAnnotations(Collection<? extends RefexChronicleBI<?>> annotations) throws IOException {
      if ((annotations != null) &&!annotations.isEmpty()) {
         this.annotations = new ArrayList<>(annotations.size());

         for (RefexChronicleBI<?> r : annotations) {
            this.annotations.add(TtkConcept.convertRefex(r));
         }
      }
   }

   /**
    * Method description
    *
    *
    * @param in
    * @param dataVersion
    *
    * @throws ClassNotFoundException
    * @throws IOException
    */
   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      primordialUuid = new UUID(in.readLong(), in.readLong());

      short idVersionCount = in.readShort();

      assert idVersionCount < 500 : "idVersionCount is: " + idVersionCount;

      if (idVersionCount > 0) {
         additionalIds = new ArrayList<>(idVersionCount);

         for (int i = 0; i < idVersionCount; i++) {
            switch (IDENTIFIER_PART_TYPES.readType(in)) {
            case LONG :
               additionalIds.add(new TkIdentifierLong(in, dataVersion));

               break;

            case STRING :
               additionalIds.add(new TkIdentifierString(in, dataVersion));

               break;

            case UUID :
               additionalIds.add(new TkIdentifierUuid(in, dataVersion));

               break;

            default :
               throw new UnsupportedOperationException();
            }
         }
      }

      short annotationCount = in.readShort();

      assert annotationCount < 5000 : "annotation count is: " + annotationCount;

      if (annotationCount > 0) {
         annotations = new ArrayList<>(annotationCount);

         for (int i = 0; i < annotationCount; i++) {
            ToolkitRefexType type = ToolkitRefexType.readType(in);

            switch (type) {
            case CID :
               annotations.add(new TkRefexUuidMember(in, dataVersion));

               break;

            case CID_CID :
               annotations.add(new TkRefexUuidUuidMember(in, dataVersion));

               break;

            case MEMBER :
               annotations.add(new TkRefexMember(in, dataVersion));

               break;

            case CID_CID_CID :
               annotations.add(new TkRefexUuidUuidUuidMember(in, dataVersion));

               break;

            case CID_CID_STR :
               annotations.add(new TkRefexUuidUuidStringMember(in, dataVersion));

               break;

            case INT :
               annotations.add(new TkRefexIntMember(in, dataVersion));

               break;

            case STR :
               annotations.add(new TkRefexStringMember(in, dataVersion));

               break;

            case CID_INT :
               annotations.add(new TkRefexUuidIntMember(in, dataVersion));

               break;

            case BOOLEAN :
               annotations.add(new TkRefexBooleanMember(in, dataVersion));

               break;

            case CID_FLOAT :
               annotations.add(new TkRefexUuidFloatMember(in, dataVersion));

               break;

            case CID_LONG :
               annotations.add(new TkRefexUuidLongMember(in, dataVersion));

               break;

            case CID_STR :
               annotations.add(new TkRefexUuidStringMember(in, dataVersion));

               break;

            case LONG :
               annotations.add(new TkRefexLongMember(in, dataVersion));

               break;

            case ARRAY_BYTEARRAY :
               annotations.add(new TkRefexArrayOfByteArrayMember(in, dataVersion));

               break;

            case CID_CID_CID_FLOAT :
               annotations.add(new TkRefexUuidUuidUuidFloatMember(in, dataVersion));

               break;

            case CID_CID_CID_INT :
               annotations.add(new TkRefexUuidUuidUuidIntMember(in, dataVersion));

               break;

            case CID_CID_CID_LONG :
               annotations.add(new TkRefexUuidUuidUuidLongMember(in, dataVersion));

               break;

            case CID_CID_CID_STRING :
               annotations.add(new TkRefexUuidUuidUuidStringMember(in, dataVersion));

               break;

            case CID_BOOLEAN :
               annotations.add(new TkRefexUuidBooleanMember(in, dataVersion));

               break;

            default :
               throw new UnsupportedOperationException("Can't handle refset type: " + type);
            }
         }
      }
   }

   /**
    * Returns a string representation of the object.
    *
    * @return
    */
   @Override
   public String toString() {
      int depth = 1;

      if (this instanceof TkRefexAbstractMember) {
         depth = 2;
      }

      StringBuilder buff = new StringBuilder();

      buff.append(" primordial:");
      buff.append(this.primordialUuid);
      buff.append(" xtraIds:");
      buff.append(this.additionalIds);
      buff.append(super.toString());

      if ((annotations != null) && (annotations.size() > 0)) {
         buff.append("\n" + TtkConcept.PADDING);

         for (int i = 0; i < depth; i++) {
            buff.append(TtkConcept.PADDING);
         }

         buff.append("annotations:\n");

         for (TkRefexAbstractMember m : this.annotations) {
            buff.append(TtkConcept.PADDING);
            buff.append(TtkConcept.PADDING);

            for (int i = 0; i < depth; i++) {
               buff.append(TtkConcept.PADDING);
            }

            buff.append(m);
            buff.append("\n");
         }
      }

      if ((revisions != null) && (revisions.size() > 0)) {
         buff.append("\n" + TtkConcept.PADDING + "revisions:\n");

         for (TtkRevision r : this.revisions) {
            buff.append(TtkConcept.PADDING);
            buff.append(TtkConcept.PADDING);

            for (int i = 0; i < depth; i++) {
               buff.append(TtkConcept.PADDING);
            }

            buff.append(r);
            buff.append("\n");
         }
      }

      return buff.toString();
   }

   /**
    * Method description
    *
    *
    * @param out
    *
    * @throws IOException
    */
   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(primordialUuid.getMostSignificantBits());
      out.writeLong(primordialUuid.getLeastSignificantBits());

      if (additionalIds == null) {
         out.writeShort(0);
      } else {
         assert additionalIds.size() < 500 : "additionalIds is: " + additionalIds.size();
         out.writeShort(additionalIds.size());

         for (TkIdentifier idv : additionalIds) {
            idv.getIdType().writeType(out);
            idv.writeExternal(out);
         }
      }

      if (annotations == null) {
         out.writeShort(0);
      } else {
         assert annotations.size() < 500 : "annotation count is: " + annotations.size();
         out.writeShort(annotations.size());

         for (TkRefexAbstractMember<?> r : annotations) {
            r.getType().writeType(out);
            r.writeExternal(out);
         }
      }
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public List<TkIdentifier> getAdditionalIdComponents() {
      return additionalIds;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public List<TkRefexAbstractMember<?>> getAnnotations() {
      return annotations;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public List<TkIdentifier> getEIdentifiers() {
      List<TkIdentifier> ids;

      if (additionalIds != null) {
         ids = new ArrayList<>(additionalIds.size() + 1);
         ids.addAll(additionalIds);
      } else {
         ids = new ArrayList<>(1);
      }

      ids.add(new TkIdentifierUuid(this.primordialUuid));

      return ids;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public int getIdComponentCount() {
      if (additionalIds == null) {
         return 1;
      }

      return additionalIds.size() + 1;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public UUID getPrimordialComponentUuid() {
      return primordialUuid;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public abstract List<? extends TtkRevision> getRevisionList();

   /**
    * Method description
    *
    *
    * @return
    */
   public List<V> getRevisions() {
      return revisions;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public List<UUID> getUuids() {
      List<UUID> uuids;

      if (additionalIds != null) {
         uuids = new ArrayList<>(additionalIds.size() + 1);
      } else {
         uuids = new ArrayList<>(1);
      }

      uuids.add(primordialUuid);

      if (additionalIds != null) {
         for (TkIdentifier idv : additionalIds) {
            if (TkIdentifierUuid.class.isAssignableFrom(idv.getClass())) {
               uuids.add((UUID) idv.getDenotation());
            } else {
               uuids.add(UuidFactory.getUuidFromAlternateId(idv.authorityUuid,
                   idv.getDenotation().toString()));
            }
         }
      }

      return uuids;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public int getVersionCount() {
      List<? extends TtkRevision> extraVersions = getRevisionList();

      if (extraVersions == null) {
         return 1;
      }

      return extraVersions.size() + 1;
   }

   /**
    * Method description
    *
    *
    * @param additionalIdComponents
    */
   public void setAdditionalIdComponents(List<TkIdentifier> additionalIdComponents) {
      this.additionalIds = additionalIdComponents;
   }

   /**
    * Method description
    *
    *
    * @param annotations
    */
   public void setAnnotations(List<TkRefexAbstractMember<?>> annotations) {
      this.annotations = annotations;
   }

   /**
    * Method description
    *
    *
    * @param primordialComponentUuid
    */
   public void setPrimordialComponentUuid(UUID primordialComponentUuid) {
      this.primordialUuid = primordialComponentUuid;
   }

   /**
    * Method description
    *
    *
    * @param revisions
    */
   public void setRevisions(List<V> revisions) {
      this.revisions = revisions;
   }
}
