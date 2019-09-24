package services;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class StringOperationsService {

   public void removeDuplicates(String stringToRemoveDuplicates) {
        LinkedHashSet<String> inputSet = new LinkedHashSet<>();
        for(String stringSlice : stringToRemoveDuplicates.split(" ")){
            inputSet.add(stringSlice);
        }
        stringToRemoveDuplicates = "";
        for(String itemFromInputSet : inputSet) {
            stringToRemoveDuplicates = stringToRemoveDuplicates + " " + itemFromInputSet;
        }
        System.out.println("After removing duplicates string is : " + stringToRemoveDuplicates);
    }
}
