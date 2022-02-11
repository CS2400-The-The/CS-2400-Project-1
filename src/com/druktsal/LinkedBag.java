package com.druktsal;

/**
 * implementation of basic bag data structure that uses a linked list structure
 * TODO: implement methods union, intersection, difference
 * @param <T>
 */
public class LinkedBag<T> implements BagInterface<T> {

    private Node head;
    private int count;

    public LinkedBag() {
        head = null;
        count = 0;
    }

    private class Node
    {
        private T data;
        private Node next;

        Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        T getData() { return data; }

        void setData(T newData) { data = newData; }

        Node getNextNode() { return next; }

        void setNextNode(Node nextNode) { next = nextNode; }
    }

    @Override
    public int getCurrentSize() { return count; }

    @Override
    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.setNextNode(head);
        head = newNode;
        count++;
        return true;
    }

    private Node getReferenceTo(T anEntry)
    {
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

    @Override
    public void clear() {
        head = null;
        count = 0;
    }

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

    @Override
    public boolean contains(T anEntry) {
        if (getReferenceTo(anEntry) == null)
            return false;
        return true;
    }

    @Override
    public T[] toArray() {

        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Object[count];
        int i=0;
        Node current = head;
        while ((i<count) && (current != null)) {
            arr[i] = current.data;
            i++;
            current = current.next;
        }
        return arr;
    }
}
