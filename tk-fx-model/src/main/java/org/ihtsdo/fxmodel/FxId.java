/*
 * Copyright 2012 International Health Terminology Standards Development Organisation.
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



package org.ihtsdo.fxmodel;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author kec
 */
public class FxId {
   private int        nid = Integer.MAX_VALUE;
   private final long lsb;
   private final long msb;

   //~--- constructors --------------------------------------------------------

   public FxId(int nid) throws IOException {
      this.nid = nid;

      UUID primordialUuid = Ts.get().getUuidPrimordialForNid(nid);

      this.lsb = primordialUuid.getLeastSignificantBits();
      this.msb = primordialUuid.getMostSignificantBits();
   }

   public FxId(UUID primordialUuid) {
      this.lsb = primordialUuid.getLeastSignificantBits();
      this.msb = primordialUuid.getMostSignificantBits();
   }

   public FxId(UUID primordialUuid, Integer nid) {
      this.lsb = primordialUuid.getLeastSignificantBits();
      this.msb = primordialUuid.getMostSignificantBits();
      this.nid = nid;
   }

   //~--- methods -------------------------------------------------------------

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (getClass() != obj.getClass()) {
         return false;
      }

      final FxId other = (FxId) obj;

      if (!Objects.equals(this.msb, other.msb)) {
         return false;
      }

      return (this.msb == other.msb) && (this.lsb == other.lsb);
   }

   @Override
   public int hashCode() {
      int hash = 7;

      hash = 89 * hash + (int) (this.lsb ^ (this.lsb >>> 32));
      hash = 89 * hash + (int) (this.msb ^ (this.msb >>> 32));

      return hash;
   }

   @Override
   public String toString() {
      return "FxId{" + "nid=" + nid + ", primordialUuid=" + new UUID(msb, lsb) + '}';
   }

   //~--- get methods ---------------------------------------------------------

   public final int getNid() {
      return nid;
   }

   public final UUID getPrimordialUuid() {
      return new UUID(msb, lsb);
   }

   //~--- set methods ---------------------------------------------------------

   public final void setNid(int nid) {
      if (this.nid != Integer.MAX_VALUE) {
         throw new IllegalArgumentException("Nid is already set");
      }

      this.nid = nid;
   }
}
