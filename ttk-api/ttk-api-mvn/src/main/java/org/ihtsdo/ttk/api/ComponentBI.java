package org.ihtsdo.ttk.api;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.id.IdBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface ComponentBI {
   boolean addAnnotation(RefexChronicleBI<?> annotation) throws IOException;

   String toUserString();

   //~--- get methods ---------------------------------------------------------

   Collection<? extends IdBI> getAdditionalIds() throws IOException;

   Collection<? extends IdBI> getAllIds() throws IOException;

   Collection<? extends RefexChronicleBI<?>> getAnnotations() throws IOException;

   int getConceptNid();

   Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz) throws IOException;

   <T extends RefexVersionBI<?>> Collection<T> getCurrentAnnotationMembers(ViewCoordinate xyz, Class<T> cls)
           throws IOException;

   Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz, int refexNid)
           throws IOException;

   <T extends RefexVersionBI<?>> Collection<T> getCurrentAnnotationMembers(ViewCoordinate xyz, int refexNid,
           Class<T> cls)
           throws IOException;

   Collection<? extends RefexVersionBI<?>> getCurrentRefexMembers(ViewCoordinate xyz, int refsetNid)
           throws IOException;

   Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz) throws IOException;

   /**
    *
    * @param xyz
    * @param refsetNid
    * @return
    * @throws IOException
    * @deprecated use getCurrentRefexMembers
    */
   @Deprecated
   Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz, int refsetNid)
           throws IOException;

   Collection<? extends RefexVersionBI<?>> getInactiveRefexes(ViewCoordinate xyz) throws IOException;

   int getNid();

   /**
    *
    * @return the primordial if known. The IUnknown UUID (00000000-0000-0000-C000-000000000046) if not known.
    */
   UUID getPrimUuid();

   Collection<? extends RefexChronicleBI<?>> getRefexMembers(int refsetNid) throws IOException;

   Collection<? extends RefexChronicleBI<?>> getRefexes() throws IOException;

   /**
    *
    * @param refsetNid
    * @return
    * @throws IOException
    * @deprecated use getRefexMembers
    */
   @Deprecated
   Collection<? extends RefexChronicleBI<?>> getRefexes(int refsetNid) throws IOException;

   List<UUID> getUUIDs();

   boolean hasCurrentAnnotationMember(ViewCoordinate xyz, int refsetNid) throws IOException;

   boolean hasCurrentRefexMember(ViewCoordinate xyz, int refsetNid) throws IOException;
}
