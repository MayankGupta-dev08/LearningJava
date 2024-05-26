package dev.mayankg.design.patterns.behavioural.interpreter.example;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Parses & builds an Abstract syntax tree
 */
class ExpressionBuilder {

    private static final String AND = "and";
    private static final String NOT = "not";
    private static final String OR = "or";

    private Stack<String> operators = new Stack<>();
    private Stack<PermissionExpression> permissions = new Stack<>();

    public PermissionExpression build(Report report) {
        parse(report.getPermission());
        buildExpressions();
        if (permissions.size() > 1 || !operators.isEmpty()) {
            System.out.println("ERROR!");
        }
        return permissions.pop();
    }

    private void parse(String permission) {
        StringTokenizer tokenizer = new StringTokenizer(permission.toLowerCase());
        while (tokenizer.hasMoreTokens()) {
            String token;
            switch ((token = tokenizer.nextToken())) {
                case AND:
                    operators.push(AND);
                    break;
                case NOT:
                    operators.push(NOT);
                    break;
                case OR:
                    operators.push(OR);
                    break;
                default:
                    permissions.push(new Permission(token));
                    break;
            }
        }
    }

    private void buildExpressions() {
        while (!operators.isEmpty()) {
            String operator = operators.pop();
            PermissionExpression perm1;
            PermissionExpression perm2;
            PermissionExpression exp;
            switch (operator) {
                case NOT:
                    perm1 = permissions.pop();
                    exp = new NotExpression(perm1);
                    break;
                case AND:
                    perm1 = permissions.pop();
                    perm2 = permissions.pop();
                    exp = new AndExpression(perm1, perm2);
                    break;
                case OR:
                    perm1 = permissions.pop();
                    perm2 = permissions.pop();
                    exp = new OrExpression(perm1, perm2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operator:" + operator);
            }
            permissions.push(exp);
        }
    }
}