package com.company.services;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class StringOperations {
    public String removeDuplicates(String string) {
        String array[] = string.split(" ");
        string = "";
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String str : array) {
            set.add(str);
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            string = string + iterator.next() + " ";
        }
        return string;
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
