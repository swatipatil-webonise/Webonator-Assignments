package com.company.services;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class StringOperations {
    public String removeDuplicates(String inputString) {
        String array[] = inputString.split(" ");
        inputString = "";
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String str : array) {
            set.add(str);
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            inputString = inputString + iterator.next() + " ";
        }
        return inputString;
    }

    public void doStringInputOutput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string from which you want to remove duplicates : ");
        String inputString = scan.nextLine();
        System.out.println(inputString);
        inputString = removeDuplicates(inputString);
        System.out.println("After removing duplicates : " + inputString);
    }
}

