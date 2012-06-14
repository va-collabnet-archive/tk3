package org.ihtsdo.fxmodel.concept.component.refex.type_boolean;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexBooleanChronicle extends FxRefexChronicle<FxRefexBooleanVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexBooleanChronicle() {
      super();
   }

   public FxRefexBooleanChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRefexBooleanVersion>(another.getVersions().size()));

      for (Object v : another.getVersions()) {
         this.versions.add(new FxRefexBooleanVersion(ss, (RefexBooleanVersionBI) v));
      }
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.BOOLEAN;
   }
}
