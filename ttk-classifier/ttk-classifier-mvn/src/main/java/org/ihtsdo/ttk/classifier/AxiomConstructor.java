/*
 * Copyright 2013 International Health Terminology Standards Development Organisation.
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
package org.ihtsdo.ttk.classifier;

import au.csiro.ontology.Factory;
import au.csiro.ontology.axioms.IAxiom;
import au.csiro.ontology.model.IConcept;
import au.csiro.ontology.model.INamedRole;

import org.ihtsdo.ttk.api.ConceptFetcherBI;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 *
 * @author kec
 */
public class AxiomConstructor implements ProcessUnfetchedConceptDataBI {
    NidBitSetBI                   kindOfConcepts;
    NidBitSetBI                   roleConcepts;
    Factory<Integer>              f;
    ConcurrentSkipListSet<IAxiom> axioms;
    ViewCoordinate                vc;
    INamedRole<Integer>           roleGroup;
    ConcurrentHashMap<Integer, IConcept> concepts;
    ConcurrentHashMap<Integer, INamedRole> roles;

    public AxiomConstructor(NidBitSetBI kindOfConcepts, NidBitSetBI roleConcepts, Factory<Integer> f,
                            ViewCoordinate vc) {
        this.kindOfConcepts = kindOfConcepts;
        this.roleConcepts   = roleConcepts;
        this.f              = f;
        this.vc             = vc;
        axioms              = new ConcurrentSkipListSet<>();
        concepts = new ConcurrentHashMap<>(kindOfConcepts.cardinality());
        roles = new ConcurrentHashMap<>(roleConcepts.cardinality());
        roleGroup           = f.createRole(Integer.MIN_VALUE);
    }
    
    IConcept getConcept(int nid) {
        if (concepts.containsKey(nid)) {
            return concepts.get(nid);
        }
        IConcept newC = f.createConcept(nid);
        IConcept oldC = concepts.putIfAbsent(nid, newC);
        if (oldC != null) {
            return oldC;
        }
        return newC;
    }

    INamedRole getRole(int nid) {
        if (roles.containsKey(nid)) {
            return roles.get(nid);
        }
        INamedRole newR = f.createRole(nid);
        INamedRole oldR = roles.putIfAbsent(nid, newR);
        if (oldR != null) {
            return oldR;
        }
        return newR;
    }

    @Override
    public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fetcher) throws Exception {
        ConceptVersionBI                      cv         = fetcher.fetch(vc);
        IConcept                              c          = getConcept(cNid);
        HashMap<Integer, ArrayList<IConcept>> roleGroups = new HashMap<>();

        for (RelationshipVersionBI rv : cv.getRelsOutgoingActiveIsa()) {
            axioms.add(f.createConceptInclusion(c, getConcept(rv.getDestinationNid())));
        }

        for (RelationshipVersionBI rv : cv.getRelsOutgoingActive()) {
            if (roleConcepts.isMember(rv.getTypeNid())) {
                if (rv.getGroup() == 0) {
                    axioms.add(f.createConceptInclusion(c,
                            f.createExistential(getRole(rv.getTypeNid()),
                                                getConcept(rv.getDestinationNid()))));
                } else {
                    if (!roleGroups.containsKey(rv.getGroup())) {
                        roleGroups.put(rv.getGroup(), new ArrayList<IConcept>());
                    }

                    roleGroups.get(rv.getGroup()).add(f.createExistential(getRole(rv.getTypeNid()),
                            getConcept(rv.getDestinationNid())));
                }
            }
        }

        for (ArrayList<IConcept> group : roleGroups.values()) {
            axioms.add(f.createConceptInclusion(c, f.createConjunction(group.toArray(new IConcept[group.size()]))));
        }

        if (cv.getConAttrsActive() != null && cv.getConAttrsActive().isDefined()) {
            for (RelationshipVersionBI rv : cv.getRelsOutgoingActiveIsa()) {
                axioms.add(f.createConceptInclusion(getConcept(rv.getDestinationNid()), c));
            }

            for (RelationshipVersionBI rv : cv.getRelsOutgoingActive()) {
                if (roleConcepts.isMember(rv.getTypeNid()) && (rv.getGroup() == 0)) {
                    axioms.add(f.createConceptInclusion(f.createExistential(getRole(rv.getTypeNid()),
                            getConcept(rv.getDestinationNid())), c));
                }
            }

            for (ArrayList<IConcept> group : roleGroups.values()) {
                axioms.add(f.createConceptInclusion(f.createConjunction(group.toArray(new IConcept[group.size()])), c));
            }
        }
    }

    @Override
    public NidBitSetBI getNidSet() throws IOException {
        return kindOfConcepts;
    }

    @Override
    public boolean continueWork() {
        return true;
    }
}
