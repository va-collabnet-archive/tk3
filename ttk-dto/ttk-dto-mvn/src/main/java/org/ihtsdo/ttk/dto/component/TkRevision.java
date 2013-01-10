package org.ihtsdo.ttk.dto.component;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.ComponentBI;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.ExternalStampBI;
import org.ihtsdo.ttk.api.id.IdBI;
import org.ihtsdo.ttk.dto.component.transformer.ComponentFields;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TkRevision implements ExternalStampBI {
    private static final long serialVersionUID      = 1;
    public static UUID        unspecifiedUserUuid   = UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c");
    public static UUID        unspecifiedModuleUuid = UUID.fromString("40d1c869-b509-32f8-b735-836eac577a67");
    @XmlAttribute
    public long               time                  = Long.MIN_VALUE;
    @XmlAttribute
    public UUID               authorUuid;
    @XmlAttribute
    public UUID               pathUuid;
    @XmlAttribute
    public UUID               statusUuid;
    @XmlAttribute
    public UUID               moduleUuid;

    public TkRevision() {
        super();
    }

    public TkRevision(ComponentVersionBI another) throws IOException {
        super();
        this.statusUuid = Ts.get().getComponent(another.getStatusNid()).getPrimUuid();
        this.authorUuid = Ts.get().getComponent(another.getAuthorNid()).getPrimUuid();
        this.pathUuid   = Ts.get().getComponent(another.getPathNid()).getPrimUuid();
        this.moduleUuid = Ts.get().getComponent(another.getModuleNid()).getPrimUuid();
        assert pathUuid != null : another;
        assert authorUuid != null : another;
        assert statusUuid != null : another;
        assert moduleUuid != null : another;
        this.time = another.getTime();
    }

    public TkRevision(IdBI id) throws IOException {
        super();
        this.authorUuid = Ts.get().getComponent(id.getAuthorNid()).getPrimUuid();
        this.pathUuid   = Ts.get().getComponent(id.getPathNid()).getPrimUuid();
        this.statusUuid = Ts.get().getComponent(id.getStatusNid()).getPrimUuid();
        this.moduleUuid = Ts.get().getComponent(id.getModuleNid()).getPrimUuid();
        this.time       = id.getTime();
        assert pathUuid != null : id;
        assert authorUuid != null : id;
        assert statusUuid != null : id;
        assert moduleUuid != null : id;
    }

    public TkRevision(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
        super();
        readExternal(in, dataVersion);
        assert pathUuid != null : this;
        assert authorUuid != null : this;
        assert statusUuid != null : this;
        assert moduleUuid != null : this;
    }

    public TkRevision(TkRevision another, ComponentTransformerBI transformer) {
        super();
        this.statusUuid = transformer.transform(another.statusUuid, another, ComponentFields.STATUS_UUID);
        this.authorUuid = transformer.transform(another.authorUuid, another, ComponentFields.AUTHOR_UUID);
        this.pathUuid   = transformer.transform(another.pathUuid, another, ComponentFields.PATH_UUID);
        this.moduleUuid = transformer.transform(another.moduleUuid, another, ComponentFields.MODULE_UUID);
        assert pathUuid != null : another;
        assert authorUuid != null : another;
        assert statusUuid != null : another;
        assert moduleUuid != null : another;
        this.time = transformer.transform(another.time, another, ComponentFields.TIME);
    }

    /**
     * Compares this object to the specified object. The result is <tt>true</tt> if and only if the argument
     * is not <tt>null</tt>, is a <tt>EVersion</tt> object, and contains the same values, field by field, as
     * this <tt>EVersion</tt>.
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

        if (TkRevision.class.isAssignableFrom(obj.getClass())) {
            TkRevision another = (TkRevision) obj;

            // =========================================================
            // Compare properties of 'this' class to the 'another' class
            // =========================================================
            if (!this.statusUuid.equals(another.statusUuid)) {
                return false;
            }

            if ((this.authorUuid != null) && (another.authorUuid != null)) {
                if (!this.authorUuid.equals(another.authorUuid)) {
                    return false;
                }
            } else if (!((this.authorUuid == null) && (another.authorUuid == null))) {
                return false;
            }

            if (!this.pathUuid.equals(another.pathUuid)) {
                return false;
            }

            if ((this.moduleUuid != null) && (another.moduleUuid != null)) {
                if (!this.moduleUuid.equals(another.moduleUuid)) {
                    return false;
                }
            } else if (!((this.moduleUuid == null) && (another.moduleUuid == null))) {
                return false;
            }

            if (this.time != another.time) {
                return false;
            }

            // Objects are equal! (Don't climb any higher in the hierarchy)
            return true;
        }

        return false;
    }

    /**
     * Returns a hash code for this
     * <code>EVersion</code>.
     *
     * @return a hash code value for this <tt>EVersion</tt>.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(new int[] { statusUuid.hashCode(), pathUuid.hashCode(), (int) time,
                                           (int) (time >>> 32) });
    }

    public static CharSequence informAboutUuid(UUID uuid) {
        if (Ts.get() == null) {
            return uuid.toString();
        }

        StringBuilder sb = new StringBuilder();

        if (Ts.get().hasUuid(uuid)) {
            try {
                int nid  = Ts.get().getNidForUuids(uuid);
                int cNid = Ts.get().getConceptNidForNid(nid);

                if (cNid == nid) {
                    ConceptChronicleBI cc = Ts.get().getConcept(cNid);

                    sb.append("'");
                    sb.append(cc.toUserString());
                    sb.append("' ");
                    sb.append(cNid);
                    sb.append(" ");
                } else {
                    ComponentBI component = Ts.get().getComponent(nid);

                    sb.append("comp: '");

                    if (component != null) {
                        sb.append(component.toUserString());
                    } else {
                        sb.append("null");
                    }

                    sb.append("' ");
                    sb.append(nid);
                    sb.append(" ");
                }
            } catch (IOException ex) {
                Logger.getLogger(TkRevision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        sb.append(uuid.toString());

        return sb;
    }

    public abstract TkRevision makeTransform(ComponentTransformerBI transformer);

    public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
        pathUuid   = new UUID(in.readLong(), in.readLong());
        statusUuid = new UUID(in.readLong(), in.readLong());

        if (dataVersion >= 3) {
            authorUuid = new UUID(in.readLong(), in.readLong());
        } else {
            authorUuid = unspecifiedUserUuid;
        }

        if (dataVersion >= 8) {
            moduleUuid = new UUID(in.readLong(), in.readLong());
        } else {
            moduleUuid = unspecifiedModuleUuid;
        }

        time = in.readLong();

        if (time == Long.MAX_VALUE) {
            time = Long.MIN_VALUE;
        }
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        buff.append(" s:");
        buff.append(informAboutUuid(this.statusUuid));
        buff.append(" t: ");
        buff.append(new Date(this.time)).append(" ").append(this.time);
        buff.append(" a:");
        buff.append(informAboutUuid(this.authorUuid));
        buff.append(" m:");
        buff.append(informAboutUuid(this.moduleUuid));
        buff.append(" p:");
        buff.append(informAboutUuid(this.pathUuid));

        return buff.toString();
    }

    public void writeExternal(DataOutput out) throws IOException {
        if (time == Long.MAX_VALUE) {
            time = Long.MIN_VALUE;
        }

        assert pathUuid != null : this;
        assert authorUuid != null : this;
        assert statusUuid != null : this;
        assert moduleUuid != null : this;
        out.writeLong(pathUuid.getMostSignificantBits());
        out.writeLong(pathUuid.getLeastSignificantBits());
        out.writeLong(statusUuid.getMostSignificantBits());
        out.writeLong(statusUuid.getLeastSignificantBits());

        if (authorUuid == null) {
            authorUuid = unspecifiedUserUuid;
        }

        out.writeLong(authorUuid.getMostSignificantBits());
        out.writeLong(authorUuid.getLeastSignificantBits());

        if (moduleUuid == null) {
            moduleUuid = unspecifiedModuleUuid;
        }

        out.writeLong(moduleUuid.getMostSignificantBits());
        out.writeLong(moduleUuid.getLeastSignificantBits());
        out.writeLong(time);
    }

    @Override
    public UUID getAuthorUuid() {
        return authorUuid;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.ihtsdo.etypes.I_VersionExternal#getPathUuid()
     */
    @Override
    public UUID getPathUuid() {
        return pathUuid;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.ihtsdo.etypes.I_VersionExternal#getStatusUuid()
     */
    @Override
    public UUID getStatusUuid() {
        return statusUuid;
    }

    public UUID getModuleUuid() {
        return moduleUuid;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.ihtsdo.etypes.I_VersionExternal#getTime()
     */
    @Override
    public long getTime() {
        return time;
    }

    public void setAuthorUuid(UUID authorUuid) {
        this.authorUuid = authorUuid;
    }

    public void setPathUuid(UUID pathUuid) {
        this.pathUuid = pathUuid;
    }

    public void setStatusUuid(UUID statusUuid) {
        this.statusUuid = statusUuid;
    }

    public void setModuleUuid(UUID moduleUuid) {
        this.moduleUuid = moduleUuid;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
