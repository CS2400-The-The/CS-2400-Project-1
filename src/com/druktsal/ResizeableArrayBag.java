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
    private static final int INITIAL_CAPACITY = 5;

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

    public int getCount() { return this.count; }

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
        T[] b2 = (T[]) bag2.toArray();
        Arrays.sort(this.bag);
        Arrays.sort(b2);
        return Arrays.equals(this.bag, b2);
    }

    /**
     * returns a new bag containing the union of this bag and b2
     * that is, the elements from both bags all together 
     */
    public ResizeableArrayBag union(ResizeableArrayBag b2) {
        T[] bag1 = this.toArray();
        T[] bag2 = (T[]) b2.toArray();
        ResizeableArrayBag result = new ResizeableArrayBag();

        // if one of the bags is empty, the union will be the non-empty bag's contents
        if (bag1.length==0) {
            result.setBag(bag2);
            return result;
        } else if (bag2.length==0) {
            result.setBag(bag1);
            return result;
        }

        for (int i=0; i<bag1.length; i++) {
            result.add(bag1[i]);
        }
        for (int i=0; i<bag2.length; i++) {
            result.add(bag2[i]);
        }

        result.setBag(result.toArray());
        return result;
    }

    /**
     * returns a new bag containing the intersection of this bag and b2
     * that is, the contents common to both bags
     */
    public ResizeableArrayBag intersection(ResizeableArrayBag b2) {

        T[] bag1 = this.toArray();
        T[] bag2 = (T[]) b2.toArray();
        ResizeableArrayBag result = new ResizeableArrayBag();

        // if the bags are equal, the intersection will be either bag's contents
        if (Arrays.equals(bag1, bag2))
            return this;

        // if one of the bags is empty, the intersection will be an empty bag
        if (bag1.length==0 || bag2.length==0)
            return result;

        for (int i=0; i<this.count; i++) {

            for (int j=0; j<b2.getCount() && i<this.count; j++) {
                if (bag1[i] == bag2[j]) {
                    result.add(bag1[i]);
                    bag2[j] = null;
                    i++;
                    j=-1;
                }
            }
        }

        result.setBag(result.toArray());
        return result;
    }

    /**
     * returns a new bag containing the difference of this bag and b2
     * that is, the elements in bag1 that are NOT also in bag2
     * this is a non-symmetric difference which handles duplicates
     */
    public ResizeableArrayBag difference(ResizeableArrayBag b2) {
        T[] bag1 = this.toArray();
        T[] bag2 = (T[]) b2.toArray();
        Arrays.sort(bag1);
        Arrays.sort(bag2);

        ResizeableArrayBag result = new ResizeableArrayBag();

        // if the bags are equal, the difference will be an empty bag
        if (Arrays.equals(bag1, bag2))
            return result;

        // if either bag is empty, the difference will be the first bag
        if (bag1.length==0 || bag2.length==0) {
            result.setBag(bag1);
            return result;
        }

        for (int i = 0; i < bag1.length; i++) {
            boolean match = false;
            for (int j = 0; j < bag2.length; j++) {
                if (bag1[i] == bag2[j]) {
                    match = true;
                    bag2[j] = null;
                    break;
                }
            }
            if (!match) {
                result.add(bag1[i]);
            }
        }
        result.setBag(result.toArray());
        return result;
    }

}
