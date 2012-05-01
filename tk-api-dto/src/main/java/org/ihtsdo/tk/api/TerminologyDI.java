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

   void addUncommitted(ConceptChronicleBI cc) throws IOException;

   void addUncommitted(ConceptVersionBI cv) throws IOException;

   void commit() throws IOException;

   void cancel() throws IOException;

   void commit(ConceptChronicleBI cc) throws IOException;

   void cancel(ConceptChronicleBI cc) throws IOException;

   void commit(ConceptVersionBI cv) throws IOException;

   void cancel(ConceptVersionBI cv) throws IOException;

   void addChangeSetGenerator(String key, ChangeSetGeneratorBI writer);

   void removeChangeSetGenerator(String key);

   ChangeSetGeneratorBI createDtoChangeSetGenerator(File changeSetFileName,
           File changeSetTempFileName,
           ChangeSetGenerationPolicy policy);

   Set<PositionBI> getPositionSet(Set<Integer> sapNids) throws IOException;

   Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException;

   Set<PathBI> getPathSetFromPositionSet(Set<PositionBI> positions) throws IOException;
   
   PathBI getPath(int pathNid) throws IOException;

    void addPropertyChangeListener(TerminologyStoreDI.CONCEPT_EVENT pce, PropertyChangeListener l);

    void addTermChangeListener(TermChangeListener cl);

    /**
     * Only CONCEPT_EVENT.PRE_COMMIT is a vetoable change
     * @param pce
     * @param l
     */
    void addVetoablePropertyChangeListener(TerminologyStoreDI.CONCEPT_EVENT pce, VetoableChangeListener l);

    void forget(ConAttrVersionBI attr) throws IOException;

    void forget(ConceptChronicleBI concept) throws IOException;

    void forget(DescriptionVersionBI desc) throws IOException;

    void forget(RefexChronicleBI extension) throws IOException;

    void forget(RelationshipVersionBI rel) throws IOException;

    NidBitSetBI getAllConceptNids() throws IOException;

    NidBitSetBI getEmptyNidSet() throws IOException;

    ViewCoordinate getMetadataVC() throws IOException;

    void iterateConceptDataInParallel(ProcessUnfetchedConceptDataBI processor) throws Exception;

    void iterateConceptDataInSequence(ProcessUnfetchedConceptDataBI processor) throws Exception;

    void loadEconFiles(File[] econFiles) throws Exception;

    PositionBI newPosition(PathBI path, long time) throws IOException;

    void removeTermChangeListener(TermChangeListener cl);

    boolean satisfiesDependencies(Collection<DbDependency> dependencies);

    public static enum CONCEPT_EVENT {

        PRE_COMMIT, POST_COMMIT, ADD_UNCOMMITTED
    }
}
