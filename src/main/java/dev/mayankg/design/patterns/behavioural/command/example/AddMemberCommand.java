package dev.mayankg.design.patterns.behavioural.command.example;

/** A Concrete implementation of Command. */
class AddMemberCommand implements Command{
	private String emailAddress;
	private String listName;
	private EWSService receiver;
	
	public AddMemberCommand(String email, String listName, EWSService service) {
		this.emailAddress = email;
		this.listName = listName;
		this.receiver = service;
	}
	
	@Override
	public void execute() {
		receiver.addMember(emailAddress, listName);
	}
}