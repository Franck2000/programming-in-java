package agh.ii.prinjava.lab04.exc04_02.impl;

import java.util.NoSuchElementException;

public class DLinkList<E> {

    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    public DLinkList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void addFirst(E elem) {
        Node<E> newNode = new Node<>(elem, null, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void addLast(E elem) {
        Node<E> newNode = new Node<>(elem, last, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedElem = first.elem;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return removedElem;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedElem = last.elem;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return removedElem;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return first.elem;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return last.elem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

