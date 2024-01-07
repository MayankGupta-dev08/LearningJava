package dev.mayankg;

import dev.mayankg.junit5.ComputeUtil;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) //By default its PER_METHOD
class ComputeUtilTest {
    private ComputeUtil computer;

    @BeforeAll
    static void init() {
        System.out.println("This will run once before all test methods...");
    }

    @BeforeEach
    void setUp() {
        this.computer = new ComputeUtil();
        System.out.println("This runs before each test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clean up happens after every test...");
    }

    @Test
    @DisplayName("sum of two numbers")
    void testSum() {
        // fail("Not yet implemented");
        int expected = 3;
        int actual = computer.sum(1, 2);
        assertEquals(expected, actual, "The method should add two numbers");
    }

    @Test
    @DisplayName("area of a circle")
    void testAreaOfCircle() {
        double expected = 314.1592653589793;
        assertEquals(expected, computer.computeCircleArea(10), "should return area of a circle");
    }

    @Test
    @DisplayName("divide by 0 should throw arithmetic exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> computer.divide(10, 0));
    }
}