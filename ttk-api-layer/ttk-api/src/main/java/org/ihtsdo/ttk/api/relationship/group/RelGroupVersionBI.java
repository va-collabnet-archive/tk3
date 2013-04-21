package org.ihtsdo.ttk.api.relationship.group;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.util.Collection;

public interface RelGroupVersionBI extends RelGroupChronicleBI, ComponentVersionBI {
   Collection<? extends RelationshipVersionBI> getAllCurrentRelVersions();

   Collection<? extends RelationshipVersionBI> getAllRels() throws ContradictionException;

   Collection<? extends RelationshipVersionBI> getCurrentRels() throws ContradictionException;
}
