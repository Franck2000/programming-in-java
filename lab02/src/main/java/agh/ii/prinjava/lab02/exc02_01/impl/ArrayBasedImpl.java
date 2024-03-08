package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
/**
 * An implementation of the {@code StackOfInts} interface using an array-based approach.
 * This class provides basic stack operations such as push, pop, peek, and retrieval of the number of elements.
 * Elements are of type integer.
 *

 */
public class ArrayBasedImpl implements StackOfInts {

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack
     * @throws IllegalStateException if the operation is not supported
     * @see StackOfInts#pop()
     */
    @Override
    public int pop() {
        throw new IllegalStateException("To be implemented");
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
        throw new IllegalStateException("To be implemented");
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
        throw new IllegalStateException("To be implemented");
    }

    /**
     * The current number of elements in the stack.
     */
    private int numOfElems = 0;
}

