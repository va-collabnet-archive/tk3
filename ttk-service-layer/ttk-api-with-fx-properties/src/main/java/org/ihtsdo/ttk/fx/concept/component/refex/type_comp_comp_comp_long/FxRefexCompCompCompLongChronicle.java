package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_long;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_long.RefexNidNidNidLongVersionBI;

@XmlRootElement()
public class FxRefexCompCompCompLongChronicle
        extends FxRefexChronicle<FxRefexCompCompCompLongVersion, RefexNidNidNidLongVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompCompLongChronicle() {
      super();
   }

   public FxRefexCompCompCompLongChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexCompCompCompLongVersion makeVersion(TerminologySnapshotDI ss, RefexNidNidNidLongVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexCompCompCompLongVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_COMP_COMP_LONG;
   }
}
