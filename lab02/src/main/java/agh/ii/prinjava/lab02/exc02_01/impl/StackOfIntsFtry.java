package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

/**
 * Stack of integers factory
 */
/**
 * Factory class for creating instances of {@code StackOfInts}.
 * This factory provides methods to create different implementations of the {@code StackOfInts} interface,
 * such as Array-Based and (Custom) Linked List-Based.
 *
 * <p>The available implementations are specified by the {@code Impln} enum.
 *
 * <p>This class follows the Factory Method design pattern to abstract the process of object creation
 * and allow clients to create instances of the {@code StackOfInts} interface without specifying their concrete classes.
 *

 */
public final class StackOfIntsFtry {

    /**
     * Private constructor to prevent instantiation of the factory class.
     */
    private StackOfIntsFtry() {
    }

    /**
     * Enumeration of available implementations for the {@code StackOfInts} interface.
     */
    enum Impln {
        /**
         * Array-Based implementation
         */
        ARRAY_B,

        /**
         * (Custom) Linked List-Based implementation
         */
        L_LIST_B
    }

    /**
     * Creates an instance of the {@code StackOfInts} interface based on the specified implementation.
     *
     * @param s The implementation to create
     * @return An instance of the specified implementation
     */
    static StackOfInts create(Impln s) {
        return switch (s) {
            case ARRAY_B -> new ArrayBasedImpl();
            case L_LIST_B -> new LinkedListBasedImpl();
        };
    }
}
