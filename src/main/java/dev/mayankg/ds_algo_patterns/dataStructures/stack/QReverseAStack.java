package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import dev.mayankg.dataStructures.stack.QPushAtBottomOfStack;

import java.util.Stack;

public class QReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        System.out.println("Before reverse: " + stack);
        reverseStack(stack);
        System.out.println("After reverse : " + stack);
    }

    static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;

        Integer top = stack.pop();
        reverseStack(stack);
        QPushAtBottomOfStack.pushAtTheBottomOfStack(top, stack);
    }
}