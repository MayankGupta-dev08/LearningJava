package dev.mayankg.unitTesting.mockito.advanced;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Every.everyItem;

/**
 * Readable asserts for different java class
 */
class HamcrestMatchersTest {

    @Test
    public void testListWithHamcrestMatchers() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        assertThat(scores, Matchers.hasSize(4)); // assert: has 4 items
        assertThat(scores, hasItems(100, 101)); // assert: has these items

        // assert: every item satisfies the cond
        assertThat(scores, everyItem(Matchers.greaterThan(90)));
        assertThat(scores, everyItem(Matchers.lessThan(200)));
    }

    @Test
    public void testStringWithHamcrestMatchers() {
        assertThat("", Matchers.isEmptyString());
        assertThat(null, Matchers.isEmptyOrNullString());
    }

    @Test
    public void testArrayWithHamcrestMatchers() {
        Integer[] marks = {1, 2, 3};

        assertThat(marks, Matchers.arrayWithSize(3));
        assertThat(marks, Matchers.arrayContaining(1, 2, 3));
        assertThat(marks, Matchers.arrayContainingInAnyOrder(2, 3, 1));
    }
}