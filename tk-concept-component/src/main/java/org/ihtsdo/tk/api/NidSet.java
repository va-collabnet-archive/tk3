package org.ihtsdo.tk.api;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;

public class NidSet implements NidSetBI, Serializable, ListDataListener {
   private static final int dataVersion = 1;

   /**
    *
    */
   private static final long serialVersionUID = 1L;
  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      int objDataVersion = in.readInt();

      if (objDataVersion == 1) {
          setValues = (int[]) in.readObject();
      }
      else {
         throw new IOException("Can't handle dataversion: " + objDataVersion);
      }
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.writeInt(dataVersion);
      out.writeObject(setValues);
   }


    private int[] setValues = new int[0];

    public NidSet(NidSet another) {
        this(another.setValues);
    }
    public NidSet(int[] values) {
        super();
        this.setValues = new int[values.length];
        System.arraycopy(values, 0, this.setValues, 0, values.length);
        Arrays.sort(this.setValues);
        boolean duplicates = false;
        for (int i = 1; i < values.length; i++) {
            if (this.setValues[i - 1] == this.setValues[i]) {
                duplicates = true;
            }
        }
        if (duplicates) {
            HashSet<Integer> hashSetValues = new HashSet<Integer>();
            for (int i : values) {
                hashSetValues.add(i);
            }
            this.setValues = new int[hashSetValues.size()];
            int i = 0;
            for (Integer value : hashSetValues) {
                this.setValues[i] = value;
                i++;
            }
            Arrays.sort(this.setValues);
        }
    }

    public NidSet() {
        super();
        this.setValues = new int[0];
    }

    public NidSet(Collection<PathBI> pathSet) {
        super();
        setValues = new int[pathSet.size()];
        int i = 0;
        for (PathBI p : pathSet) {
            setValues[i++] = p.getConceptNid();
        }
        Arrays.sort(setValues);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dwfa.ace.api.I_IntSet#contains(int)
     */
    @Override
    public boolean contains(int key) {
        return Arrays.binarySearch(setValues, key) >= 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dwfa.ace.api.I_IntSet#getSetValues()
     */
    @Override
    public int[] getSetValues() {
        return setValues;
    }

    @Override
    public synchronized void add(int key) {
        if (setValues.length == 0) {
            setValues = new int[1];
            setValues[0] = key;
        } else {
            int insertionPoint = Arrays.binarySearch(setValues, key);
            if (insertionPoint >= 0) {
                return;
            }
            insertionPoint = -insertionPoint - 1;
            int[] newSet = new int[setValues.length + 1];
            System.arraycopy(setValues, 0, newSet, 0, insertionPoint);
            newSet[insertionPoint] = key;
            for (int i = insertionPoint + 1; i < newSet.length; i++) {
                newSet[i] = setValues[i - 1];
            }
            setValues = newSet;
        }
    }

    @Override
    public void remove(int key) {
        int insertionPoint = Arrays.binarySearch(setValues, key);
        if (insertionPoint < 0) {
            return;
        }
        int[] newSet = new int[setValues.length - 1];
        System.arraycopy(setValues, 0, newSet, 0, insertionPoint);
        for (int i = insertionPoint + 1; i < setValues.length; i++) {
            newSet[i - 1] = setValues[i];
        }
        setValues = newSet;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dwfa.ace.api.I_IntSet#addAll(int[])
     */
    @Override
    public synchronized NidSet addAll(int[] keys) {
        HashSet<Integer> members = getAsSet();
        for (int key : keys) {
            members.add(key);
        }
        replaceWithSet(members);
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dwfa.ace.api.I_IntSet#removeAll(int[])
     */
    @Override
    public synchronized void removeAll(int[] keys) {
        HashSet<Integer> members = getAsSet();
        for (int key : keys) {
            members.remove(key);
        }
        replaceWithSet(members);
    }

    public HashSet<Integer> getAsSet() {
        HashSet<Integer> members = new HashSet<Integer>();
        for (int elem : setValues) {
            members.add(elem);
        }
        return members;
    }

    public void replaceWithSet(HashSet<Integer> members) {
        setValues = new int[members.size()];
        int i = 0;
        for (int elem : members) {
            setValues[i++] = elem;
        }
        Arrays.sort(setValues);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dwfa.ace.api.I_IntSet#clear()
     */
    @Override
    public void clear() {
        setValues = new int[0];
    }

    @Override
    public boolean equals(Object obj) {
        if (NidSetBI.class.isAssignableFrom(obj.getClass())) {
            NidSetBI another = (NidSetBI) obj;
            if (setValues.length != another.getSetValues().length) {
                return false;
            }
            for (int i = 0; i < setValues.length; i++) {
                if (setValues[i] != another.getSetValues()[i]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int size() {
        return setValues.length;
    }

    @Override
    public int getMax() {
        if (setValues.length == 0) {
            return Integer.MAX_VALUE;
        }
        return setValues[setValues.length - 1];
    }

    @Override
    public int getMin() {
        if (setValues.length == 0) {
            return Integer.MIN_VALUE;
        }
        return setValues[0];
    }

    @Override
    public boolean contiguous() {
        if (setValues.length == 0) {
            return true;
        }
        int prev = setValues[0] - 1;
        for (int i : setValues) {
            if (prev != i - 1) {
                return false;
            }
            prev = i;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        int count = 0;
        for (int i : setValues) {
            try {
                if (i < 0 && Ts.get().getConceptNidForNid(i) == i) {
                    buf.append(Ts.get().getConcept(i).toString());
                } else {
                    buf.append(i);
                }
            } catch (IOException e) {
                buf.append(i);
            }
            if (count++ < setValues.length - 1) {
                buf.append(", ");
            }
        }
        buf.append("]");
        return buf.toString();
    }
    
    private Set<ListDataListener> listeners = new HashSet<ListDataListener>();

    @Override
    public void intervalAdded(ListDataEvent e) {
        if (e.getSource() != this) {
            handleChange(e);
        }
        for (ListDataListener l : listeners) {
            l.intervalAdded(e);
        }
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        if (e.getSource() != this) {
            handleChange(e);
        }
        for (ListDataListener l : listeners) {
            l.intervalRemoved(e);
        }
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        if (e.getSource() != this) {
            handleChange(e);
        }
        for (ListDataListener l : listeners) {
            l.contentsChanged(e);
        }
    }
    
    private void handleChange(ListDataEvent e) {
        AbstractListModel model = (AbstractListModel) e.getSource();
        clear();
        for (int i = 0; i < model.getSize(); i++) {
            ConceptChronicleBI cb = (ConceptChronicleBI) model.getElementAt(i);
            add(cb.getConceptNid());
        }
    }
    
    @Override
    public boolean addListDataListener(ListDataListener o) {
        return listeners.add(o);
    }
    
    @Override
    public boolean removeListDataListener(ListDataListener o) {
        return listeners.remove(o);
    }
    
}
