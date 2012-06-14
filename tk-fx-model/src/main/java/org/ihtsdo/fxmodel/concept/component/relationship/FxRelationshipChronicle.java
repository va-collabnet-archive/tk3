package org.ihtsdo.fxmodel.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRelationshipChronicle extends FxComponentChronicle<FxRelationshipVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRelationshipChronicle() {
      super();
   }

   public FxRelationshipChronicle(TerminologySnapshotDI ss, FxConcept concept,
                                  RelationshipChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another.getPrimordialVersion());
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxRelationshipVersion>(another.getVersions().size()));

      for (RelationshipVersionBI v : another.getVersions()) {
         this.versions.add(new FxRelationshipVersion(ss, v));
      }
   }
}
