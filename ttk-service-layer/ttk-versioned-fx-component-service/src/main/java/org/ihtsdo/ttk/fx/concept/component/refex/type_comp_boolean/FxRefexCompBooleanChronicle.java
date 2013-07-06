package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_boolean;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.ttk.fx.concept.FxConceptChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;


import javax.xml.bind.annotation.XmlRootElement;
import org.ihtsdo.ttk.api.refex.type_nid_boolean.RefexNidBooleanVersionBI;

@XmlRootElement()
public class FxRefexCompBooleanChronicle
        extends FxRefexChronicle<FxRefexCompBooleanVersion, RefexNidBooleanVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompBooleanChronicle() {
      super();
   }

   public FxRefexCompBooleanChronicle(TerminologySnapshotDI ss, FxConceptChronicle concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexCompBooleanVersion makeVersion(TerminologySnapshotDI ss, RefexNidBooleanVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexCompBooleanVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_BOOLEAN;
   }
}
