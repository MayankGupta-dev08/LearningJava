package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

/**
 * A [Concrete Handler] extending from our [Abstract Handler]
 */
class Director extends Employee {
    private static final String ROLE = "Director";

    public Director(LeaveApprover nextApprover) {
        super(ROLE, nextApprover);
    }

    /**
     * Approves Leaves of Type: PTO leave
     */
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