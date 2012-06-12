package org.ihtsdo.fxmodel.concept.component.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;


public abstract class FxRefexChronicle<V extends FxVersion> extends FxComponentChronicle<V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public FxComponentReference componentRef;
   public FxComponentReference refexRef;

   //~--- constructors --------------------------------------------------------

   public FxRefexChronicle() {
      super();
   }

   public FxRefexChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexVersionBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another);
      this.componentRef = new FxComponentReference(ss, another.getReferencedComponentNid());
      this.refexRef     = new FxComponentReference(ss.getConceptVersion(another.getRefexNid()));
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getComponentRef() {
      return componentRef;
   }

   public FxComponentReference getRefexRef() {
      return refexRef;
   }

   public abstract FX_REFEX_TYPE getType();

   //~--- set methods ---------------------------------------------------------

   public void setComponentRef(FxComponentReference componentRef) {
      this.componentRef = componentRef;
   }

   public void setRefexUuid(FxComponentReference refexRef) {
      this.refexRef = refexRef;
   }
}
