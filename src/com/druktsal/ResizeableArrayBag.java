package com.druktsal;

import java.util.Arrays;

/**
 * implementation of basic bag data structure that uses a resizeable array
 * @param <T>: generically-typed
 */
public class ResizeableArrayBag<T> implements BagInterface<T> {

    /**
     * instance variables
     */
    private static final int INITIAL_CAPACITY = 25;

    private T[] bag;
    private int count;

    /**
     * constructor: initializes new bag array and sets count to 0
     * @param capacity: used to set initial size of bag array
     */
    public ResizeableArrayBag(int capacity) {

        count = 0;
        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Object[capacity];
        bag = temp;
    }

    /**
     * default constructor
     */
    public ResizeableArrayBag() {
        this(INITIAL_CAPACITY);
    }

    /**
     * if bag has reached capacity, double length of bag array
     */
    private void resize() {

        if (count == bag.length)
            bag = Arrays.copyOf(bag, 2*bag.length);
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
        if (count == 0)
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

        resize();
        bag[count] = newEntry;
        count++;

        return true;
    }

    /**
     * removes first entry from bag
     * @return the entry removed
     */
    @Override
    public T remove() {
        if (isEmpty())
            return null;

        T element = bag[0];
        bag[0] = null;
        count--;
        bag = toArray();
        return element;
    }

    /**
     * removes a specified entry from bag
     * @param anEntry  The entry to be removed.
     * @return true if remove was successful, false otherwise
     */
    @Override
    public boolean remove(T anEntry) {
        if (isEmpty())
            return false;

        for (int i=0; i<count; i++) {
            if (bag[i] == anEntry) {
                bag[i] = null;
                count--;
                bag = toArray();
                return true;
            }
        }
        return false;
    }

    /**
     * sets bag to new, empty array
     */
    @Override
    public void clear() {
        count = 0;
        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Object[INITIAL_CAPACITY];
        bag = temp;
    }

    /**
     * counts how many times a given entry appears in the bag
     * @param anEntry  The entry to be counted.
     * @return an integer count
     */
    @Override
    public int getFrequencyOf(T anEntry) {

        int frequency = 0;

        for (int i=0; i<count; i++) {
            if (bag[i] == anEntry)
                frequency++;
        }

        return frequency;
    }

    /**
     * tests whether bag contains given entry
     * @param anEntry  The entry to find.
     * @return true if the bag contains anEntry, false otherwise
     */
    @Override
    public boolean contains(T anEntry) {
        for (int i=0; i<count; i++) {
            if (bag[i] == anEntry)
                return true;
        }
        return false;
    }

    /**
     * toArray: returns bag elements in newly-allocated non-null array
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] newBag = (T[]) new Object[count];
        int j = 0;

        for (int i=0; i<bag.length; i++) {
            if (bag[i] == null) {
                j = i;
                break;
            }
            newBag[i] = bag[i];
        }

        for (int i=j, k=i+1; i<count; i++, k++) {
            newBag[i] = bag[k];
        }

        return newBag;
    }

    /**
     * prints bag as comma-separated list of elements
     * @return String output of printed object
     */
    @Override
    public String toString() {

        String output = "";

        if (isEmpty())
            output = "bag empty";

        for (int i=0; i<count; i++) {
            if (i == count-1) {
                output += bag[i] + ".";
                continue;
            }
            output += bag[i] + ", ";
        }

        return output;
    }

}
