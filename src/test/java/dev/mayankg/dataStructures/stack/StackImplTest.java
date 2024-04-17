package dev.mayankg.dataStructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {

    @AfterEach
    void printLineBreaker() {
        System.out.println("-------------------------------");
    }

    @Test
    void testStackImplementationUsingArray() {
        int capacity = 5;
        StackImplArray stack = new StackImplArray(capacity);
        testStack(stack);
    }

    @Test
    void testStackImplementationUsingArrayList() {
        StackImplAL stack = new StackImplAL();
        testStack(stack);
    }

    @Test
    void testStackImplementationUsingLinkedList() {
        StackImplLL stack = new StackImplLL();
        testStack(stack);
    }

    private static void testStack(MyStack stack) {
        // Test pushing and popping elements
        testPushAndPop(stack);

        // Test isEmpty method
        testIsEmpty(stack);

        // Test isFull method
        if (stack instanceof StackImplArray)
            testIsFull(stack);

        // Test top method
        testTop(stack);

        // Test size method
        testSize(stack);
    }

    private static void testPushAndPop(MyStack stack) {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());

        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(1, stack.pop());
    }

    private static void testIsEmpty(MyStack stack) {
        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());

        stack.pop();

        assertTrue(stack.isEmpty());
    }

    private static void testIsFull(MyStack stack) {
        assertFalse(stack.isFull());

        int capacity = 5;
        for (int i = 0; i < capacity; i++) {
            stack.push(i);
        }

        assertTrue(stack.isFull());
    }

    private static void testTop(MyStack stack) {
        stack.clear();
        assertThrows(NoSuchElementException.class, stack::top);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.top());

        stack.pop();

        assertEquals(2, stack.top());
    }

    private static void testSize(MyStack stack) {
        stack.clear();
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());

        stack.pop();

        assertEquals(2, stack.size());
    }
}