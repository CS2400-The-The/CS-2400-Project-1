package com.druktsal;

public class ArrayBagTest {
    /**
     * client program: runs tests for ResizeableArrayBag
     */
    public static <T> void main(String[] args) {

        System.out.println("Testing methods for resizeable array based bag implementation...");

        testUnion();
        testIntersection();
        testDifference();
    }

    public static void testUnion() {
        System.out.println("Testing bag union...");

        System.out.println("Test A: one bag empty");
        ResizeableArrayBag bagA1 = new ResizeableArrayBag();
        ResizeableArrayBag bagA2 = new ResizeableArrayBag(4);
        ResizeableArrayBag expectedA = new ResizeableArrayBag(4);

        bagA2.add(2);
        bagA2.add(4);
        bagA2.add(6);
        bagA2.add(8);

        expectedA.add(2);
        expectedA.add(4);
        expectedA.add(6);
        expectedA.add(8);

        ResizeableArrayBag actualA = bagA1.union(bagA2);
        System.out.println("Bag1: " + bagA1);
        System.out.println("Bag2: " + bagA2);
        System.out.println("Expected: " + expectedA);
        System.out.println("Actual: " + actualA);
        if (actualA.bagEquals(expectedA))
            System.out.println("Test A passed!");
        else
            System.out.println("Test A failed!");
        System.out.println();

        System.out.println("Test B: nonempty, repeat elements");
        ResizeableArrayBag bagB1 = new ResizeableArrayBag(5);
        ResizeableArrayBag bagB2 = new ResizeableArrayBag(4);
        ResizeableArrayBag expectedB = new ResizeableArrayBag(3);

        bagB1.add(1);
        bagB1.add(2);
        bagB1.add(7);
        bagB1.add(4);

        bagB2.add(2);
        bagB2.add(1);
        bagB2.add(9);

        expectedB.add(1);
        expectedB.add(1);
        expectedB.add(2);
        expectedB.add(2);
        expectedB.add(4);
        expectedB.add(7);
        expectedB.add(9);

        ResizeableArrayBag actualB = bagB1.union(bagB2);
        System.out.println("Bag1: " + bagB1);
        System.out.println("Bag2: " + bagB2);
        System.out.println("Expected: " + expectedB);
        System.out.println("Actual: " + actualB);
        if (actualB.bagEquals(expectedB))
            System.out.println("Test B passed!");
        else
            System.out.println("Test B failed!");
        System.out.println();
    }

    public static void testIntersection() {

        System.out.println("Testing bag intersection...");

        System.out.println("Test B: nonempty, repeat elements");
        ResizeableArrayBag bagB1 = new ResizeableArrayBag(5);
        ResizeableArrayBag bagB2 = new ResizeableArrayBag(4);
        ResizeableArrayBag expectedB = new ResizeableArrayBag(3);

        bagB1.add(1);
        bagB1.add(1);
        bagB1.add(2);
        bagB1.add(6);
        bagB1.add(8);

        bagB2.add(2);
        bagB2.add(1);
        bagB2.add(5);
        bagB2.add(8);

        expectedB.add(1);
        expectedB.add(2);
        expectedB.add(8);

        ResizeableArrayBag actualB = bagB1.intersection(bagB2);
        System.out.println("Bag1: " + bagB1);
        System.out.println("Bag2: " + bagB2);
        System.out.println("Expected: " + expectedB);
        System.out.println("Actual: " + actualB);
        if (actualB.bagEquals(expectedB))
            System.out.println("Test B passed!");
        else
            System.out.println("Test B failed!");
        System.out.println();
    }

    public static void testDifference() {

        System.out.println("Testing bag difference...");

        System.out.println("Test B: bag1 larger than bag2");
        ResizeableArrayBag bagB1 = new ResizeableArrayBag(5);
        ResizeableArrayBag bagB2 = new ResizeableArrayBag(3);
        ResizeableArrayBag expectedB = new ResizeableArrayBag(2);

        bagB1.add(1);
        bagB1.add(1);
        bagB1.add(2);
        bagB1.add(6);
        bagB1.add(5);

        bagB2.add(2);
        bagB2.add(1);
        bagB2.add(5);

        expectedB.add(1);
        expectedB.add(6);

        ResizeableArrayBag actualB = bagB1.difference(bagB2);
        System.out.println("Bag1: " + bagB1);
        System.out.println("Bag2: " + bagB2);
        System.out.println("Expected: " + expectedB);
        System.out.println("Actual: " + actualB);
        if (actualB.bagEquals(expectedB))
            System.out.println("Test B passed!");
        else
            System.out.println("Test B failed!");
        System.out.println();
    }
}
