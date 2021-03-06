package org.ihtsdo.fxmodel.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleLongProperty;

import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.id.LongIdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;


public class FxIdentifierLong extends FxIdentifier {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private SimpleLongProperty denotationProperty = new SimpleLongProperty(this, "denotation");

   //~--- constructors --------------------------------------------------------

   public FxIdentifierLong() {
      super();
   }

   public FxIdentifierLong(TerminologySnapshotDI ss, LongIdBI id) throws IOException, ContradictionException {
      super(ss, id);
      denotationProperty.set(id.getDenotation());
   }

   //~--- methods -------------------------------------------------------------

   public SimpleLongProperty denotationProperty() {
      return denotationProperty;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" denotation:");
      buff.append(this.denotationProperty.get());
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public Long getDenotation() {
      return denotationProperty.get();
   }

   @Override
   public IDENTIFIER_PART_TYPES getIdType() {
      return IDENTIFIER_PART_TYPES.LONG;
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setDenotation(Object denotation) {
      this.denotationProperty.set((Long) denotation);
   }
}
