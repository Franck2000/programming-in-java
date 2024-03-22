package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for the Pair class.
 */
public class PairTest {
    /**
     * Tests the creation of a Pair instance with specified values.
     */
    @Test
    void testPairCreation() {
        Pair<Integer, String> pair = new Pair<>(42, "Hello");
        assertEquals(42, pair.getFirst());
        assertEquals("Hello", pair.getSecond());
    }

    /**
     * Tests the string representation of a Pair instance.
     */
    @Test
    void testToString() {
        Pair<Double, Integer> pair = new Pair<>(3.14, 42);
        assertEquals("(3.14, 42)", pair.toString());
    }

    /**
     * Tests the equality of two Pair instances.
     */
    @Test
    void testEqualsAndHashCode() {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(1, "One");
        Pair<Integer, String> pair3 = new Pair<>(2, "Two");

        assertEquals(pair1, pair2);
        assertNotEquals(pair1, pair3);

        assertEquals(pair1.hashCode(), pair2.hashCode());
        assertNotEquals(pair1.hashCode(), pair3.hashCode());
    }

    /**
     * Tests the cloning of a Pair instance.
     *
     * @throws CloneNotSupportedException If cloning is not supported.
     */
    @Test
    void testClone() throws CloneNotSupportedException {
        Pair<Integer, String> original = new Pair<>(42, "Original");
        Pair<Integer, String> cloned = (Pair<Integer, String>) original.clone();

        assertEquals(original, cloned);
        assertNotSame(original, cloned);
    }
}
