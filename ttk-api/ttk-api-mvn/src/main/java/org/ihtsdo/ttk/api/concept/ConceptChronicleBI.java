package org.ihtsdo.ttk.api.concept;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ComponentChroncileBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.ttk.api.changeset.ChangeSetGenerationThreadingPolicy;
import org.ihtsdo.ttk.api.conattr.ConAttrChronicleBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.description.DescriptionChronicleBI;
import org.ihtsdo.ttk.api.media.MediaChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.ttk.api.relationship.group.RelGroupVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Collection;
import org.ihtsdo.ttk.api.ProcessComponentChronicleBI;

public interface ConceptChronicleBI extends ComponentChroncileBI<ConceptVersionBI> {
   void cancel() throws IOException;

   boolean commit(ChangeSetGenerationPolicy changeSetPolicy,
                  ChangeSetGenerationThreadingPolicy changeSetWriterThreading)
           throws IOException;

   /**
    * Returns a longer - more complete - string representation of the chronicle.
    * Useful for diagnostic purposes.
    *
    * @return
    */
   String toLongString();

   //~--- get methods ---------------------------------------------------------

   ConAttrChronicleBI getConAttrs() throws IOException;

   RefexVersionBI<?> getCurrentRefsetMemberForComponent(ViewCoordinate vc, int componentNid)
           throws IOException;
   
   ComponentChroncileBI<?> getComponent(int nid) throws IOException;
   


   Collection<? extends RefexVersionBI<?>> getCurrentRefsetMembers(ViewCoordinate vc) throws IOException;

   /**
     * Retrieves tuples matching the specified view coordinate
     * 
     * @param cuttoffTime
     *          cutoff time to match tuples, tuples with a time greater than
     *          cutoff will no be returned
     * @return List of matching tuples
     * @throws TerminologyException
     */
   public Collection<? extends RefexVersionBI<?>> getCurrentRefsetMembers(ViewCoordinate vc, Long cutoffTime)
           throws IOException;

   Collection<? extends DescriptionChronicleBI> getDescs() throws IOException;

   long getLastModificationSequence();

   Collection<? extends MediaChronicleBI> getMedia() throws IOException;

   RefexChronicleBI<?> getRefsetMemberForComponent(int componentNid) throws IOException;

   Collection<? extends RefexChronicleBI<?>> getRefsetMembers() throws IOException;

   Collection<? extends RelGroupVersionBI> getRelGroups(ViewCoordinate vc)
           throws IOException, ContradictionException;

   Collection<? extends RelationshipChronicleBI> getRelsIncoming() throws IOException;

   Collection<? extends RelationshipChronicleBI> getRelsOutgoing() throws IOException;

   boolean hasCurrentRefsetMemberForComponent(ViewCoordinate vc, int componentNid) throws IOException;

   boolean isAnnotationStyleRefex() throws IOException;

   //~--- set methods ---------------------------------------------------------

   void setAnnotationStyleRefex(boolean annotationSyleRefex);
   
   void processComponentChronicles(ProcessComponentChronicleBI processor) throws Exception;

   boolean isAnnotationIndex() throws IOException;
}