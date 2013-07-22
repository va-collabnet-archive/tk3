package org.ihtsdo.ttk.fx.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.fx.FxComponentReference;
import org.ihtsdo.ttk.fx.concept.component.FxVersion;
import org.ihtsdo.otf.tcc.api.ContradictionException;
import org.ihtsdo.otf.tcc.api.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.id.IdBI;
import org.ihtsdo.otf.tcc.api.id.LongIdBI;
import org.ihtsdo.otf.tcc.api.id.StringIdBI;
import org.ihtsdo.otf.tcc.api.id.UuidIdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({ FxIdentifierLong.class, FxIdentifierString.class, FxIdentifierUuid.class })
public abstract class FxIdentifier extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   protected FxComponentReference authorityRef;

   //~--- constructors --------------------------------------------------------

   public FxIdentifier() {
      super();
   }

   public FxIdentifier(TerminologySnapshotDI ss, IdBI id) throws IOException, ContradictionException {
      super(ss, id);
      this.authorityRef = new FxComponentReference(ss.getConceptVersion(id.getAuthorityNid()));
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

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getAuthorityRef() {
      return authorityRef;
   }

   public abstract Object getDenotation();

   public abstract IDENTIFIER_PART_TYPES getIdType();

   //~--- set methods ---------------------------------------------------------

   public void setAuthorityRef(FxComponentReference authorityRef) {
      this.authorityRef = authorityRef;
   }

   public abstract void setDenotation(Object denotation);
}
