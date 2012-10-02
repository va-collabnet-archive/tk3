package org.ihtsdo.fxmodel.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleStringProperty;

import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.id.StringIdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

public class FxIdentifierString extends FxIdentifier {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private SimpleStringProperty denotationProperty = new SimpleStringProperty(this, "denotation");

   //~--- constructors --------------------------------------------------------

   public FxIdentifierString() {
      super();
   }

   public FxIdentifierString(TerminologySnapshotDI ss, StringIdBI id)
           throws IOException, ContradictionException {
      super(ss, id);
      denotationProperty.set(id.getDenotation());
   }

   //~--- methods -------------------------------------------------------------

   public SimpleStringProperty denotationProperty() {
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
      buff.append("'").append(this.denotationProperty.get()).append("'");
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public String getDenotation() {
      return denotationProperty.get();
   }

   @Override
   public IDENTIFIER_PART_TYPES getIdType() {
      return IDENTIFIER_PART_TYPES.STRING;
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setDenotation(Object denotation) {
      this.denotationProperty.set((String) denotation);
   }
}
