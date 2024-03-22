package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueDLLBImplTest {
    private MyQueue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueueDLLBImpl<>();
    }

    @Test
    void testEnqueue() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.numOfElems());

        queue.enqueue("a");
        assertEquals(1, queue.numOfElems());

        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals(3, queue.numOfElems());
    }

    @Test
    void testDequeue() {
        assertTrue(queue.isEmpty());
        assertNull(queue.dequeue());

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue("a");
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testNumOfElems() {
        assertEquals(0, queue.numOfElems());

        queue.enqueue("a");
        assertEquals(1, queue.numOfElems());

        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals(3, queue.numOfElems());

        queue.dequeue();
        assertEquals(2, queue.numOfElems());

        queue.dequeue();
        queue.dequeue();
        assertEquals(0, queue.numOfElems());
    }

    @Test
    void testPeek() {
        assertNull(queue.peek());

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        assertEquals("a", queue.peek());

        queue.dequeue();
        assertEquals("b", queue.peek());
    }
}
