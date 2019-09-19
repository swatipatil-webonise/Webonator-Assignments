package com.company;

import com.company.services.CollectionService;
import com.company.services.StringOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static CollectionService service;
    public static StringOperations operations;

    public static void main(String[] args) {
        service = new CollectionService();
        operations = new StringOperations();
        Scanner scan = new Scanner(System.in);
        ArrayList list = new ArrayList();
        HashMap<String, String> map = new HashMap();
        char checkWhetherContinueOrNot = 'y';
        System.out.println("You are performing arraylist and hashmap traversing.");
        System.out.println("Enter the items arraylist : ");
        do {
            list.add(scan.next());
            System.out.println("Would you like to enter new item(y/n) : ");
            checkWhetherContinueOrNot = scan.next().charAt(0);
        } while (checkWhetherContinueOrNot == 'y');
        System.out.println("Enter the items hashmap(key value) : ");
        do {
            map.put(scan.next(), scan.next());
            System.out.println("Would you like to enter new item(y/n): ");
            checkWhetherContinueOrNot = scan.next().charAt(0);
        } while (checkWhetherContinueOrNot == 'y');
        service.traverseCollection(list, map);
        System.out.println("\nYou are performing string operation.");
        operations.doStringInputOutput();
    }
}
