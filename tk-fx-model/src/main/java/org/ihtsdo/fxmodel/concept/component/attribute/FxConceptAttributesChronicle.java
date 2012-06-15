package org.ihtsdo.fxmodel.concept.component.attribute;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.conattr.ConAttrChronicleBI;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxConceptAttributesChronicle extends FxComponentChronicle<FxConceptAttributesVersion> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxConceptAttributesChronicle() {
      super();
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxConceptAttributesVersion>(1));
   }

   public FxConceptAttributesChronicle(TerminologySnapshotDI ss, FxConcept concept,
           ConAttrChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another.getPrimordialVersion());
      this.versions = FXCollections.observableArrayList(
         new ArrayList<FxConceptAttributesVersion>(another.getVersions().size()));

      for (ConAttrVersionBI v : another.getVersions()) {
         this.versions.add(new FxConceptAttributesVersion(ss, v));
      }
   }
}
