package dev.mayankg.design.patterns.behavioural.interpreter.example;

/**
 * [Abstract Interpreter] Non-terminal Expression
 */
class OrExpression implements PermissionExpression {

    private PermissionExpression expression1;
    private PermissionExpression expression2;

    public OrExpression(PermissionExpression expression1, PermissionExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(User user) {
        return expression1.interpret(user) || expression2.interpret(user);
    }

    @Override
    public String toString() {
        return expression1 + " OR " + expression2;
    }
}