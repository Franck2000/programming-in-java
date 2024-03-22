package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackDLLBImplTest {
    private MyStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStackDLLBImpl<>();
    }

    @Test
    void testPop() {
        assertNull(stack.pop());

        stack.push("x");
        stack.push("y");
        stack.push("z");

        assertEquals("z", stack.pop());
        assertEquals("y", stack.pop());
        assertEquals("x", stack.pop());
        assertNull(stack.pop());
    }

    @Test
    void testPush() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.numOfElems());

        stack.push("x");
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.numOfElems());

        stack.push("y");
        stack.push("z");
        assertEquals(3, stack.numOfElems());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push("x");
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testNumOfElems() {
        assertEquals(0, stack.numOfElems());

        stack.push("x");
        assertEquals(1, stack.numOfElems());

        stack.push("y");
        stack.push("z");
        assertEquals(3, stack.numOfElems());

        stack.pop();
        assertEquals(2, stack.numOfElems());

        stack.pop();
        stack.pop();
        assertEquals(0, stack.numOfElems());
    }

    @Test
    void testPeek() {
        assertNull(stack.peek());

        stack.push("x");
        stack.push("y");
        stack.push("z");

        assertEquals("z", stack.peek());

        stack.pop();
        assertEquals("y", stack.peek());
    }
}
