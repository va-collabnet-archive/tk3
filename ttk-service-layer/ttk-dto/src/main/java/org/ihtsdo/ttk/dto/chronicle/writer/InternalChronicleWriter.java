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
package org.ihtsdo.ttk.dto.chronicle.writer;

import java.io.DataOutput;
import java.io.IOException;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.dto.ChronicleConverter;
import org.ihtsdo.ttk.dto.TtkConceptChronicle;
import org.ihtsdo.ttk.dto.chronicle.ChronicleWriter;

/**
 *
 * @author kec
 */
public class InternalChronicleWriter extends ChronicleWriter {

    public InternalChronicleWriter(DataOutput out) {
        super(out);
    }
    
   
    public void write(long time, TtkConceptChronicle ttkConceptChronicle) throws IOException {
        
        ConceptChronicleBI chronicleToWrite = ChronicleConverter.convert(ttkConceptChronicle);
        // find a way to write out in a sorted order based on 
        // 1. nid
        // 2. time
        
        // Write out to a directory structure with file names based on nid.time.icf?
        // Write out to a ZIP file using this structure?
        throw new UnsupportedOperationException();
    }
}
