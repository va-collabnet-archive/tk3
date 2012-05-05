package org.ihtsdo.cc.computer.kindof;

import java.util.Collection;

import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.tk.api.ConceptFetcherBI;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.NidList;
import org.ihtsdo.tk.api.NidSetBI;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

public class PossibleIsaCache extends TypeCache {

    private NidBitSetBI nidSet;

    @Override
    public NidBitSetBI getNidSet() {
        return nidSet;
    }

    public PossibleIsaCache(NidBitSetBI nidSet) {
        super();
        this.nidSet = nidSet;
    }

    @Override
    public void processUnfetchedConceptData(int cNid,
            ConceptFetcherBI fcfc) throws Exception {
        if (isCancelled() == false) {
            Concept c = (Concept) fcfc.fetch();
            Collection<? extends RelationshipChronicleBI> rels = c.getRelsOutgoing();
            NidList destNids = new NidList();
            NidSetBI localTypes = coordinate.getIsaTypeNids();

            for (RelationshipChronicleBI r : rels) {
                for (RelationshipVersionBI rv : r.getVersions()) {
                    if (localTypes.contains(rv.getTypeNid())) {
                        destNids.add(rv.getDestinationNid());
                        break;
                    }
                }
            }
            typeMap.put(cNid, destNids.getListArray());
        }
    }
}
