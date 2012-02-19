package org.ihtsdo.concept.component.media;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import java.io.IOException;
import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.Revision;
import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.media.MediaVersionBI;
import org.ihtsdo.tk.dto.concept.component.media.TkMediaRevision;

//~--- JDK imports ------------------------------------------------------------

import java.util.Collection;
import java.util.Set;
import org.ihtsdo.tk.api.blueprint.InvalidCAB;
import org.ihtsdo.tk.api.blueprint.MediaCAB;

public class MediaRevision extends Revision<MediaRevision, Media>
        implements MediaVersionFacade {
   private String textDescription;
   private int    typeNid;

   //~--- constructors --------------------------------------------------------

   protected MediaRevision() {
      super();
   }

   MediaRevision(Media primoridalMember) {
      super(primoridalMember.primordialSapNid, primoridalMember);
      this.textDescription = primoridalMember.getTextDescription();
      this.typeNid         = primoridalMember.getTypeNid();
   }

   MediaRevision(MediaRevision another, Media primoridalMember) {
      super(another.sapNid, primoridalMember);
      this.textDescription = another.textDescription;
      this.typeNid         = another.typeNid;
   }

   public MediaRevision(TkMediaRevision eiv, Media primoridalMember) {
      super(Bdb.uuidToNid(eiv.getStatusUuid()), Bdb.uuidToNid(eiv.getAuthorUuid()),
            Bdb.uuidToNid(eiv.getPathUuid()), eiv.getTime(), primoridalMember);
      this.textDescription = eiv.getTextDescription();
      this.typeNid         = Bdb.uuidToNid(eiv.getTypeUuid());
   }

   protected MediaRevision(TupleInput input, Media primoridalMember) {
      super(input.readInt(), primoridalMember);
      this.textDescription = input.readString();
      this.typeNid         = input.readInt();
   }

   protected MediaRevision(MediaVersionBI another, int statusNid, int authorNid, int pathNid, long time,
                           Media primoridalMember) {
      super(statusNid, authorNid, pathNid, time, primoridalMember);
      this.textDescription = another.getTextDescription();
      this.typeNid         = another.getTypeNid();
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addComponentNids(Set<Integer> allNids) {
      allNids.add(typeNid);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (MediaRevision.class.isAssignableFrom(obj.getClass())) {
         MediaRevision another = (MediaRevision) obj;

         if (this.sapNid == another.sapNid) {
            return true;
         }
      }

      return false;
   }

   @Override
   public MediaRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);

         return this;
      }

      MediaRevision newR;

      newR = new MediaRevision(this, statusNid, authorNid, pathNid, time,
                               this.primordialComponent);
      this.primordialComponent.addRevision(newR);

      return newR;
   }
   
   @Override
    public MediaCAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB{
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
   public boolean readyToWriteRevision() {
      assert textDescription != null : assertionString();
      assert typeNid != Integer.MAX_VALUE : assertionString();

      return true;
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder buf = new StringBuilder();

      buf.append(this.getClass().getSimpleName()).append(":{");
      buf.append(" textDescription:" + "'").append(this.textDescription).append("'");
      buf.append(" typeNid:").append(this.typeNid);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   public String toUserString() {
      StringBuffer buf = new StringBuffer();

      ConceptComponent.addTextToBuffer(buf, typeNid);
      buf.append("; ");
      buf.append(primordialComponent.getFormat());
      buf.append(": ");
      buf.append(textDescription);

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeString(textDescription);
      output.writeInt(typeNid);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public int getConceptNid() {
      return primordialComponent.enclosingConceptNid;
   }

   @Override
   public String getFormat() {
      return primordialComponent.getFormat();
   }

   @Override
   public byte[] getMedia() {
      return primordialComponent.getMedia();
   }

   @Override
   public Media getPrimordialVersion() {
      return primordialComponent;
   }

   /*
    *  (non-Javadoc)
    * @see org.dwfa.vodb.types.I_ImagePart#getTextDescription()
    */
   @Override
   public String getTextDescription() {
      return textDescription;
   }

   /*
    *  (non-Javadoc)
    * @see org.dwfa.vodb.types.I_ImagePart#setTypeId(int)
    */

   @Override
   public int getTypeNid() {
      return typeNid;
   }

   /*
    *  (non-Javadoc)
    * @see org.dwfa.vodb.types.I_ImagePart#setTypeId(int)
    */

   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList partComponentNids = new IntArrayList(3);

      partComponentNids.add(typeNid);

      return partComponentNids;
   }

   @Override
   public Media.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return primordialComponent.getVersion(c);
   }

   @Override
   public Collection<? extends MediaVersionFacade> getVersions() {
      return ((Media) primordialComponent).getVersions();
   }

   @Override
   public Collection<Media.Version> getVersions(ViewCoordinate c) {
      return primordialComponent.getVersions(c);
   }

   /*
    *  (non-Javadoc)
    * @see org.dwfa.vodb.types.I_ImagePart#hasNewData(org.dwfa.vodb.types.ThinImagePart)
    */
   public boolean hasNewData(MediaRevision another) {
      return ((this.getPathNid() != another.getPathNid()) || (this.getStatusNid() != another.getStatusNid())
              || ((this.textDescription.equals(another.getTextDescription()) == false)
                  || (this.typeNid != another.getTypeNid())));
   }

   /*
    *  (non-Javadoc)
    * @see org.dwfa.vodb.types.I_ImagePart#convertIds(org.dwfa.vodb.jar.I_MapNativeToNative)
    */

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setTextDescription(String name) {
      this.textDescription = name;
      modified();
   }

   @Override
   public void setTypeNid(int type) {
      this.typeNid = type;
      modified();
   }
}
