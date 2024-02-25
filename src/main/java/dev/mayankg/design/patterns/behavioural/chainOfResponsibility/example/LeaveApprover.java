package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

/**
 * This represents a handler in chain of responsibility
 */
interface LeaveApprover {

    void processLeaveApplication(LeaveApplication application);

    String getApproverRole();
}