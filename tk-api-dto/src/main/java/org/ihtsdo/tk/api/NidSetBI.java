package org.ihtsdo.tk.api;

import javax.swing.event.ListDataListener;

public interface NidSetBI {

    boolean contains(int nid);

    int[] getSetValues();

    void add(int nid);

    void remove(int nid);

    NidSetBI addAll(int[] nids);

    void removeAll(int[] nids);

    void clear();

    int size();

    int getMax();

    int getMin();

    boolean contiguous();
    
    public boolean addListDataListener(ListDataListener o);
    
    public boolean removeListDataListener(ListDataListener o);
}