package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
/**
 * An implementation of the {@code StackOfInts} interface using an array-based approach.
 * This class provides basic stack operations such as push, pop, peek, and retrieval of the number of elements.
 * Elements are of type integer.
 *

 */
public class ArrayBasedImpl implements StackOfInts {

    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;
    private int size;

    public ArrayBasedImpl() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     * @see StackOfInts#pop()
     */
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int topElem = elements[size - 1];
        size--;
        return topElem;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param x The element to be pushed onto the stack
     * @throws IllegalStateException if the stack is full
     * @see StackOfInts#push(int)
     */
    @Override
    public void push(int x) {
        if (size == elements.length) {
            throw new IllegalStateException("Stack is full");
        }
        elements[size] = x;
        size++;
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return The number of elements in the stack
     * @see StackOfInts#numOfElems()
     */
    @Override
    public int numOfElems() {
        return size;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     * @see StackOfInts#peek()
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[size - 1];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
}

