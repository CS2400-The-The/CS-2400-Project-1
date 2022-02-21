package com.druktsal;

import static org.junit.jupiter.api.Assertions.*;

class ResizeableArrayBagTest {

    @org.junit.jupiter.api.Test
    void union() {
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
        assertTrue(actualA.bagEquals(expectedA));

        System.out.println("Test B: nonempty, repeat elements");
        ResizeableArrayBag bagB1 = new ResizeableArrayBag(4);
        ResizeableArrayBag bagB2 = new ResizeableArrayBag(3);
        ResizeableArrayBag expectedB = new ResizeableArrayBag(7);

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
        assertTrue(actualB.bagEquals(expectedB));

        System.out.println("Test C: no repeat elements");
        ResizeableArrayBag bagC1 = new ResizeableArrayBag(3);
        ResizeableArrayBag bagC2 = new ResizeableArrayBag(2);
        ResizeableArrayBag expectedC = new ResizeableArrayBag(5);

        bagC1.add(1);
        bagC1.add(2);
        bagC1.add(7);

        bagC2.add(5);
        bagC2.add(8);

        expectedC.add(1);
        expectedC.add(2);
        expectedC.add(5);
        expectedC.add(7);
        expectedC.add(8);


        ResizeableArrayBag actualC = bagC1.union(bagC2);
        System.out.println("Bag1: " + bagC1);
        System.out.println("Bag2: " + bagC2);
        System.out.println("Expected: " + expectedC);
        System.out.println("Actual: " + actualC);
        assertTrue(actualC.bagEquals(expectedC));
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void intersection() {
        System.out.println("Testing bag intersection...");

        System.out.println("Test A: one bag empty");
        ResizeableArrayBag bagA1 = new ResizeableArrayBag();
        ResizeableArrayBag bagA2 = new ResizeableArrayBag(2);

        bagA1.add(1);
        bagA1.add(3);
        bagA1.add(5);

        ResizeableArrayBag actualA = bagA1.intersection(bagA2);
        System.out.println("Bag1: " + bagA1);
        System.out.println("Bag2: " + bagA2);
        System.out.println("Expected: bag empty");
        System.out.println("Actual: " + actualA);
        assertTrue(actualA.isEmpty());

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
        assertTrue(actualB.bagEquals(expectedB));

        System.out.println("Test C: no repeat elements");
        ResizeableArrayBag bagC1 = new ResizeableArrayBag(4);
        ResizeableArrayBag bagC2 = new ResizeableArrayBag(4);
        ResizeableArrayBag expectedC = new ResizeableArrayBag(2);

        bagC1.add(1);
        bagC1.add(2);
        bagC1.add(8);
        bagC1.add(6);

        bagC2.add(3);
        bagC2.add(1);
        bagC2.add(5);
        bagC2.add(8);

        expectedC.add(1);
        expectedC.add(8);

        ResizeableArrayBag actualC = bagC1.intersection(bagC2);
        System.out.println("Bag1: " + bagC1);
        System.out.println("Bag2: " + bagC2);
        System.out.println("Expected: " + expectedC);
        System.out.println("Actual: " + actualC);
        assertTrue(actualC.bagEquals(expectedC));
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void difference() {
        System.out.println("Testing bag difference...");

        System.out.println("Test A: second bag empty");
        ResizeableArrayBag bagA1 = new ResizeableArrayBag(3);
        ResizeableArrayBag bagA2 = new ResizeableArrayBag();
        ResizeableArrayBag expectedA = new ResizeableArrayBag(3);

        bagA1.add(1);
        bagA1.add(3);
        bagA1.add(5);

        expectedA.add(1);
        expectedA.add(3);
        expectedA.add(5);

        ResizeableArrayBag actualA = bagA1.difference(bagA2);
        System.out.println("Bag1: " + bagA1);
        System.out.println("Bag2: " + bagA2);
        System.out.println("Expected: " + expectedA);
        System.out.println("Actual: " + actualA);
        assertTrue(actualA.bagEquals(expectedA));

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
        assertTrue(actualB.bagEquals(expectedB));

        System.out.println("Test C: bag2 larger than bag1");
        ResizeableArrayBag bagC1 = new ResizeableArrayBag(3);
        ResizeableArrayBag bagC2 = new ResizeableArrayBag(4);
        ResizeableArrayBag expectedC = new ResizeableArrayBag(2);

        bagC1.add(2);
        bagC1.add(1);
        bagC1.add(5);

        bagC2.add(1);
        bagC2.add(3);
        bagC2.add(9);
        bagC2.add(8);

        expectedC.add(2);
        expectedC.add(5);

        ResizeableArrayBag actualC = bagC1.difference(bagC2);
        System.out.println("Bag1: " + bagC1);
        System.out.println("Bag2: " + bagC2);
        System.out.println("Expected: " + expectedC);
        System.out.println("Actual: " + actualC);
        assertTrue(actualC.bagEquals(expectedC));

        System.out.println("Test D: equal bags");
        ResizeableArrayBag bagD1 = new ResizeableArrayBag(2);
        ResizeableArrayBag bagD2 = new ResizeableArrayBag(2);

        bagD1.add(1);
        bagD1.add(2);

        bagD2.add(2);
        bagD2.add(1);

        ResizeableArrayBag actualD = bagD1.difference(bagD2);
        System.out.println("Bag1: " + bagD1);
        System.out.println("Bag2: " + bagD2);
        System.out.println("Expected: bag empty");
        System.out.println("Actual: " + actualD);
        assertTrue(actualD.isEmpty());
    }
}