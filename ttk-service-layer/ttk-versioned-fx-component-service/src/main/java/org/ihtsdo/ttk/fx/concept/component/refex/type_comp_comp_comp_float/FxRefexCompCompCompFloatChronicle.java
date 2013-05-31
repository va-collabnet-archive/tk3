package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_float;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_float.RefexNidNidNidFloatVersionBI;

@XmlRootElement()
public class FxRefexCompCompCompFloatChronicle
        extends FxRefexChronicle<FxRefexCompCompCompFloatVersion, RefexNidNidNidFloatVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompCompFloatChronicle() {
      super();
   }

   public FxRefexCompCompCompFloatChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexCompCompCompFloatVersion makeVersion(TerminologySnapshotDI ss, RefexNidNidNidFloatVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexCompCompCompFloatVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_COMP_COMP_FLOAT;
   }
}
