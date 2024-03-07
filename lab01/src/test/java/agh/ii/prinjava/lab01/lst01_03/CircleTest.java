package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void area() {
        // Arrange
        Circle circle = new Circle(5.0);

        // Act
        double result = circle.area();

        // Assert
        assertEquals(Math.PI * 5.0 * 5.0, result, 0.0001); //  delta for double comparison

    }

    @Test
    void perimeter() {
        // Arrange
        Circle circle = new Circle(3.0);

        // Act
        double result = circle.perimeter();

        // Assert
        assertEquals(2 * Math.PI * 3.0, result, 0.0001); //  delta for double comparison

    }
}