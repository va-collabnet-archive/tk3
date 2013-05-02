package org.ihtsdo.ttk.api.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.AnalogGeneratorBI;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.blueprint.IdDirective;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexDirective;
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
public interface RefexVersionBI<A extends RefexAnalogBI<A>>
        extends ComponentVersionBI, RefexChronicleBI<A>, AnalogGeneratorBI<A> {

   /**
    * @param viewCoordinate the view coordinate specifying which version of the
    * description to make a blueprint of
    * @param idDirective
    * @param refexDirective
    * @return the refex blueprint, which can be constructed to create a <code>RefexChronicleBI</code>
    * @throws IOException signals that an I/O exception has occurred
    * @throws ContradictionException if more than one version of the
    * description was returned for the specified view coordinate
    * @throws InvalidCAB if the any of the values in blueprint to make are
    * invalid
    * @see org.ihtsdo.tk.api.blueprint.CreateOrAmendBlueprint
    */
   @Override
   RefexCAB makeBlueprint(ViewCoordinate viewCoordinate, IdDirective idDirective,
                          RefexDirective refexDirective)
           throws IOException, InvalidCAB, ContradictionException;

   /**
    * Method description
    *
    *
    * @param another
    *
    * @return
    */
   boolean refexFieldsEqual(RefexVersionBI another);
}
