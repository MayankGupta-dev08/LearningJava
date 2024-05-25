package dev.mayankg.design.patterns.behavioural.interpreter.example;

/**
 * [Abstract Interpreter] Non-terminal Not Expression
 */
class NotExpression implements PermissionExpression {

    private PermissionExpression expression;

    public NotExpression(PermissionExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(User user) {
        return !expression.interpret(user);
    }

    @Override
    public String toString() {
        return "NOT " + expression;
    }
}