/*
 * Copyright 2011 International Health Terminology Standards Development Organisation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ihtsdo.cc.refex.type_array_of_bytearray;

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.ihtsdo.cc.refex.RefexRevision;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.type_array_of_bytearray.TkRefexArrayOfByteArrayRevision;
import org.ihtsdo.tk.uuid.UuidT5Generator;

/**
 *
 * @author kec
 */
public class ArrayOfByteArrayRevisionX extends RefexRevision<ArrayOfByteArrayRevisionX, ArrayOfByteArrayMemberX>
        implements RefexArrayOfBytearrayAnalogBI<ArrayOfByteArrayRevisionX>  {

   private byte[][] arrayOfByteArray;

    @Override
    public byte[][] getArrayOfByteArray() {
        return arrayOfByteArray;
    }

    @Override
    public void setArrayOfByteArray(byte[][] arrayOfByteArray) {
        this.arrayOfByteArray = arrayOfByteArray;
        modified();
    }

    
   //~--- constructors --------------------------------------------------------

   public ArrayOfByteArrayRevisionX() {
      super();
   }

   protected ArrayOfByteArrayRevisionX(int statusAtPositionNid, ArrayOfByteArrayMemberX another) {
      super(statusAtPositionNid, another);
      this.arrayOfByteArray = another.getArrayOfByteArray();
   }

   public ArrayOfByteArrayRevisionX(TkRefexArrayOfByteArrayRevision eVersion, ArrayOfByteArrayMemberX another) throws IOException {
      super(eVersion, another);
      this.arrayOfByteArray = eVersion.getArrayOfByteArray1();
   }

   public ArrayOfByteArrayRevisionX(TupleInput in, ArrayOfByteArrayMemberX primoridalMember) {
      super(in, primoridalMember);
      int arrayLength = in.readShort();
      this.arrayOfByteArray = new byte[arrayLength][];
      for (int i = 0; i < arrayLength; i++) {
          int byteArrayLength = in.readInt();
          this.arrayOfByteArray[i] = new byte[byteArrayLength];
          in.read(this.arrayOfByteArray[i], 0, byteArrayLength);
      }
   }

   protected ArrayOfByteArrayRevisionX(int statusNid, long time, int authorNid,
           int moduleNid, int pathNid, ArrayOfByteArrayMemberX primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
      this.arrayOfByteArray = primoridalMember.getArrayOfByteArray();
   }

   protected ArrayOfByteArrayRevisionX(int statusNid, long time, int authorNid,
           int moduleNid, int pathNid, ArrayOfByteArrayRevisionX another) {
      super(statusNid, time, authorNid, moduleNid, pathNid, another.primordialComponent);
      this.arrayOfByteArray = another.getArrayOfByteArray();
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {

      // ;
   }

    @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexCAB.RefexProperty.ARRAY_OF_BYTEARRAY, getArrayOfByteArray());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (ArrayOfByteArrayRevisionX.class.isAssignableFrom(obj.getClass())) {
         ArrayOfByteArrayRevisionX another = (ArrayOfByteArrayRevisionX) obj;

         return (Arrays.deepEquals(arrayOfByteArray, another.getArrayOfByteArray())) && super.equals(obj);
      }

      return false;
   }

   @Override
   public ArrayOfByteArrayRevisionX makeAnalog() {
      return new ArrayOfByteArrayRevisionX(getStatusNid(), getTime(), getAuthorNid(),
              getModuleNid(), getPathNid(),  this);
   }
   
   @Override
   public ArrayOfByteArrayRevisionX makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);

         return this;
      }

      ArrayOfByteArrayRevisionX newR = new ArrayOfByteArrayRevisionX(statusNid, time,
              authorNid, moduleNid, pathNid,this);

      primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRefsetRevision() {
      return true;
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();
      buff.append(" size: ");
      buff.append(this.arrayOfByteArray.length);
      for (int i = 0; i < this.arrayOfByteArray.length; i++) {
        buff.append(" ").append(i);
        buff.append(": ");
        if (this.arrayOfByteArray[i].length == 16){
            buff.append(UuidT5Generator.getUuidFromRawBytes(this.arrayOfByteArray[i]));
        }else{
            buff.append(this.arrayOfByteArray[i]);
        }
      }
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput out) {
      out.writeShort(arrayOfByteArray.length);
      for (byte[] bytes: arrayOfByteArray) {
        out.writeInt(bytes.length);  
        out.write(bytes);
      }
   }

   //~--- get methods ---------------------------------------------------------


    @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.ARRAY_BYTEARRAY;
   }

   @Override
   public ArrayOfByteArrayMemberX.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return (ArrayOfByteArrayMemberX.Version) ((ArrayOfByteArrayMemberX) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<ArrayOfByteArrayMemberX.Version> getVersions() {
      return ((ArrayOfByteArrayMemberX) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<ArrayOfByteArrayRevisionX>> getVersions(ViewCoordinate c) {
      return ((ArrayOfByteArrayMemberX) primordialComponent).getVersions(c);
   }

   //~--- set methods ---------------------------------------------------------

    @Override
    public IntArrayList getVariableVersionNids() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
