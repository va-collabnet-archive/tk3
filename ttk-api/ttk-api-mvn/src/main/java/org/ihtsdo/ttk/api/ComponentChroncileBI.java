package org.ihtsdo.ttk.api;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;

import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

public interface ComponentChroncileBI<T extends ComponentVersionBI>
        extends ComponentBI {

    T getVersion(ViewCoordinate c) throws ContradictionException;

    Collection<? extends T> getVersions(ViewCoordinate c);

    Collection<? extends T> getVersions();

    boolean isUncommitted();

    Set<Integer> getAllStamps() throws IOException;
    
    Set<PositionBI> getPositions() throws IOException;
    
    T getPrimordialVersion();
    
    boolean makeAdjudicationAnalogs(EditCoordinate ec, ViewCoordinate vc) throws Exception;
    
    ConceptChronicleBI getEnclosingConcept();

}
