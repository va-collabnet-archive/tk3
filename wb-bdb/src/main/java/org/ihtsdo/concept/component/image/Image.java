package org.ihtsdo.concept.component.image;

//~--- non-JDK imports --------------------------------------------------------
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.concept.Concept;
import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.RevisionSet;
import org.ihtsdo.concept.component.attributes.ConceptAttributes;
import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.db.bdb.computer.version.VersionComputer;
import org.ihtsdo.tk.api.ContradictionManagerBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidSetBI;
import org.ihtsdo.tk.api.PositionSetBI;
import org.ihtsdo.tk.api.Precedence;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.media.MediaAnalogBI;
import org.ihtsdo.tk.dto.concept.component.media.TkMedia;
import org.ihtsdo.tk.dto.concept.component.media.TkMediaRevision;
import org.ihtsdo.tk.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.temp.I_AmTypedPart;
import org.ihtsdo.tk.api.blueprint.InvalidCAB;
import org.ihtsdo.tk.api.blueprint.MediaCAB;

public class Image extends ConceptComponent<ImageRevision, Image>
        implements MediaAnalogBI<ImageRevision> {

    private static VersionComputer<Image.Version> computer = new VersionComputer<Image.Version>();
    //~--- fields --------------------------------------------------------------
    private String format;
    private byte[] image;
    private String textDescription;
    private int typeNid;
    List<Version> versions;

    //~--- constructors --------------------------------------------------------
    public Image() {
        super();
    }

    public Image(Concept enclosingConcept, TupleInput input) throws IOException {
        super(enclosingConcept.getNid(), input);
    }

    public Image(TkMedia eMedia, Concept enclosingConcept) throws IOException {
        super(eMedia, enclosingConcept.getNid());
        image = eMedia.getDataBytes();
        format = eMedia.getFormat();
        textDescription = eMedia.getTextDescription();
        typeNid = Bdb.uuidToNid(eMedia.getTypeUuid());
        primordialSapNid = Bdb.getSapNid(eMedia);

        if (eMedia.getRevisionList() != null) {
            revisions = new RevisionSet<ImageRevision, Image>(primordialSapNid);

            for (TkMediaRevision eiv : eMedia.getRevisionList()) {
                revisions.add(new ImageRevision(eiv, this));
            }
        }
    }

    //~--- methods -------------------------------------------------------------
    @Override
    protected void addComponentNids(Set<Integer> allNids) {
        allNids.add(typeNid);
    }

    @Override
    public void clearVersions() {
        versions = null;
        clearAnnotationVersions();
    }


    // TODO Verify this is a correct implementation
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (Image.class.isAssignableFrom(obj.getClass())) {
            Image another = (Image) obj;

            if (this.nid == another.nid) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean fieldsEqual(ConceptComponent<ImageRevision, Image> obj) {
        if (ConceptAttributes.class.isAssignableFrom(obj.getClass())) {
            Image another = (Image) obj;

            if (!this.format.equals(another.format)) {
                return false;
            }

            if (!Arrays.equals(this.image, another.image)) {
                return false;
            }

            if (this.typeNid != another.typeNid) {
                return false;
            }

            return conceptComponentFieldsEqual(another);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Hashcode.compute(new int[]{this.getNid()});
    }

    @Override
    public ImageRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
        ImageRevision newR;

        newR = new ImageRevision(this, statusNid, authorNid, pathNid, time, this);
        addRevision(newR);

        return newR;
    }

    @Override
    public void readFromBdb(TupleInput input) {

        // nid, list size, and conceptNid are read already by the binder...
        this.format = input.readString();

        int imageBytes = input.readInt();

        image = new byte[imageBytes];
        input.read(image, 0, imageBytes);
        textDescription = input.readString();
        typeNid = input.readInt();

        int additionalVersionCount = input.readShort();

        for (int i = 0; i < additionalVersionCount; i++) {
            ImageRevision ir = new ImageRevision(input, this);

            if (ir.getTime() != Long.MIN_VALUE) {
                revisions.add(ir);
            }
        }
    }

    @Override
    public boolean readyToWriteComponent() {
        assert textDescription != null : assertionString();
        assert format != null : assertionString();
        assert typeNid != Integer.MAX_VALUE : assertionString();
        assert image != null : assertionString();

        return true;
    }

    /*
     *  (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();

        buf.append(this.getClass().getSimpleName()).append(":{");
        buf.append("format:'").append(this.format).append("'");
        buf.append(" image:").append(this.image);
        buf.append(" textDescription:'").append(this.textDescription).append("'");
        buf.append(" typeNid:");
        ConceptComponent.addNidToBuffer(buf, typeNid);
        buf.append(" ");
        buf.append(super.toString());

        return buf.toString();
    }

    @Override
    public String toUserString() {
        StringBuffer buf = new StringBuffer();

        ConceptComponent.addTextToBuffer(buf, typeNid);
        buf.append("; ");
        buf.append(format);
        buf.append(": ");
        buf.append(textDescription);

        return buf.toString();
    }

    /**
     * Test method to check to see if two objects are equal in all respects.
     * @param another
     * @return either a zero length String, or a String containing a description of the
     * validation failures.
     * @throws IOException
     */
    public String validate(Image another) throws IOException {
        assert another != null;

        StringBuilder buf = new StringBuilder();

        if (!this.format.equals(another.format)) {
            buf.append("\tImage.format not equal: \n\t\tthis.format = ").append(this.format).append(
                    "\n\t\tanother.format = ").append(another.format).append("\n");
        }

        if (!Arrays.equals(this.image, another.image)) {
            buf.append("\tImage.image not equal: \n" + "\t\tthis.image = ").append(this.image).append(
                    "\n\t\tanother.image = ").append(another.image).append("\n");
        }

        if (this.typeNid != another.typeNid) {
            buf.append("\tImage.typeNid not equal: \n\t\tthis.typeNid = ").append(this.typeNid).append(
                    "\n\t\tanother.typeNid = ").append(another.typeNid).append("\n");
        }

        // Compare the parents
        buf.append(super.validate(another));

        return buf.toString();
    }

    @Override
    public void writeToBdb(TupleOutput output, int maxReadOnlyStatusAtPositionNid) {
        List<ImageRevision> partsToWrite = new ArrayList<ImageRevision>();

        if (revisions != null) {
            for (ImageRevision p : revisions) {
                if ((p.getStatusAtPositionNid() > maxReadOnlyStatusAtPositionNid)
                        && (p.getTime() != Long.MIN_VALUE)) {
                    partsToWrite.add(p);
                }
            }
        }

        // Start writing
        // conceptNid is the enclosing concept, does not need to be written.
        output.writeString(format);
        output.writeInt(image.length);
        output.write(image);
        output.writeString(textDescription);
        output.writeInt(typeNid);
        output.writeShort(partsToWrite.size());

        for (ImageRevision p : partsToWrite) {
            p.writePartToBdb(output);
        }
    }

    //~--- get methods ---------------------------------------------------------

    /*
     * (non-Javadoc)
     *
     * @see org.dwfa.vodb.types.I_ImageVersioned#getConceptNid()
     */
    @Override
    public int getConceptNid() {
        return enclosingConceptNid;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dwfa.vodb.types.I_ImageVersioned#getFormat()
     */
    @Override
    public MediaCAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB {
        MediaCAB mediaBp = new MediaCAB(getConceptNid(),
                getTypeNid(),
                getFormat(),
                getTextDescription(),
                getMedia(),
                getVersion(vc),
                vc);
        return mediaBp;
    }

    @Override
    public String getFormat() {
        return format;
    }



    @Override
    public byte[] getMedia() {
        return image;
    }

    @Override
    public Image getPrimordialVersion() {
        return Image.this;
    }

    @Override
    public String getTextDescription() {
        return textDescription;
    }

    @Override
    public int getTypeNid() {
        return typeNid;
    }

    @Override
    public IntArrayList getVariableVersionNids() {
        IntArrayList nidList = new IntArrayList(3);

        nidList.add(typeNid);

        return nidList;
    }

    @Override
    public Image.Version getVersion(ViewCoordinate c) throws ContradictionException {
        List<Image.Version> vForC = getVersions(c);

        if (vForC.isEmpty()) {
            return null;
        }

        if (vForC.size() > 1) {
            vForC = c.getContradictionManager().resolveVersions(vForC);
        }

        if (vForC.size() > 1) {
            throw new ContradictionException(vForC.toString());
        }

        return vForC.get(0);
    }

    @Override
    public List<Version> getVersions() {
        if (versions == null) {
            int count = 1;

            if (revisions != null) {
                count = count + revisions.size();
            }

            ArrayList<Version> list = new ArrayList<Version>(count);

            if (getTime() != Long.MIN_VALUE) {
                list.add(new Version(this));
            }

            if (revisions != null) {
                for (ImageRevision ir : revisions) {
                    if (ir.getTime() != Long.MIN_VALUE) {
                        list.add(new Version(ir));
                    }
                }
            }

            versions = list;
        }

        return versions;
    }

    @Override
    public List<Image.Version> getVersions(ViewCoordinate c) {
        List<Version> returnTuples = new ArrayList<Version>(2);

        computer.addSpecifiedVersions(c.getAllowedStatusNids(), (NidSetBI) null, c.getPositionSet(),
                returnTuples, getVersions(), c.getPrecedence(),
                c.getContradictionManager());

        return returnTuples;
    }

    public Collection<Image.Version> getVersions(NidSetBI allowedStatus, NidSetBI allowedTypes,
            PositionSetBI viewPositions, Precedence precedence, ContradictionManagerBI contradictionMgr) {
        List<Version> returnTuples = new ArrayList<Version>(2);

        computer.addSpecifiedVersions(allowedStatus, allowedTypes, viewPositions, returnTuples, getVersions(),
                precedence, contradictionMgr);

        return returnTuples;
    }

    //~--- set methods ---------------------------------------------------------
    public void setFormat(String format) {
        this.format = format;
        modified();
    }

    public void setImage(byte[] image) {
        this.image = image;
        modified();
    }

    @Override
    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
        modified();
    }

    @Override
    public void setTypeNid(int typeNid) {
        this.typeNid = typeNid;
        modified();
    }

    //~--- inner classes -------------------------------------------------------
    public class Version extends ConceptComponent<ImageRevision, Image>.Version
            implements MediaAnalogBI<ImageRevision>, I_AmTypedPart {

        public Version(MediaAnalogBI cv) {
            super(cv);
        }

        //~--- methods ----------------------------------------------------------

        public ImageRevision makeAnalog() {
            if (getCv() != Image.this) {
                return new ImageRevision((ImageRevision) getCv(), Image.this);
            }

            return new ImageRevision(Image.this);
        }

        @Override
        public ImageRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
            return (ImageRevision) getCv().makeAnalog(statusNid, authorNid, pathNid, time);
        }

        @Override
        public boolean fieldsEqual(ConceptComponent.Version another) {
            Image.Version anotherVersion = (Image.Version) another;
            if (!this.getFormat().equals(anotherVersion.getFormat())) {
                return false;
            }

            if (!Arrays.equals(this.getMedia(), anotherVersion.getMedia())) {
                return false;
            }

            if (this.getTypeNid() != anotherVersion.getTypeNid()) {
                return false;
            }

            return true;
        }

        //~--- get methods ------------------------------------------------------
        @Override
        public int getConceptNid() {
            return enclosingConceptNid;
        }

        MediaAnalogBI getCv() {
            return (MediaAnalogBI) cv;
        }

        @Override
        public MediaCAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB {
            return getCv().makeBlueprint(vc);
        }

        @Override
        public String getFormat() {
            return format;
        }

        @Override
        public byte[] getMedia() {
            return image;
        }
        @Override
        public Image getPrimordialVersion() {
            return Image.this;
        }

        @Override
        public String getTextDescription() {
            return getCv().getTextDescription();
        }

         @Override
        public int getTypeNid() {
            return getCv().getTypeNid();
        }

        @Override
        public IntArrayList getVariableVersionNids() {
            if (Image.this != getCv()) {
                return ((ImageRevision) getCv()).getVariableVersionNids();
            }

            return Image.this.getVariableVersionNids();
        }

        @Override
        public Image.Version getVersion(ViewCoordinate c) throws ContradictionException {
            return Image.this.getVersion(c);
        }

        @Override
        public List<? extends Version> getVersions() {
            return Image.this.getVersions();
        }

        @Override
        public Collection<Image.Version> getVersions(ViewCoordinate c) {
            return Image.this.getVersions(c);
        }

        //~--- set methods ------------------------------------------------------
        @Override
        public void setTextDescription(String name) throws PropertyVetoException {
            getCv().setTextDescription(name);
        }

        @Override
        public void setTypeNid(int type) throws PropertyVetoException {
            getCv().setTypeNid(type);
        }
    }
}
