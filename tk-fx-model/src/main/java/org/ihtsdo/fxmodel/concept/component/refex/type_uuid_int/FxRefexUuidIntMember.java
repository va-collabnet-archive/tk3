package org.ihtsdo.fxmodel.concept.component.refex.type_uuid_int;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_int.RefexNidIntVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;

public class FxRefexUuidIntMember extends FxRefexChronicle<FxRefexUuidIntRevision> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexUuidIntMember() {
      super();
   }

   public FxRefexUuidIntMember(FxConcept concept, RefexChronicleBI another) throws IOException {
      super(concept, (RefexVersionBI) another.getPrimordialVersion());
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRefexUuidIntRevision>(another.getVersions().size()));

      for (Object v : another.getVersions()) {
         this.versions.add(new FxRefexUuidIntRevision((RefexNidIntVersionBI) v));
      }
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.CID_INT;
   }
}
