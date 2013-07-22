package org.ihtsdo.ttk.fx.concept.component.attribute;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.ttk.fx.concept.FxConceptChronicle;
import org.ihtsdo.ttk.fx.concept.component.FxComponentChronicle;
import org.ihtsdo.otf.tcc.api.ContradictionException;
import org.ihtsdo.otf.tcc.api.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.conattr.ConceptAttributeChronicleBI;
import org.ihtsdo.otf.tcc.api.conattr.ConceptAttributeVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;



public class FxConceptAttributesChronicle
        extends FxComponentChronicle<FxConceptAttributesVersion, ConceptAttributeVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxConceptAttributesChronicle() {
      super();
   }

   public FxConceptAttributesChronicle(TerminologySnapshotDI ss, FxConceptChronicle concept,
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
