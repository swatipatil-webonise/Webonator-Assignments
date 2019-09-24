import services.CollectionService;
import services.StringOperationsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CollectionAndStringOperationApp {

    private static CollectionService collectionService = new CollectionService();
    private static StringOperationsService stringOperationService = new StringOperationsService();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //Collection operation starts....
        ArrayList<Object> inputList = new ArrayList();
        HashMap<Object, Object> inputMap = new HashMap();
        char checkWhetherContinueOrNot = 'y';
        System.out.println("You are performing arraylist and hashmap traversing\nEnter the items arraylist : ");
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
        collectionService.traverseArrayList(inputList);
        collectionService.traverseHashMap(inputMap);
        //String operation starts.....
        System.out.println("\nYou are performing string operation\nEnter the string from which you want to remove duplicates : ");
        stringOperationService.removeDuplicates("I am swati , I am an employee of webonise.");
    }
}
