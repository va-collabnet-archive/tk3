package org.ihtsdo.ttk.api.relationship;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.AnalogGeneratorBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TypedComponentVersionBI;
import org.ihtsdo.ttk.api.blueprint.IdDirective;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.blueprint.RefexDirective;
import org.ihtsdo.ttk.api.blueprint.RelationshipCAB;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

/**
 * Interface description
 *
 *
 * @param <A>
 *
 * @version        Enter version here..., 13/04/30
 * @author         Enter your name here...    
 */
public interface RelationshipVersionBI<A extends RelationshipAnalogBI>
        extends TypedComponentVersionBI, RelationshipChronicleBI, AnalogGeneratorBI<A> {

   /**
    * Method description
    *
    *
    * @param vc
    * @param idDirective
    * @param refexDirective
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidCAB
    */
   @Override
   public RelationshipCAB makeBlueprint(ViewCoordinate vc, IdDirective idDirective,
       RefexDirective refexDirective)
           throws IOException, ContradictionException, InvalidCAB;

   /**
    * Method description
    *
    *
    * @return
    */
   public int getCharacteristicNid();

   /**
    * Method description
    *
    *
    * @return
    */
   public int getGroup();

   /**
    * Method description
    *
    *
    * @return
    */
   public int getRefinabilityNid();

   /**
    * Method description
    *
    *
    * @return
    */
   public boolean isInferred();

   /**
    * Method description
    *
    *
    * @return
    */
   public boolean isStated();
}
