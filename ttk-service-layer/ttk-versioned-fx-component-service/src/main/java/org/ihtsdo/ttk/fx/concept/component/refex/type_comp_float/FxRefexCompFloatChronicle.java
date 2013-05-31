package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_float;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_float.RefexNidFloatVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompFloatChronicle
        extends FxRefexChronicle<FxRefexCompFloatVersion, RefexNidFloatVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompFloatChronicle() {
      super();
   }

   public FxRefexCompFloatChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexCompFloatVersion makeVersion(TerminologySnapshotDI ss, RefexNidFloatVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexCompFloatVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_FLOAT;
   }
}