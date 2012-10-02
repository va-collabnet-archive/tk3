package org.ihtsdo.fxmodel.concept.component.refex.type_member;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_member.RefexMemberVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexMembershipChronicle
        extends FxRefexChronicle<FxRefexMembershipVersion, RefexMemberVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public FxRefexMembershipChronicle() {
      super();
   }

   public FxRefexMembershipChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected FxRefexMembershipVersion makeVersion(TerminologySnapshotDI ss, RefexMemberVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexMembershipVersion(this, ss, version);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.MEMBER;
   }
}
