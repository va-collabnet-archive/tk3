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
package org.ihtsdo.ttk.concept.cc.refex.type_array_of_bytearray;

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;
import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.component.RevisionSet;
import org.ihtsdo.ttk.concept.cc.computer.version.VersionComputer;
import org.ihtsdo.ttk.concept.cc.refex.RefexMember;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexProperty;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayAnalogBI;
import org.ihtsdo.ttk.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayVersionBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.dto.component.refex.type_array_of_bytearray.TkRefexArrayOfByteArrayRevision;
import org.ihtsdo.ttk.dto.component.refex.type_array_of_bytearray.TkRefexArrayOfByteArrayMember;
import org.ihtsdo.ttk.api.hash.Hashcode;
import org.ihtsdo.ttk.api.uuid.UuidT5Generator;

/**
 *
 * @author kec
 */
public class ArrayOfByteArrayMember extends RefexMember<ArrayOfByteArrayRevision, ArrayOfByteArrayMember>
        implements RefexArrayOfBytearrayAnalogBI<ArrayOfByteArrayRevision> {

    private static VersionComputer<RefexMember<ArrayOfByteArrayRevision, ArrayOfByteArrayMember>.Version> computer =
            new VersionComputer<>();
    //~--- fields --------------------------------------------------------------
    private byte[][] arrayOfByteArray;

    @Override
    public byte[][] getArrayOfByteArray() {
        return arrayOfByteArray;
    }

    @Override
    public void setArrayOfByteArray(byte[][] byteArray) {
        this.arrayOfByteArray = byteArray;
        modified();
    }


    //~--- constructors --------------------------------------------------------
    public ArrayOfByteArrayMember() {
        super();
    }

    public ArrayOfByteArrayMember(int enclosingConceptNid, TupleInput input) throws IOException {
        super(enclosingConceptNid, input);
    }

    public ArrayOfByteArrayMember(TkRefexArrayOfByteArrayMember refsetMember, int enclosingConceptNid) throws IOException {
        super(refsetMember, enclosingConceptNid);
        arrayOfByteArray = refsetMember.getArrayOfByteArray1();

        if (refsetMember.getRevisionList() != null) {
            revisions = new RevisionSet(primordialStamp);

            for (TkRefexArrayOfByteArrayRevision eVersion : refsetMember.getRevisionList()) {
                revisions.add(new ArrayOfByteArrayRevision(eVersion, this));
            }
        }
    }

    //~--- methods -------------------------------------------------------------
    @Override
    protected void addRefsetTypeNids(Set<Integer> allNids) {
        // ;
    }
 
    @Override
    protected void addSpecProperties(RefexCAB rcs) {
        rcs.with(RefexProperty.ARRAY_OF_BYTEARRAY, arrayOfByteArray);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (RefexArrayOfBytearrayVersionBI.class.equals(obj.getClass())) {
            RefexArrayOfBytearrayVersionBI another = (RefexArrayOfBytearrayVersionBI) obj;

            return this.nid == another.getNid();
        }

        return false;
    }

   @Override
   protected IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

    @Override
    public int hashCode() {
        return Hashcode.compute(new int[]{nid});
    }

    @Override
    public ArrayOfByteArrayRevision makeAnalog() {
        ArrayOfByteArrayRevision newR = new ArrayOfByteArrayRevision(getStatusNid(), getTime(),
                getAuthorNid(), getModuleNid(), getPathNid(), this);

        return newR;
    }
    
    @Override
    public ArrayOfByteArrayRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
        ArrayOfByteArrayRevision newR = new ArrayOfByteArrayRevision(statusNid, time,
                authorNid, moduleNid, pathNid, this);

        addRevision(newR);

        return newR;
    }

    @Override
    protected boolean refexFieldsEqual(ConceptComponent<ArrayOfByteArrayRevision, ArrayOfByteArrayMember> obj) {
        if (ArrayOfByteArrayMember.class.isAssignableFrom(obj.getClass())) {
            ArrayOfByteArrayMember another = (ArrayOfByteArrayMember) obj;

            return Arrays.deepEquals(this.arrayOfByteArray, another.arrayOfByteArray);
        }

        return false;
    }

    @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexArrayOfBytearrayVersionBI.class.isAssignableFrom(another.getClass())){
            RefexArrayOfBytearrayVersionBI bv = (RefexArrayOfBytearrayVersionBI) another;
            return Arrays.deepEquals(this.arrayOfByteArray, bv.getArrayOfByteArray());
        }
        return false;
    }

    @Override
    protected void readMemberFields(TupleInput in) {
      int arrayLength = in.readShort();
      this.arrayOfByteArray = new byte[arrayLength][];
      for (int i = 0; i < arrayLength; i++) {
          int byteArrayLength = in.readInt();
          this.arrayOfByteArray[i] = new byte[byteArrayLength];
          in.read(this.arrayOfByteArray[i], 0, byteArrayLength);
      }
    }

    @Override
    protected final ArrayOfByteArrayRevision readMemberRevision(TupleInput input) {
        return new ArrayOfByteArrayRevision(input, this);
    }

    @Override
    public boolean readyToWriteRefsetMember() {
        return true;
    }

    /*
     *  (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
     buff.append("AOBA size: ");
      buff.append(this.arrayOfByteArray.length);
      for (int i = 0; i < this.arrayOfByteArray.length; i++) {
        buff.append(" ").append(i);
        buff.append(": ");
        if(this.arrayOfByteArray[i].length == 16){
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
    protected void writeMember(TupleOutput out) {
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
    public int getTypeNid() {
        return TK_REFEX_TYPE.ARRAY_BYTEARRAY.getTypeToken();
    }

    @Override
    protected VersionComputer<RefexMember<ArrayOfByteArrayRevision, ArrayOfByteArrayMember>.Version> getVersionComputer() {
        return computer;
    }

    @Override
    public List<ArrayOfByteArrayMember.Version> getVersions() {
        if (versions == null) {
            int count = 1;

            if (revisions != null) {
                count = count + revisions.size();
            }

            ArrayList<ArrayOfByteArrayMember.Version> list = new ArrayList<>(count);

            if (getTime() != Long.MIN_VALUE) {
                list.add(new ArrayOfByteArrayMember.Version(this));
            }

            if (revisions != null) {
                for (ArrayOfByteArrayRevision br : revisions) {
                    if (br.getTime() != Long.MIN_VALUE) {
                        list.add(new ArrayOfByteArrayMember.Version(br));
                    }
                }
            }

            versions = list;
        }

        return (List<ArrayOfByteArrayMember.Version>) versions;
    }

    //~--- set methods ---------------------------------------------------------

    //~--- inner classes -------------------------------------------------------
    public class Version extends RefexMember<ArrayOfByteArrayRevision, ArrayOfByteArrayMember>.Version
            implements RefexArrayOfBytearrayAnalogBI<ArrayOfByteArrayRevision> {

        private Version(RefexArrayOfBytearrayAnalogBI<ArrayOfByteArrayRevision> cv) {
            super(cv);
        }

        //~--- methods ----------------------------------------------------------

        //~--- get methods ------------------------------------------------------
        @Override
        public byte[][] getArrayOfByteArray() {
            return getCv().getArrayOfByteArray();
        }

        RefexArrayOfBytearrayAnalogBI<ArrayOfByteArrayRevision> getCv() {
            return (RefexArrayOfBytearrayAnalogBI<ArrayOfByteArrayRevision>) cv;
        }

        @Override
        public TkRefexArrayOfByteArrayMember getERefsetMember() throws IOException {
            return new TkRefexArrayOfByteArrayMember(this);
        }

        @Override
        public TkRefexArrayOfByteArrayRevision getERefsetRevision() throws IOException {
            return new TkRefexArrayOfByteArrayRevision(this);
        }

        //~--- set methods ------------------------------------------------------
        @Override
        public void setArrayOfByteArray(byte[][] arrayOfByteArray) throws PropertyVetoException {
            getCv().setArrayOfByteArray(arrayOfByteArray);
        }
    }
}
