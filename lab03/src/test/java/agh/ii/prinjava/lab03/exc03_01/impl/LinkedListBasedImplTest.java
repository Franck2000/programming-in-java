package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    // Create an empty queue
    private final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void enqueue() {
         var queue = new LinkedListBasedImpl();
        // Queue is initially empty
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.numOfElems());

        // Enqueue one element
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.numOfElems());
        assertEquals(10, queue.peek());

        // Enqueue another element
        queue.enqueue(20);
        assertEquals(2, queue.numOfElems());
    }

    @Test
    void dequeue() {

        var queue = new LinkedListBasedImpl();
        // Queue is initially empty
        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);

        // Enqueue an element and dequeue it
        queue.enqueue(10);
        assertEquals(10, queue.dequeue());
        assertTrue(queue.isEmpty());

        // Enqueue two elements and dequeue them
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void numOfElems() {

        var queue = new LinkedListBasedImpl();
        // Initially, the queue has zero elements
        assertEquals(0, queue.numOfElems());

        // Enqueue one element and check the count
        queue.enqueue(10);
        assertEquals(1, queue.numOfElems());

        // Enqueue another element and check the count
        queue.enqueue(20);
        assertEquals(2, queue.numOfElems());

        // Dequeue elements and check the count
        queue.dequeue();
        assertEquals(1, queue.numOfElems());
        queue.dequeue();
        assertEquals(0, queue.numOfElems());
    }

    @Test
    void peek() {
        var queue = new LinkedListBasedImpl();
        // Queue is initially empty
        assertTrue(queue.isEmpty());

        // Peeking an empty queue should throw an exception
        assertThrows(IllegalStateException.class, queue::peek);

        // Enqueue one element and peek
        queue.enqueue(10);
        assertEquals(10, queue.peek());

        // Enqueue another element and peek
        queue.enqueue(20);
        assertEquals(10, queue.peek());

        // Dequeue elements and peek
        queue.dequeue();
        assertEquals(20, queue.peek());
        queue.dequeue();

        // Peeking an empty queue should throw an exception
        assertThrows(IllegalStateException.class, queue::peek);
    }
}
