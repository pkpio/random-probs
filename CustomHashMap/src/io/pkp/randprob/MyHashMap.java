package io.pkp.randprob;

import java.util.*;

/**
 * Sample implementation of a HashMap
 * Created by praveen on 5/8/16.
 */
public class MyHashMap<K,V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private int mCapacity;
    private ArrayList<Entry<K,V>> mTable;

    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyHashMap(int capacity){
        mCapacity = capacity;
        mTable = new ArrayList<Entry<K,V>>(mCapacity);
        for(int i=0; i<mCapacity; i++)
            mTable.add(null);
    }

    public int indexOf(K key){
        return key.hashCode() & (mCapacity - 1);
    }

    public V put(K key, V value) {
        int index = indexOf(key);
        Entry<K,V> e = mTable.get(index);

        // Empty bucket
        if(e == null) {
            mTable.set(index, new Entry<>(key, value));
            return null;
        }

        // Bucket already has some values
        else {
            while (true){
                if(e.getKey().equals(key)){
                    V oldVal = e.getValue();
                    e.setValue(value);
                    return oldVal;
                }

                if(e.getNext() == null){
                    e.setNext(new Entry<>(key, value));
                    return null;
                }

                e = e.getNext();
            }
        }
    }

    public V get(K key) {
        int index = indexOf(key);
        Entry<K,V> e = mTable.get(index);

        while (true){
            if(e.getKey().equals(key))
                return e.getValue();

            if(e.getNext() == null)
                return null;

            e = e.getNext();
        }
    }

    public V remove(K key) {
        int index = indexOf(key);
        Entry<K,V> e = mTable.get(index);

        // Removing value at head
        if(e.getKey().equals(key)){
            mTable.set(index, e.getNext());
            return e.getValue();
        }

        Entry<K,V> prev = e;
        Entry<K,V> now = e.getNext();
        while (true){
            if(now == null)
                return null;

            if(now.getKey().equals(key)) {
                prev.setNext(now.getNext());
                return now.getValue();
            }

            prev = now;
            now = now.getNext();
        }
    }

    public void print(){
        for (Entry<K,V> e : mTable){
            System.out.println("----------------");
            while (e != null){
                System.out.println("Key : " + e.getKey() + " Value : " + e.getValue());
                e = e.getNext();
            }
        }
    }

    /**
     * An entry that encapsulates key-value pairs into one object.
     */
    private class Entry<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V val){
            this.key = key;
            this.value = val;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oval = this.value;
            this.value = value;
            return oval;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
