package org.ihtsdo.ttk.fx.concept.component.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.fx.FxComponentReference;
import org.ihtsdo.ttk.fx.concept.FxConceptChronicle;
import org.ihtsdo.ttk.fx.concept.component.FxComponentChronicle;
import org.ihtsdo.ttk.fx.concept.component.FxComponentVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_array_of_bytearray.FxRefexArrayOfByteArrayChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_boolean.FxRefexBooleanChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp.FxRefexCompChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_boolean.FxRefexCompBooleanChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp.FxRefexCompCompChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp.FxRefexCompCompCompChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_float.FxRefexCompCompCompFloatChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_int.FxRefexCompCompCompIntChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_long.FxRefexCompCompCompLongChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_string
   .FxRefexCompCompCompStringChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_string.FxRefexCompCompStringChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_float.FxRefexCompFloatChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_int.FxRefexCompIntChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_long.FxRefexCompLongChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_string.FxRefexCompStringChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_int.FxRefexIntChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_long.FxRefexLongChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_member.FxRefexMembershipChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_string.FxRefexStringChronicle;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlSeeAlso;

//J-
@XmlSeeAlso( {
   FxRefexArrayOfByteArrayChronicle.class, 
   FxRefexBooleanChronicle.class, 
   FxRefexCompChronicle.class, 
   FxRefexCompBooleanChronicle.class, 
   FxRefexCompCompChronicle.class,
   FxRefexCompCompCompChronicle.class, 
   FxRefexCompCompCompFloatChronicle.class,
   FxRefexCompCompCompIntChronicle.class,
   FxRefexCompCompCompLongChronicle.class,
   FxRefexCompCompCompStringChronicle.class,
   FxRefexCompCompStringChronicle.class, 
   FxRefexCompFloatChronicle.class,
   FxRefexCompIntChronicle.class,
   FxRefexCompLongChronicle.class,
   FxRefexCompStringChronicle.class, 
   FxRefexIntChronicle.class, 
   FxRefexLongChronicle.class, 
   FxRefexMembershipChronicle.class,
   FxRefexStringChronicle.class, 
})
//J+
public abstract class FxRefexChronicle<V extends FxComponentVersion, T extends RefexVersionBI>
        extends FxComponentChronicle<V, T> {

   /** Field description */
   public static final long serialVersionUID = 1;

   /** Field description */
   protected FxComponentReference referencedComponentReference;

   /** Field description */
   protected FxComponentReference refexExtensionIdentifierReference;

   /**
    * Constructs ...
    *
    */
   public FxRefexChronicle() {
      super();
   }

   /**
    * Constructs ...
    *
    *
    * @param ss
    * @param concept
    * @param another
    *
    * @throws ContradictionException
    * @throws IOException
    */
   public FxRefexChronicle(TerminologySnapshotDI ss, FxConceptChronicle concept, RefexVersionBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another);
      this.referencedComponentReference      = new FxComponentReference(ss,
          another.getReferencedComponentNid());
      this.refexExtensionIdentifierReference =
         new FxComponentReference(ss.getConceptVersion(another.getRefexExtensionNid()));
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public FxComponentReference getReferencedComponentReference() {
      return referencedComponentReference;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public FxComponentReference getRefexExtensionIdentifierReference() {
      return refexExtensionIdentifierReference;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public abstract FX_REFEX_TYPE getType();

   /**
    * Method description
    *
    *
    * @param componentReference
    */
   public void setReferencedComponentReference(FxComponentReference componentReference) {
      this.referencedComponentReference = componentReference;
   }

   /**
    * Method description
    *
    *
    * @param refexRef
    */
   public void setRefexExtensionIdentifierReference(FxComponentReference refexRef) {
      this.refexExtensionIdentifierReference = refexRef;
   }
}
