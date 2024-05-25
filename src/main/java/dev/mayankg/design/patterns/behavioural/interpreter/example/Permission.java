package dev.mayankg.design.patterns.behavioural.interpreter.example;

/**
 * [Concrete Interpreter] Terminal Expression
 */
public class Permission implements PermissionExpression {

    private String permission;

    public Permission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean interpret(User user) {
        return user.getPermissions().contains(permission);
    }

    @Override
    public String toString() {
        return permission;
    }
}