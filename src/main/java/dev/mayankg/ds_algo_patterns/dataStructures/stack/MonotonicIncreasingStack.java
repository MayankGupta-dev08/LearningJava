package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * A monotonic increasing stack maintains elements in non-decreasing order.
 * When pushing a new element, it removes elements greater than the new element
 * before adding it to maintain the monotonic property.
 */
public class MonotonicIncreasingStack {
    private Stack<Integer> stack;

    public MonotonicIncreasingStack() {
        stack = new Stack<>();
    }

    /**
     * Pushes an element onto the stack, maintaining the monotonic increasing property.
     * Removes elements greater than the new element before pushing.
     *
     * @param num The element to push
     */
    public void push(int num) {
        while (!stack.isEmpty() && stack.peek() > num) {
            stack.pop();
        }
        stack.push(num);
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return The top element
     * @throws EmptyStackException if the stack is empty
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Returns the top element without removing it.
     *
     * @return The top element
     * @throws EmptyStackException if the stack is empty
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Returns the current size of the stack.
     *
     * @return The number of elements in the stack
     */
    public int size() {
        return stack.size();
    }
}