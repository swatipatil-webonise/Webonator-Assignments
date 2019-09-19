package com.company.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectionService {
    public void traverseCollection(ArrayList list, HashMap<String, String> map) {
        Iterator iterator = list.iterator();
        System.out.println("\nTraversing given arraylist : ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("\nTraversing given hashmap : \nKey\tValue");
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
    }
}
