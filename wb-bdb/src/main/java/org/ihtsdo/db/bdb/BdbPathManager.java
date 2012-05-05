/**
 * Copyright (c) 2009 International Health Terminology Standards Development Organisation
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.ihtsdo.db.bdb;

//~--- non-JDK imports --------------------------------------------------------
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.refex.RefexMember;
import org.ihtsdo.cc.refex.type_nid.NidMember;
import org.ihtsdo.cc.refex.type_nid_int.NidIntMember;
import org.ihtsdo.cc.refex.type_nid_long.NidLongMember;
import org.ihtsdo.cc.ReferenceConcepts;
import org.ihtsdo.temp.AceLog;
import org.ihtsdo.tk.api.Path;
import org.ihtsdo.tk.api.PathBI;
import org.ihtsdo.tk.api.Position;
import org.ihtsdo.tk.api.PositionBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.type_nid_long.RefexNidLongVersionBI;

/**
 * Path management.
 *
 * Defines methods for obtaining and modifying paths. Paths are now stored/defined in reference sets
 * (extension by reference).
 *
 * This implementation avoids the use of the redundant Path store and instead marshals to to the Extension
 * store (indirectly).
 *
 */
public class BdbPathManager {

    private static final Logger logger = Logger.getLogger(BdbPathManager.class.getName());
    private static Lock l = new ReentrantLock();
    private static BdbPathManager singleton;
    //~--- fields --------------------------------------------------------------
//   private RefsetHelperGetter       helperGetter = new RefsetHelperGetter();
    protected PathBI editPath;
    ConcurrentHashMap<Integer, PathBI> pathMap;
    private Concept pathRefsetConcept;
    private Concept refsetPathOriginsConcept;

    //~--- constructors --------------------------------------------------------
    private BdbPathManager() throws IOException {
        try {
            editPath = new Path(ReferenceConcepts.TERM_AUXILIARY_PATH.getNid(), null);
            setupPathMap();
        } catch (Exception e) {
            throw new IOException("Unable to initialise path management.", e);
        }
    }

    //~--- methods -------------------------------------------------------------
    public boolean exists(int cNid) throws IOException {
        if (pathMap.containsKey(cNid)) {
            return true;
        }

        return getFromDisk(cNid) != null;
    }

    public boolean existsFast(int cNid) throws IOException {
        if (pathMap.containsKey(cNid)) {
            return true;
        }

        return false;
    }

    public synchronized void resetPathMap() throws IOException {
        pathMap = null;
        setupPathMap();
    }

    @SuppressWarnings("unchecked")
    private void setupPathMap() throws IOException {
        if (pathMap == null) {
            pathMap = new ConcurrentHashMap<Integer, PathBI>();

            try {
                getPathRefsetConcept();

                for (RefexMember extPart : getPathRefsetConcept().getExtensions()) {
                    NidMember conceptExtension = (NidMember) extPart;
                    int pathId = conceptExtension.getC1Nid();

                    pathMap.put(pathId, new Path(pathId, getPathOriginsFromDb(pathId)));
                }
            } catch (Exception e) {
                throw new IOException("Unable to retrieve all paths.", e);
            }
        }
    }

//   /**
//    * Set an origin on a path
//    */
//   public void writeOrigin(final PathBI path, final PositionBI origin, I_ConfigAceFrame config)
//           throws IOException {
//      assert path.getOrigins().contains(origin) : "Must add origin: " + origin + " before writing: " + path;
//
////      RefsetHelper refsetHelper = helperGetter.get(config);
//
//      try {
//         RefsetPropertyMap propMap = new RefsetPropertyMap().with(
//                                         RefsetPropertyMap.REFSET_PROPERTY.CID_ONE,
//                                         origin.getPath().getConceptNid()).with(
//                                            RefsetPropertyMap.REFSET_PROPERTY.INTEGER_VALUE,
//                                            origin.getVersion());
//
////         if (refsetHelper.hasCurrentRefsetExtension(ReferenceConcepts.REFSET_PATH_ORIGINS.getNid(),
////                 path.getConceptNid(), propMap)) {
////
////            // Skip already exists
////            return;
////         }
//
//         // Retire any positions that may exist that just have a different
//         // version (time) point
//         propMap = new RefsetPropertyMap().with(RefsetPropertyMap.REFSET_PROPERTY.CID_ONE,
//                 origin.getPath().getConceptNid());
//         refsetHelper.retireRefsetExtension(ReferenceConcepts.REFSET_PATH_ORIGINS.getNid(),
//                                            path.getConceptNid(), propMap);
//         propMap = new RefsetPropertyMap().with(RefsetPropertyMap.REFSET_PROPERTY.CID_ONE,
//                 origin.getPath().getConceptNid()).with(RefsetPropertyMap.REFSET_PROPERTY.INTEGER_VALUE,
//                    origin.getVersion());
//
//         // Create the new origin/position
//         refsetHelper.newRefsetExtension(ReferenceConcepts.REFSET_PATH_ORIGINS.getNid(),
//                                         path.getConceptNid(), EConcept.REFSET_TYPES.CID_INT, propMap,
//                                         config);
//
//         Concept pathOriginRefConcept = getRefsetPathOriginsConcept();
//
//         BdbCommitManager.addUncommittedNoChecks(pathOriginRefConcept);
//         pathMap.put(path.getConceptNid(), (Path) path);
//      } catch (Exception e) {
//         throw new IOException("Unable to write path origin: " + origin + " to path " + path, e);
//      }
//   }
    //~--- get methods ---------------------------------------------------------
    public static BdbPathManager get() {
        if (singleton == null) {
            l.lock();

            try {
                if (singleton == null) {
                    try {
                        BdbPathManager mgr = new BdbPathManager();

                        singleton = mgr;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } finally {
                l.unlock();
            }
        }

        return singleton;
    }

    public static void reset() {
        if (singleton != null) {
            l.lock();
            try {
                singleton = null;
            } finally {
                l.unlock();
            }
        }
    }

    public PathBI get(int nid) throws IOException {
        if (exists(nid)) {
            return pathMap.get(nid);
        } else {
            PathBI p = getFromDisk(nid);

            if (p != null) {
                return p;
            }
        }
        pathMap.put(
                nid,
                pathMap.get(ReferenceConcepts.TERM_AUXILIARY_PATH.getNid()));

        return pathMap.get(nid);
    }

    public Set<PathBI> getAll() {
        return new HashSet<PathBI>(pathMap.values());
    }

    public List<PositionBI> getAllPathOrigins(int nid) throws IOException {
        PathBI p = pathMap.get(nid);

        if (p == null) {
            p = getFromDisk(nid);
        }

        return new ArrayList<PositionBI>(p.getInheritedOrigins());
    }

    @SuppressWarnings("unchecked")
    private PathBI getFromDisk(int cNid) throws IOException {
        try {
            for (RefexMember extPart : getPathRefsetConcept().getExtensions()) {
                NidMember conceptExtension = (NidMember) extPart;
                int pathId = conceptExtension.getC1Nid();

                if (pathId == cNid) {
                    pathMap.put(pathId, new Path(pathId, getPathOriginsFromDb(pathId)));

                    return pathMap.get(cNid);
                }
            }
        } catch (Exception e) {
            throw new IOException("Unable to retrieve all paths.", e);
        }

        return null;
    }

    public List<PathBI> getPathChildren(int nid) {
        List<PathBI> children = new ArrayList<PathBI>();

        for (PathBI p : pathMap.values()) {
            if (p.getOrigins() != null) {
                for (PositionBI origin : p.getOrigins()) {
                    if (origin.getPath().getConceptNid() == nid) {
                        children.add(p);
                    }
                }
            }
        }

        return children;
    }

    @SuppressWarnings("unchecked")
    public Set<Integer> getPathNids() throws IOException {
        try {
            HashSet<Integer> result = new HashSet<Integer>();

            for (RefexMember extPart : getPathRefsetConcept().getExtensions()) {
                RefexNidLongVersionBI conceptExtension = (RefexNidLongVersionBI) extPart;

                result.add(conceptExtension.getNid1());
            }

            return result;
        } catch (Exception e) {
            throw new IOException("Unable to retrieve all paths.", e);
        }
    }

    public Collection<? extends PositionBI> getPathOrigins(int nid) throws IOException {
        try {
            PathBI p = pathMap.get(nid);

            return p.getOrigins();
        } catch (Exception e) {
            throw new IOException("Unable to retrieve path children.", e);
        }
    }

    private List<PositionBI> getPathOriginsFromDb(int nid) throws IOException {
        return getPathOriginsWithDepth(nid, 0);
    }

    private List<PositionBI> getPathOriginsWithDepth(int nid, int depth) throws IOException {
        try {
            ArrayList<PositionBI> result = new ArrayList<>();
            Concept pathConcept = Bdb.getConceptDb().getConcept(nid);

            for (RefexChronicleBI<?> extPart : pathConcept.getRefexes(ReferenceConcepts.REFSET_PATH_ORIGINS.getNid())) {
                if (extPart == null) {
                    AceLog.getAppLog().alertAndLogException(new Exception("Null path origins for: "
                            + pathConcept.toLongString() + "\n\nin refset: \n\n"
                            + getRefsetPathOriginsConcept().toLongString()));
                } else {
                    if (extPart instanceof NidLongMember) {
                        NidLongMember conceptExtension = (NidLongMember) extPart;

                        if (conceptExtension.getC1Nid() == nid) {
                            AceLog.getAppLog().severe(
                                    "Self-referencing origin in path: "
                                    + pathConcept.getDescriptions().iterator().next());
                        } else {
                            if (pathMap.containsKey(conceptExtension.getC1Nid())) {
                                result.add(new Position(conceptExtension.getLong1(),
                                        pathMap.get(conceptExtension.getC1Nid())));
                            } else {
                                if (depth > 40) {
                                    AceLog.getAppLog().alertAndLogException(
                                            new Exception(
                                            "\n\n****************************************\nDepth limit exceeded. Path concept: \n"
                                            + pathConcept.toLongString() + "\n\n extensionPart: \n\n"
                                            + extPart.toString() + "\n\n origin refset: \n\n"
                                            + Concept.get(extPart.getRefexNid()).toLongString()
                                            + "\n-------------------------------------------\n\n"));
                                } else {
                                    result.add(new Position(conceptExtension.getLong1(),
                                            new Path(conceptExtension.getC1Nid(),
                                            getPathOriginsWithDepth(conceptExtension.getC1Nid(),
                                            depth + 1))));
                                }
                            }
                        }
                    } else {
                        // TODO remove after paths convert to NidLongMembers automatically on import...
                        
                        NidIntMember conceptExtension = (NidIntMember) extPart;

                        if (conceptExtension.getC1Nid() == nid) {
                            AceLog.getAppLog().severe(
                                    "Self-referencing origin in path: "
                                    + pathConcept.getDescriptions().iterator().next());
                        } else {
                            if (pathMap.containsKey(conceptExtension.getC1Nid())) {
                                result.add(new Position(ThinVersionHelper.convert(conceptExtension.getInt1()),
                                        pathMap.get(conceptExtension.getC1Nid())));
                            } else {
                                if (depth > 40) {
                                    AceLog.getAppLog().alertAndLogException(
                                            new Exception(
                                            "\n\n****************************************\nDepth limit exceeded. Path concept: \n"
                                            + pathConcept.toLongString() + "\n\n extensionPart: \n\n"
                                            + extPart.toString() + "\n\n origin refset: \n\n"
                                            + Concept.get(extPart.getRefexNid()).toLongString()
                                            + "\n-------------------------------------------\n\n"));
                                } else {
                                    result.add(new Position(ThinVersionHelper.convert(conceptExtension.getInt1()),
                                            new Path(conceptExtension.getC1Nid(),
                                            getPathOriginsWithDepth(conceptExtension.getC1Nid(),
                                            depth + 1))));
                                }
                            }
                        }
                    }
                }
            }

            return result;
        } catch (Exception e) {
            throw new IOException("Unable to retrieve path origins.", e);
        }
    }

    private Concept getPathRefsetConcept() throws IOException {
        if (pathRefsetConcept == null) {
            pathRefsetConcept = Bdb.getConceptDb().getConcept(ReferenceConcepts.REFSET_PATHS.getNid());
        }

        return pathRefsetConcept;
    }

    private Concept getRefsetPathOriginsConcept() throws IOException {
        if (this.refsetPathOriginsConcept == null) {
            this.refsetPathOriginsConcept = Concept.get(ReferenceConcepts.REFSET_PATH_ORIGINS.getNid());
        }

        return refsetPathOriginsConcept;
    }

    public boolean hasPath(int nid) throws IOException {
        if (exists(nid)) {
            return true;
        } else {
            PathBI p = getFromDisk(nid);

            if (p != null) {
                return true;
            }
        }

        return false;
    }
}
