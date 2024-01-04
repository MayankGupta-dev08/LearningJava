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

    @Test
    @DisplayName("sum of two numbers")
    void testSum() {
        // fail("Not yet implemented");
        ComputeUtil computeUtil = new ComputeUtil();
        int expected = 3;
        int actual = computeUtil.sum(1, 2);
        assertEquals(expected, actual, "The method should add two numbers");
    }
}