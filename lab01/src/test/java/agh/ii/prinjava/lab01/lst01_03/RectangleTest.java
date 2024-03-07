package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void area() {
        // Arrange
        Rectangle rectangle = new Rectangle(4.0, 5.0);

        // Act
        double result = rectangle.area();

        // Assert
        assertEquals(4.0 * 5.0, result, 0.0001);
    }

    @Test
    void perimeter() {

        // Arrange
        Rectangle rectangle = new Rectangle(3.0, 6.0);

        // Act
        double result = rectangle.perimeter();

        // Assert
        assertEquals(2 * (3.0 + 6.0), result, 0.0001);
    }
}