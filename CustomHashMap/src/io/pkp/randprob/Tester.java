package io.pkp.randprob;

/**
 * Created by praveen on 5/10/16.
 */
public class Tester {
    public static void main(String[] args){
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>(2);
        myHashMap.put(1, "One");
        myHashMap.put(4, "Four");
        myHashMap.put(2, "Two");
        myHashMap.put(3, "Three");
        myHashMap.put(17, "Seventeen");
        myHashMap.put(2, "TwoDash");
        myHashMap.put(17, "SeventeenDash");
        myHashMap.print();
    }
}
