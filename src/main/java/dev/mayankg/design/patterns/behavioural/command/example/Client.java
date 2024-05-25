package dev.mayankg.design.patterns.behavioural.command.example;

class Client {

	public static void main(String[] args) throws InterruptedException {
		EWSService service = new EWSService();
		
		Command c1 = new AddMemberCommand("a@a.com", "spam", service);
		MailTasksRunner.getInstance().addCommandToQueue(c1);
		
		Command c2 = new AddMemberCommand("b@b.com", "spam", service);
		MailTasksRunner.getInstance().addCommandToQueue(c2);

		Command c3 = new RmoveMemberCommand("c@c.com", "spam", service);
		MailTasksRunner.getInstance().addCommandToQueue(c3);
		
		Thread.sleep(3000);
		MailTasksRunner.getInstance().shutdown();
	}
}