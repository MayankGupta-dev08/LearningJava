package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

/**
 * A [Concrete Handler] extending from our [Abstract Handler]
 */
class ProjectLead extends Employee {
    private static final String ROLE = "Project Lead";

    public ProjectLead(LeaveApprover successor) {
        super(ROLE, successor);
    }

    /**
     * Approves Leaves if the type is sick leave & duration is less than or equal to 2 days
     */
    @Override
    protected boolean processRequest(LeaveApplication application) {
        if (application.getType() == LeaveApplication.Type.Sick) {
            if (application.getNoOfDays() <= 2) {
                application.approve(getApproverRole());
                return true;
            }
        }
        application.reject(getApproverRole());
        System.out.println("Project Lead is not able to approve the " + application);
        return false;
    }
}