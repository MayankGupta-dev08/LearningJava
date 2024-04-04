package dev.mayankg.dataStructures.stack;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class StackArrayTest {

    @Test
    public void testPushAndPop() {
        StackImplArray stack = new StackImplArray(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());

        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testIsEmpty() {
        StackImplArray stack = new StackImplArray(5);

        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());

        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        StackImplArray stack = new StackImplArray(3);

        assertFalse(stack.isFull());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.isFull());
    }

    @Test
    public void testTop() {
        StackImplArray stack = new StackImplArray(3);

        assertThrows(NoSuchElementException.class, stack::pop);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.top());

        stack.pop();

        assertEquals(2, stack.top());
    }

    @Test
    public void testSize() {
        StackImplArray stack = new StackImplArray(3);

        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());

        stack.pop();

        assertEquals(2, stack.size());
    }
}