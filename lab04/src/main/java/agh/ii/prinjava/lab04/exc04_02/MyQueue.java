package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyQueueDLLBImpl;

import java.util.NoSuchElementException;

public interface MyQueue<E> {
    void enqueue(E x);
    E dequeue() throws NoSuchElementException; // Throws an exception if the queue is empty
    int numOfElems();
    E peek() throws NoSuchElementException; // Throws an exception if the queue is empty

    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}