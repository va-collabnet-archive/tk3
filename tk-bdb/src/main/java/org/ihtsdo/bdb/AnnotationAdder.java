/*
 * Copyright 2010 International Health Terminology Standards Development Organisation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ihtsdo.bdb;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.bdb.concept.I_ProcessUnfetchedConceptData;
import org.ihtsdo.bdb.concept.ParallelConceptIterator;
import org.ihtsdo.cc.component.IdentifierSet;
import org.ihtsdo.cc.refex.RefexMemberFactory;
import org.ihtsdo.bdb.temp.AceLog;
import org.ihtsdo.tk.api.ComponentChroncileBI;
import org.ihtsdo.tk.api.ConceptFetcherBI;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;

/**
 *
 * @author maestro
 */
public class AnnotationAdder implements I_ProcessUnfetchedConceptData {

    static class TkRmComparator implements Comparator<TkRefexAbstractMember<?>> {

        @Override
        public int compare(TkRefexAbstractMember<?> t, TkRefexAbstractMember<?> t1) {
            return t.primordialUuid.compareTo(t1.primordialUuid);
        }
    }
    NidBitSetBI conceptNids = new IdentifierSet();
    ConcurrentHashMap<Integer, ConcurrentSkipListSet<TkRefexAbstractMember<?>>> membersForConcept =
            new ConcurrentHashMap<>();

    AnnotationAdder(List<TkRefexAbstractMember<?>> members) {

        TkRmComparator comparator = new TkRmComparator();
        int errors = 0;
        Set<UUID> errorSet = new TreeSet<>();
        for (TkRefexAbstractMember<?> member : members) {
            UUID componentUuid = member.getComponentUuid();
            int nid = Bdb.uuidToNid(componentUuid);
            int cNid = Bdb.getConceptNid(nid);
            if (cNid + Integer.MIN_VALUE >= 0) {
                conceptNids.setMember(cNid);
                ConcurrentSkipListSet<TkRefexAbstractMember<?>> set =
                        new ConcurrentSkipListSet<>(comparator);
                membersForConcept.putIfAbsent(cNid, set);
                membersForConcept.get(cNid).add(member);
            } else {
                errors++;
                errorSet.add(componentUuid);
                int nid2 = Bdb.uuidToNid(member.getComponentUuid());
                int cNid2 = Bdb.getConceptNid(nid);
                AceLog.getAppLog().warning("No concept for: " + member);
            }
        }
        if (errors > 0) {
                AceLog.getAppLog().warning(errors + " processing errors.\n\nError set: " + 
                        errorSet.size() + "\n" +
                        errorSet);
        }
    }

    @Override
    public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fcfc) throws Exception {
        if (conceptNids.isMember(cNid)) {
            Concept c = (Concept) fcfc.fetch();
            ConcurrentSkipListSet<TkRefexAbstractMember<?>> set =
                    membersForConcept.get(cNid);
            for (TkRefexAbstractMember<?> member : set) {
                ComponentChroncileBI<?> component = c.getComponent(Bdb.uuidToNid(member.getComponentUuid()));
                if (component != null) {
                    component.addAnnotation(RefexMemberFactory.create(member, cNid));
                } else {
                    AceLog.getAppLog().warning("Cannot import annotation. Component is null for: " + member);
                }
            }
            membersForConcept.remove(cNid);
            BdbCommitManager.addUncommittedNoChecks(c);
        }
    }

    @Override
    public void setParallelConceptIterators(List<ParallelConceptIterator> pcis) {
        // nothing to do...;
    }

    @Override
    public NidBitSetBI getNidSet() throws IOException {
        return conceptNids;
    }

    @Override
    public boolean continueWork() {
        return true;
    }
}
