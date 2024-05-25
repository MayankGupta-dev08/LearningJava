package dev.mayankg.design.patterns.behavioural.chainOfResponsibility.example;

import java.time.LocalDate;

class Client {

    public static void main(String[] args) {
        LeaveApplication application = LeaveApplication.getBuilder().withType(LeaveApplication.Type.PTO)
                .from(LocalDate.of(2024, 2, 25))
                .to(LocalDate.of(2024, 3, 18))
                .build();

        LeaveApprover approver = createChain();

        System.out.println(application);
        System.out.println("Sending the leave request................");
        System.out.println("********************************************************************");
        approver.processLeaveApplication(application);
        System.out.println(application);
    }

    private static LeaveApprover createChain() {
        Director director = new Director(null);
        Manager manager = new Manager(director);
        ProjectLead lead = new ProjectLead(manager);
        return lead;
    }
}