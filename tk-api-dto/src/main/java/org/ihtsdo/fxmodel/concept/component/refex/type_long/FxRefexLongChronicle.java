package org.ihtsdo.fxmodel.concept.component.refex.type_long;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexLongChronicle extends FxRefexChronicle<FxRefexLongVersion, RefexLongVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexLongChronicle() {
      super();
   }

   public FxRefexLongChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexLongVersion makeVersion(TerminologySnapshotDI ss, RefexLongVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexLongVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.LONG;
   }
}
