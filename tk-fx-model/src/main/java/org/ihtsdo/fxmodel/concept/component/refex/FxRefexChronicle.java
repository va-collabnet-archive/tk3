package org.ihtsdo.fxmodel.concept.component.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.FxComponentRef;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.fxmodel.concept.component.FxVersion;
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

@XmlSeeAlso( {
   FxRefexBooleanChronicle.class, FxRefexCompChronicle.class, FxRefexCompCompChronicle.class,
   FxRefexCompCompCompChronicle.class, FxRefexCompStringChronicle.class, FxRefexCompIntChronicle.class,
   FxRefexStringChronicle.class, FxRefexLongChronicle.class, FxRefexCompFloatChronicle.class,
   FxRefexIntChronicle.class, FxRefexCompCompStringChronicle.class, FxRefexMembershipChronicle.class,
   FxRefexCompLongChronicle.class
})
public abstract class FxRefexChronicle<V extends FxVersion> extends FxComponentChronicle<V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   protected FxComponentRef componentRef;
   protected FxComponentRef refexRef;

   //~--- constructors --------------------------------------------------------

   public FxRefexChronicle() {
      super();
   }

   public FxRefexChronicle(TerminologySnapshotDI ss, FxConcept concept, RefexVersionBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another);
      this.componentRef = new FxComponentRef(ss, another.getReferencedComponentNid());
      this.refexRef     = new FxComponentRef(ss.getConceptVersion(another.getRefexNid()));
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentRef getComponentRef() {
      return componentRef;
   }

   public FxComponentRef getRefexRef() {
      return refexRef;
   }

   public abstract FX_REFEX_TYPE getType();

   //~--- set methods ---------------------------------------------------------

   public void setComponentRef(FxComponentRef componentRef) {
      this.componentRef = componentRef;
   }

   public void setRefexUuid(FxComponentRef refexRef) {
      this.refexRef = refexRef;
   }
}
