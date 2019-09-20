package com.company.services;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class StringOperationsService {
    public String removeDuplicates(String inputString) {
        String inputStringSplitArray[] = inputString.split(" ");
        inputString = "";
        LinkedHashSet<String> inputSet = new LinkedHashSet<>();
        for (String str : inputStringSplitArray) {
            inputSet.add(str);
        }
        Iterator<String> inputSetIterator = inputSet.iterator();
        while (inputSetIterator.hasNext()) {
            inputString = inputString + inputSetIterator.next() + " ";
        }
        return inputString;
    }

    public void doStringInputOutput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string from which you want to remove duplicates : ");
        inputString = removeDuplicates(scan.nextLine());
        System.out.println("After removing duplicates : " + inputString);
    }
}




