package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_string;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.ttk.fx.concept.FxConceptChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_string.RefexNidStringVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompStringChronicle
        extends FxRefexChronicle<FxRefexCompStringVersion, RefexNidStringVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompStringChronicle() {
      super();
   }

   public FxRefexCompStringChronicle(TerminologySnapshotDI ss, FxConceptChronicle concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexCompStringVersion makeVersion(TerminologySnapshotDI ss, RefexNidStringVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexCompStringVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_STR;
   }
}
