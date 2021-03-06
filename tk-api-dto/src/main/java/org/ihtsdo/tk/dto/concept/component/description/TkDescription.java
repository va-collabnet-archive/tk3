package org.ihtsdo.tk.dto.concept.component.description;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.ext.I_DescribeExternally;
import org.ihtsdo.tk.dto.concept.UtfHelper;
import org.ihtsdo.tk.dto.concept.component.TkComponent;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "description")
public class TkDescription extends TkComponent<TkDescriptionRevision> implements I_DescribeExternally {
    public static final long serialVersionUID = 1;
    @XmlAttribute
    public UUID              conceptUuid;
    @XmlAttribute
    public boolean           initialCaseSignificant;
    @XmlAttribute
    public String            lang;
    @XmlAttribute
    public String            text;
    @XmlAttribute
    public UUID              typeUuid;

    public TkDescription() {
        super();
    }

    public TkDescription(DescriptionChronicleBI desc) throws IOException {
        super(desc.getPrimordialVersion());

        Collection<? extends DescriptionVersionBI> versions  = desc.getVersions();
        Iterator<? extends DescriptionVersionBI>   itr       = versions.iterator();
        TerminologyStoreDI                         ts        = Ts.get();
        int                                        partCount = versions.size();
        DescriptionVersionBI                       part      = itr.next();

        conceptUuid            = ts.getUuidPrimordialForNid(desc.getConceptNid());
        initialCaseSignificant = part.isInitialCaseSignificant();
        lang                   = part.getLang();
        text                   = part.getText();
        typeUuid               = ts.getUuidPrimordialForNid(part.getTypeNid());
        pathUuid               = ts.getUuidPrimordialForNid(part.getPathNid());
        statusUuid             = ts.getUuidPrimordialForNid(part.getStatusNid());
        time                   = part.getTime();

        if (partCount > 1) {
            revisions = new ArrayList<>(partCount - 1);

            while (itr.hasNext()) {
                DescriptionVersionBI dv = itr.next();

                revisions.add(new TkDescriptionRevision(dv));
            }
        }
    }

    public TkDescription(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
        super();
        readExternal(in, dataVersion);
    }

    public TkDescription(TkDescription another, ComponentTransformerBI transformer) {
        super(another, transformer);
        this.initialCaseSignificant = transformer.transform(another.initialCaseSignificant, another,
                ComponentFields.DESCRIPTION_INITIAL_CASE_SIGNIFICANT);
        this.lang        = transformer.transform(another.lang, another, ComponentFields.DESCRIPTION_LANGUAGE);
        this.text        = transformer.transform(another.text, another, ComponentFields.DESCRIPTION_TEXT);
        this.typeUuid    = transformer.transform(another.typeUuid, another, ComponentFields.DESCRIPTION_TYPE_UUID);
        this.conceptUuid = transformer.transform(another.conceptUuid, another,
                ComponentFields.DESCRIPTION_ENCLOSING_CONCEPT_UUID);
    }

    /**
     * Compares this object to the specified object. The result is <tt>true</tt>
     * if and only if the argument is not <tt>null</tt>, is a
     * <tt>EDescription</tt> object, and contains the same values, field by field,
     * as this <tt>EDescription</tt>.
     *
     * @param obj the object to compare with.
     * @return <code>true</code> if the objects are the same;
     *         <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (TkDescription.class.isAssignableFrom(obj.getClass())) {
            TkDescription another = (TkDescription) obj;

            // =========================================================
            // Compare properties of 'this' class to the 'another' class
            // =========================================================
            // Compare conceptUuid
            if (!this.conceptUuid.equals(another.conceptUuid)) {
                return false;
            }

            // Compare initialCaseSignificant
            if (this.initialCaseSignificant != another.initialCaseSignificant) {
                return false;
            }

            // Compare lang
            if (!this.lang.equals(another.lang)) {
                return false;
            }

            // Compare text
            if (!this.text.equals(another.text)) {
                return false;
            }

            // Compare typeUuid
            if (!this.typeUuid.equals(another.typeUuid)) {
                return false;
            }

            // Compare their parents
            return super.equals(obj);
        }

        return false;
    }

    @Override
    public TkDescription makeTransform(ComponentTransformerBI transformer) {
        return new TkDescription(this, transformer);
    }

    @Override
    public final void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
        super.readExternal(in, dataVersion);
        conceptUuid            = new UUID(in.readLong(), in.readLong());
        initialCaseSignificant = in.readBoolean();
        lang                   = in.readUTF();
        text                   = UtfHelper.readUtfV6(in, dataVersion);
        typeUuid               = new UUID(in.readLong(), in.readLong());

        int versionLength = in.readInt();

        if (versionLength > 0) {
            revisions = new ArrayList<>(versionLength);

            for (int i = 0; i < versionLength; i++) {
                revisions.add(new TkDescriptionRevision(in, dataVersion));
            }
        }
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        buff.append(this.getClass().getSimpleName()).append(": ");
        buff.append("'").append(this.text).append("'");
        buff.append(" concept:");
        buff.append(informAboutUuid(this.conceptUuid));
        buff.append(" ics:");
        buff.append(this.initialCaseSignificant);
        buff.append(" lang:");
        buff.append("'").append(this.lang).append("'");
        buff.append(" type:");
        buff.append(informAboutUuid(this.typeUuid));
        buff.append(" ");
        buff.append(super.toString());

        return buff.toString();
    }

    @Override
    public void writeExternal(DataOutput out) throws IOException {
        super.writeExternal(out);
        out.writeLong(conceptUuid.getMostSignificantBits());
        out.writeLong(conceptUuid.getLeastSignificantBits());
        out.writeBoolean(initialCaseSignificant);
        out.writeUTF(lang);
        UtfHelper.writeUtf(out, text);
        out.writeLong(typeUuid.getMostSignificantBits());
        out.writeLong(typeUuid.getLeastSignificantBits());

        if (revisions == null) {
            out.writeInt(0);
        } else {
            out.writeInt(revisions.size());

            for (TkDescriptionRevision edv : revisions) {
                edv.writeExternal(out);
            }
        }
    }

    public UUID getConceptUuid() {
        return conceptUuid;
    }

    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public List<TkDescriptionRevision> getRevisionList() {
        return revisions;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public UUID getTypeUuid() {
        return typeUuid;
    }

    @Override
    public boolean isInitialCaseSignificant() {
        return initialCaseSignificant;
    }

    public void setConceptUuid(UUID conceptUuid) {
        this.conceptUuid = conceptUuid;
    }

    public void setInitialCaseSignificant(boolean initialCaseSignificant) {
        this.initialCaseSignificant = initialCaseSignificant;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTypeUuid(UUID typeUuid) {
        this.typeUuid = typeUuid;
    }
}
