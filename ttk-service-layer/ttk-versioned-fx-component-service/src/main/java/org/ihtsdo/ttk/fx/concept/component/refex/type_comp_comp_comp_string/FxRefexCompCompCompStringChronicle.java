package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_string;

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
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_string.RefexNidNidNidStringVersionBI;

@XmlRootElement()
public class FxRefexCompCompCompStringChronicle
        extends FxRefexChronicle<FxRefexCompCompCompStringVersion, RefexNidNidNidStringVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompCompStringChronicle() {
      super();
   }

   public FxRefexCompCompCompStringChronicle(TerminologySnapshotDI ss, FxConceptChronicle concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexCompCompCompStringVersion makeVersion(TerminologySnapshotDI ss, RefexNidNidNidStringVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexCompCompCompStringVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_COMP_COMP_STRING;
   }
}
