package org.ihtsdo.tk.metrics;

/*
* Copyright 2001-2005 The Apache Software Foundation.
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
import java.io.File;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.ihtdo.tk.metrics.IsKindOfMetrics;
import org.ihtsdo.helper.io.FileIO;
import org.ihtsdo.helper.time.TimeHelper;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.coordinate.StandardViewCoordinates;
import org.ihtsdo.tk.binding.Taxonomies;
import org.ihtsdo.tk.binding.TermAux;

/**
 * Goal which touches a timestamp file.
 *
 * @goal load-bdb
 *
 * @phase process-sources
 */
public class LoadBdb extends AbstractMojo {

   /**
    * true if the mutable database should replace the read-only database after
    * load is complete.
    * @parameter default-value=true
    * @required
    */
   private boolean moveToReadOnly = true;

   /**
    * Location of the file.
    * @parameter expression="${project.build.directory}/berkeley-db"
    * @required
    */
   private String bdbFolderLocation;

   /**
    * <code>eConcept format</code> files to import.
    * @parameter
    * @required
    */
   private String[] econFileStrings;

   //~--- methods -------------------------------------------------------------

   @Override
   public void execute() throws MojoExecutionException {
      try {
         File    bdbFolderFile = new File(bdbFolderLocation);
         boolean dbExists      = bdbFolderFile.exists();

         Ts.setup(Ts.EMBEDDED_BERKELEY_DB_IMPL_CLASS, bdbFolderLocation);

         if (!dbExists) {
            Ts.get().loadEconFiles(econFileStrings);
         }


         getLog().info("Starting metrics");

         long start = System.currentTimeMillis();
         IsKindOfMetrics metrics = new IsKindOfMetrics(Taxonomies.SNOMED.getLenient().getNid(),
                                      StandardViewCoordinates.getSnomedLatest());

         Ts.get().iterateConceptDataInParallel(metrics);

         long end = System.currentTimeMillis();

         getLog().info("\n\nParallel: " + metrics.getReport());
         getLog().info("Finished parallel metrics. Elapsed time: "
                       + TimeHelper.getElapsedTimeString(end - start) + 
                 " (" + (end - start) + " ms)");
         start   = System.currentTimeMillis();
         metrics = new IsKindOfMetrics(Taxonomies.SNOMED.getLenient().getNid(),
                                       StandardViewCoordinates.getSnomedLatest());
         Ts.get().iterateConceptDataInSequence(metrics);
         end = System.currentTimeMillis();
         getLog().info("\nSequential: " + metrics.getReport());
         getLog().info("Finished sequential metrics. Elapsed time: "
                       + TimeHelper.getElapsedTimeString(end - start) + 
                 " (" + (end - start) + " ms)");
         start   = System.currentTimeMillis();
         metrics = new IsKindOfMetrics(Taxonomies.SNOMED.getLenient().getNid(),
                                      StandardViewCoordinates.getSnomedLatest());

         Ts.get().iterateConceptDataInParallel(metrics);

         end = System.currentTimeMillis();

         getLog().info("\n\nParallel: " + metrics.getReport());
         getLog().info("Finished parallel metrics. Elapsed time: "
                       + TimeHelper.getElapsedTimeString(end - start) + 
                 " (" + (end - start) + " ms)");
         start   = System.currentTimeMillis();
         metrics = new IsKindOfMetrics(Taxonomies.SNOMED.getLenient().getNid(),
                                       StandardViewCoordinates.getSnomedLatest());
         Ts.get().iterateConceptDataInSequence(metrics);
         end = System.currentTimeMillis();
         getLog().info("\nSequential: " + metrics.getReport());
         getLog().info("Finished sequential metrics. Elapsed time: "
                       + TimeHelper.getElapsedTimeString(end - start) + 
                 " (" + (end - start) + " ms)");
         getLog().info("\n\n");
         
         
         int nid = Ts.get().getNidFromAlternateId(TermAux.SNOMED_IDENTIFIER.getUuids()[0], "138875005");
         ConceptChronicleBI snomedConcept = Ts.get().getConceptForNid(nid);
         System.out.println("Found concept from alt id: " + snomedConcept);
         
         Ts.close();

         if (!dbExists && moveToReadOnly) {
            getLog().info("moving mutable to read-only");

            File readOnlyDir = new File(bdbFolderLocation, "read-only");

            FileIO.recursiveDelete(readOnlyDir);

            File mutableDir = new File(bdbFolderLocation, "mutable");

            mutableDir.renameTo(readOnlyDir);
         }
      } catch (Exception ex) {
         throw new MojoExecutionException(ex.getLocalizedMessage(), ex);
      }
   }
}
