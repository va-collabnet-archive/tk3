package org.ihtsdo.fxmodel.concept.component;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ComponentBI;
import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.ext.I_VersionExternally;
import org.ihtsdo.tk.api.id.IdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class FxRevision implements I_VersionExternally {

    private static final long serialVersionUID = 1;
    public static UUID unspecifiedUserUuid = UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c");
    //~--- fields --------------------------------------------------------------
    @XmlAttribute
    public long time = Long.MIN_VALUE;
    @XmlAttribute
    public UUID authorUuid;
    @XmlAttribute
    public UUID pathUuid;
    @XmlAttribute
    public UUID statusUuid;

    //~--- constructors --------------------------------------------------------
    public FxRevision() {
        super();
    }

    public FxRevision(ComponentVersionBI another) throws IOException {
        super();
             this.statusUuid = Ts.get().getComponent(another.getStatusNid()).getPrimUuid();
            this.authorUuid = Ts.get().getComponent(another.getAuthorNid()).getPrimUuid();
            this.pathUuid = Ts.get().getComponent(another.getPathNid()).getPrimUuid();
            assert pathUuid != null : another;
            assert authorUuid != null : another;
            assert statusUuid != null : another;
            this.time = another.getTime();
    }

    public FxRevision(IdBI id) throws IOException {
        super();
            this.authorUuid = Ts.get().getComponent(id.getAuthorNid()).getPrimUuid();
            this.pathUuid = Ts.get().getComponent(id.getPathNid()).getPrimUuid();
            this.statusUuid = Ts.get().getComponent(id.getStatusNid()).getPrimUuid();
            this.time = id.getTime();
    }

    public FxRevision(ComponentVersionBI another, Map<UUID, UUID> conversionMap, long offset, boolean mapAll)
            throws IOException {
        super();

        if (mapAll) {
            this.statusUuid = conversionMap.get(Ts.get().getComponent(another.getStatusNid()).getPrimUuid());
            this.authorUuid = conversionMap.get(Ts.get().getComponent(another.getAuthorNid()).getPrimUuid());
            this.pathUuid = conversionMap.get(Ts.get().getComponent(another.getPathNid()).getPrimUuid());
        } else {
            this.statusUuid = Ts.get().getComponent(another.getStatusNid()).getPrimUuid();
            this.authorUuid = Ts.get().getComponent(another.getAuthorNid()).getPrimUuid();
            this.pathUuid = Ts.get().getComponent(another.getPathNid()).getPrimUuid();
        }

        assert pathUuid != null : another;
        assert authorUuid != null : another;
        assert statusUuid != null : another;
        this.time = another.getTime() + offset;
    }

    public FxRevision(FxRevision another, Map<UUID, UUID> conversionMap, long offset, boolean mapAll) {
        super();

        if (mapAll) {
            this.statusUuid = conversionMap.get(another.statusUuid);
            this.authorUuid = conversionMap.get(another.authorUuid);
            this.pathUuid = conversionMap.get(another.pathUuid);
        } else {
            this.statusUuid = another.statusUuid;
            this.authorUuid = another.authorUuid;
            this.pathUuid = another.pathUuid;
        }

        assert pathUuid != null : another;
        assert authorUuid != null : another;
        assert statusUuid != null : another;
        this.time = another.time + offset;
    }

    //~--- methods -------------------------------------------------------------
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

        if (FxRevision.class.isAssignableFrom(obj.getClass())) {
            FxRevision another = (FxRevision) obj;

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
        return Arrays.hashCode(new int[]{statusUuid.hashCode(), pathUuid.hashCode(), (int) time,
                    (int) (time >>> 32)});
    }

    public static CharSequence informAboutUuid(UUID uuid) {
        if (uuid == null) {
            return "null";
        }
        if (Ts.get() == null) {
            return uuid.toString();
        }

        StringBuilder sb = new StringBuilder();

        if (Ts.get().hasUuid(uuid)) {
            try {
                int nid = Ts.get().getNidForUuids(uuid);
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
                Logger.getLogger(FxRevision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        sb.append(uuid.toString());

        return sb;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        buff.append(" s:");
        buff.append(informAboutUuid(this.statusUuid));
        buff.append(" a:");
        buff.append(informAboutUuid(this.authorUuid));
        buff.append(" p:");
        buff.append(informAboutUuid(this.pathUuid));
        buff.append(" t: ");
        buff.append(new Date(this.time)).append(" ").append(this.time);

        return buff.toString();
    }

    //~--- get methods ---------------------------------------------------------
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

    /*
     * (non-Javadoc)
     *
     * @see org.ihtsdo.etypes.I_VersionExternal#getTime()
     */
    @Override
    public long getTime() {
        return time;
    }

    //~--- set methods ---------------------------------------------------------
    public void setAuthorUuid(UUID authorUuid) {
        this.authorUuid = authorUuid;
    }

    public void setPathUuid(UUID pathUuid) {
        this.pathUuid = pathUuid;
    }

    public void setStatusUuid(UUID statusUuid) {
        this.statusUuid = statusUuid;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
