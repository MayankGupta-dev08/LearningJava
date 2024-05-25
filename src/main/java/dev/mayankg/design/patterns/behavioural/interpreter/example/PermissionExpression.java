package dev.mayankg.design.patterns.behavioural.interpreter.example;

/**
 * [Abstract Interpreter] Expression
 */
interface PermissionExpression {

    boolean interpret(User user);
}