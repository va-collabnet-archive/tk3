package org.ihtsdo.fxmodel.concept.component.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.UUID;

public abstract class FxRefexChronicle<V extends FxVersion> extends FxComponentChronicle<V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public UUID componentUuid;
   public UUID refexUuid;

   //~--- constructors --------------------------------------------------------

   public FxRefexChronicle() {
      super();
   }

   public FxRefexChronicle(FxConcept concept, RefexVersionBI another) throws IOException {
      super(concept, another);
      this.componentUuid = Ts.get().getComponent(another.getReferencedComponentNid()).getPrimUuid();
      this.refexUuid     = Ts.get().getComponent(another.getRefexNid()).getPrimUuid();
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getComponentUuid() {
      return componentUuid;
   }

   public UUID getRefexUuid() {
      return refexUuid;
   }

   public abstract FX_REFEX_TYPE getType();

   //~--- set methods ---------------------------------------------------------

   public void setComponentUuid(UUID componentUuid) {
      this.componentUuid = componentUuid;
   }

   public void setRefexUuid(UUID refexUuid) {
      this.refexUuid = refexUuid;
   }
}
