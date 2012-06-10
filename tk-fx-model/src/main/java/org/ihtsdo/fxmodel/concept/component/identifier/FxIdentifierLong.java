package org.ihtsdo.fxmodel.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.api.id.LongIdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;

public class FxIdentifierLong extends FxIdentifier {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public long denotation;

   //~--- constructors --------------------------------------------------------

   public FxIdentifierLong() {
      super();
   }

   public FxIdentifierLong(LongIdBI id) throws IOException {
      super(id);
      denotation = id.getDenotation();
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" denotation:");
      buff.append(this.denotation);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeDenotation(DataOutput out) throws IOException {
      out.writeLong(denotation);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public Long getDenotation() {
      return denotation;
   }

   @Override
   public IDENTIFIER_PART_TYPES getIdType() {
      return IDENTIFIER_PART_TYPES.LONG;
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setDenotation(Object denotation) {
      this.denotation = (Long) denotation;
   }
}
