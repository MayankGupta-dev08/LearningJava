package dev.mayankg.unitTesting.mockito.basics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Tests for List using the Mockito framework
 */
class ListTest {

    @Test
    @DisplayName("test mocking for list size")
    void letsMockListSize() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(8);
        assertEquals(8, list.size());
        assertEquals(8, list.size());
    }

    @Test
    @DisplayName("test mocking for list size with multiple values")
    void letsMockListSizeWithMultipleReturnValues() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size()); // First Call
        assertEquals(20, list.size()); // Second Call
    }

    @Test
    @DisplayName("test mocking for getting an element from list for a specific index")
    void letsMockListGet() {
        List<String> list = mock(List.class);
        Mockito.when(list.get(0)).thenReturn("codeWithMayank");
        assertEquals("codeWithMayank", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    @DisplayName("test mocking for getting an element from list for any index")
    void letsMockListGetWithAnyInteger() {
        List<String> list = mock(List.class);
        // Argument Matcher: Mockito.anyInt()
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("codeWithMayank");
        // If you are using argument matchers, all arguments have to be provided by matchers.
        assertEquals("codeWithMayank", list.get(0));
        assertEquals("codeWithMayank", list.get(1));
    }

    @Test
    public void bddAliases_UsingGivenWillReturn() {
        List<String> list = mock(List.class);

        //given
        given(list.get(Mockito.anyInt())).willReturn("in28Minutes");

        //then
        assertThat("in28Minutes", is(list.get(0)));
        assertThat("in28Minutes", is(list.get(0)));
    }

    @Test
    @DisplayName("test mocking for getting an exception via list.get() for any index")
    void letsMockListGetThrowsAnException() {
        List<String> list = mock(List.class);
        // Argument Matcher: Mockito.anyInt()
        Mockito.when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> list.get(0));
        assertThrows(RuntimeException.class, () -> list.get(5));
    }
}