package com.company;

import com.company.services.CollectionService;
import com.company.services.StringOperationsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static CollectionService collectionService = new CollectionService();
    private static StringOperationsService stringOperationService = new StringOperationsService();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Collection operation starts....
        ArrayList inputList = new ArrayList();
        HashMap<String, String> inputMap = new HashMap();
        char checkWhetherContinueOrNot = 'y';
        System.out.println("You are performing arraylist and hashmap traversing.");
        System.out.println("Enter the items arraylist : ");
        do {
            inputList.add(scan.next());
            System.out.println("Would you like to enter new item(y/n) : ");
            checkWhetherContinueOrNot = scan.next().charAt(0);
        } while (checkWhetherContinueOrNot == 'y');
        System.out.println("Enter the items hashmap(key value) : ");
        do {
            inputMap.put(scan.next(), scan.next());
            System.out.println("Would you like to enter new item(y/n): ");
            checkWhetherContinueOrNot = scan.next().charAt(0);
        } while (checkWhetherContinueOrNot == 'y');
        collectionService.traverseCollection(inputList, inputMap);
        //String operation starts.....
        System.out.println("\nYou are performing string operation.");
        stringOperationService.doStringInputOutput();
    }
}