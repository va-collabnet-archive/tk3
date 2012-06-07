package org.ihtsdo.fxmodel.concept.component.refex.type_string;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;

public class FxRefexStringChronicle extends FxRefexChronicle<FxRefexStringVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexStringChronicle() {
      super();
   }

   public FxRefexStringChronicle(FxConcept concept, RefexChronicleBI another) throws IOException {
      super(concept, (RefexVersionBI) another.getPrimordialVersion());
      this.versions =
         FXCollections.observableArrayList(new ArrayList<FxRefexStringVersion>(another.getVersions().size()));

      for (Object v : another.getVersions()) {
         this.versions.add(new FxRefexStringVersion((RefexStringVersionBI) v));
      }
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.STR;
   }
}
