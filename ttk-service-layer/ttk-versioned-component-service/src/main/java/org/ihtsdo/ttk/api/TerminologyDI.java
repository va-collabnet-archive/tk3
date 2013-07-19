package org.ihtsdo.ttk.api;

import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import org.ihtsdo.ttk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.ttk.api.changeset.ChangeSetGeneratorBI;
import org.ihtsdo.ttk.api.conattr.ConceptAttributeVersionBI;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.api.db.DbDependency;

public interface TerminologyDI {
   public static enum CONCEPT_EVENT { PRE_COMMIT, POST_COMMIT, ADD_UNCOMMITTED }

   //~--- methods -------------------------------------------------------------

   void addChangeSetGenerator(String key, ChangeSetGeneratorBI writer);

   void addPropertyChangeListener(TerminologyStoreDI.CONCEPT_EVENT pce, PropertyChangeListener l);

   void addTermChangeListener(TermChangeListener cl);

   void addUncommitted(ConceptChronicleBI cc) throws IOException;

   void addUncommitted(ConceptVersionBI cv) throws IOException;

   void addUncommittedNoChecks(ConceptChronicleBI cc) throws IOException;

   void addUncommittedNoChecks(ConceptVersionBI cv) throws IOException;

   /**
    * Only CONCEPT_EVENT.PRE_COMMIT is a vetoable change
    * @param pce
    * @param l
    */
   void addVetoablePropertyChangeListener(TerminologyStoreDI.CONCEPT_EVENT pce, VetoableChangeListener l);

   void cancel() throws IOException;

   void cancel(ConceptChronicleBI cc) throws IOException;

   void cancel(ConceptVersionBI cv) throws IOException;

   void commit() throws IOException;

   void commit(ConceptChronicleBI cc) throws IOException;

   void commit(ConceptVersionBI cv) throws IOException;

   ChangeSetGeneratorBI createDtoChangeSetGenerator(File changeSetFileName, File changeSetTempFileName,
           ChangeSetGenerationPolicy policy);

   boolean forget(ConceptAttributeVersionBI attr) throws IOException;

   void forget(ConceptChronicleBI concept) throws IOException;

   void forget(DescriptionVersionBI desc) throws IOException;

   void forget(RefexChronicleBI extension) throws IOException;

   void forget(RelationshipVersionBI rel) throws IOException;

   void iterateConceptDataInParallel(ProcessUnfetchedConceptDataBI processor) throws Exception;

   void iterateConceptDataInSequence(ProcessUnfetchedConceptDataBI processor) throws Exception;

   void loadEconFiles(File[] econFiles) throws Exception;

   void loadEconFiles(Path[] econFiles) throws Exception;

   void loadEconFiles(String[] econFileStrings) throws Exception;

   PositionBI newPosition(PathBI path, long time) throws IOException;

   void removeChangeSetGenerator(String key);

   void removeTermChangeListener(TermChangeListener cl);

   void resumeChangeNotifications();

   boolean satisfiesDependencies(Collection<DbDependency> dependencies);

   void suspendChangeNotifications();

   //~--- get methods ---------------------------------------------------------

   NidBitSetBI getAllConceptNids() throws IOException;
   
   NativeIdSetBI getConceptNidsForComponentNids(NativeIdSetBI componentNativeIds) throws IOException;

   NativeIdSetBI getComponentNidsForConceptNids(NativeIdSetBI conceptNativeIds) throws IOException;

   int getAuthorNidForStamp(int sapNid);

   NidBitSetBI getEmptyNidSet() throws IOException;

   ViewCoordinate getMetadataVC() throws IOException;

   int getModuleNidForStamp(int sapNid);

   PathBI getPath(int pathNid) throws IOException;

   int getPathNidForStamp(int sapNid);

   Set<PathBI> getPathSetFromPositionSet(Set<PositionBI> positions) throws IOException;

   Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException;

   Set<PositionBI> getPositionSet(Set<Integer> sapNids) throws IOException;

    Status getStatusForStamp(int stamp);

   long getTimeForStamp(int sapNid);
   
   
   int getNidForUuids(Collection<UUID> uuids) throws IOException;

   Collection<UUID> getUuidCollection(Collection<Integer> nids) throws IOException;
   
   Collection<Integer> getNidCollection(Collection<UUID> uuids) throws IOException;

   int getNidForUuids(UUID... uuids) throws IOException;
   
   int getConceptNidForNid(int nid);
   
   int getNidFromAlternateId(UUID authorityUuid, String altId) throws IOException;
   
   CharSequence informAboutUuid(UUID uuid);
   CharSequence informAboutNid(int nid);
   CharSequence informAboutId(Object id);

}
