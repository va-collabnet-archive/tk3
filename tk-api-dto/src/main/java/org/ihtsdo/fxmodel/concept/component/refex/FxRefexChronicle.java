package org.ihtsdo.fxmodel.concept.component.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_boolean.FxRefexBooleanChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp.FxRefexCompChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp.FxRefexCompCompChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp_comp.FxRefexCompCompCompChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp_string.FxRefexCompCompStringChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_float.FxRefexCompFloatChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_int.FxRefexCompIntChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_long.FxRefexCompLongChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_string.FxRefexCompStringChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_int.FxRefexIntChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_long.FxRefexLongChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_member.FxRefexMembershipChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_string.FxRefexStringChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlSeeAlso;
import org.ihtsdo.fxmodel.concept.component.FxComponentVersion;

@XmlSeeAlso( {
   FxRefexBooleanChronicle.class, FxRefexCompChronicle.class, FxRefexCompCompChronicle.class,
   FxRefexCompCompCompChronicle.class, FxRefexCompStringChronicle.class, FxRefexCompIntChronicle.class,
   FxRefexStringChronicle.class, FxRefexLongChronicle.class, FxRefexCompFloatChronicle.class,
   FxRefexIntChronicle.class, FxRefexCompCompStringChronicle.class, FxRefexMembershipChronicle.class,
   FxRefexCompLongChronicle.class
})
public abstract class FxRefexChronicle<V extends FxComponentVersion, T extends RefexVersionBI> 
    extends FxComponentChronicle<V, T> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   protected FxComponentReference componentReference;
   protected FxComponentReference refexReference;

   //~--- constructors --------------------------------------------------------

   public FxRefexChronicle() {
      super();
   }

   public FxRefexChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexVersionBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another);
      this.componentReference = new FxComponentReference(ss, another.getReferencedComponentNid());
      this.refexReference     = new FxComponentReference(ss.getConceptVersion(another.getRefexNid()));
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getComponentReference() {
      return componentReference;
   }

   public FxComponentReference getRefexReference() {
      return refexReference;
   }

   public abstract FX_REFEX_TYPE getType();

   //~--- set methods ---------------------------------------------------------

   public void setComponentReference(FxComponentReference componentReference) {
      this.componentReference = componentReference;
   }

   public void setRefexUuid(FxComponentReference refexRef) {
      this.refexReference = refexRef;
   }
}
