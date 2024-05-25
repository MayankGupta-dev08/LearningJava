package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

/**
 * This represents the [Main Handler] in the chain of responsibility pattern.
 */
interface LeaveApprover {

    void processLeaveApplication(LeaveApplication application);

    String getApproverRole();
}