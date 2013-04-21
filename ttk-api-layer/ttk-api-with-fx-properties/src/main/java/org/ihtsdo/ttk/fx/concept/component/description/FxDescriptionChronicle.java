package org.ihtsdo.ttk.fx.concept.component.description;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.concept.component.FxComponentChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.description.DescriptionChronicleBI;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxDescriptionChronicle extends FxComponentChronicle<FxDescriptionVersion, DescriptionVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxDescriptionChronicle() {
      super();
   }

   public FxDescriptionChronicle(TerminologySnapshotDI ss, FxConcept concept, DescriptionChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another.getPrimordialVersion());
   }

    @Override
    protected FxDescriptionVersion makeVersion(TerminologySnapshotDI ss, DescriptionVersionBI version) throws IOException, ContradictionException {
        return new FxDescriptionVersion(this, ss, version);
    }
}