package org.ihtsdo.ttk.fx.concept.component.attribute;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.concept.component.FxComponentChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.conattr.ConceptAttributeChronicleBI;
import org.ihtsdo.ttk.api.conattr.ConceptAttributeVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;



public class FxConceptAttributesChronicle
        extends FxComponentChronicle<FxConceptAttributesVersion, ConceptAttributeVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxConceptAttributesChronicle() {
      super();
   }

   public FxConceptAttributesChronicle(TerminologySnapshotDI ss, FxConcept concept,
           ConceptAttributeChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxConceptAttributesVersion makeVersion(TerminologySnapshotDI ss, ConceptAttributeVersionBI version)
           throws IOException, ContradictionException {
      return new FxConceptAttributesVersion(this, ss, version);
   }
}
