package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

/**
 * A [Concrete Handler] extending from our [Abstract Handler]
 */
class Manager extends Employee {
    private static final String ROLE = "Manager";

    public Manager(LeaveApprover nextApprover) {
        super(ROLE, nextApprover);
    }

    /**
     * Approves Leaves if the Type: [Sick, PTO] leave & duration <= 5 days for PTO
     */
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