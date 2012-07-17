package org.ihtsdo.tk.api;

import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.ihtsdo.tk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.tk.api.changeset.ChangeSetGeneratorBI;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.tk.db.DbDependency;

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

   boolean forget(ConAttrVersionBI attr) throws IOException;

   void forget(ConceptChronicleBI concept) throws IOException;

   void forget(DescriptionVersionBI desc) throws IOException;

   void forget(RefexChronicleBI extension) throws IOException;

   void forget(RelationshipVersionBI rel) throws IOException;

   void iterateConceptDataInParallel(ProcessUnfetchedConceptDataBI processor) throws Exception;

   void iterateConceptDataInSequence(ProcessUnfetchedConceptDataBI processor) throws Exception;

   void loadEconFiles(File[] econFiles) throws Exception;

   void loadEconFiles(String[] econFileStrings) throws Exception;

   PositionBI newPosition(PathBI path, long time) throws IOException;

   void removeChangeSetGenerator(String key);

   void removeTermChangeListener(TermChangeListener cl);

   void resumeChangeNotifications();

   boolean satisfiesDependencies(Collection<DbDependency> dependencies);

   void suspendChangeNotifications();

   //~--- get methods ---------------------------------------------------------

   NidBitSetBI getAllConceptNids() throws IOException;

   int getAuthorNidForSapNid(int sapNid);

   NidBitSetBI getEmptyNidSet() throws IOException;

   ViewCoordinate getMetadataVC() throws IOException;

   int getModuleNidForSapNid(int sapNid);

   PathBI getPath(int pathNid) throws IOException;

   int getPathNidForSapNid(int sapNid);

   Set<PathBI> getPathSetFromPositionSet(Set<PositionBI> positions) throws IOException;

   Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException;

   Set<PositionBI> getPositionSet(Set<Integer> sapNids) throws IOException;

   int getStatusNidForSapNid(int sapNid);

   long getTimeForSapNid(int sapNid);
}
