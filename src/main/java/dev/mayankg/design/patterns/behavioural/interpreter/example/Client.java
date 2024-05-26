package dev.mayankg.design.patterns.behavioural.interpreter.example;

class Client {

    public static void main(String[] args) {
        ExpressionBuilder builder = new ExpressionBuilder();

        Report report1 = new Report("Cash flow report", "FINANCE_ADMIN OR ADMIN");
        User user1 = new User("Dave", "USER");
        boolean result1 = checkIfUserHasAccessToReport(builder, report1, user1);
        printUserAccessOutput(result1);

        Report report2 = new Report("Asset report", "CA OR CFO OR CEO");
        User user2 = new User("Mayank", "CEO");
        boolean result2 = checkIfUserHasAccessToReport(builder, report2, user2);
        printUserAccessOutput(result2);
    }

    private static void printUserAccessOutput(boolean result) {
        if (result)
            System.out.println("User has access to the report.");
        else
            System.out.println("User doesn't have the access to this report");

        System.out.println("-----------------------------------------------------------------");
        System.out.println();
    }

    private static boolean checkIfUserHasAccessToReport(ExpressionBuilder builder, Report report, User user) {
        System.out.println("user = " + user);
        System.out.println("report = " + report);
        System.out.println("Checking in the system if the user has access to the report...");
        PermissionExpression exp = builder.build(report);
        System.out.println("Permission expression: " + exp + ".");
        return exp.interpret(user);
    }
}