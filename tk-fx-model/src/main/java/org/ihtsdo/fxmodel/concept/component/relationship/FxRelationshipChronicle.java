package org.ihtsdo.fxmodel.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;

public class FxRelationshipChronicle extends FxComponentChronicle<FxRelationshipVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRelationshipChronicle() {
      super();
   }

   public FxRelationshipChronicle(FxConcept concept, RelationshipChronicleBI another) throws IOException {
      super(concept, another.getPrimordialVersion());
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRelationshipVersion>(another.getVersions().size()));

      for (RelationshipVersionBI v : another.getVersions()) {
         this.versions.add(new FxRelationshipVersion(v));
      }
   }
}
