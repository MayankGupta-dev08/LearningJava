package dev.mayankg.design.patterns.structural.facade.example.email;

class Email {

	public static EmailBuilder getBuilder() {
		return new EmailBuilder();
	}
}