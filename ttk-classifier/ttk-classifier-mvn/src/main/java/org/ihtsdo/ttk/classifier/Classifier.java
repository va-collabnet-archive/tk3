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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.RelAssertionType;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.coordinate.StandardViewCoordinates;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.metadata.binding.Taxonomies;
import org.ihtsdo.ttk.helpers.classifier.FetchKindOf;
import org.ihtsdo.ttk.helpers.time.TimeHelper;

import au.csiro.ontology.Factory;
import au.csiro.ontology.IOntology;
import au.csiro.ontology.axioms.IAxiom;
import au.csiro.ontology.classification.IReasoner;
import au.csiro.ontology.model.IConcept;
import au.csiro.snorocket.core.SnorocketReasoner;

//~--- JDK imports ------------------------------------------------------------


/**
 *
 * @author kec
 */
public class Classifier {
    @SuppressWarnings("unchecked")
	public static void classify() throws Exception {

        // Implement the action as a FX Service...
        // Step 1: Determine all current descendents of the SNOMED root concept
        // for parallel iteration...
        long time = System.currentTimeMillis();

        System.out.println(TimeHelper.formatDate(time));

        ViewCoordinate vc = StandardViewCoordinates.getSnomedLatest();

        vc.setRelAssertionType(RelAssertionType.STATED);

        FetchKindOf kindOfFetcher = new FetchKindOf(Taxonomies.SNOMED.getLenient().getNid(), vc);

        Ts.get().iterateConceptDataInSequence(kindOfFetcher);

        NidBitSetBI kindOfConcepts = kindOfFetcher.getKindOfBitSet();

        System.out.println("Kind of fetch: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        System.out.println(TimeHelper.formatDate(time));

        // Step 2: Determine all current descendents of the SNOMED Role concept
        FetchKindOf roleFetcher = new FetchKindOf(Taxonomies.SNOMED_ROLE_ROOT.getLenient().getNid(), vc);

        Ts.get().iterateConceptDataInSequence(roleFetcher);

        NidBitSetBI roleConcepts = roleFetcher.getKindOfBitSet();

        System.out.println("Role fetch: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        System.out.println("Kind of concepts: " + kindOfConcepts.cardinality());
        System.out.println("Role concepts: " + roleConcepts.cardinality());

        // Step 3:
        time = System.currentTimeMillis();
        System.out.println(TimeHelper.formatDate(time));

        IReasoner<String> reasoner = new SnorocketReasoner<>();
        Factory<String>   f        = new Factory<>();
        AxiomConstructor   ac       = new AxiomConstructor(kindOfConcepts, roleConcepts, f, vc);

        Ts.get().iterateConceptDataInParallel(ac);
        System.out.println("Axiom constructor: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        System.out.println(TimeHelper.formatDate(time));
        reasoner.classify(ac.axioms);
        System.out.println("Classify: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        System.out.println(TimeHelper.formatDate(time));

        @SuppressWarnings("unused")
		IOntology<String> t = reasoner.getClassifiedOntology();

        System.out.println("Get Ontology: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        System.out.println(TimeHelper.formatDate(time));
        
        System.out.println("Writing state to disk...");
        try (FileOutputStream fos = new FileOutputStream("c:/temp/classifier_uuid.state", false)) {
            reasoner.save(fos);
        }
        System.out.println("Write time: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        System.out.println(TimeHelper.formatDate(time));
        
        System.out.println("Reading state from disk...");

        FileInputStream fis = new FileInputStream("classifier.state");
        reasoner = SnorocketReasoner.load(fis);
        f        = new Factory<>();
        System.out.println("Read time: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        
        System.out.println("Adding new concept");
        // Add new concept
        IConcept newConcept = f.createConcept(UUID.randomUUID().toString());
        // Add new is-a
        ArrayList<IConcept>                   defn       = new ArrayList<>();
        defn.add(f.createConcept(AxiomConstructor.getUUID(Taxonomies.SNOMED.getStrict(vc).getNid())));
        IConcept expr = f.createConjunction(defn.toArray(new IConcept[defn.size()]));
        HashSet<IAxiom> newAxioms = new HashSet<>();
        newAxioms.add(f.createConceptInclusion(newConcept, expr));
        System.out.println("Start classify");
 
        reasoner.classify(newAxioms);
        System.out.println("Classify: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        System.out.println(TimeHelper.formatDate(time));

        t = reasoner.getClassifiedOntology();

        System.out.println("Get Ontology: " + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        System.out.println(TimeHelper.formatDate(time));

    }
    
}
