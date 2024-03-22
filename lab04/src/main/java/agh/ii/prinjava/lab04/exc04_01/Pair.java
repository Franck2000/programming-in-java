package agh.ii.prinjava.lab04.exc04_01;

import java.util.Objects;


/**
 * A generic class representing a pair of two values.
 *
 * @param <F> The type of the first value in the pair.
 * @param <S> The type of the second value in the pair.
 */
public class Pair<F, S> implements Cloneable {
    private F first;
    private S second;

    /**
     * Constructs a new Pair with the specified first and second values.
     *
     * @param first  The first value in the pair.
     * @param second The second value in the pair.
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Retrieves the first value of the pair.
     *
     * @return The first value.
     */
    public F getFirst() {
        return first;
    }

    /**
     * Sets the first value of the pair.
     *
     * @param first The new value for the first value.
     */
    public void setFirst(F first) {
        this.first = first;
    }

    /**
     * Retrieves the second value of the pair.
     *
     * @return The second value.
     */
    public S getSecond() {
        return second;
    }

    /**
     * Sets the second value of the pair.
     *
     * @param second The new value for the second value.
     */
    public void setSecond(S second) {
        this.second = second;
    }

    /**
     * Returns a string representation of the pair.
     *
     * @return A string representation of the pair in the format "(first, second)".
     */
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    /**
     * Returns a hash code value for the pair.
     *
     * @return A hash code value for this pair.
     */
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return A clone of this instance.
     * @throws CloneNotSupportedException If the clone operation is not supported.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


