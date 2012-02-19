package org.ihtsdo.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.Revision;
import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import java.util.Date;
import java.util.Set;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.hash.Hashcode;

public abstract class IdentifierVersion
        implements IdBI {

   //~--- fields --------------------------------------------------------------

   protected int authorityNid;
   private int statusAtPositionNid;

   //~--- constructors --------------------------------------------------------

   protected IdentifierVersion() {
      super();
   }

   protected IdentifierVersion(TkIdentifier idv) {
      super();
      this.statusAtPositionNid = Bdb.getSapDb().getSapNid(Bdb.uuidToNid(idv.getStatusUuid()),
              Bdb.uuidToNid(idv.getAuthorUuid()), Bdb.uuidToNid(idv.getPathUuid()), idv.getTime());
      this.authorityNid = Bdb.uuidToNid(idv.getAuthorityUuid());
   }

   protected IdentifierVersion(TupleInput input) {
      super();
      statusAtPositionNid = input.readInt();
      authorityNid        = input.readInt();
   }

   protected IdentifierVersion(int statusNid, int authorNid, int pathNid, long time, int authorityNid) {
      this.statusAtPositionNid = Bdb.getSapDb().getSapNid(statusNid, authorNid, pathNid, time);
      this.authorityNid = authorNid;
   }

   protected IdentifierVersion(int statusNid, int authorNid, int pathNid, long time,
                               IdentifierVersion idVersion) {
      this(statusNid, authorNid, pathNid, time, idVersion.authorityNid);
   }

   //~--- methods -------------------------------------------------------------


   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (IdentifierVersion.class.isAssignableFrom(obj.getClass())) {
         IdentifierVersion another = (IdentifierVersion) obj;

         return (this.statusAtPositionNid == another.statusAtPositionNid)
                && (this.authorityNid == another.authorityNid);
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { statusAtPositionNid, authorityNid });
   }

   public final boolean readyToWrite() {
      assert statusAtPositionNid != Integer.MAX_VALUE : toString();
      assert authorityNid != Integer.MAX_VALUE : toString();
      assert readyToWriteIdentifier() : toString();

      return true;
   }

   public abstract boolean readyToWriteIdentifier();

   public boolean sapIsInRange(int min, int max) {
      return (statusAtPositionNid >= min) && (statusAtPositionNid <= max);
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuffer buf = new StringBuffer();

      buf.append("sap:").append(statusAtPositionNid);
      buf.append(" authority:");
      ConceptComponent.addNidToBuffer(buf, authorityNid);
      buf.append(" path:");
      ConceptComponent.addNidToBuffer(buf, getPathNid());
      buf.append(" tm:");

      if (getTime() == Long.MAX_VALUE) {
         buf.append(" uncommitted");
      } else if (getTime() == Long.MIN_VALUE) {
         buf.append(" uncommitted");
      } else {
         buf.append(Revision.fileDateFormat.format(new Date(getTime())));
      }

      buf.append(" status:");
      ConceptComponent.addNidToBuffer(buf, getStatusNid());

      return buf.toString();
   }

   public final void writeIdPartToBdb(TupleOutput output) {
      output.writeInt(statusAtPositionNid);
      output.writeInt(authorityNid);
      writeSourceIdToBdb(output);
   }

   protected abstract void writeSourceIdToBdb(TupleOutput output);

   //~--- get methods ---------------------------------------------------------

   @Override
   public Set<Integer> getAllNidsForId() throws IOException {
      HashSet<Integer> allNids = new HashSet<Integer>();

      allNids.add(authorityNid);
      allNids.add(getStatusNid());
      allNids.add(getAuthorNid());
      allNids.add(getPathNid());

      return allNids;
   }

   public int getAuthorId() {
      return Bdb.getSapDb().getAuthorNid(statusAtPositionNid);
   }

   @Override
   public int getAuthorNid() {
      return Bdb.getSapDb().getAuthorNid(statusAtPositionNid);
   }

   @Override
   public int getAuthorityNid() {
      return authorityNid;
   }

   @Override
   public int getPathNid() {
      return Bdb.getSapDb().getPathNid(statusAtPositionNid);
   }

    @Override
   public int getSapNid() {
      return statusAtPositionNid;
   }
    
   @Override
   public int getStatusNid() {
      return Bdb.getSapDb().getStatusNid(statusAtPositionNid);
   }

   @Override
   public long getTime() {
      return Bdb.getSapDb().getTime(statusAtPositionNid);
   }

   public abstract ConceptComponent.IDENTIFIER_PART_TYPES getType();

   protected IntArrayList getVariableVersionNids() {
      IntArrayList nids = new IntArrayList(3);

      nids.add(authorityNid);

      return nids;
   }
   
   public void setTime(long time) {
      if (getTime() != Long.MAX_VALUE) {
         throw new UnsupportedOperationException("Time alreay committed.");
      }

      this.statusAtPositionNid = Bdb.getSapDb().getSapNid(getStatusNid(), getAuthorId(), getPathNid(), time);
   }
   
   public void setSapNid(int sapNid) {
      statusAtPositionNid = sapNid;
   }
}
