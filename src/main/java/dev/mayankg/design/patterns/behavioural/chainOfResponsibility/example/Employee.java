package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

/*+ Abstract handler */
abstract class Employee implements LeaveApprover {
    private String role;
    private LeaveApprover successor;

    public Employee(String role, LeaveApprover successor) {
        this.role = role;
        this.successor = successor;
    }

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