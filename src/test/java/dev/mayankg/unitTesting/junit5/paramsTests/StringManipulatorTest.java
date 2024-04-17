package dev.mayankg.unitTesting.junit5.paramsTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringManipulatorTest {

    private final StringManipulator stringManipulator = new StringManipulator();

    private static Stream<Arguments> testConditions() {
        return Stream.of(
                Arguments.of("AACD", "CD", false),
                Arguments.of("ACD", "CD", false),
                Arguments.of("CDEF", "CDEF", false),
                Arguments.of("CDAA", "CDAA", false),
                Arguments.of("ABAB", "BAB", true),
                Arguments.of("AB", "B", false),
                Arguments.of("A", "", false),
                Arguments.of("ABCZSDAB", "BCZSDAB", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    public void truncateCharIfPresentInFirst2Position(String actualInput, String expectedOutput, boolean other) {
        String actualResult = stringManipulator.truncateCharIfPresentInFirst2Position(actualInput, 'A');
        assertEquals(expectedOutput, actualResult);
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    public void areFirstAndLastTwoCharsTheSame(String actualInput, String other, boolean expectedOutput) {
        boolean actualResultBool = stringManipulator.areFirstAndLastTwoCharsTheSame(actualInput);
        assertEquals(expectedOutput, actualResultBool);
    }

    @Test
    public void concatenate() {
        String actualResult = stringManipulator.concatenate("Hello", "World");
        assertEquals("HelloWorld", actualResult);
    }

    @Test
    public void multiply() {
        String actualResult = stringManipulator.multiply("Hello", 3);
        assertEquals("HelloHelloHello", actualResult);
    }

    @Test
    public void reverse() {
        String actualResult = stringManipulator.reverse("Hello");
        assertEquals("olleH", actualResult);
    }
}