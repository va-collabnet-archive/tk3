package org.ihtsdo.ttk.fx.concept.component.refex.type_array_of_bytearray;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayVersionBI;
import org.ihtsdo.ttk.fx.concept.FxConceptChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.FX_REFEX_TYPE;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class description
 *
 *
 * @version        Enter version here..., 13/04/25
 * @author         Enter your name here...    
 */
@XmlRootElement()
public class FxRefexArrayOfByteArrayChronicle
        extends FxRefexChronicle<FxRefexArrayOfByteArrayVersion, RefexArrayOfBytearrayVersionBI> {

   /** Field description */
   public static final long serialVersionUID = 1;

   /**
    * Constructs ...
    *
    */
   public FxRefexArrayOfByteArrayChronicle() {
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
   public FxRefexArrayOfByteArrayChronicle(TerminologySnapshotDI ss, FxConceptChronicle concept,
       RefexChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, (RefexVersionBI) another.getPrimordialVersion());
   }

   /**
    * Method description
    *
    *
    * @param ss
    * @param version
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    */
   @Override
   protected FxRefexArrayOfByteArrayVersion makeVersion(TerminologySnapshotDI ss,
       RefexArrayOfBytearrayVersionBI version)
           throws IOException, ContradictionException {
      return new FxRefexArrayOfByteArrayVersion(this, ss, version);
   }

   /**
    * Method description
    *
    *
    * @return
    */
   @Override
   public FX_REFEX_TYPE getType() {
      return FX_REFEX_TYPE.COMP;
   }
}
