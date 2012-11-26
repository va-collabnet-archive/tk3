package org.ihtsdo.tk.dto.concept.component.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkComponent;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.UUID;
import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

public abstract class TkRefexAbstractMember<V extends TkRevision> extends TkComponent<V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID componentUuid;
   @XmlAttribute
   public UUID refexUuid;

   //~--- constructors --------------------------------------------------------

   public TkRefexAbstractMember() {
      super();
   }

   public TkRefexAbstractMember(RefexVersionBI another) throws IOException {
      super(another);
      this.componentUuid = Ts.get().getComponent(another.getReferencedComponentNid()).getPrimUuid();
      this.refexUuid    = Ts.get().getComponent(another.getRefexNid()).getPrimUuid();
   }

   public TkRefexAbstractMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexAbstractMember(TkRefexAbstractMember another, ComponentTransformerBI transformer) {
      super(another, transformer);

         this.componentUuid = transformer.transform(another.componentUuid, another, ComponentFields.REFEX_REFERENCED_COMPONENT_UUID);
         this.refexUuid    = transformer.transform(another.refexUuid, another, ComponentFields.REFEX_COLLECTION_UUID);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefset</tt> object, and contains the same values, field by field,
    * as this <tt>ERefset</tt>.
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

      if (TkRefexAbstractMember.class.isAssignableFrom(obj.getClass())) {
         TkRefexAbstractMember<?> another = (TkRefexAbstractMember<?>) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare refsetUuid
         if (!this.refexUuid.equals(another.refexUuid)) {
            return false;
         }

         // Compare componentUuid
         if (!this.componentUuid.equals(another.componentUuid)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>ERefset</code>.
    *
    * @return a hash code value for this <tt>ERefset</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      refexUuid    = new UUID(in.readLong(), in.readLong());
      componentUuid = new UUID(in.readLong(), in.readLong());
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(" refex:");
      buff.append(informAboutUuid(this.refexUuid));
      buff.append(" component:");
      buff.append(informAboutUuid(this.componentUuid));
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(refexUuid.getMostSignificantBits());
      out.writeLong(refexUuid.getLeastSignificantBits());
      out.writeLong(componentUuid.getMostSignificantBits());
      out.writeLong(componentUuid.getLeastSignificantBits());
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getComponentUuid() {
      return componentUuid;
   }

   public UUID getRefexUuid() {
      return refexUuid;
   }

   public abstract TK_REFEX_TYPE getType();

   //~--- set methods ---------------------------------------------------------

   public void setComponentUuid(UUID componentUuid) {
      this.componentUuid = componentUuid;
   }

   public void setRefexUuid(UUID refexUuid) {
      this.refexUuid = refexUuid;
   }
}
