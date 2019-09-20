package com.company.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectionService {
    public void traverseCollection(ArrayList inputList, HashMap<String, String> inputMap) {
        Iterator collectionIterator = inputList.iterator();
        System.out.println("\nTraversing given arraylist : ");
        while (collectionIterator.hasNext()) {
            System.out.println(collectionIterator.next());
        }
        System.out.println("\nTraversing given hashmap : \nKey\tValue");
        collectionIterator = inputMap.entrySet().iterator();
        while (collectionIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) collectionIterator.next();
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
    }
}