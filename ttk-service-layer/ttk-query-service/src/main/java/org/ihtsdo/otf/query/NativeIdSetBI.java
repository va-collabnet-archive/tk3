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
package org.ihtsdo.otf.query;

/**
 *
 * @author kec
 */
public interface NativeIdSetBI {


    public int size();

    public boolean isMember(int nid);
    
    public void setMember(int nid);
    
    public void and(NativeIdSetBI other);
    
    public void or(NativeIdSetBI other);
    
    public void xor(NativeIdSetBI other);
    
    public boolean contains(int nid);
    
    public int[] getSetValues();
    
    public void add(int nid);
    
    public void addAll(int[] nids);
    
    public void remove(int nid);
    
    public void removeAll(int[] nids);
    
    public void clear();
    
    @Override
    public boolean equals(Object obj);
    
    @Override
    public int hashCode();
    
    public int getMax();
    
    public int getMin();
    
    public boolean contiguous();
    
    @Override
    public String toString();
    
    public void union(NativeIdSetBI other);
    
    public void setNotMember(int nid);
    
    public void andNot(NativeIdSetBI other); 
    
}
