package com.druktsal;

import java.util.Arrays;

/**
 * implementation of basic bag data structure that uses a linked list structure
 * @param <T> generically-typed
 */
public class LinkedBag<T> implements BagInterface<T> {

    /**
     * instance variables
     */
    private Node head;
    private int count;

    /**
     * default constructor
     */
    public LinkedBag() {
        head = null;
        count = 0;
    }

    /**
     * inner class for linked list node
     */
    private class Node {
        /**
         * Node instance variables
         */
        private T data;
        private Node next;

        /**
         * Node constructor, data only
         */
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        /**
         * Node constructor, includes nextNode
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * Node getters and setters
         */
        private T getData() { 
            return data; 
        }

        private void setData(T newData) { 
            data = newData; 
        }

        private Node getNextNode() { 
            return next; 
        }

        private void setNextNode(Node nextNode) { 
            next = nextNode; 
        }
    }

    /**
     * gets number of entries in bag
     * @return integer count
     */
    @Override
    public int getCurrentSize() { 
        return count; 
    }

    /**
     * checks if bag is empty
     * @return true if bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (head == null) 
            return true;
        return false;
    }

    /**
     * adds specified item to bag
     * @param newEntry  The object to be added as a new entry.
     * @return true if add was successful, false otherwise
     */
    @Override
    public boolean add(T newEntry) {
        if (newEntry == null) {
            return false;
        }
        Node newNode = new Node(newEntry);
        newNode.setNextNode(head);
        head = newNode;
        count++;
        return true;
    }

    /**
     * Locates a given entry within this bag
     * 
     */
    private Node getReferenceTo(T anEntry) {
        Node current = head;
        while (current != null)
        {
            if (anEntry.equals(current.data))
                return current;
            else
                current = current.next;
        }
        return null;
    }

    /**
     * removes first entry from bag
     * @return the item removed (if present, null otherwise)
     */
    @Override
    public T remove() {
        T result = null;
        if (head != null) {
            result = head.data;
            head = head.next;
            count--;
        }
        return result;
    }

    /**
     * removes specified entry from bag
     * @param anEntry  The entry to be removed.
     * @return true if remove successful, false otherwise
     */
    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.data = head.data;
            remove();
            result = true;
        }
        return result;
    }

    /**
     * removes all nodes from linked list
     */
    @Override
    public void clear() {
        head = null;
        count = 0;
    }

    /** Counts the number of times a given entry appears in this bag
     * @param anEntry The entry to be counted
     * @return The number of times anEntry appears in the bag
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        int freq=0, i=0;
        Node current = head;
        while ((i < count) && (current != null))
        {
            if (anEntry.equals(current.data))
                freq++;
            i++;
            current = current.next;
        }
        return freq;
    }

    /**
     * checks if bag contains given entry
     * @param anEntry  The entry to find.
     * @return true if entry is in bag, false otherwise
     */
    @Override
    public boolean contains(T anEntry) {
        if (getReferenceTo(anEntry) == null)
            return false;
        return true;
    }

    /**
     * copies this bags contents to a newly-allocated array
     * @return the (generically-typed) array
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Object[count];
        int i=0;
        Node current = head;
        while ((i < count) && (current != null)) {
            arr[i] = current.data;
            i++;
            current = current.next;
        }
        return arr;
    }

    /**
     * returns formatted string representation of bag's contents
     */
    @Override
    public String toString() {
        String output = "";
        if (isEmpty()) {
            return "bag empty";
        }
        T[] contents = this.toArray();
        for (int i = 0; i < contents.length; i++) {
            if (i == contents.length - 1) {
                output += contents[i] + "";
                continue;
            }
            output += contents[i] + " , ";
        }
        return output;
    }

    /**
     * checks if this bag and bag2 are equal
     * @param bag2 bag to be compared
     * @return true if the bags are equal, false otherwise
     */
    public boolean bagEquals(BagInterface<T> bag2) {
        T[] b1 = (T[]) this.toArray();
        T[] b2 = (T[]) bag2.toArray();
        Arrays.sort(b1);
        Arrays.sort(b2);
        return Arrays.equals(b1, b2);
    }

    /**
     * @param bag2  The bag whose contents to subtract
     * @return a new bag whose collection are the total added entries
     * of both collections
     */ 
    public BagInterface<T> union(BagInterface<T> bag2) throws NullPointerException {
        if (bag2 == null) {
            throw new NullPointerException("passed in a null bag");
        } //checks if second bag is null

        T[] contentsOfBag2 = bag2.toArray();
        LinkedBag<T> copyBag2 = new LinkedBag<T>();
        for (int i = 0; i < contentsOfBag2.length; i++) {
            copyBag2.add(contentsOfBag2[i]);
        }

        Node current = this.head;
        BagInterface<T> linkedUnion = new LinkedBag<T>();
    
        while (current != null) {
            linkedUnion.add(current.getData());
            current = current.next;
        }
        current = copyBag2.head;
        while (current != null) {
            linkedUnion.add(current.getData());
            current = current.next;
        }
        return linkedUnion;
    } //end union

    /**
     * @param bag2  The bag whose contents to subtract
     * @return a new bag whose collection are the entries left over after removing 
     * the ones that occur in another bag
     */ 
    public BagInterface<T> difference(BagInterface<T> bag2) throws NullPointerException {
        if (bag2 == null) {
            throw new NullPointerException("passed in a null bag");
        }//checks if second bag is null

        T[] contentsOfBag2 = bag2.toArray();
        LinkedBag<T> copyBag2 = new LinkedBag<T>();
        for (int i = 0; i < contentsOfBag2.length; i++) {
            copyBag2.add(contentsOfBag2[i]);
        }

        BagInterface<T> copyBag1 = new LinkedBag<T>();
        Node current = this.head;
        while (current != null) {
            copyBag1.add(current.getData());
            current = current.next;
        }

        Node currentBag2 = copyBag2.head;
        while (currentBag2 != null) {
            if (copyBag1.contains(currentBag2.getData())) {
                copyBag1.remove(currentBag2.getData());
            }
            currentBag2 = currentBag2.next;
        }
        return copyBag1;
    } //end difference

    /**
     * @param bag2  The bag whose contents to subtract
     * @return a new bag whose collection are the entries that occur 
     * in both collections
    */ 
    public BagInterface<T> intersection(BagInterface<T> bag2) {
        if (bag2 == null) {
            throw new NullPointerException("passed in a null bag");
        } //checks if second bag is null

        BagInterface<T> linkedIntersection = new LinkedBag<T>();
        BagInterface<T> copyBag1 = new LinkedBag<T>();
        LinkedBag<T> copyBag2 = new LinkedBag<T>();  
        T[] contentsBag2 = bag2.toArray();         //creates a method with contents of bag2 in it
        for (int i = 0; i < bag2.getCurrentSize(); i++) {
            copyBag2.add(contentsBag2[i]);
        }

        Node current = this.head;
        while (current != null) {
            copyBag1.add(current.getData());
            current = current.next;
        }
        current = copyBag2.head;
        while (current != null) {
            if (copyBag1.contains(current.getData())) {
                linkedIntersection.add(current.getData());
                copyBag1.remove(current.getData());
            }
            current = current.next;
        } 
        return linkedIntersection;
    } //end intersection

    

}
