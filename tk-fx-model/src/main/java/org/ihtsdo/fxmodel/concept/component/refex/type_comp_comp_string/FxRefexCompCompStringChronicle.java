package org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp_string;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

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

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompCompStringChronicle extends FxRefexChronicle<FxRefexCompCompStringVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompStringChronicle() {
      super();
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRefexCompCompStringVersion>(1));
   }

   public FxRefexCompCompStringChronicle(TerminologySnapshotDI ss, FxConcept concept,
           RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRefexCompCompStringVersion>(another.getVersions().size()));

      for (Object v : another.getVersions()) {
         this.versions.add(new FxRefexCompCompStringVersion(this, ss, (RefexNidNidStringVersionBI) v));
      }
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_COMP_STR;
   }
}
