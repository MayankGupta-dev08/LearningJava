package dev.mayankg.design.patterns.behavioural.command.example;

/**
 * A Concrete implementation of our [Command Interface]
 */
class RmoveMemberCommand implements Command {
    private String emailAddress;
    private String listName;
    private EWSService receiver;

    public RmoveMemberCommand(String email, String listName, EWSService service) {
        this.emailAddress = email;
        this.listName = listName;
        this.receiver = service;
    }

    @Override
    public void execute() {
        receiver.removeMember(emailAddress, listName);
    }
}