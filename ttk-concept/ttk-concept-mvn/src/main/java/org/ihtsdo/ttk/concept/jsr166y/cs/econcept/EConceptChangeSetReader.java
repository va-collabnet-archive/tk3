package org.ihtsdo.ttk.concept.jsr166y.cs.econcept;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;

import org.ihtsdo.ttk.concept.cc.concept.Concept;

import org.ihtsdo.ttk.helpers.time.TimeHelper;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.jsr166y.cs.ChangeSetLogger;
import org.ihtsdo.ttk.concept.jsr166y.cs.CsProperty;
import org.ihtsdo.ttk.concept.jsr166y.cs.ChangeSetReaderI;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.dto.TkConcept;

public class EConceptChangeSetReader implements ChangeSetReaderI {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private File changeSetFile;
    private File csreFile;
    private transient FileWriter csreOut;
    private File csrcFile;
    private transient FileWriter csrcOut;
    private DataInputStream dataStream;
    private int count = 0;
    private int conceptCount = 0;
    private int unvalidated = 0;
    private boolean initialized = false;
    private Long nextCommit;
    private String nextCommitStr;
    private boolean noCommit = false;

    public boolean isNoCommit() {
        return noCommit;
    }

    public void setNoCommit(boolean noCommit) {
        this.noCommit = noCommit;
    }
    private boolean fileContentMerged = false;

    public EConceptChangeSetReader() {
        super();
    }

    @Override
    public long nextCommitTime() throws IOException, ClassNotFoundException {
        lazyInit();
        if (nextCommit == null) {
            try {
                nextCommit = dataStream.readLong();
                assert nextCommit != Long.MAX_VALUE;
                nextCommitStr = TimeHelper.getFileDateFormat().format(new Date(nextCommit));
            } catch (EOFException e) {
                ChangeSetLogger.logger.log(Level.INFO, "No next commit time for file: {0}", changeSetFile);
                nextCommit = Long.MAX_VALUE;
                nextCommitStr = "end of time";
            }
        }
        return nextCommit;
    }

    @Override
    public void readUntil(long endTime, Set<ConceptChronicleBI> indexedAnnotationConcepts) throws IOException, ClassNotFoundException {
        if (ChangeSetLogger.logger.isLoggable(Level.INFO)) {
            ChangeSetLogger.logger.log(
                    Level.INFO, "Reading from log {0} until {1}", new Object[]{changeSetFile.getName(), TimeHelper.getFileDateFormat().format(new Date(endTime))});
        }
        while ((nextCommitTime() <= endTime) && (nextCommitTime() != Long.MAX_VALUE)) {
            try {
                TkConcept eConcept = new TkConcept(dataStream);
                if (csreOut != null) {
                    csreOut.append("\n*******************************\n");
                    csreOut.append(TimeHelper.formatDateForFile(nextCommitTime()));
                    csreOut.append("\n*******************************\n");
                    csreOut.append(eConcept.toString());
                }
                if (ChangeSetLogger.logger.isLoggable(Level.FINE)) {
                    ChangeSetLogger.logger.log(Level.FINE, "Reading change set entry: \n{0}", eConcept);
                }
                count++;
                conceptCount++;
                if (ChangeSetLogger.logger.isLoggable(Level.FINE)) {
                    ChangeSetLogger.logger.log(Level.FINE, "Read eConcept... {0}", eConcept);
                }
                if (!noCommit) {
                    commitEConcept(eConcept, nextCommit, indexedAnnotationConcepts);
                }
                nextCommit = dataStream.readLong();
            } catch (EOFException ex) {
                dataStream.close();
                if (changeSetFile.length() == 0) {
                    changeSetFile.delete();
                }
                ChangeSetLogger.logger.log(
                        Level.INFO, "\n  +++++----------------\n End of change set: {0}\n  +++++---------------\n", changeSetFile.getName());
                nextCommit = Long.MAX_VALUE;
                P.s.setProperty(changeSetFile.getName(),
                        Long.toString(changeSetFile.length()));
                P.s.setProperty(CsProperty.LAST_CHANGE_SET_READ.toString(),
                        changeSetFile.getName());
                if (csreOut != null) {
                    csreOut.flush();
                    csreOut.close();
                    csreFile.delete();
                }
                if (csrcOut != null) {
                    csrcOut.flush();
                    csrcOut.close();
                    csrcFile.delete();
                }
            } catch (Exception e) {
                throw new IOException(e);
            }
        }
        Concept.resolveUnresolvedAnnotations(indexedAnnotationConcepts);
        ChangeSetLogger.logger.log(
                Level.INFO, "Change set {0} contains {1}" + " change objects. " + "\n unvalidated objects: {2}\n imported concepts: {3}", new Object[]{changeSetFile.getName(), count, unvalidated, conceptCount});

    }

    @Override
    public void read(Set<ConceptChronicleBI> indexedAnnotationConcepts) throws IOException, ClassNotFoundException {
        readUntil(Long.MAX_VALUE, indexedAnnotationConcepts);
    }

    private Concept commitEConcept(TkConcept eConcept, long time, Set<ConceptChronicleBI> indexedAnnotationConcepts) throws IOException,
            ClassNotFoundException {
        if (noCommit) {
            return null;
        }
        try {
            assert time != Long.MAX_VALUE;
            if (EConceptChangeSetWriter.writeDebugFiles) {
                csrcOut.append("\n*******************************\n");
                csrcOut.append(TimeHelper.formatDateForFile(time));
                csrcOut.append("\n********** before ***********\n");

                Concept before = Concept.get(P.s.getNidForUuids(eConcept.getPrimordialUuid()));
                csrcOut.append(before.toLongString());
                csrcOut.flush();
                Concept after = Concept.mergeAndWrite(eConcept, indexedAnnotationConcepts);
                csrcOut.append("\n----------- after  -----------\n");
                csrcOut.append(after.toLongString());
                return after;
            } else {
                if (!fileContentMerged) {
                    int conceptNid = P.s.getNidForUuids(eConcept.getPrimordialUuid());
                    long lastChange = Concept.get(conceptNid).getData().getLastChange();

                    Concept mergedConcept = Concept.mergeAndWrite(eConcept, indexedAnnotationConcepts);

                    if (mergedConcept.getData().getLastChange() != lastChange) {
                        fileContentMerged = true;
                    }

                    return mergedConcept;
                } else {
                    return Concept.mergeAndWrite(eConcept, indexedAnnotationConcepts);
                }
            }
        } catch (Exception e) {
            ChangeSetLogger.logger.log(
                    Level.SEVERE, "Error committing bean in change set: {0}\nUniversalAceBean:  \n{1}", new Object[]{changeSetFile, eConcept});
            throw new IOException(e);
        }
    }

    private void lazyInit() throws FileNotFoundException, IOException, ClassNotFoundException {
        String lastImportSize = P.s.getProperty(changeSetFile.getName());
        if (lastImportSize != null) {
            long lastSize = Long.parseLong(lastImportSize);
            if (lastSize == changeSetFile.length()) {
                ChangeSetLogger.logger.log(
                        Level.FINER, "Change set already fully read: {0}", changeSetFile.getName());
                // already imported, set to nothing to do...
                nextCommit = Long.MAX_VALUE;
                initialized = true;
            }
        }
        if (initialized == false) {
            FileInputStream fis = new FileInputStream(changeSetFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            dataStream = new DataInputStream(bis);

            if (EConceptChangeSetWriter.writeDebugFiles) {
                csreFile = new File(changeSetFile.getParentFile(), changeSetFile.getName() + ".csre");
                csreOut = new FileWriter(csreFile, true);
                csrcFile = new File(changeSetFile.getParentFile(), changeSetFile.getName() + ".csrc");
                csrcOut = new FileWriter(csrcFile, true);
            }
            initialized = true;
        }
    }

    @Override
    public File getChangeSetFile() {
        return changeSetFile;
    }

    @Override
    public void setChangeSetFile(File changeSetFile) {
        this.changeSetFile = changeSetFile;
    }

    @Override
    public int availableBytes() throws FileNotFoundException, IOException, ClassNotFoundException {
        lazyInit();
        if (dataStream != null) {
            return dataStream.available();
        }
        return 0;
    }

    @Override
    public boolean isContentMerged() {
        return fileContentMerged;
    }
}
