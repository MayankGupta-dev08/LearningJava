package dev.mayankg.unitTesting.junit5.basicTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) //By default its PER_METHOD
@DisplayName("When running ComputeUtils...")
class ComputeUtilTest {
    private ComputeUtil computer;
    private TestInfo testInfo;
    private TestReporter testReporter;

    public ComputeUtilTest(TestInfo testInfo, TestReporter testReporter) {
        this.computer = new ComputeUtil();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
    }

    @BeforeAll
    static void init() {
        System.out.println("This will run once before all test methods...");
    }

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        System.out.println("This runs before each test...");
        testReporter.publishEntry("Running [" + testInfo.getDisplayName() + "] with tag as " + testInfo.getTags());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clean up happens after every test...");
    }

    @Test
    @Tag("Math")
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
    @Tag("Math")
    @DisplayName("divide by 0 should throw arithmetic exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> computer.divide(10, 0));
    }

    @Test
    @Tag("Math")
    @DisplayName("test multiply with bunch of assertion scenarios")
    void testMultiply() {
        assertAll(
                () -> assertEquals(0, computer.multiply(4, 0), "X x 0 = 0"),
                () -> assertEquals(8, computer.multiply(8, 1), "X x 1 = X"),
                () -> assertEquals(-6, computer.multiply(2, -3), "X x -Y = -Z")
        );
    }

    @Nested
    @DisplayName("Checking extras...")
    class TestAdditional {
        @Test
        @Disabled
        @DisplayName("TDD method, shouldn't run")
        void testToBeWritten() {
            fail("Not yet implemented");
        }

        @Test
        @EnabledOnOs(OS.WINDOWS)
        @DisplayName("Test runs only on windows")
        void testCheckOS() {
            OS os = OS.WINDOWS;
            assertTrue(() -> os.equals(OS.WINDOWS), "checks if os is WINDOWS");
        }

        @RepeatedTest(3)
        @DisplayName("check if server is up and running and only then does some work...")
        void testServerCondition(RepetitionInfo repetitionInfo) {
            System.out.println("This is the " + repetitionInfo.getCurrentRepetition() + " repetition of the test!");
            boolean isServerUp = false;
            assumeTrue(isServerUp);
            System.out.println("Does some work if and only if the server is up...");
        }
    }
}