package com.druktsal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests of union, intersection, and difference methods for linked list-based bag
 */
public class LinkedBagTest {

    /**
     * test union method for LinkedBag
     */
    @Test
    void union() {
        System.out.println("Testing LinkedBag union...");
        System.out.println();

    //Test A
        System.out.println("Test A: first bag is empty");
        BagInterface<Integer> bagA1 = new LinkedBag<>();
        BagInterface<Integer> bagA2 = new LinkedBag<>();
        BagInterface<Integer> expectedA = new LinkedBag<>();

        bagA2.add(2);
        bagA2.add(4);
        bagA2.add(10);
        bagA2.add(8);

        expectedA.add(2);
        expectedA.add(4);
        expectedA.add(10);
        expectedA.add(8);

        BagInterface<Integer> actualA = bagA1.union(bagA2);
        System.out.println("Bag1: " + bagA1);
        System.out.println("Bag2: " + bagA2);
        System.out.println("Expected: " + expectedA);
        System.out.println("Actual: " + actualA);
        assertTrue(actualA.bagEquals(expectedA));
        System.out.println();
    //end Test A

    //Test B
        System.out.println("Test B: both bags are empty");
        BagInterface<Integer> bagB1 = new LinkedBag<>();
        BagInterface<Integer> bagB2 = new LinkedBag<>();
        BagInterface<Integer> expectedB = new LinkedBag<>();

        BagInterface<Integer> actualB = bagB1.union(bagB2);
        System.out.println("Bag1: " + bagB1);
        System.out.println("Bag2: " + bagB2);
        System.out.println("Expected: " + expectedB);
        System.out.println("Actual: " + actualB);
        assertTrue(actualB.bagEquals(expectedB));
        System.out.println();
    //end Test B

    //Test C
        System.out.println("Test C: both bags are equal in contents and size");
        BagInterface<Integer> bagC1 = new LinkedBag<>();
        BagInterface<Integer> bagC2 = new LinkedBag<>();
        BagInterface<Integer> expectedC = new LinkedBag<>();

        bagC1.add(10);
        bagC1.add(4);
        bagC1.add(8);

        bagC2.add(10);
        bagC2.add(4);
        bagC2.add(8);

        expectedC.add(10);
        expectedC.add(4);
        expectedC.add(8);
        expectedC.add(10);
        expectedC.add(4);
        expectedC.add(8);

        BagInterface<Integer> actualC = bagC1.union(bagC2);
        System.out.println("Bag1: " + bagC1);
        System.out.println("Bag2: " + bagC2);
        System.out.println("Expected: " + expectedC);
        System.out.println("Actual: " + actualC);
        assertTrue(actualC.bagEquals(expectedC));
        System.out.println();
    //end Test C

    //Test D
        System.out.println("Test D: one bag is null");
        BagInterface<Integer> bagD1 = new LinkedBag<>();
        BagInterface<Integer> bagD2 = null;

        bagD1.add(20);
        bagD1.add(31);

        System.out.println("Bag1: " + bagD1);
        System.out.println("Bag2: " + bagD2);
        var actualD = assertThrows(NullPointerException.class, () -> {bagD1.union(bagD2);});
        System.out.println("Method should throw an exception.\n" + "Result: " + actualD);
        System.out.println();

    //end Test D

    //Test E
        System.out.println("Test E: second bag is empty");
        BagInterface<Integer> bagE1 = new LinkedBag<>();
        BagInterface<Integer> bagE2 = new LinkedBag<>();
        BagInterface<Integer> expectedE = new LinkedBag<>();

        bagE1.add(20);
        bagE1.add(8);
        bagE1.add(2);
        bagE1.add(13);

        expectedE.add(20);
        expectedE.add(8);
        expectedE.add(2);
        expectedE.add(13);

        BagInterface<Integer> actualE = bagE1.union(bagE2);
        System.out.println("Bag1: " + bagE1);
        System.out.println("Bag2: " + bagE2);
        System.out.println("Expected: " + expectedE);
        System.out.println("Actual: " + actualE);
        assertTrue(actualE.bagEquals(expectedE));
        System.out.println();
    //end Test E

    //Test F
        System.out.println("Test F: first bag is bigger than second bag, but has same contents");
        BagInterface<Integer> bagF1 = new LinkedBag<>();
        BagInterface<Integer> bagF2 = new LinkedBag<>();
        BagInterface<Integer> expectedF = new LinkedBag<>();

        bagF1.add(2);
        bagF1.add(4);
        bagF1.add(10);
        bagF1.add(8);

        bagF2.add(2);
        bagF2.add(4);
        bagF2.add(10);

        expectedF.add(2);
        expectedF.add(4);
        expectedF.add(10);
        expectedF.add(8);
        expectedF.add(2);
        expectedF.add(4);
        expectedF.add(10);

        BagInterface<Integer> actualF = bagF1.union(bagF2);
        System.out.println("Bag1: " + bagF1);
        System.out.println("Bag2: " + bagF2);
        System.out.println("Expected: " + expectedF);
        System.out.println("Actual: " + actualF);
        assertTrue(actualF.bagEquals(expectedF));
        System.out.println();
    //end Test F

    //Test G
    System.out.println("Test G: second bag is bigger than first bag, but has same contents");
        BagInterface<Integer> bagG1 = new LinkedBag<>();
        BagInterface<Integer> bagG2 = new LinkedBag<>();
        BagInterface<Integer> expectedG = new LinkedBag<>();

        bagG2.add(70);
        bagG2.add(5);
        bagG2.add(60);
        bagG2.add(21);

        bagG1.add(3);
        bagG1.add(13);
        bagG1.add(57);

        expectedG.add(70);
        expectedG.add(5);
        expectedG.add(60);
        expectedG.add(21);
        expectedG.add(3);
        expectedG.add(13);
        expectedG.add(57);

        BagInterface<Integer> actualG = bagG1.union(bagG2);
        System.out.println("Bag1: " + bagG1);
        System.out.println("Bag2: " + bagG2);
        System.out.println("Expected: " + expectedG);
        System.out.println("Actual: " + actualG);
        assertTrue(actualG.bagEquals(expectedG));
        System.out.println();
    //end Test G

    //Test H
        System.out.println("Test H: bags have different contents");
        BagInterface<Integer> bagH1 = new LinkedBag<>();
        BagInterface<Integer> bagH2 = new LinkedBag<>();
        BagInterface<Integer> expectedH = new LinkedBag<>();

        bagH1.add(73);
        bagH1.add(12);
        bagH1.add(8);

        bagH2.add(90);
        bagH2.add(83);
        bagH2.add(3);

        expectedH.add(73);
        expectedH.add(12);
        expectedH.add(8);
        expectedH.add(90);
        expectedH.add(83);
        expectedH.add(3);

        BagInterface<Integer> actualH = bagH1.union(bagH2);
        System.out.println("Bag1: " + bagH1);
        System.out.println("Bag2: " + bagH2);
        System.out.println("Expected: " + expectedH);
        System.out.println("Actual: " + actualH);
        assertTrue(actualH.bagEquals(expectedH));
        System.out.println();
    //end Test H
    }

    /**
     * test difference method for LinkedBag
     */
    @Test
    void difference() {
        System.out.println("Testing LinkedBag difference...");
        System.out.println();

    //Test A
        System.out.println("Test A: first bag is empty");
        BagInterface<Integer> bagA1 = new LinkedBag<>();
        BagInterface<Integer> bagA2 = new LinkedBag<>();
        BagInterface<Integer> expectedA = new LinkedBag<>();

        bagA2.add(10);
        bagA2.add(4);
        bagA2.add(9);

        BagInterface<Integer> actualA = bagA1.difference(bagA2);
        System.out.println("Bag1: " + bagA1);
        System.out.println("Bag2: " + bagA2);
        System.out.println("Expected: " + expectedA);
        System.out.println("Actual: " + actualA);
        assertTrue(actualA.bagEquals(expectedA));
        System.out.println();
    //end Test A

    //Test B
        System.out.println("Test B: second bag is empty");
        BagInterface<Integer> bagB1 = new LinkedBag<>();
        BagInterface<Integer> bagB2 = new LinkedBag<>();
        BagInterface<Integer> expectedB = new LinkedBag<>();

        bagB1.add(100);
        bagB1.add(23);
        bagB1.add(87);

        expectedB.add(100);
        expectedB.add(23);
        expectedB.add(87);

        BagInterface<Integer> actualB = bagB1.difference(bagB2);
        System.out.println("Bag1: " + bagB1);
        System.out.println("Bag2: " + bagB2);
        System.out.println("Expected: " + expectedB);
        System.out.println("Actual: " + actualB);
        assertTrue(actualB.bagEquals(expectedB));
        System.out.println();
    //end Test B

    //Test C
        System.out.println("Test C: both bags are empty");
        BagInterface<Integer> bagC1 = new LinkedBag<>();
        BagInterface<Integer> bagC2 = new LinkedBag<>();
        BagInterface<Integer> expectedC = new LinkedBag<>();

        BagInterface<Integer> actualC = bagC1.difference(bagC2);
        System.out.println("Bag1: " + bagC1);
        System.out.println("Bag2: " + bagC2);
        System.out.println("Expected: " + expectedC);
        System.out.println("Actual: " + actualC);
        assertTrue(actualC.bagEquals(expectedC));
        System.out.println();
    //end Test C

    //Test D
        System.out.println("Test D: both bags have the same contents and size");
        BagInterface<Integer> bagD1 = new LinkedBag<>();
        BagInterface<Integer> bagD2 = new LinkedBag<>();
        BagInterface<Integer> expectedD = new LinkedBag<>();

        bagD1.add(30);
        bagD1.add(134);
        bagD1.add(80);

        bagD2.add(30);
        bagD2.add(134);
        bagD2.add(80);

        BagInterface<Integer> actualD = bagD1.difference(bagD2);
        System.out.println("Bag1: " + bagD1);
        System.out.println("Bag2: " + bagD2);
        System.out.println("Expected: " + expectedD);
        System.out.println("Actual: " + actualD);
        assertTrue(actualD.bagEquals(expectedD));
        System.out.println();
    //end Test D

    //Test E
        System.out.println("Test E: first bag is bigger than second bag, but has same contents");
        BagInterface<Integer> bagE1 = new LinkedBag<>();
        BagInterface<Integer> bagE2 = new LinkedBag<>();
        BagInterface<Integer> expectedE = new LinkedBag<>();

        bagE1.add(3);
        bagE1.add(20);
        bagE1.add(1);
        bagE1.add(8);

        bagE2.add(3);
        bagE2.add(20);

        expectedE.add(1);
        expectedE.add(8);

        BagInterface<Integer> actualE = bagE1.difference(bagE2);
        System.out.println("Bag1: " + bagE1);
        System.out.println("Bag2: " + bagE2);
        System.out.println("Expected: " + expectedE);
        System.out.println("Actual: " + actualE);
        assertTrue(actualE.bagEquals(expectedE));
        System.out.println();
    //end Test E

    //Test F
        System.out.println("Test F: second bag is bigger than first bag, but has same contents");
        BagInterface<Integer> bagF1 = new LinkedBag<>();
        BagInterface<Integer> bagF2 = new LinkedBag<>();
        BagInterface<Integer> expectedF = new LinkedBag<>();

        bagF1.add(9);
        bagF1.add(2);

        bagF2.add(9);
        bagF2.add(2);
        bagF2.add(3);
        bagF2.add(14);

        BagInterface<Integer> actualF = bagF1.difference(bagF2);
        System.out.println("Bag1: " + bagF1);
        System.out.println("Bag2: " + bagF2);
        System.out.println("Expected: " + expectedF);
        System.out.println("Actual: " + actualF);
        assertTrue(actualF.bagEquals(expectedF));
        System.out.println();
    //end Test F

    //Test G
        System.out.println("Test G: one bag is null");
        BagInterface<Integer> bagG1 = new LinkedBag<>();
        BagInterface<Integer> bagG2 = null;

        System.out.println("Bag1: " + bagG1);
        System.out.println("Bag2: " + bagG2);
        var actualG = assertThrows(NullPointerException.class, () -> {bagG1.difference(bagG2);});
        System.out.println("Method should throw an exception.\n" + "Result: " + actualG);
        System.out.println();
    //end Test G

    //Test H
        System.out.println("Test H: bags have different contents");
        BagInterface<Integer> bagH1 = new LinkedBag<>();
        BagInterface<Integer> bagH2 = new LinkedBag<>();
        BagInterface<Integer> expectedH = new LinkedBag<>();

        bagH1.add(19);
        bagH1.add(3);
        bagH1.add(4);

        bagH2.add(6);
        bagH2.add(31);
        bagH2.add(21);

        expectedH.add(19);
        expectedH.add(3);
        expectedH.add(4);

        BagInterface<Integer> actualH = bagH1.difference(bagH2);
        System.out.println("Bag1: " + bagH1);
        System.out.println("Bag2: " + bagH2);
        System.out.println("Expected: " + expectedH);
        System.out.println("Actual: " + actualH);
        assertTrue(actualH.bagEquals(expectedH));
        System.out.println();
    //end Test H
    }

    /**
     * test intersection method for LinkedBag
     */
    @Test
    void intersection() {
        System.out.println("Testing LinkedBag intersection...");
        System.out.println();

    //Test A
        System.out.println("Test A: first bag is empty");
        BagInterface<Integer> bagA1 = new LinkedBag<>();
        BagInterface<Integer> bagA2 = new LinkedBag<>();
        BagInterface<Integer> expectedA = new LinkedBag<>();

        bagA2.add(3);
        bagA2.add(29);
        bagA2.add(10);

        BagInterface<Integer> actualA = bagA1.intersection(bagA2);
        System.out.println("Bag1: " + bagA1);
        System.out.println("Bag2: " + bagA2);
        System.out.println("Expected: " + expectedA);
        System.out.println("Actual: " + actualA);
        assertTrue(actualA.bagEquals(expectedA));
        System.out.println();
    //end Test A

    //Test B
        System.out.println("Test B: second bag is empty");
        BagInterface<Integer> bagB1 = new LinkedBag<>();
        BagInterface<Integer> bagB2 = new LinkedBag<>();
        BagInterface<Integer> expectedB = new LinkedBag<>();

        bagB1.add(13);
        bagB1.add(6);
        bagB1.add(80);

        BagInterface<Integer> actualB = bagB1.intersection(bagB2);
        System.out.println("Bag1: " + bagB1);
        System.out.println("Bag2: " + bagB2);
        System.out.println("Expected: " + expectedB);
        System.out.println("Actual: " + actualB);
        assertTrue(actualB.bagEquals(expectedB));
        System.out.println();
    //end Test B

    //Test C
        System.out.println("Test C: both bags are empty");
        BagInterface<Integer> bagC1 = new LinkedBag<>();
        BagInterface<Integer> bagC2 = new LinkedBag<>();
        BagInterface<Integer> expectedC = new LinkedBag<>();

        BagInterface<Integer> actualC = bagC1.intersection(bagC2);
        System.out.println("Bag1: " + bagC1);
        System.out.println("Bag2: " + bagC2);
        System.out.println("Expected: " + expectedC);
        System.out.println("Actual: " + actualC);
        assertTrue(actualB.bagEquals(expectedC));
        System.out.println();
    //end Test C

    //Test D
        System.out.println("Test D: bags are equal");
        BagInterface<Integer> bagD1 = new LinkedBag<>();
        BagInterface<Integer> bagD2 = new LinkedBag<>();
        BagInterface<Integer> expectedD = new LinkedBag<>();

        bagD1.add(3);
        bagD1.add(12);
        bagD1.add(9);

        bagD2.add(3);
        bagD2.add(12);
        bagD2.add(9);

        expectedD.add(3);
        expectedD.add(12);
        expectedD.add(9);

        BagInterface<Integer> actualD = bagD1.intersection(bagD2);
        System.out.println("Bag1: " + bagD1);
        System.out.println("Bag2: " + bagD2);
        System.out.println("Expected: " + expectedD);
        System.out.println("Actual: " + actualD);
        assertTrue(actualD.bagEquals(expectedD));
        System.out.println();
    //end Test D

    //Test E
        System.out.println("Test E: one bag is null");
        BagInterface<Integer> bagE1 = new LinkedBag<>();
        BagInterface<Integer> bagE2 = null;

        System.out.println("Bag1: " + bagE1);
        System.out.println("Bag2: " + bagE2);
        var actualE = assertThrows(NullPointerException.class, () -> {bagE1.intersection(bagE2);});
        System.out.println("Method should throw an exception.\n" + "Result: " + actualE);
        System.out.println();
    //end Test E

    //Test F
        System.out.println("Test F: first bag is bigger than second bag, but has same contents");
        BagInterface<Integer> bagF1 = new LinkedBag<>();
        BagInterface<Integer> bagF2 = new LinkedBag<>();
        BagInterface<Integer> expectedF = new LinkedBag<>();

        bagF1.add(20);
        bagF1.add(1);
        bagF1.add(39);

        bagF2.add(20);
        bagF2.add(1);

        expectedF.add(20);
        expectedF.add(1);

        BagInterface<Integer> actualF = bagF1.intersection(bagF2);
        System.out.println("Bag1: " + bagF1);
        System.out.println("Bag2: " + bagF2);
        System.out.println("Expected: " + expectedF);
        System.out.println("Actual: " + actualF);
        assertTrue(actualF.bagEquals(expectedF));
        System.out.println();
    //end Test F

    //Test G
        System.out.println("Test G: second bag is bigger than first bag, but has same contents");
        BagInterface<Integer> bagG1 = new LinkedBag<>();
        BagInterface<Integer> bagG2 = new LinkedBag<>();
        BagInterface<Integer> expectedG = new LinkedBag<>();

        bagG2.add(3);
        bagG2.add(7);
        bagG2.add(12);

        bagG1.add(3);
        bagG1.add(7);

        expectedG.add(3);
        expectedG.add(7);

        BagInterface<Integer> actualG = bagG1.intersection(bagG2);
        System.out.println("Bag1: " + bagG1);
        System.out.println("Bag2: " + bagG2);
        System.out.println("Expected: " + expectedG);
        System.out.println("Actual: " + actualG);
        assertTrue(actualG.bagEquals(expectedG));
        System.out.println();

    //Test H
        System.out.println("Test H: bags have different contents");
        BagInterface<Integer> bagH1 = new LinkedBag<>();
        BagInterface<Integer> bagH2 = new LinkedBag<>();
        BagInterface<Integer> expectedH = new LinkedBag<>();

        bagH1.add(3);
        bagH1.add(10);
        bagH1.add(9);

        bagH2.add(2);
        bagH2.add(1);
        bagH2.add(23);

        BagInterface<Integer> actualH = bagH1.intersection(bagH2);
        System.out.println("Bag1: " + bagH1);
        System.out.println("Bag2: " + bagH2);
        System.out.println("Expected: " + expectedH);
        System.out.println("Actual: " + actualH);
        assertTrue(actualH.bagEquals(expectedH));
        System.out.println();
    //end Test H

    }
}
