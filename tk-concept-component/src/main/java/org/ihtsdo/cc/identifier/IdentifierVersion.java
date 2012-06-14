package org.ihtsdo.cc.identifier;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cc.P;
import org.ihtsdo.cc.component.ConceptComponent;
import org.ihtsdo.cc.component.Revision;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.tk.api.id.IdBI;

//import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import java.util.Date;
import java.util.Set;

public abstract class IdentifierVersion implements IdBI {
   protected int authorityNid;
   private int   stampNid;

   //~--- constructors --------------------------------------------------------

   protected IdentifierVersion() {
      super();
   }

   protected IdentifierVersion(TkIdentifier idv) throws IOException {
      super();
      this.stampNid = P.s.getSapNid(P.s.getNidForUuids(idv.getStatusUuid()), idv.getTime(),
                                    P.s.getNidForUuids(idv.getAuthorUuid()),
                                    P.s.getNidForUuids(idv.getModuleUuid()),
                                    P.s.getNidForUuids(idv.getPathUuid()));
      this.authorityNid = P.s.getNidForUuids(idv.getAuthorityUuid());
   }

   protected IdentifierVersion(TupleInput input) {
      super();
      stampNid     = input.readInt();
      authorityNid = input.readInt();
   }

   protected IdentifierVersion(int statusNid, long time, int authorNid, int moduleNid, int pathNid,
                               IdentifierVersion idVersion) {
      this(statusNid, time, moduleNid, authorNid, pathNid, idVersion.authorityNid);
   }

   protected IdentifierVersion(int statusNid, long time, int authorNid, int moduleNid, int pathNid,
                               int authorityNid) {
      this.stampNid     = P.s.getSapNid(statusNid, time, moduleNid, authorNid, pathNid);
      this.authorityNid = authorNid;
   }

   //~--- methods -------------------------------------------------------------

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (IdentifierVersion.class.isAssignableFrom(obj.getClass())) {
         IdentifierVersion another = (IdentifierVersion) obj;

         return (this.stampNid == another.stampNid) && (this.authorityNid == another.authorityNid);
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { stampNid, authorityNid });
   }

   public final boolean readyToWrite() {
      assert stampNid != Integer.MAX_VALUE : toString();
      assert authorityNid != Integer.MAX_VALUE : toString();
      assert readyToWriteIdentifier() : toString();

      return true;
   }

   public abstract boolean readyToWriteIdentifier();

   public boolean stampIsInRange(int min, int max) {
      return (stampNid >= min) && (stampNid <= max);
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuffer buf = new StringBuffer();

      buf.append("authority:");
      ConceptComponent.addNidToBuffer(buf, authorityNid);
      buf.append(" stamp:").append(stampNid);
      buf.append(" s:");
      ConceptComponent.addNidToBuffer(buf, getStatusNid());
      buf.append(" t:");

      if (getTime() == Long.MAX_VALUE) {
         buf.append(" uncommitted");
      } else if (getTime() == Long.MIN_VALUE) {
         buf.append(" uncommitted");
      } else {
         buf.append(Revision.fileDateFormat.format(new Date(getTime())));
      }

      buf.append(" a:");
      ConceptComponent.addNidToBuffer(buf, getAuthorNid());
      buf.append(" m:");
      ConceptComponent.addNidToBuffer(buf, getModuleNid());
      buf.append(" p:");
      ConceptComponent.addNidToBuffer(buf, getPathNid());

      return buf.toString();
   }

   public final void writeIdPartToBdb(TupleOutput output) {
      output.writeInt(stampNid);
      output.writeInt(authorityNid);
      writeSourceIdToBdb(output);
   }

   protected abstract void writeSourceIdToBdb(TupleOutput output);

   //~--- get methods ---------------------------------------------------------

   @Override
   public Set<Integer> getAllNidsForId() throws IOException {
      HashSet<Integer> allNids = new HashSet<>();

      allNids.add(authorityNid);
      allNids.add(getStatusNid());
      allNids.add(getAuthorNid());
      allNids.add(getModuleNid());
      allNids.add(getPathNid());

      return allNids;
   }

   public int getAuthorId() {
      return P.s.getAuthorNidForSapNid(stampNid);
   }

   @Override
   public int getAuthorNid() {
      return P.s.getAuthorNidForSapNid(stampNid);
   }

   @Override
   public int getAuthorityNid() {
      return authorityNid;
   }

   @Override
   public int getModuleNid() {
      return P.s.getModuleNidForSapNid(stampNid);
   }

   @Override
   public int getPathNid() {
      return P.s.getPathNidForSapNid(stampNid);
   }

   @Override
   public int getStampNid() {
      return stampNid;
   }

   @Override
   public int getStatusNid() {
      return P.s.getStatusNidForSapNid(stampNid);
   }

   @Override
   public long getTime() {
      return P.s.getTimeForSapNid(stampNid);
   }

   public abstract ConceptComponent.IDENTIFIER_PART_TYPES getType();

   protected IntArrayList getVariableVersionNids() {
      IntArrayList nids = new IntArrayList(3);

      nids.add(authorityNid);

      return nids;
   }

   //~--- set methods ---------------------------------------------------------

   public void setStampNid(int stampNid) {
      this.stampNid = stampNid;
   }

   public void setTime(long time) {
      if (getTime() != Long.MAX_VALUE) {
         throw new UnsupportedOperationException("Time alreay committed.");
      }

      this.stampNid = P.s.getSapNid(getStatusNid(), time, getAuthorNid(), getModuleNid(), getPathNid());
   }
}
