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

//~--- non-JDK imports --------------------------------------------------------

import au.csiro.ontology.Factory;
import au.csiro.ontology.axioms.IAxiom;
import au.csiro.ontology.axioms.RoleInclusion;
import au.csiro.ontology.model.IConcept;
import au.csiro.ontology.model.INamedRole;

import org.ihtsdo.ttk.api.ConceptFetcherBI;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.metadata.binding.Snomed;
import org.ihtsdo.ttk.api.metadata.binding.Taxonomies;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.api.spec.ValidationException;

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
    NidBitSetBI                            kindOfConcepts;
    NidBitSetBI                            roleConcepts;
    Factory<Integer>                       f;
    ConcurrentSkipListSet<IAxiom>          axioms;
    ViewCoordinate                         vc;
    INamedRole<Integer>                    roleGroup;
    ConcurrentHashMap<Integer, IConcept>   concepts;
    ConcurrentHashMap<Integer, INamedRole> roles;

    public AxiomConstructor(NidBitSetBI kindOfConcepts, NidBitSetBI roleConcepts, Factory<Integer> f, ViewCoordinate vc)
            throws IOException, ValidationException {
        this.kindOfConcepts = kindOfConcepts;
        this.roleConcepts   = roleConcepts;
        this.f              = f;
        this.vc             = vc;
        axioms              = new ConcurrentSkipListSet<>();
        concepts            = new ConcurrentHashMap<>(kindOfConcepts.cardinality());
        roles               = new ConcurrentHashMap<>(roleConcepts.cardinality());
        roleGroup           = f.createRole(Integer.MIN_VALUE);

        // Add right identity for SNOMED.
        if (kindOfConcepts.isMember(Taxonomies.SNOMED.getStrict(vc).getNid())) {
            axioms.add(new RoleInclusion(new INamedRole[] { getRole(Snomed.DIRECT_SUBSTANCE.getStrict(vc).getNid()),
                    getRole(Snomed.HAS_ACTIVE_INGREDIENT.getStrict(vc).getNid()) }, getRole(
                        Snomed.DIRECT_SUBSTANCE.getStrict(vc).getNid())));
        }
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

    final INamedRole getRole(int nid) {
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
        ArrayList<IConcept>                   defn       = new ArrayList<>();
        HashMap<Integer, ArrayList<IConcept>> roleGroups = new HashMap<>();

        // Special handling to support role groups...
        // RoleInclusion axiom of the form new RoleInclusion(new Role<>(childRole), new Role<>(parentRole)).
        if (roleConcepts.isMember(cNid)) {
            for (RelationshipVersionBI rv : cv.getRelsOutgoingActiveIsa()) {
                if (roleConcepts.isMember(rv.getDestinationNid())) {
                    axioms.add(new RoleInclusion(getRole(cNid), getRole(rv.getDestinationNid())));
                }
            }
        }

        // Aggregate the conjuncts of the necessary condition into defn
        for (RelationshipVersionBI rv : cv.getRelsOutgoingActiveIsa()) {
            defn.add(getConcept(rv.getDestinationNid()));
        }

        for (RelationshipVersionBI rv : cv.getRelsOutgoingActive()) {
            if (roleConcepts.isMember(rv.getTypeNid())) {
                if (rv.getGroup() == 0) {
                    defn.add(f.createExistential(getRole(rv.getTypeNid()), getConcept(rv.getDestinationNid())));
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
            defn.add(f.createConjunction(group.toArray(new IConcept[group.size()])));
        }

        IConcept expr = f.createConjunction(defn.toArray(new IConcept[defn.size()]));

        axioms.add(f.createConceptInclusion(c, expr));

        // check if concept is fully defined and add the sufficient condition axiom
        if ((cv.getConAttrsActive() != null) && cv.getConAttrsActive().isDefined()) {
            axioms.add(f.createConceptInclusion(expr, c));
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
