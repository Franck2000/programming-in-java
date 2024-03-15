package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
/**
 * An implementation of the {@code StackOfInts} interface using a linked list-based approach.
 * This class provides basic stack operations such as push, pop, peek, and retrieval of the number of elements.
 * Elements are of type integer.
 *
 * <p>The implementation uses a linked list structure where each element is represented by a node containing
 * the element value and a reference to the next node in the list.
 *

 */
public class LinkedListBasedImpl implements StackOfInts {

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack
     * @throws IllegalStateException if the operation is not supported
     * @see StackOfInts#pop()
     */
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int topElem = first.elem;
        first = first.next;
        numOfElems--;
        return topElem;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param x The element to be pushed onto the stack
     * @throws IllegalStateException if the operation is not supported
     * @see StackOfInts#push(int)
     */
    @Override
    public void push(int x) {
        Node newNode = new Node(x, first);
        first = newNode;
        numOfElems++;
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return The number of elements in the stack
     * @see StackOfInts#numOfElems()
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack
     * @throws IllegalStateException if the operation is not supported
     * @see StackOfInts#peek()
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return first.elem;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Represents a node in the linked list with an integer element and a reference to the next node.
     */
    private static class Node {
        int elem;
        Node next;

        /**
         * Constructs a new node with the given element and next node reference.
         *
         * @param elem The element value of the node
         * @param next The reference to the next node in the linked list
         */
        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    /** The first node in the linked list. */
    private Node first = null;

    /** The current number of elements in the stack. */
    private int numOfElems = 0;
}
