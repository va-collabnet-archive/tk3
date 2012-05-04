package org.ihtsdo.db.bdb.computer.kindof;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import org.ihtsdo.cc.P;

import org.ihtsdo.concept.Concept;
import org.ihtsdo.concept.ConceptVersion;
import org.ihtsdo.helper.thread.NamedThreadFactory;
import org.ihtsdo.tk.api.KindOfCacheBI;
import org.ihtsdo.tk.api.RelAssertionType;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.coordinate.IsaCoordinate;
import org.ihtsdo.tk.api.coordinate.KindOfSpec;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

public class KindOfComputer {

    public static boolean persistIsaCache = false;
    private static int cacheLimit = 10;
    private static ConcurrentHashMap<KindOfSpec, KindOfCache> caches =
            new ConcurrentHashMap<>(10);
    private static Map<IsaCoordinate, IsaCache> isaCache = new ConcurrentHashMap<>();
    protected static ExecutorService kindOfComputerService =
            Executors.newFixedThreadPool(1, new NamedThreadFactory(
            new ThreadGroup("KindOfComputer"), "kind-of computer service"));

    public static void reset() {
        caches.clear();
    }

    /**
     * TODO make this trim algorithm more intelligent.
     */
    public static void trimCache() {
        while (caches.size() >= cacheLimit) {
            Entry<KindOfSpec, KindOfCache> looser = null;
            for (Entry<KindOfSpec, KindOfCache> entry : caches.entrySet()) {
                if (looser == null) {
                    looser = entry;
                } else {
                    if (entry.getValue().getLastRequestTime()
                            < looser.getValue().getLastRequestTime()) {
                        looser = entry;
                    }

                }
            }
            caches.remove(looser.getKey());
        }
    }
    static ReentrantLock lock = new ReentrantLock();

    public static boolean isKindOf(Concept c, KindOfSpec spec)
            throws IOException {
        Map<IsaCoordinate, IsaCache> debugMap = isaCache;
        IsaCache debugIsaCache = debugMap.get(spec.getIsaCoordinate());
        if (isaCache.get(spec.getIsaCoordinate()) != null && isaCache.get(spec.getIsaCoordinate()).isReady()
                && isaCache.get(spec.getIsaCoordinate()).isTested(c.getNid())) {
            return cachedIsKindOfWithDepth(c, spec, 0);
        }
        return isKindOfWithDepth(c, spec, 0);
    }

    public static void resetIsaCache(IsaCoordinate isaCoordinate) {
        if (isaCache.get(isaCoordinate) != null) {
            isaCache.get(isaCoordinate).setCancelled(true);
            isaCache.remove(isaCoordinate);
        }
    }

    public static void updateIsaCaches(ConceptChronicleBI c) throws Exception {
        for (IsaCache isac : isaCache.values()) {
            isac.updateCache(c);
        }
    }

    @Deprecated
    public static void updateIsaCachesUsingStatedView(ConceptChronicleBI c) throws Exception {
        updateIsaCaches(c);
    }

    public static void clearIsaCache() {
        isaCache.clear();
    }

    public static void setIsaCache(IsaCoordinate isaCoordinate, KindOfCacheBI newIsaCache) throws IOException {
        isaCache.put(isaCoordinate, (IsaCache) newIsaCache);
    }

    public static IsaCache setupIsaCache(IsaCoordinate isaCoordinate) throws IOException {
        if (isaCache.get(isaCoordinate) != null) {
            return isaCache.get(isaCoordinate);
        } else {
            IsaCache tempIsaCache =
                    new IsaCache(P.s.getAllConceptNids());
            try {
                tempIsaCache.setup(isaCoordinate.getCoordinate());
            } catch (Exception e) {
                TypeCache.logger.log(Level.SEVERE, e.getMessage(), e);
            }
            TypeCache.logger.info("Saving cache reference...");
            isaCache.put(isaCoordinate, tempIsaCache);
            return tempIsaCache;
        }
    }

    public static IsaCache setupIsaCacheAndWait(IsaCoordinate isaCoordinate)
            throws IOException, InterruptedException {
        IsaCache tempIsaCache = setupIsaCache(isaCoordinate);
        tempIsaCache.getLatch().await();
        isaCache.put(isaCoordinate, tempIsaCache);
        return tempIsaCache;
    }

    public static void updateIsaCache(int cNid) throws Exception {
        Concept concept = Concept.get(cNid);

        boolean isClassifierEdit = false;
        for (IsaCoordinate loopCoordinate : isaCache.keySet()) {
            ViewCoordinate vc = new ViewCoordinate(loopCoordinate.getCoordinate());
            vc.setRelAssertionType(RelAssertionType.INFERRED);
            ConceptVersion cv = new ConceptVersion(concept, vc);

            Collection<? extends RelationshipVersionBI> inferredRels = cv.getRelsOutgoingActiveIsa();

            for (RelationshipVersionBI loopRel : inferredRels) {
                if (loopRel.getTime() == Long.MAX_VALUE) {
                    isClassifierEdit = true;
                }
            }
            if (isClassifierEdit) {
                isaCache.get(loopCoordinate).updateCache(Concept.get(cNid));
            } else {
                isaCache.get(loopCoordinate).updateCacheUsingStatedView(Concept.get(cNid));
            }
        }
    }

    protected static void updateIsaCache(IsaCoordinate isaCoordinate, int cNid) throws Exception {
        if (isaCache.get(isaCoordinate) != null && isaCache.get(isaCoordinate).isReady()) {
            isaCache.get(isaCoordinate).updateCache(Concept.get(cNid));
        }
    }

    protected static void updateIsaCacheUsingStatedView(IsaCoordinate isaCoordinate, int cNid) throws Exception {
        if (isaCache.get(isaCoordinate) != null && isaCache.get(isaCoordinate).isReady()) {
            isaCache.get(isaCoordinate).updateCacheUsingStatedView(Concept.get(cNid));
        }
    }

    public static void persistIsaCache() throws Exception {
        writeIsaCacheToFile(new File("berkeley-db/isa-cache.oos"));
    }

    public static void writeIsaCacheToFile(File cacheFile) throws IOException {
        //use buffering
        TypeCache.logger.log(Level.INFO, "writing is-a cache to file: {0}", cacheFile);
        cacheFile.getParentFile().mkdirs();
        OutputStream file = new FileOutputStream(cacheFile);
        OutputStream buffer = new BufferedOutputStream(file);
        try (ObjectOutput output = new ObjectOutputStream(buffer)) {
            output.writeObject(isaCache);
        }
    }

    public static boolean loadIsaCacheFromFile(File cacheFile, Collection<IsaCoordinate> isaCoordinates) throws Exception {
        if (!cacheFile.exists()) {
            TypeCache.logger.log(Level.INFO, "Is-a cache file does not exist: {0}", cacheFile);
            return false;
        }
        TypeCache.logger.log(Level.INFO, "Reading is-a cache from file: {0}", cacheFile);
        InputStream file = new FileInputStream(cacheFile);
        InputStream buffer = new BufferedInputStream(file);
        try (ObjectInput input = new ObjectInputStream(buffer)) {
            isaCache = loadIsaCacheFromStream(input);
        }
        cacheFile.delete();
        if (isaCache.keySet().containsAll(isaCoordinates) && isaCoordinates.containsAll(isaCache.keySet())) {
            return true;
        } else {
            return false;
        }
    }

    public static Map<IsaCoordinate, IsaCache> loadIsaCacheFromStream(ObjectInput ois) throws Exception {
        return (Map<IsaCoordinate, IsaCache>) ois.readObject();
    }

    private static boolean cachedIsKindOfWithDepth(
            Concept c, KindOfSpec spec, int depth)
            throws IOException {
        if (depth > 15) {
            TypeCache.logger.log(Level.WARNING, "depth of: {0} testing: {1}", new Object[]{depth, c});
            if (depth > 100) {
                String message = "Depth limit of 100 exceeded: "
                        + depth + " testing: " + c;
                TypeCache.logger.log(Level.SEVERE, message,
                        new Exception(message));
                return false;
            }
        }

        try {
             return isaCache.get(spec.getIsaCoordinate()).isKindOf(c.getConceptNid(), spec.getKindNid());
        } catch (Exception e1) {
            TypeCache.logger.log(Level.SEVERE, e1.getMessage(), e1);
        }

        KindOfCache cache = caches.get(spec);
        if (cache != null && cache.tested(c.getNid())) {
            return cache.isKindOf(c.getNid());
        }
        if (cache == null) {
            Concept kindOf = (Concept) P.s.getConcept(spec.kindNid);
            cache = new KindOfCache(
                    kindOf.getPossibleKindOfConcepts(spec.getRelTypeNids()));
            KindOfCache prevCache = caches.putIfAbsent(spec, cache);
            if (prevCache != null) {
                cache = prevCache;
            }
            cache.setKindOf(spec.kindNid, true);
            if (c.getNid() == spec.kindNid) {
                return true;
            }
        }
        try {
            boolean isKindOf = isaCache.get(spec.getIsaCoordinate()).isKindOf(c.getNid(), spec.kindNid);
            cache.setKindOf(c.getNid(), isKindOf);
            return isKindOf;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static boolean isKindOfWithDepth(Concept c, KindOfSpec spec, int depth)
            throws IOException {
        if (depth > 15) {
            TypeCache.logger.log(Level.WARNING, "depth of: {0} testing: {1}", new Object[]{depth, c});
            if (depth > 100) {
                String message = "Depth limit of 100 exceeded: "
                        + depth + " testing: " + c;
                TypeCache.logger.log(Level.SEVERE, message,
                        new Exception(message));
                return false;
            }
        }
        KindOfCache cache = caches.get(spec.getIsaCoordinate());
        if (cache != null && cache.tested(c.getNid())) {
            return cache.isKindOf(c.getNid());
        }
        if (cache == null) {
            Concept kindOf = (Concept) P.s.getConcept(spec.kindNid);
            cache = new KindOfCache(
                    kindOf.getPossibleKindOfConcepts(spec.getRelTypeNids()));
            KindOfCache prevCache = caches.putIfAbsent(spec, cache);
            if (prevCache != null) {
                cache = prevCache;
            }
            cache.setKindOf(spec.kindNid, true);
            if (c.getNid() == spec.kindNid) {
                return true;
            }
        }
        ConceptVersion cv = new ConceptVersion(c, spec.getCoordinate());
        Collection<? extends ConceptVersionBI> parents = cv.getRelsOutgoingDestinations();
        if (parents.isEmpty()) {
            cache.setKindOf(c.getNid(), false);
            return false;
        }
        for (ConceptVersionBI parent : parents) {
            if (cache.tested(parent.getNid())) {
                if (cache.isKindOf(parent.getNid())) {
                    return true;
                }
            } else {
                if (isaCache.get(spec.getIsaCoordinate()) != null && isaCache.get(spec.getIsaCoordinate()).isReady()) {
                    if (cachedIsKindOfWithDepth((Concept) parent, spec, depth + 1)) {
                        cache.setKindOf(c.getNid(), true);
                        return true;
                    }
                } else {
                    if (isKindOfWithDepth((Concept) parent, spec, depth + 1)) {
                        cache.setKindOf(c.getNid(), true);
                        return true;
                    }
                }
            }
        }
        cache.setKindOf(c.getNid(), false);
        return false;
    }

    public static Map<IsaCoordinate, IsaCache> getIsaCacheMap() {
        return isaCache;
    }
}
