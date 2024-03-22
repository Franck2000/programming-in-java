package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;

import java.util.NoSuchElementException;

public interface MyStack<E> {
    E pop() throws NoSuchElementException; // Throws an exception if the stack is empty
    void push(E x);
    int numOfElems();
    E peek() throws NoSuchElementException; // Throws an exception if the stack is empty

    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<>();
    }
}
