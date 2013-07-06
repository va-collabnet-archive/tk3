package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.ttk.fx.concept.FxConceptChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid.RefexNidNidVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompCompChronicle extends FxRefexChronicle<FxRefexCompCompVersion, RefexNidNidVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompChronicle() {
      super();
   }

   public FxRefexCompCompChronicle(TerminologySnapshotDI ss, FxConceptChronicle concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexCompCompVersion makeVersion(TerminologySnapshotDI ss, RefexNidNidVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexCompCompVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_COMP;
   }
}
