package org.ihtsdo.cs.econcept;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;

import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.db.bdb.BdbProperty;

import org.ihtsdo.helper.time.TimeHelper;
import org.ihtsdo.temp.AceLog;
import org.ihtsdo.temp.I_Count;
import org.ihtsdo.temp.I_ReadChangeSet;
import org.ihtsdo.tk.dto.concept.TkConcept;

public class EConceptChangeSetReader implements I_ReadChangeSet {

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;

    private File changeSetFile;

    private File csreFile;
    private transient FileWriter csreOut;
    private File csrcFile;
    private transient FileWriter csrcOut;

    private I_Count counter;

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
                AceLog.getAppLog().info("No next commit time for file: " + changeSetFile);
                nextCommit = Long.MAX_VALUE;
                nextCommitStr = "end of time";
            }
        }
        return nextCommit;
    }

   @Override
    public void readUntil(long endTime) throws IOException, ClassNotFoundException {
        if (AceLog.getEditLog().isLoggable(Level.INFO)) {
            AceLog.getEditLog().info(
                "Reading from log " + changeSetFile.getName() + " until " +
                TimeHelper.getFileDateFormat().format(new Date(endTime)));
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
                //AceLog.getEditLog().info("Reading change set entry: \n" + eConcept);
                count++;
                if (counter != null) {
                    counter.increment();
                }
                        conceptCount++;
                        if (AceLog.getEditLog().isLoggable(Level.FINE)) {
                            AceLog.getEditLog().fine("Read eConcept... " + eConcept);
                        }
                        if (!noCommit) {
                            commitEConcept(eConcept, nextCommit);
                        }
                 nextCommit = dataStream.readLong();
            } catch (EOFException ex) {
                dataStream.close();
                if (changeSetFile.length() == 0) {
                    changeSetFile.delete();
                }
                AceLog.getEditLog().info(
                    "\n  +++++----------------\n End of change set: " + changeSetFile.getName()
                        + "\n  +++++---------------\n");
                nextCommit = Long.MAX_VALUE;
                Bdb.setProperty(changeSetFile.getName(),
                    Long.toString(changeSetFile.length()));
                Bdb.setProperty(BdbProperty.LAST_CHANGE_SET_READ.toString(),
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
        Concept.resolveUnresolvedAnnotations();
        AceLog.getAppLog().info(
            "Change set " + changeSetFile.getName() + " contains " + count + " change objects. "
                + "\n unvalidated objects: " + unvalidated + "\n imported concepts: " + conceptCount);

    }

   @Override
    public void read() throws IOException, ClassNotFoundException {
        readUntil(Long.MAX_VALUE);
    }


    private Concept commitEConcept(TkConcept eConcept, long time) throws IOException,
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

                Concept before = Concept.get(Bdb.uuidToNid(eConcept.getPrimordialUuid()));
                csrcOut.append(before.toLongString());
                csrcOut.flush();
                Concept after = Concept.mergeAndWrite(eConcept);
                csrcOut.append("\n----------- after  -----------\n");
                csrcOut.append(after.toLongString());
                return after;
            } else {
            	if (!fileContentMerged) {
	                int conceptNid = Bdb.uuidToNid(eConcept.getPrimordialUuid());
	                long lastChange = Concept.get(conceptNid).getData().getLastChange();

	                Concept mergedConcept =  Concept.mergeAndWrite(eConcept);
	                
	                if (mergedConcept.getData().getLastChange() != lastChange) {
	                	fileContentMerged = true;
	                }
	                
	                return mergedConcept;
            	} else {
            		return Concept.mergeAndWrite(eConcept);
            	}
            }
        } catch (Exception e) {
            AceLog.getEditLog().severe(
                "Error committing bean in change set: " + changeSetFile + "\nUniversalAceBean:  \n" + eConcept);
            throw new IOException(e);
        }
    }

    private void lazyInit() throws FileNotFoundException, IOException, ClassNotFoundException {
        String lastImportSize = Bdb.getProperty(changeSetFile.getName());
        if (lastImportSize != null) {
            long lastSize = Long.parseLong(lastImportSize);
            if (lastSize == changeSetFile.length()) {
                AceLog.getAppLog().finer(
                    "Change set already fully read: " + changeSetFile.getName());
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
    public void setCounter(I_Count counter) {
        this.counter = counter;
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
