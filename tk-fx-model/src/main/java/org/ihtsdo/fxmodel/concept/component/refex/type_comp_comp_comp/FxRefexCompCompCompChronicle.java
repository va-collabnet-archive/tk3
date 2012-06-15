package org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp_comp;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompCompCompChronicle extends FxRefexChronicle<FxRefexCompCompCompVersion> {
   public static final long serialVersionUID = 1;
   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompCompChronicle() {
      super();
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRefexCompCompCompVersion>(1));
   }

   public FxRefexCompCompCompChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRefexCompCompCompVersion>(another.getVersions().size()));

      for (Object v : another.getVersions()) {
         this.versions.add(new FxRefexCompCompCompVersion(this, ss, (RefexNidNidNidVersionBI) v));
      }
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_COMP_COMP;
   }
}
