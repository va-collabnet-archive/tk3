package org.ihtsdo.fxmodel.concept;

//~--- non-JDK imports --------------------------------------------------------
import java.io.IOException;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.*;
import org.ihtsdo.fxmodel.concept.component.FxRevision;
import org.ihtsdo.fxmodel.concept.component.attribute.FxConceptAttributes;
import org.ihtsdo.fxmodel.concept.component.description.FxDescription;
import org.ihtsdo.fxmodel.concept.component.media.FxMedia;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexAbstractMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_boolean.FxRefexBooleanMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_int.FxRefexIntMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_long.FxRefexLongMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_member.FxRefexMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_string.FxRefexStringMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid.FxRefexUuidMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_float.FxRefexUuidFloatMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_int.FxRefexUuidIntMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_long.FxRefexUuidLongMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_string.FxRefexUuidStringMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_uuid.FxRefexUuidUuidMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_uuid_string.FxRefexUuidUuidStringMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_uuid_uuid.FxRefexUuidUuidUuidMember;
import org.ihtsdo.fxmodel.concept.component.relationship.FxRelationship;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.media.MediaChronicleBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.tk.api.refex.type_int.RefexIntVersionBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;
import org.ihtsdo.tk.api.refex.type_member.RefexMemberVersionBI;
import org.ihtsdo.tk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_int.RefexNidIntVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_long.RefexNidLongVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid.RefexNidNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_string.RefexNidNidStringVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_string.RefexNidStringVersionBI;
import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="concept")
public class FxConcept {

    public static final String PADDING = "     ";
    public static final int dataVersion = 7;
    public static final long serialVersionUID = 1;
    //~--- fields --------------------------------------------------------------
    @XmlAttribute
    protected boolean annotationStyleRefex = false;
    protected FxConceptAttributes conceptAttributes;

    @XmlElementWrapper(name="description-collection")
    @XmlElement(name="description")
    protected ObservableList<FxDescription> descriptions;
    @XmlElementWrapper(name="media-collection")
    @XmlElement(name="media")
     protected ObservableList<FxMedia> media;
    @XmlAttribute
    protected UUID primordialUuid;
    @XmlElementWrapper(name="refex-member-collection")
    @XmlElement(name="refex")
    protected ObservableList<FxRefexAbstractMember<?>> refsetMembers;
    @XmlElementWrapper(name="relationship-collection")
    @XmlElement(name="relationship")
    protected ObservableList<FxRelationship> relationships;

    //~--- constructors --------------------------------------------------------
    public FxConcept() {
        super();
    }

    public FxConcept(ConceptChronicleBI c) throws IOException {
        conceptAttributes = new FxConceptAttributes(c.getConAttrs());
        primordialUuid = conceptAttributes.primordialUuid;
        relationships = FXCollections.observableArrayList(new ArrayList<FxRelationship>(c.getRelsOutgoing().size()));

        for (RelationshipChronicleBI rel : c.getRelsOutgoing()) {
            relationships.add(new FxRelationship(rel));
        }

        descriptions = FXCollections.observableArrayList(new ArrayList<FxDescription>(c.getDescs().size()));

        for (DescriptionChronicleBI desc : c.getDescs()) {
            descriptions.add(new FxDescription(this, desc));
        }

        media = FXCollections.observableArrayList(new ArrayList<FxMedia>(c.getMedia().size()));

        for (MediaChronicleBI mediaChronicle : c.getMedia()) {
            FxMedia tkMedia = new FxMedia(mediaChronicle);
            media.add(tkMedia);
        }

        if (!c.isAnnotationStyleRefex()) {
            Collection<? extends RefexChronicleBI> members = c.getRefsetMembers();

            if (members != null) {
                refsetMembers = FXCollections.observableArrayList(new ArrayList<FxRefexAbstractMember<?>>(members.size()));

                for (RefexChronicleBI m : members) {
                    FxRefexAbstractMember<?> member = convertRefex(m);

                    if (member != null) {
                        refsetMembers.add(member);
                    } else {
                        throw new IOException("Could not convert refset member: " + m + "\nfrom refset: " + c);
                    }
                }
            }
        }
    }

    public static FxRefexAbstractMember<?> convertRefex(RefexChronicleBI<?> m) throws IOException {
        if (m.getPrimordialVersion() instanceof RefexNidNidNidVersionBI) {
            return new FxRefexUuidUuidUuidMember((RefexNidNidNidVersionBI) m);
        } else if (m.getPrimordialVersion() instanceof RefexNidNidStringVersionBI) {
            return new FxRefexUuidUuidStringMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidNidVersionBI) {
            return new FxRefexUuidUuidMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidFloatVersionBI) {
            return new FxRefexUuidFloatMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidIntVersionBI) {
            return new FxRefexUuidIntMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidLongVersionBI) {
            return new FxRefexUuidLongMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidStringVersionBI) {
            return new FxRefexUuidStringMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexNidVersionBI) {
            return new FxRefexUuidMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexIntVersionBI) {
            return new FxRefexIntMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexStringVersionBI) {
            return new FxRefexStringMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexLongVersionBI) {
            return new FxRefexLongMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexBooleanVersionBI) {
            return new FxRefexBooleanMember(m);
        } else if (m.getPrimordialVersion() instanceof RefexMemberVersionBI) {
            return new FxRefexMember(m);
        } else {
            throw new UnsupportedOperationException("Cannot handle: " + m);
        }
    }

    //~--- methods -------------------------------------------------------------
    /**
     * Compares this object to the specified object. The result is <tt>true</tt> if and only if the argument
     * is not <tt>null</tt>, is a <tt>EConcept</tt> object, and contains the same values, field by field, as
     * this <tt>EConcept</tt>.
     *
     * @param obj the object to compare with.
     * @return
     * <code>true</code> if the objects are the same;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (FxConcept.class.isAssignableFrom(obj.getClass())) {
            FxConcept another = (FxConcept) obj;

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
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        buff.append(this.getClass().getSimpleName());
        buff.append(": \n   primordial UUID: ");
        buff.append(FxRevision.informAboutUuid(this.primordialUuid));
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
            for (FxDescription d : this.descriptions) {
                buff.append(PADDING);
                buff.append(d);
                buff.append("\n");
            }
        }

        buff.append("\n   Relationships: \n");

        if (this.relationships == null) {
            buff.append(PADDING + "none\n");
        } else {
            for (FxRelationship r : this.relationships) {
                buff.append(PADDING);
                buff.append(r);
                buff.append("\n");
            }
        }

        buff.append("\n   RefsetMembers: \n");

        if (this.refsetMembers == null) {
            buff.append(PADDING + "none\n");
        } else {
            for (FxRefexAbstractMember<?> r : this.refsetMembers) {
                buff.append(PADDING);
                buff.append(r);
                buff.append("\n");
            }
        }

        buff.append("\n   Media: \n");

        if (this.media == null) {
            buff.append(PADDING + "none");
        } else {
            for (FxMedia m : this.media) {
                buff.append(PADDING);
                buff.append(m);
                buff.append("\n");
            }
        }

        return buff.toString();
    }

    //~--- get methods ---------------------------------------------------------
    public FxConceptAttributes getConceptAttributes() {
        return conceptAttributes;
    }

    public ObservableList<FxDescription> getDescriptions() {
        return descriptions;
    }

    public ObservableList<FxMedia> getImages() {
        return media;
    }

    public UUID getPrimordialUuid() {
        return primordialUuid;
    }

    public ObservableList<FxRefexAbstractMember<?>> getRefsetMembers() {
        return refsetMembers;
    }

    public ObservableList<FxRelationship> getRelationships() {
        return relationships;
    }

    public boolean isAnnotationStyleRefex() {
        return annotationStyleRefex;
    }

    //~--- set methods ---------------------------------------------------------
    public void setAnnotationStyleRefex(boolean annotationStyleRefex) {
        this.annotationStyleRefex = annotationStyleRefex;
    }

    public void setConceptAttributes(FxConceptAttributes conceptAttributes) {
        this.conceptAttributes = conceptAttributes;
    }

    public void setDescriptions(List<FxDescription> descriptions) {
        this.descriptions = FXCollections.observableArrayList(descriptions);
    }

    public void setImages(List<FxMedia> images) {
        this.media = FXCollections.observableArrayList(images);
    }

    public void setPrimordialUuid(UUID primordialUuid) {
        this.primordialUuid = primordialUuid;
    }

    public void setRefsetMembers(List<FxRefexAbstractMember<?>> refsetMembers) {
        this.refsetMembers = FXCollections.observableArrayList(refsetMembers);
    }

    public void setRelationships(List<FxRelationship> relationships) {
        this.relationships = FXCollections.observableArrayList(relationships);
    }
}
