package org.ihtsdo.fxmodel.concept.component.refex.type_comp_string;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_string.RefexNidStringVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompStringChronicle extends FxRefexChronicle<FxRefexCompStringVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompStringChronicle() {
      super();
      this.versions = FXCollections.observableArrayList(new ArrayList<FxRefexCompStringVersion>(1));
   }

   public FxRefexCompStringChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRefexCompStringVersion>(another.getVersions().size()));

      for (Object v : another.getVersions()) {
         this.versions.add(new FxRefexCompStringVersion(this, ss, (RefexNidStringVersionBI) v));
      }
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP_STR;
   }
}
