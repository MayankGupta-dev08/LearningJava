package dev.mayankg;

import dev.mayankg.junit5.ComputeUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ComputeUtilTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test @DisplayName("sum of two numbers")
    void testSum() {
        // fail("Not yet implemented");
        int expected = 3;
        int actual = ComputeUtil.sum(1, 2);
        assertEquals(expected, actual, "The method should add two numbers");
    }

    @Test @DisplayName("area of a circle")
    void testAreaOfCircle(){
        double expected = 314.1592653589793;
        assertEquals(expected, ComputeUtil.computeCircleArea(10), "should return area of a circle");
    }
}