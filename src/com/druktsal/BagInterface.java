package com.druktsal;

/**
 * public generic interface for the Bag ADT
 */
public interface BagInterface<T> {

    /** Gets the current number of entries in this bag.
     @return  The integer number of entries currently in the bag. 
     */
    public int getCurrentSize();

    /** Sees whether this bag is empty.
     @return  True if the bag is empty, or false if not. 
     */
    public boolean isEmpty();

    /** Adds a new entry to this bag.
     @param newEntry  The object to be added as a new entry.
     @return  True if the addition is successful, or false if not. 
     */
    public boolean add(T newEntry);

    /** Removes one unspecified entry from this bag, if possible.
     @return  Either the removed entry, if the removal was successful, or null. 
     */
    public T remove();

    /** Removes one occurrence of a given entry from this bag, if possible.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false if not. 
     */
    public boolean remove(T anEntry);

    /** Removes all entries from this bag. */
    public void clear();

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry  The entry to be counted.
     @return  The number of times anEntry appears in the bag. 
     */
    public int getFrequencyOf(T anEntry);

    /** Tests whether this bag contains a given entry.
     @param anEntry  The entry to find.
     @return  True if the bag contains anEntry, or false if not. 
     */
    public boolean contains(T anEntry);

    /** Retrieves all entries that are in this bag.
     @return  A newly allocated array of all the entries in the bag. Note: If the bag is empty, the returned array is empty. 
     */
    public T[] toArray();

    /**
     @param bag2  bag to be compared to first bag to check equality
     @return  true if the contents of this bag and bag2 are equal, returns false otherwise
     */
    public boolean bagEquals(BagInterface<T> bag2);

    /**
     @param bag2  The bag whose elements to be combined with first bag
     @returns  bag containing the elements from both bag1 and bag2
     */
    public BagInterface<T> union(BagInterface<T> bag2);

    /**
     @param bag2  The bag whose elements are to be subtracted from first bag
     @returns  bag containing the elements in first bag after removing matching elements in second bag
     */
    public BagInterface<T> difference(BagInterface<T> bag2);

    /**
     @param bag2  The bag whose elements are to be matched with first bag
     @returns  bag containing common elements of first and second bag
     */
    public BagInterface<T> intersection(BagInterface<T> bag2);

}
