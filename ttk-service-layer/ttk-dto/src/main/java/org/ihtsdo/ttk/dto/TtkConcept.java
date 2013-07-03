package org.ihtsdo.ttk.dto;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ToolkitRefexType;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.description.DescriptionChronicleBI;
import org.ihtsdo.ttk.api.media.MediaChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayVersionBI;
import org.ihtsdo.ttk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.ttk.api.refex.type_int.RefexIntVersionBI;
import org.ihtsdo.ttk.api.refex.type_long.RefexLongVersionBI;
import org.ihtsdo.ttk.api.refex.type_member.RefexMemberVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_float.RefexNidFloatVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_int.RefexNidIntVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_long.RefexNidLongVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid.RefexNidNidVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_string.RefexNidNidStringVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_string.RefexNidStringVersionBI;
import org.ihtsdo.ttk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.ttk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.ttk.dto.component.TtkRevision;
import org.ihtsdo.ttk.dto.component.attribute.TtkConceptAttributes;
import org.ihtsdo.ttk.dto.component.description.TtkDescription;
import org.ihtsdo.ttk.dto.component.media.TtkMedia;
import org.ihtsdo.ttk.dto.component.refex.TtkRefexAbstractMember;
import org.ihtsdo.ttk.dto.component.refex.type_array_of_bytearray.TtkRefexArrayOfByteArrayMember;
import org.ihtsdo.ttk.dto.component.refex.type_boolean.TtkRefexBooleanMember;
import org.ihtsdo.ttk.dto.component.refex.type_int.TtkRefexIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_long.TtkRefexLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_member.TtkRefexMember;
import org.ihtsdo.ttk.dto.component.refex.type_string.TtkRefexStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid.TtkRefexUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_boolean.TtkRefexUuidBooleanMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_float.TtkRefexUuidFloatMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_int.TtkRefexUuidIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_long.TtkRefexUuidLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_string.TtkRefexUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid.TtkRefexUuidUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_string.TtkRefexUuidUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid.TtkRefexUuidUuidUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_float.TtkRefexUuidUuidUuidFloatMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_int.TtkRefexUuidUuidUuidIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_long.TtkRefexUuidUuidUuidLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_string.TtkRefexUuidUuidUuidStringMember;
import org.ihtsdo.ttk.dto.component.relationship.TtkRelationship;
import org.ihtsdo.ttk.dto.component.transformer.ComponentFields;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

import static org.ihtsdo.ttk.api.ToolkitRefexType.CID_CID_CID_FLOAT;
import static org.ihtsdo.ttk.api.ToolkitRefexType.CID_CID_CID_INT;
import static org.ihtsdo.ttk.api.ToolkitRefexType.CID_CID_CID_LONG;
import static org.ihtsdo.ttk.api.ToolkitRefexType.CID_CID_CID_STRING;

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
 * @version        Enter version here..., 13/03/27
 * @author         Enter your name here...    
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "concept")
public class TtkConcept {

   /** Field description */
   public static final String PADDING = "     ";

   /** Field description */
   public static final int dataVersion = 9;

   /** Field description */
   public static final long serialVersionUID = 1;

   /** Field description */
   @XmlAttribute
   protected boolean annotationStyleRefex = false;

   /** Field description */
   protected boolean annotationIndexStyleRefex = false;

   /** Field description */
   protected TtkConceptAttributes conceptAttributes;

   /** Field description */
   @XmlElementWrapper(name = "description-collection")
   @XmlElement(name = "description")
   protected List<TtkDescription> descriptions;

   /** Field description */
   @XmlElementWrapper(name = "media-collection")
   @XmlElement(name = "media")
   protected List<TtkMedia> media;

   /** Field description */
   @XmlAttribute
   protected UUID primordialUuid;

   /** Field description */
   @XmlElementWrapper(name = "refex-member-collection")
   @XmlElement(name = "refex")
   protected List<TtkRefexAbstractMember<?>> refsetMembers;

   /** Field description */
   @XmlElementWrapper(name = "relationship-collection")
   @XmlElement(name = "relationship")
   protected List<TtkRelationship> relationships;

   /**
    * Constructs ...
    *
    */
   public TtkConcept() {
      super();
   }

   /**
    * Constructs ...
    *
    *
    * @param c
    *
    * @throws IOException
    */
   public TtkConcept(ConceptChronicleBI c) throws IOException {
      annotationStyleRefex      = c.isAnnotationStyleRefex();
      annotationIndexStyleRefex = c.isAnnotationIndex();
      conceptAttributes         = new TtkConceptAttributes(c.getConAttrs());
      primordialUuid            = conceptAttributes.primordialUuid;
      relationships             = new ArrayList<>(c.getRelationshipsOutgoing().size());

      for (RelationshipChronicleBI rel : c.getRelationshipsOutgoing()) {
         relationships.add(new TtkRelationship(rel));
      }

      descriptions = new ArrayList<>(c.getDescs().size());

      for (DescriptionChronicleBI desc : c.getDescs()) {
         descriptions.add(new TtkDescription(desc));
      }

      media = new ArrayList<>(c.getMedia().size());

      for (MediaChronicleBI mediaChronicle : c.getMedia()) {
         TtkMedia tkMedia = new TtkMedia(mediaChronicle);

         media.add(tkMedia);
      }

      if (!c.isAnnotationStyleRefex()) {
         Collection<? extends RefexChronicleBI> members = c.getRefsetMembers();

         if (members != null) {
            refsetMembers = new ArrayList<>(members.size());

            for (RefexChronicleBI m : members) {
               TtkRefexAbstractMember<?> member = convertRefex(m);

               if (member != null) {
                  refsetMembers.add(member);
               } else {
                  throw new IOException("Could not convert refset member: " + m + "\nfrom refset: " + c);
               }
            }
         }
      }
   }

   /**
    * Constructs ...
    *
    *
    * @param in
    *
    * @throws ClassNotFoundException
    * @throws IOException
    */
   public TtkConcept(DataInput in) throws IOException, ClassNotFoundException {
      super();
      readExternal(in);
   }

   /**
    * Constructs ...
    *
    *
    * @param another
    * @param transformer
    */
   public TtkConcept(TtkConcept another, ComponentTransformerBI transformer) {
      super();
      this.annotationStyleRefex = transformer.transform(another.annotationStyleRefex, another,
          ComponentFields.ANNOTATION_REFEX);
      this.annotationIndexStyleRefex = transformer.transform(another.annotationIndexStyleRefex, another,
          ComponentFields.ANNOTATION_INDEX_REFEX);

      if (another.conceptAttributes != null) {
         this.conceptAttributes = another.conceptAttributes.makeTransform(transformer);
      }

      if (another.descriptions != null) {
         this.descriptions = new ArrayList<>(another.descriptions.size());

         for (TtkDescription d : another.descriptions) {
            this.descriptions.add(d.makeTransform(transformer));
         }
      }

      if (another.media != null) {
         this.media = new ArrayList<>(another.media.size());

         for (TtkMedia d : another.media) {
            this.media.add(d.makeTransform(transformer));
         }
      }

      this.primordialUuid = transformer.transform(another.primordialUuid, another,
          ComponentFields.PRIMORDIAL_UUID);

      if (another.refsetMembers != null) {
         this.refsetMembers = new ArrayList<>(another.refsetMembers.size());

         for (TtkRefexAbstractMember<?> d : another.refsetMembers) {
            this.refsetMembers.add((TtkRefexAbstractMember<?>) d.makeTransform(transformer));
         }
      }

      if (another.relationships != null) {
         this.relationships = new ArrayList<>(another.relationships.size());

         for (TtkRelationship d : another.relationships) {
            this.relationships.add(d.makeTransform(transformer));
         }
      }
   }

   /**
    * Method description
    *
    *
    * @param m
    *
    * @return
    *
    * @throws IOException
    */
   public static TtkRefexAbstractMember<?> convertRefex(RefexChronicleBI<?> m) throws IOException {
      if (m.getPrimordialVersion() instanceof RefexNidNidNidVersionBI) {
         return new TtkRefexUuidUuidUuidMember((RefexNidNidNidVersionBI) m);
      } else if (m.getPrimordialVersion() instanceof RefexNidNidStringVersionBI) {
         return new TtkRefexUuidUuidStringMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexNidNidVersionBI) {
         return new TtkRefexUuidUuidMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexNidFloatVersionBI) {
         return new TtkRefexUuidFloatMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexNidIntVersionBI) {
         return new TtkRefexUuidIntMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexNidLongVersionBI) {
         return new TtkRefexUuidLongMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexNidStringVersionBI) {
         return new TtkRefexUuidStringMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexNidVersionBI) {
         return new TtkRefexUuidMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexIntVersionBI) {
         return new TtkRefexIntMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexStringVersionBI) {
         return new TtkRefexStringMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexLongVersionBI) {
         return new TtkRefexLongMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexBooleanVersionBI) {
         return new TtkRefexBooleanMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexArrayOfBytearrayVersionBI) {
         return new TtkRefexArrayOfByteArrayMember(m);
      } else if (m.getPrimordialVersion() instanceof RefexMemberVersionBI) {
         return new TtkRefexMember(m);
      } else {
         throw new UnsupportedOperationException("Cannot handle: " + m);
      }
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a <tt>EConcept</tt>
    * object, and contains the same values, field by field, as this
    * <tt>EConcept</tt>.
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

      if (TtkConcept.class.isAssignableFrom(obj.getClass())) {
         TtkConcept another = (TtkConcept) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare ConceptAttributes
         if (this.conceptAttributes == null) {
            if (this.conceptAttributes != another.conceptAttributes) {
               return false;
            }
         } else if (!this.conceptAttributes.equals(another.conceptAttributes)) {
            return false;
         }

         // Compare Descriptions
         if (this.descriptions == null) {
            if (another.descriptions == null) {              // Equal!
            } else if (another.descriptions.isEmpty()) {     // Equal!
            } else {
               return false;
            }
         } else if (!this.descriptions.equals(another.descriptions)) {
            return false;
         }

         // Compare Relationships
         if (this.relationships == null) {
            if (another.relationships == null) {             // Equal!
            } else if (another.relationships.isEmpty()) {    // Equal!
            } else {
               return false;
            }
         } else if (!this.relationships.equals(another.relationships)) {
            return false;
         }

         // Compare Images
         if (this.media == null) {
            if (another.media == null) {                     // Equal!
            } else if (another.media.isEmpty()) {            // Equal!
            } else {
               return false;
            }
         } else if (!this.media.equals(another.media)) {
            return false;
         }

         // Compare Refset Members
         if (this.refsetMembers == null) {
            if (another.refsetMembers == null) {             // Equal!
            } else if (another.refsetMembers.isEmpty()) {    // Equal!
            } else {
               return false;
            }
         } else if (!this.refsetMembers.equals(another.refsetMembers)) {
            return false;
         }

         // If none of the previous comparisons fail, the objects must be equal
         return true;
      }

      return false;
   }

   /**
    * Returns a hash code for this
    * <code>EConcept</code>.
    *
    * @return a hash code value for this <tt>EConcept</tt>.
    */
   @Override
   public int hashCode() {
      return this.conceptAttributes.getPrimordialComponentUuid().hashCode();
   }

   /**
    * Method description
    *
    *
    * @param in
    *
    * @throws ClassNotFoundException
    * @throws IOException
    */
   public final void readExternal(DataInput in) throws IOException, ClassNotFoundException {
      int readDataVersion = in.readInt();

      if (readDataVersion > dataVersion) {
         throw new IOException("Unsupported dataVersion: " + readDataVersion);
      }

      if (readDataVersion == 1) {
         conceptAttributes = new TtkConceptAttributes(in, readDataVersion);
         primordialUuid    = conceptAttributes.getPrimordialComponentUuid();
      } else {
         primordialUuid = new UUID(in.readLong(), in.readLong());

         int attributeCount = in.readByte();

         if (attributeCount == 1) {
            conceptAttributes = new TtkConceptAttributes(in, readDataVersion);
         }
      }

      int descCount = in.readInt();

      if (descCount > 0) {
         descriptions = new ArrayList<>(descCount);

         for (int i = 0; i < descCount; i++) {
            descriptions.add(new TtkDescription(in, readDataVersion));
         }
      }

      int relCount = in.readInt();

      if (relCount > 0) {
         relationships = new ArrayList<>(relCount);

         for (int i = 0; i < relCount; i++) {
            relationships.add(new TtkRelationship(in, readDataVersion));
         }
      }

      int imgCount = in.readInt();

      if (imgCount > 0) {
         media = new ArrayList<>(imgCount);

         for (int i = 0; i < imgCount; i++) {
            media.add(new TtkMedia(in, readDataVersion));
         }
      }

      int refsetMemberCount = in.readInt();

      if (refsetMemberCount > 0) {
         refsetMembers = new ArrayList<>(refsetMemberCount);

         for (int i = 0; i < refsetMemberCount; i++) {
            ToolkitRefexType type = ToolkitRefexType.readType(in);

            switch (type) {
            case CID :
               refsetMembers.add(new TtkRefexUuidMember(in, readDataVersion));

               break;

            case CID_CID :
               refsetMembers.add(new TtkRefexUuidUuidMember(in, readDataVersion));

               break;

            case MEMBER :
               refsetMembers.add(new TtkRefexMember(in, readDataVersion));

               break;

            case CID_CID_CID :
               refsetMembers.add(new TtkRefexUuidUuidUuidMember(in, readDataVersion));

               break;

            case CID_CID_STR :
               refsetMembers.add(new TtkRefexUuidUuidStringMember(in, readDataVersion));

               break;

            case INT :
               refsetMembers.add(new TtkRefexIntMember(in, readDataVersion));

               break;

            case STR :
               refsetMembers.add(new TtkRefexStringMember(in, readDataVersion));

               break;

            case CID_INT :
               refsetMembers.add(new TtkRefexUuidIntMember(in, readDataVersion));

               break;

            case BOOLEAN :
               refsetMembers.add(new TtkRefexBooleanMember(in, readDataVersion));

               break;

            case CID_FLOAT :
               refsetMembers.add(new TtkRefexUuidFloatMember(in, readDataVersion));

               break;

            case CID_LONG :
               refsetMembers.add(new TtkRefexUuidLongMember(in, readDataVersion));

               break;

            case CID_STR :
               refsetMembers.add(new TtkRefexUuidStringMember(in, readDataVersion));

               break;

            case LONG :
               refsetMembers.add(new TtkRefexLongMember(in, readDataVersion));

               break;

            case ARRAY_BYTEARRAY :
               refsetMembers.add(new TtkRefexArrayOfByteArrayMember(in, readDataVersion));

               break;

            case CID_CID_CID_FLOAT :
               refsetMembers.add(new TtkRefexUuidUuidUuidFloatMember(in, dataVersion));

               break;

            case CID_CID_CID_INT :
               refsetMembers.add(new TtkRefexUuidUuidUuidIntMember(in, dataVersion));

               break;

            case CID_CID_CID_LONG :
               refsetMembers.add(new TtkRefexUuidUuidUuidLongMember(in, dataVersion));

               break;

            case CID_CID_CID_STRING :
               refsetMembers.add(new TtkRefexUuidUuidUuidStringMember(in, dataVersion));

               break;

            case CID_BOOLEAN :
               refsetMembers.add(new TtkRefexUuidBooleanMember(in, dataVersion));

               break;

            default :
               throw new UnsupportedOperationException("Can't handle refset type: " + type);
            }
         }
      }

      if (readDataVersion < 4) {
         in.readInt();    // destRelNidTypeNidsCount
         in.readInt();    // refsetUuidMemberUuidForConceptCount
         in.readInt();    // refsetUuidMemberUuidForDescsCount
         in.readInt();    // refsetUuidMemberUuidForRelsCount
         in.readInt();    // refsetUuidMemberUuidForImagesCount
         in.readInt();    // refsetUuidMemberUuidForRefsetMembersCount
      }

      if (readDataVersion >= 5) {
         annotationStyleRefex = in.readBoolean();
      } else {
         annotationStyleRefex = false;
      }

      if (readDataVersion >= 9) {
         annotationIndexStyleRefex = in.readBoolean();
      } else {
         annotationIndexStyleRefex = false;
      }
   }

   /**
    * Returns a string representation of the object.
    *
    * @return
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName());
      buff.append(": \n   primordial UUID: ");
      buff.append(TtkRevision.informAboutUuid(this.primordialUuid));
      buff.append(": \n   annotation refex: ");
      buff.append(this.annotationStyleRefex);
      buff.append(": \n   indexed annotation: ");
      buff.append(this.annotationIndexStyleRefex);
      buff.append("\n   ConceptAttributes: \n");
      buff.append(PADDING);

      if (this.conceptAttributes == null) {
         buff.append(PADDING + "none\n");
      } else {
         buff.append(this.conceptAttributes);
         buff.append("\n");
      }

      buff.append("\n   Descriptions: \n");

      if (this.descriptions == null) {
         buff.append(PADDING + "none\n");
      } else {
         for (TtkDescription d : this.descriptions) {
            buff.append(PADDING);
            buff.append(d);
            buff.append("\n");
         }
      }

      buff.append("\n   Relationships: \n");

      if (this.relationships == null) {
         buff.append(PADDING + "none\n");
      } else {
         for (TtkRelationship r : this.relationships) {
            buff.append(PADDING);
            buff.append(r);
            buff.append("\n");
         }
      }

      buff.append("\n   RefsetMembers: \n");

      if (this.refsetMembers == null) {
         buff.append(PADDING + "none\n");
      } else {
         for (TtkRefexAbstractMember<?> r : this.refsetMembers) {
            buff.append(PADDING);
            buff.append(r);
            buff.append("\n");
         }
      }

      buff.append("\n   Media: \n");

      if (this.media == null) {
         buff.append(PADDING + "none");
      } else {
         for (TtkMedia m : this.media) {
            buff.append(PADDING);
            buff.append(m);
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
   public void writeExternal(DataOutput out) throws IOException {
      out.writeInt(dataVersion);

      if (primordialUuid == null) {
         primordialUuid = conceptAttributes.getPrimordialComponentUuid();
      }

      out.writeLong(primordialUuid.getMostSignificantBits());
      out.writeLong(primordialUuid.getLeastSignificantBits());

      if (conceptAttributes == null) {
         out.writeByte(0);
      } else {
         out.writeByte(1);
         conceptAttributes.writeExternal(out);
      }

      if (descriptions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(descriptions.size());

         for (TtkDescription d : descriptions) {
            d.writeExternal(out);
         }
      }

      if (relationships == null) {
         out.writeInt(0);
      } else {
         out.writeInt(relationships.size());

         for (TtkRelationship r : relationships) {
            r.writeExternal(out);
         }
      }

      if (media == null) {
         out.writeInt(0);
      } else {
         out.writeInt(media.size());

         for (TtkMedia img : media) {
            img.writeExternal(out);
         }
      }

      if (refsetMembers == null) {
         out.writeInt(0);
      } else {
         out.writeInt(refsetMembers.size());

         for (TtkRefexAbstractMember<?> r : refsetMembers) {
            r.getType().writeType(out);
            r.writeExternal(out);
         }
      }

      out.writeBoolean(annotationStyleRefex);
      out.writeBoolean(annotationIndexStyleRefex);
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public TtkConceptAttributes getConceptAttributes() {
      return conceptAttributes;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public List<TtkDescription> getDescriptions() {
      if (descriptions == null) {
         descriptions = new ArrayList<>();
      }

      return descriptions;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public List<TtkMedia> getMedia() {
      if (media == null) {
         media = new ArrayList<>();
      }

      return media;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public UUID getPrimordialUuid() {
      return primordialUuid;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public List<TtkRefexAbstractMember<?>> getRefsetMembers() {
      if (refsetMembers == null) {
         refsetMembers = new ArrayList<>();
      }

      return refsetMembers;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public List<TtkRelationship> getRelationships() {
      if (relationships == null) {
         relationships = new ArrayList<>();
      }

      return relationships;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public boolean isAnnotationIndexStyleRefex() {
      return annotationIndexStyleRefex;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public boolean isAnnotationStyleRefex() {
      return annotationStyleRefex;
   }

   /**
    * Method description
    *
    *
    * @param annotationIndexStyleRefex
    */
   public void setAnnotationIndexStyleRefex(boolean annotationIndexStyleRefex) {
      this.annotationIndexStyleRefex = annotationIndexStyleRefex;
   }

   /**
    * Method description
    *
    *
    * @param annotationStyleRefex
    */
   public void setAnnotationStyleRefex(boolean annotationStyleRefex) {
      this.annotationStyleRefex = annotationStyleRefex;
   }

   /**
    * Method description
    *
    *
    * @param conceptAttributes
    */
   public void setConceptAttributes(TtkConceptAttributes conceptAttributes) {
      this.conceptAttributes = conceptAttributes;
   }

   /**
    * Method description
    *
    *
    * @param descriptions
    */
   public void setDescriptions(List<TtkDescription> descriptions) {
      this.descriptions = descriptions;
   }

   /**
    * Method description
    *
    *
    * @param images
    */
   public void setImages(List<TtkMedia> images) {
      this.media = images;
   }

   /**
    * Method description
    *
    *
    * @param primordialUuid
    */
   public void setPrimordialUuid(UUID primordialUuid) {
      this.primordialUuid = primordialUuid;
   }

   /**
    * Method description
    *
    *
    * @param refsetMembers
    */
   public void setRefsetMembers(List<TtkRefexAbstractMember<?>> refsetMembers) {
      this.refsetMembers = refsetMembers;
   }

   /**
    * Method description
    *
    *
    * @param relationships
    */
   public void setRelationships(List<TtkRelationship> relationships) {
      this.relationships = relationships;
   }
}
