package dev.mayankg.design.patterns.structural.facade.example.email;

class Mailer {
	private static final Mailer MAILER = new Mailer();
	
	public static Mailer getMailer() {
		return MAILER;
	}
	
	private Mailer() {
		//TODO
	}
	
	public boolean send(Email email) {
		return true;
	}
}