package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

/**
 * [Abstract Handler] which implements our [Main Handler] for different roles/employee types
 */
abstract class Employee implements LeaveApprover {
    private String role;
    private LeaveApprover successor;

    public Employee(String role, LeaveApprover successor) {
        this.role = role;
        this.successor = successor;
    }

    /**
     * Since different Employee types will handle the request differently, which will be dealt by the concert implementations of this abstract class
     */
    protected abstract boolean processRequest(LeaveApplication application);

    @Override
    public void processLeaveApplication(LeaveApplication application) {
        if (!processRequest(application) && successor != null) {
            successor.processLeaveApplication(application);
        }
    }

    @Override
    public String getApproverRole() {
        return role;
    }
}