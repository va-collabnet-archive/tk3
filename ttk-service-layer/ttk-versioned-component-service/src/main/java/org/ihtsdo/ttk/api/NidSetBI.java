package org.ihtsdo.ttk.api;

import java.util.Collection;
import java.util.HashSet;

public interface NidSetBI {

    boolean contains(int nid);

    int[] getSetValues();

    void add(int nid);

    void remove(int nid);

    NidSetBI addAll(int[] nids);
    
    NidSet addAll(Collection<Integer> keys);
    
    void removeAll(int[] nids);

    void clear();

    int size();

    int getMax();

    int getMin();
    
    HashSet<Integer> getAsSet();

    boolean contiguous();
        
    String getAmpersandString();
}
