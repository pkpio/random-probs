package io.pkp.randprob;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Sample implementation of a HashMap
 * Created by praveen on 5/8/16.
 */
public class MyHashMap<K,V> {
    private int myCapacity;
    private ArrayList<LinkedList<MyEntry>> myBuckets;

    public MyHashMap(int capacity){
        myCapacity = capacity;
        myBuckets = new ArrayList<>();
    }

    /**
     * Hashes the key's hash value into a number between [0, capacity)
     * @return hash value
     */
    private int hashedKey(K key){
        return key.hashCode() % myCapacity;
    }

    /**
     * Put a new key-value pair into the map
     * @param key
     * @param val
     */
    public void put(K key, V val){
        int index = hashedKey(key);
        myBuckets.get(index).add(new MyEntry(key, val));
    }

    /**
     * Get value for a given key
     * @param key
     * @return
     */
    public V get(K key){
        int index = hashedKey(key);
        for (MyEntry e : myBuckets.get(index))
            if(e.getKey().equals(key))
                return e.getVal();
        return null;
    }

    /**
     * Removes a key-value pair from map if key exists
     * @param key
     * @return Value of the removed key
     */
    public V remove(K key){
        int index = hashedKey(key);
        return null;
    }

    /**
     * An entry that encapsulates key-value pairs into one object.
     */
    private class MyEntry {
        K key;
        V val;

        public MyEntry(K key, V val){
            this.key = key;
            this.val = val;
        }

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyEntry myEntry = (MyEntry) o;

            return key.equals(myEntry.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}
