package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;



/**
 * LinkedListBasedImpl is an implementation of the QueueOfInts interface using a doubly linked list.
 * This implementation uses a doubly linked list structure where each element is represented by a node
 * containing the element value and references to the next and previous nodes in the list.
 */
public class LinkedListBasedImpl implements QueueOfInts {
    /**
     * Adds an element to the rear of the queue
     *
     * @param x The element to be enqueued
     */
    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x, null, last);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        numOfElems++;
    }

    /**
     * Removes and returns the element from the front of the queue
     *
     * @return The dequeued element
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        int retValue = first.elem;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        numOfElems--;
        return retValue;
    }

    /**
     * Returns the number of elements currently in the queue
     *
     * @return The number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * Returns the element at the front of the queue without removing it
     *
     * @return The element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        return first.elem;
    }

    /**
     * Represents a node in the doubly linked list with an integer element and references to the next and previous nodes.
     */
    private static class Node {
        int elem;
        Node next;
        Node prev;

        /**
         * Constructs a new node with the given element and references to the next and previous nodes.
         *
         * @param elem The element value of the node
         * @param next Reference to the next node in the linked list
         * @param prev Reference to the previous node in the linked list
         */
        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    /** Reference to the first node in the linked list */
    private Node first = null;

    /** Reference to the last node in the linked list */
    private Node last = null;

    /** The current number of elements in the queue */
    private int numOfElems = 0;
}
