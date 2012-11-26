package org.ihtsdo.tk.dto.concept;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes;
import org.ihtsdo.tk.dto.concept.component.description.TkDescription;
import org.ihtsdo.tk.dto.concept.component.media.TkMedia;
import org.ihtsdo.tk.dto.concept.component.refex.type_boolean.TkRefexBooleanMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
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
import org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.media.MediaChronicleBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayVersionBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.tk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid.RefexNidNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_string.RefexNidNidStringVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_int.RefexNidIntVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_long.RefexNidLongVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_string.RefexNidStringVersionBI;
import org.ihtsdo.tk.api.refex.type_int.RefexIntVersionBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;
import org.ihtsdo.tk.api.refex.type_member.RefexMemberVersionBI;
import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.tk.dto.concept.component.refex.type_array_of_bytearray.TkRefexArrayOfByteArrayMember;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "concept")
public class TkConcept {

    public static final String PADDING = "     ";
    public static final int dataVersion = 9;
    public static final long serialVersionUID = 1;
    //~--- fields --------------------------------------------------------------
    @XmlAttribute
    protected boolean annotationStyleRefex = false;
    protected boolean annotationIndexStyleRefex = false;
    protected TkConceptAttributes conceptAttributes;
    @XmlElementWrapper(name = "description-collection")
    @XmlElement(name = "description")
    protected List<TkDescription> descriptions;
    @XmlElementWrapper(name = "media-collection")
    @XmlElement(name = "media")
    protected List<TkMedia> media;
    @XmlAttribute
    protected UUID primordialUuid;
    @XmlElementWrapper(name = "refex-member-collection")
    @XmlElement(name = "refex")
    protected List<TkRefexAbstractMember<?>> refsetMembers;
    @XmlElementWrapper(name = "relationship-collection")
    @XmlElement(name = "relationship")
    protected List<TkRelationship> relationships;

    //~--- constructors --------------------------------------------------------
    public TkConcept() {
        super();
    }

    public TkConcept(DataInput in) throws IOException, ClassNotFoundException {
        super();
        readExternal(in);
    }

    public TkConcept(ConceptChronicleBI c) throws IOException {
        annotationStyleRefex = c.isAnnotationStyleRefex();
        annotationIndexStyleRefex = c.isAnnotationIndex();
        conceptAttributes = new TkConceptAttributes(c.getConAttrs());
        primordialUuid = conceptAttributes.primordialUuid;
        relationships = new ArrayList<>(c.getRelsOutgoing().size());

        for (RelationshipChronicleBI rel : c.getRelsOutgoing()) {
            relationships.add(new TkRelationship(rel));
        }

        descriptions = new ArrayList<>(c.getDescs().size());

        for (DescriptionChronicleBI desc : c.getDescs()) {
            descriptions.add(new TkDescription(desc));
        }

        media = new ArrayList<>(c.getMedia().size());

        for (MediaChronicleBI mediaChronicle : c.getMedia()) {
            TkMedia tkMedia = new TkMedia(mediaChronicle);
            media.add(tkMedia);
        }

        if (!c.isAnnotationStyleRefex()) {
            Collection<? extends RefexChronicleBI> members = c.getRefsetMembers();

            if (members != null) {
                refsetMembers = new ArrayList<>(members.size());

                for (RefexChronicleBI m : members) {
                    TkRefexAbstractMember<?> member = convertRefex(m);

                    if (member != null) {
                        refsetMembers.add(member);
                    } else {
                        throw new IOException("Could not convert refset member: " + m + "\nfrom refset: " + c);
                    }
                }
            }
        }
    }

    public static TkRefexAbstractMember<?> convertRefex(RefexChronicleBI<?> m) throws IOException {
        if (m.getPrimordialVersion() instanceof RefexNidNidNidVersionBI) {
            return new TkRefexUuidUuidUuidMember((RefexNidNidNidVersionBI) m);
        } else if (m.getPrimordialVersion() instanceof RefexNidNidStringVersionBI) {
            return new TkRefexUuidUuidStringMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidNidVersionBI) {
            return new TkRefexUuidUuidMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidFloatVersionBI) {
            return new TkRefexUuidFloatMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidIntVersionBI) {
            return new TkRefexUuidIntMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidLongVersionBI) {
            return new TkRefexUuidLongMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidStringVersionBI) {
            return new TkRefexUuidStringMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidVersionBI) {
            return new TkRefexUuidMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexIntVersionBI) {
            return new TkRefexIntMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexStringVersionBI) {
            return new TkRefexStringMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexLongVersionBI) {
            return new TkRefexLongMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexBooleanVersionBI) {
            return new TkRefexBooleanMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexArrayOfBytearrayVersionBI) {
            return new TkRefexArrayOfByteArrayMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexMemberVersionBI) {
            return new TkRefexMember(m);
        } else {
            throw new UnsupportedOperationException("Cannot handle: " + m);
        }
    }

    public TkConcept(TkConcept another, ComponentTransformerBI transformer) {
        super();
        this.annotationStyleRefex = transformer.transform(another.annotationStyleRefex, another, ComponentFields.ANNOTATION_REFEX);
        this.annotationIndexStyleRefex = transformer.transform(another.annotationIndexStyleRefex, another, ComponentFields.ANNOTATION_INDEX_REFEX);

        if (another.conceptAttributes != null) {
            this.conceptAttributes = another.conceptAttributes.makeTransform(transformer);
        }

        if (another.descriptions != null) {
            this.descriptions = new ArrayList<>(another.descriptions.size());

            for (TkDescription d : another.descriptions) {
                this.descriptions.add(d.makeTransform(transformer));
            }
        }

        if (another.media != null) {
            this.media = new ArrayList<>(another.media.size());

            for (TkMedia d : another.media) {
                this.media.add(d.makeTransform(transformer));
            }
        }

        this.primordialUuid = transformer.transform(another.primordialUuid,
                another, ComponentFields.PRIMORDIAL_UUID);

        if (another.refsetMembers != null) {
            this.refsetMembers = new ArrayList<>(another.refsetMembers.size());

            for (TkRefexAbstractMember<?> d : another.refsetMembers) {
                this.refsetMembers.add((TkRefexAbstractMember<?>) d.makeTransform(transformer));
            }
        }

        if (another.relationships != null) {
            this.relationships = new ArrayList<>(another.relationships.size());

            for (TkRelationship d : another.relationships) {
                this.relationships.add(d.makeTransform(transformer));
            }
        }
    }

    //~--- methods -------------------------------------------------------------
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

        if (TkConcept.class.isAssignableFrom(obj.getClass())) {
            TkConcept another = (TkConcept) obj;

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

    public final void readExternal(DataInput in) throws IOException, ClassNotFoundException {
        int readDataVersion = in.readInt();

        if (readDataVersion > dataVersion) {
            throw new IOException("Unsupported dataVersion: " + readDataVersion);
        }

        if (readDataVersion == 1) {
            conceptAttributes = new TkConceptAttributes(in, readDataVersion);
            primordialUuid = conceptAttributes.getPrimordialComponentUuid();
        } else {
            primordialUuid = new UUID(in.readLong(), in.readLong());

            int attributeCount = in.readByte();

            if (attributeCount == 1) {
                conceptAttributes = new TkConceptAttributes(in, readDataVersion);
            }
        }

        int descCount = in.readInt();

        if (descCount > 0) {
            descriptions = new ArrayList<>(descCount);

            for (int i = 0; i < descCount; i++) {
                descriptions.add(new TkDescription(in, readDataVersion));
            }
        }

        int relCount = in.readInt();

        if (relCount > 0) {
            relationships = new ArrayList<>(relCount);

            for (int i = 0; i < relCount; i++) {
                relationships.add(new TkRelationship(in, readDataVersion));
            }
        }

        int imgCount = in.readInt();

        if (imgCount > 0) {
            media = new ArrayList<>(imgCount);

            for (int i = 0; i < imgCount; i++) {
                media.add(new TkMedia(in, readDataVersion));
            }
        }

        int refsetMemberCount = in.readInt();

        if (refsetMemberCount > 0) {
            refsetMembers = new ArrayList<>(refsetMemberCount);

            for (int i = 0; i < refsetMemberCount; i++) {
                TK_REFEX_TYPE type = TK_REFEX_TYPE.readType(in);

                switch (type) {
                    case CID:
                        refsetMembers.add(new TkRefexUuidMember(in, readDataVersion));

                        break;

                    case CID_CID:
                        refsetMembers.add(new TkRefexUuidUuidMember(in, readDataVersion));

                        break;

                    case MEMBER:
                        refsetMembers.add(new TkRefexMember(in, readDataVersion));

                        break;

                    case CID_CID_CID:
                        refsetMembers.add(new TkRefexUuidUuidUuidMember(in, readDataVersion));

                        break;

                    case CID_CID_STR:
                        refsetMembers.add(new TkRefexUuidUuidStringMember(in, readDataVersion));

                        break;

                    case INT:
                        refsetMembers.add(new TkRefexIntMember(in, readDataVersion));

                        break;

                    case STR:
                        refsetMembers.add(new TkRefexStringMember(in, readDataVersion));

                        break;

                    case CID_INT:
                        refsetMembers.add(new TkRefexUuidIntMember(in, readDataVersion));

                        break;

                    case BOOLEAN:
                        refsetMembers.add(new TkRefexBooleanMember(in, readDataVersion));

                        break;

                    case CID_FLOAT:
                        refsetMembers.add(new TkRefexUuidFloatMember(in, readDataVersion));

                        break;

                    case CID_LONG:
                        refsetMembers.add(new TkRefexUuidLongMember(in, readDataVersion));

                        break;

                    case CID_STR:
                        refsetMembers.add(new TkRefexUuidStringMember(in, readDataVersion));

                        break;

                    case LONG:
                        refsetMembers.add(new TkRefexLongMember(in, readDataVersion));

                        break;

                    case ARRAY_BYTEARRAY:
                        refsetMembers.add(new TkRefexArrayOfByteArrayMember(in, readDataVersion));

                        break;

                    default:
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
     */
    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        buff.append(this.getClass().getSimpleName());
        buff.append(": \n   primordial UUID: ");
        buff.append(TkRevision.informAboutUuid(this.primordialUuid));
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
            for (TkDescription d : this.descriptions) {
                buff.append(PADDING);
                buff.append(d);
                buff.append("\n");
            }
        }

        buff.append("\n   Relationships: \n");

        if (this.relationships == null) {
            buff.append(PADDING + "none\n");
        } else {
            for (TkRelationship r : this.relationships) {
                buff.append(PADDING);
                buff.append(r);
                buff.append("\n");
            }
        }

        buff.append("\n   RefsetMembers: \n");

        if (this.refsetMembers == null) {
            buff.append(PADDING + "none\n");
        } else {
            for (TkRefexAbstractMember<?> r : this.refsetMembers) {
                buff.append(PADDING);
                buff.append(r);
                buff.append("\n");
            }
        }

        buff.append("\n   Media: \n");

        if (this.media == null) {
            buff.append(PADDING + "none");
        } else {
            for (TkMedia m : this.media) {
                buff.append(PADDING);
                buff.append(m);
                buff.append("\n");
            }
        }

        return buff.toString();
    }

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

            for (TkDescription d : descriptions) {
                d.writeExternal(out);
            }
        }

        if (relationships == null) {
            out.writeInt(0);
        } else {
            out.writeInt(relationships.size());

            for (TkRelationship r : relationships) {
                r.writeExternal(out);
            }
        }

        if (media == null) {
            out.writeInt(0);
        } else {
            out.writeInt(media.size());

            for (TkMedia img : media) {
                img.writeExternal(out);
            }
        }

        if (refsetMembers == null) {
            out.writeInt(0);
        } else {
            out.writeInt(refsetMembers.size());

            for (TkRefexAbstractMember<?> r : refsetMembers) {
                r.getType().writeType(out);
                r.writeExternal(out);
            }
        }

        out.writeBoolean(annotationStyleRefex);
        out.writeBoolean(annotationIndexStyleRefex);
    }

    //~--- get methods ---------------------------------------------------------
    public TkConceptAttributes getConceptAttributes() {
        return conceptAttributes;
    }

    public List<TkDescription> getDescriptions() {
        return descriptions;
    }

    public List<TkMedia> getImages() {
        return media;
    }

    public UUID getPrimordialUuid() {
        return primordialUuid;
    }

    public List<TkRefexAbstractMember<?>> getRefsetMembers() {
        return refsetMembers;
    }

    public List<TkRelationship> getRelationships() {
        return relationships;
    }

    public boolean isAnnotationStyleRefex() {
        return annotationStyleRefex;
    }
    public boolean isAnnotationIndexStyleRefex() {
        return annotationIndexStyleRefex;
    }

    //~--- set methods ---------------------------------------------------------
    public void setAnnotationStyleRefex(boolean annotationStyleRefex) {
        this.annotationStyleRefex = annotationStyleRefex;
    }
    public void setAnnotationIndexStyleRefex(boolean annotationIndexStyleRefex) {
        this.annotationIndexStyleRefex = annotationIndexStyleRefex;
    }

    public void setConceptAttributes(TkConceptAttributes conceptAttributes) {
        this.conceptAttributes = conceptAttributes;
    }

    public void setDescriptions(List<TkDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public void setImages(List<TkMedia> images) {
        this.media = images;
    }

    public void setPrimordialUuid(UUID primordialUuid) {
        this.primordialUuid = primordialUuid;
    }

    public void setRefsetMembers(List<TkRefexAbstractMember<?>> refsetMembers) {
        this.refsetMembers = refsetMembers;
    }

    public void setRelationships(List<TkRelationship> relationships) {
        this.relationships = relationships;
    }
}
