package org.ihtsdo.fxmodel.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.api.id.LongIdBI;
import org.ihtsdo.tk.api.id.StringIdBI;
import org.ihtsdo.tk.api.id.UuidIdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataOutput;
import java.io.IOException;


import org.ihtsdo.fxmodel.FxComponentRef;

public abstract class FxIdentifier extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   protected FxComponentRef authorityRef;

   //~--- constructors --------------------------------------------------------

   public FxIdentifier() {
      super();
   }

   public FxIdentifier(TerminologySnapshotDI ss, IdBI id) throws IOException, ContradictionException {
      super(ss, id);
      this.authorityRef = new FxComponentRef(ss.getConceptVersion(id.getAuthorityNid()));
   }

   //~--- methods -------------------------------------------------------------

   public static FxIdentifier convertId(TerminologySnapshotDI ss, IdBI id)
           throws IOException, ContradictionException {
      Object denotation = id.getDenotation();

      switch (IDENTIFIER_PART_TYPES.getType(denotation.getClass())) {
      case LONG :
         return new FxIdentifierLong(ss, (LongIdBI) id);

      case STRING :
         return new FxIdentifierString(ss, (StringIdBI) id);

      case UUID :
         return new FxIdentifierUuid(ss, (UuidIdBI) id);

      default :
         throw new UnsupportedOperationException();
      }
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(" authority:");
      buff.append(this.authorityRef);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   public abstract void writeDenotation(DataOutput out) throws IOException;

   //~--- get methods ---------------------------------------------------------

   public FxComponentRef getAuthorityRef() {
      return authorityRef;
   }

   public abstract Object getDenotation();

   public abstract IDENTIFIER_PART_TYPES getIdType();

   //~--- set methods ---------------------------------------------------------

   public void setAuthorityRef(FxComponentRef authorityRef) {
      this.authorityRef = authorityRef;
   }

   public abstract void setDenotation(Object denotation);
}
