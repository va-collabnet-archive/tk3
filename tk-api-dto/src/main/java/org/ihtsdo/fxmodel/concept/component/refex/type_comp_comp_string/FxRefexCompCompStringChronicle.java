package org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp_string;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_string.RefexNidNidStringVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompCompStringChronicle
        extends FxRefexChronicle<FxRefexCompCompStringVersion, RefexNidNidStringVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompStringChronicle() {
      super();
   }

   public FxRefexCompCompStringChronicle(TerminologySnapshotDI ss, FxConcept concept,
           RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexCompCompStringVersion makeVersion(TerminologySnapshotDI ss,
           RefexNidNidStringVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexCompCompStringVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_COMP_STR;
   }
}
