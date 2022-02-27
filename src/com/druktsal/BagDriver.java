package com.druktsal;

/**
 * CS 2400 Project 1 driver class
 */
public class BagDriver {

    /**
     * client program
     * demonstrates use of union, intersection, and difference methods implemented
     * for the Bag ADT
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Demonstrating implemented methods from BagInterface");
        
        // initializing linked bags of different types
        BagInterface<Integer> linkedInt1 = new LinkedBag<>();
        BagInterface<Integer> linkedInt2 = new LinkedBag<>();
        BagInterface<Integer> linkedInt3 = new LinkedBag<>();
        BagInterface<String> linkedString1 = new LinkedBag<>() ;
        BagInterface<String> linkedString2 = new LinkedBag<>();
        BagInterface<String> linkedString3 = new LinkedBag<>();
        // initializing resizeable array bags of different types
        BagInterface<Integer> arrayInt1 = new ResizeableArrayBag<>();
        BagInterface<Integer> arrayInt2 = new ResizeableArrayBag<>();
        BagInterface<Integer> arrayInt3 = new ResizeableArrayBag<>();
        BagInterface<String> arrayString1 = new ResizeableArrayBag<>() ;
        BagInterface<String> arrayString2 = new ResizeableArrayBag<>();
        BagInterface<String> arrayString3 = new ResizeableArrayBag<>();

        // filling the integer linked bags:
        linkedInt1.add(1);
        linkedInt1.add(2);
        linkedInt1.add(3);
        linkedInt1.add(4);
        linkedInt1.add(5);
        linkedInt1.add(6);
        linkedInt1.add(7);
        linkedInt1.add(8);
        linkedInt1.add(9);
        linkedInt1.add(10);
        linkedInt2.add(2);
        linkedInt2.add(4);
        linkedInt2.add(6);
        linkedInt2.add(8);
        linkedInt2.add(10);
        linkedInt2.add(12);
        linkedInt2.add(14);
        linkedInt2.add(16);
        linkedInt2.add(18);
        linkedInt2.add(20);
        linkedInt3.add(10);
        linkedInt3.add(9);
        linkedInt3.add(8);
        linkedInt3.add(7);
        linkedInt3.add(6);
        linkedInt3.add(5);
        linkedInt3.add(4);
        linkedInt3.add(3);
        linkedInt3.add(2);
        linkedInt3.add(1);
        // demo only including integer linked lists
        System.out.println("demo linked list Integer bags");
        demoUnion(linkedInt1,linkedInt2,"linked union method between two linked bags, integer: ");
        demoDifference(linkedInt1,linkedInt3,"linked difference method between two linked bags, integer: ");
        demoIntersection(linkedInt2,linkedInt3,"linked intersection method between two linked bags, integer: ");
        
        // filling the string linked bags
        linkedString1.add("I");
        linkedString1.add("am");
        linkedString1.add("The");
        linkedString1.add("The");
        linkedString2.add("I");
        linkedString2.add("love");
        linkedString2.add("Data");
        linkedString2.add("Structures");
        linkedString2.add("and");
        linkedString2.add("Algorithms");
        linkedString3.add("I");
        linkedString3.add("am");
        linkedString3.add("not");
        linkedString3.add("The");
        linkedString3.add("The");
        // demo only including linked list strings bags
        System.out.println("\n\ndemo Linked list String bags");
        demoUnion(linkedString1,linkedString2,"linked union method between two linked bags, string : ");
        demoDifference(linkedString3,linkedString1,"linked difference method between two linked bags, string: ");
        demoIntersection(linkedString2,linkedString3,"linked intersection method between two linked bags:, string ");

        // filling the integer array bags:
        arrayInt1.add(1);
        arrayInt1.add(2);
        arrayInt1.add(3);
        arrayInt1.add(4);
        arrayInt1.add(5);
        arrayInt1.add(6);
        arrayInt1.add(7);
        arrayInt1.add(8);
        arrayInt1.add(9);
        arrayInt1.add(10);
        arrayInt2.add(2);
        arrayInt2.add(4);
        arrayInt2.add(6);
        arrayInt2.add(8);
        arrayInt2.add(10);
        arrayInt2.add(12);
        arrayInt2.add(14);
        arrayInt2.add(16);
        arrayInt2.add(18);
        arrayInt2.add(20);
        arrayInt3.add(10);
        arrayInt3.add(9);
        arrayInt3.add(8);
        arrayInt3.add(7);
        arrayInt3.add(6);
        arrayInt3.add(5);
        arrayInt3.add(4);
        arrayInt3.add(3);
        arrayInt3.add(2);
        arrayInt3.add(1);
        // demo only including integer array lists
        System.out.println("\n\ndemo Array list Integer bags");
        demoUnion(arrayInt1,arrayInt2,"array union method between two array bags, integer: ");
        demoDifference(arrayInt1,arrayInt3,"array difference method between two array bags, integer: ");
        demoIntersection(arrayInt2,arrayInt3,"array intersection method between two array bags, integer: ");

        // filling the string array bags
        arrayString1.add("I");
        arrayString1.add("am");
        arrayString1.add("The");
        arrayString1.add("The");
        arrayString2.add("I");
        arrayString2.add("love");
        arrayString2.add("Data");
        arrayString2.add("Structures");
        arrayString2.add("and");
        arrayString2.add("Algorithms");
        arrayString3.add("I");
        arrayString3.add("am");
        arrayString3.add("not");
        arrayString3.add("The");
        arrayString3.add("The");
        // demo only including array list strings bags
        System.out.println("\n\ndemo array list String bags");
        demoUnion(arrayString1,arrayString2,"array union method between two array bags, string : ");
        demoDifference(arrayString3,arrayString1,"array difference method between two array bags, string: ");
        demoIntersection(arrayString2,arrayString3,"array intersection method between two array bags:, string ");

        //demo the methods on different types of bags
        System.out.println("\n\ndemo comparisons among linked bags and array bags");
        demoUnion(arrayString1,linkedString2,"array union method between one array bag and one linked bag, string : ");
        demoDifference(linkedInt1,arrayInt3,"linked difference method between one array bag and one linked bag, integer: ");
        demoIntersection(linkedString2,arrayString3,"array intersection method one array bag and one linked bag:, string ");

        // demonstrating other methods in bagInterface
        System.out.println("\n\nDemonstrating other methods in bagInterface");
        System.out.println("Calling toString method on bag: "+ arrayInt1.toString());
        System.out.println("Getting current size: "+arrayInt1.getCurrentSize());
        System.out.println("Checking if empty: "+arrayInt1.isEmpty());
        arrayInt1.add(69);
        System.out.println("Adding an entry: "+ arrayInt1.toString());
        arrayInt1.remove(69);
        System.out.println("Removing that entry: "+arrayInt1.toString());
        arrayInt1.remove();
        System.out.println("Removing the first entry: " +arrayInt1.toString());
        System.out.println("Checking the frequency of the entry '1': " +arrayInt1.getFrequencyOf(1));
        System.out.println("Checking if the bag contains the entry '1': " +arrayInt1.contains(1));
    }

    public static <T> void demoUnion(BagInterface<T> bag1, BagInterface<T> bag2,String prompt){
        System.out.println("\n" + prompt);
        System.out.println("Bag 1: " + bag1);
        System.out.println("Bag 2: " + bag2);
        System.out.println("Bag result: " + bag1.union(bag2));
    }

    public static <T> void demoDifference(BagInterface<T> bag1, BagInterface<T> bag2,String prompt){
        System.out.println("\n" + prompt);
        System.out.println("Bag 1: " + bag1);
        System.out.println("Bag 2: " + bag2);
        System.out.println("Bag result: " + bag1.difference(bag2));
    }

    public static<T> void demoIntersection(BagInterface<T> bag1, BagInterface<T> bag2,String prompt){
        System.out.println("\n" + prompt);
        System.out.println("Bag 1: " + bag1);
        System.out.println("Bag 2: " + bag2);
        System.out.println("Bag result: " + bag1.intersection(bag2));
    }
}
