package com.druktsal;

import java.util.Arrays;

/**
 * implementation of basic bag data structure that uses a resizeable array
 * TODO: implement methods union, intersection, difference
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

    public void setBag(T[] bag) {
        this.bag = bag;
    }

    public T[] getBag() { return this.bag; }

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
    public boolean isEmpty() { return count == 0; }

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

    private int getIndexOf(T entry) {
        int index = -1;
        boolean found = false;
        for (int i = 0; !found && (i < count); i++)
        {
            if (entry.equals(bag[i]))
            {
                found = true;
                index = i;
            }
        }
        return index;
    }

    private T removeEntry(int index)
    {
        T entry = null;
        if (!isEmpty() && (index >= 0)) {
            entry = bag[index];
            count--;
            bag[index] = bag[count];
            bag[count] = null;
        }
        return entry;
    }

    /**
     * removes first entry from bag
     * @return the entry removed
     */
    @Override
    public T remove() {
        T entry = null;
        if (count > 0) {
            count--;
            entry = bag[count];
            bag[count] = null;
        }
        return entry;
    }

    /**
     * removes a specified entry from bag
     * @param anEntry  The entry to be removed.
     * @return true if remove was successful, false otherwise
     */
    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
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
        for (int index = 0; index < count; index++)
        {
            newBag[index] = bag[index];
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

    public boolean bagEquals(ResizeableArrayBag bag2) {
        T[] b2 = (T[]) bag2.getBag();
        Arrays.sort(this.bag);
        Arrays.sort(b2);
        return Arrays.equals(this.bag, b2);
    }

}
