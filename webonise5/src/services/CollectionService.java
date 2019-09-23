package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionService {

    public void traverseArrayList(ArrayList inputList) {
        System.out.println("\nTraversing given arraylist : ");
        for(Object stringItemFromList : inputList){
            System.out.println(" " + stringItemFromList);
        }
    }
    public void traverseHashMap(HashMap < Object, Object > inputMap){
        System.out.println("\nTraversing given hashmap : \nValue\tKey");
        for (Map.Entry<Object,Object> entryFromMap : inputMap.entrySet()) {
            System.out.println(entryFromMap.getValue().toString() + "\t" + entryFromMap.getKey().toString());
        }
    }
}