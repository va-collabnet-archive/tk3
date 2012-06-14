package org.ihtsdo.fxmodel.concept.component.refex.type_comp;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid.RefexNidVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompChronicle extends FxRefexChronicle<FxRefexCompVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompChronicle() {
      super();
   }

   public FxRefexCompChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
      this.versions =
         FXCollections.observableArrayList(new ArrayList<FxRefexCompVersion>(another.getVersions().size()));

      for (Object v : another.getVersions()) {
         this.versions.add(new FxRefexCompVersion(ss, (RefexNidVersionBI) v));
      }
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP;
   }
}
