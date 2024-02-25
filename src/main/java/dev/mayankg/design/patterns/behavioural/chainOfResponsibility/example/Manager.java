package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

/**
 * A concrete handler
 */
class Manager extends Employee {
    public Manager(LeaveApprover nextApprover) {
        super("Manager", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        switch (application.getType()) {
            case Sick:
                application.approve(getApproverRole());
                return true;
            case PTO:
                if (application.getNoOfDays() <= 5) {
                    application.approve(getApproverRole());
                    return true;
                }
        }
        application.reject(getApproverRole());
        System.out.println("Manager is not able to approve the " + application);
        return false;
    }
}