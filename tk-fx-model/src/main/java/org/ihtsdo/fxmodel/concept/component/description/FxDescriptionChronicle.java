package org.ihtsdo.fxmodel.concept.component.description;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxDescriptionChronicle extends FxComponentChronicle<FxDescriptionVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxDescriptionChronicle() {
      super();
      this.versions =
         FXCollections.observableArrayList(new ArrayList<FxDescriptionVersion>(1));
   }

   public FxDescriptionChronicle(TerminologySnapshotDI ss, FxConcept concept, DescriptionChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another.getPrimordialVersion());
      this.versions =
         FXCollections.observableArrayList(new ArrayList<FxDescriptionVersion>(another.getVersions().size()));

      for (DescriptionVersionBI v : another.getVersions()) {
         this.versions.add(new FxDescriptionVersion(this, ss, v));
      }
   }
}
