package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;

import java.util.NoSuchElementException;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>(); // Assuming DLinkList has the necessary methods

    @Override
    public void enqueue(E x) {
        elems.addLast(x); // Assumes a method addLast exists in DLinkList
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            //throw new NoSuchElementException("Queue is empty");
            return  null;
        }
        return elems.removeFirst(); // Assumes a method removeFirst exists in DLinkList
    }

    @Override
    public int numOfElems() {
        return elems.size(); // Assumes a method size exists in DLinkList that returns the number of elements
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            //throw new NoSuchElementException("Queue is empty");
            return  null;
        }
        return elems.getFirst(); // Assumes a method getFirst exists in DLinkList that returns the first element
    }
}
