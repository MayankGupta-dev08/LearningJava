package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

//A concrete handler
class Director extends Employee {
    public Director(LeaveApprover nextApprover) {
        super("Director", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if (application.getType() == LeaveApplication.Type.PTO) {
            application.approve(getApproverRole());
            return true;
        }
        application.reject(getApproverRole());
        System.out.println("Director is not able to approve the " + application);
        return false;
    }
}