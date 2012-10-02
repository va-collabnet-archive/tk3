package org.ihtsdo.fxmodel.concept.component.attribute;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.conattr.ConAttrChronicleBI;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;



public class FxConceptAttributesChronicle
        extends FxComponentChronicle<FxConceptAttributesVersion, ConAttrVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxConceptAttributesChronicle() {
      super();
   }

   public FxConceptAttributesChronicle(TerminologySnapshotDI ss, FxConcept concept,
           ConAttrChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxConceptAttributesVersion makeVersion(TerminologySnapshotDI ss, ConAttrVersionBI version)
           throws IOException, ContradictionException {
      return new FxConceptAttributesVersion(this, ss, version);
   }
}
