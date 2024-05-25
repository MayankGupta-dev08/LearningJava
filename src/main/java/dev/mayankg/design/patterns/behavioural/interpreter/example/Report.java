package dev.mayankg.design.patterns.behavioural.interpreter.example;

class Report {

    private String name;

    /**
     * @allowedValues: "NOT ADMIN", "FINANCE_USER AND ADMIN"
     */
    private String permission;

    public Report(String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }
}