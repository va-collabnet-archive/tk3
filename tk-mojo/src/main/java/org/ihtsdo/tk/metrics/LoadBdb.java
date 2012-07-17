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
import org.ihtsdo.helper.io.FileIO;
import org.ihtsdo.tk.Ts;

/**
 * Goal which touches a timestamp file.
 *
 * @goal load-bdb
 *
 * @phase process-sources
 */
public class LoadBdb extends AbstractMojo {

   /**
    * <code>eConcept format</code> files to import.
    * @parameter
    * @required
    */
   private String[] econFileStrings;

   /**
    * Location of the file.
    * @parameter expression="${project.build.directory}/berkeley-db"
    * @required
    */
   private String bdbFolderLocation;

   /**
    * true if the mutable database should replace the read-only database after
    * load is complete. 
    * @parameter default-value=true
    * @required
    */
   private boolean moveToReadOnly = true;
   //~--- methods -------------------------------------------------------------

   @Override
   public void execute() throws MojoExecutionException {
      try {
         Ts.setup(Ts.EMBEDDED_BERKELEY_DB_IMPL_CLASS, bdbFolderLocation);
         Ts.get().loadEconFiles(econFileStrings);
         Ts.close();
         if (moveToReadOnly) {
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
