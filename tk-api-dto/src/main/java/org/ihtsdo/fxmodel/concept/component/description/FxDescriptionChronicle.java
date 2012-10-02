package org.ihtsdo.fxmodel.concept.component.description;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;

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
