package services;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class StringOperationsService {

    private Scanner scan = new Scanner(System.in);

    public String removeDuplicates(String stringToRemoveDuplicates) {
        LinkedHashSet<String> inputSet = new LinkedHashSet<>();
        for(String stringSlice : stringToRemoveDuplicates.split(" ")){
            inputSet.add(stringSlice);
        }
        return stringToRemoveDuplicates;
    }
}




