package agh.ii.prinjava.lab02.exc02_01;

/**
 * Stack of integers - Abstract Data Type (ADT)
 */

/**
 * Represents a Stack of integers, following the Abstract Data Type (ADT) design.
 * This interface defines the basic operations for a stack, including push, pop, peek, and retrieval of the number of elements.
 * Elements are of type integer.
 *
 * <p>A stack follows the Last In, First Out (LIFO) principle, where the last element added is the first one to be removed.
 *
 * <p>This interface provides a default method {@code isEmpty()} to check if the stack is empty.
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 */
public interface StackOfInts {

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack
     */
    int pop();

    /**
     * Adds an element to the top of the stack.
     *
     * @param x The element to be pushed onto the stack
     */
    void push(int x);

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return The number of elements in the stack
     */
    int numOfElems();

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack
     */
    int peek();
}
