package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import java.util.Stack;

public class QPushAtBottomOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        pushAtTheBottomOfStack(4, stack);
        pushAtTheBottomOfStack(5, stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static void pushAtTheBottomOfStack(int val, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.add(val);
            return;
        }

        Integer top = stack.pop();
        pushAtTheBottomOfStack(val, stack);
        stack.add(top);
    }
}