package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;


public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems;

    public MyStackDLLBImpl() {
        this.elems = new DLinkList<>();
    }

    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            //throw new IllegalStateException("Stack is empty");
            return  null;
        }
        return elems.removeLast();
    }

    @Override
    public void push(E x) throws IllegalStateException {
        elems.addLast(x);
    }

    @Override
    public int numOfElems() throws IllegalStateException {
        return elems.size();
    }

    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty()) {
            //throw new IllegalStateException("Stack is empty");
            return  null;
        }
        return elems.getLast();
    }
}

