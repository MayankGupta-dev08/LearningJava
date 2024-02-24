package dev.mayankg.design.patterns.structural.facade.example.email;

import dev.mayankg.design.patterns.structural.facade.example.Order;
import dev.mayankg.design.patterns.structural.facade.example.email.Template.TemplateType;

//Facade provides simple methods for Client to use
public class EmailFacade {
	public boolean sendOrderEmail(Order order) {
		Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
		Stationary stationary = StationaryFactory.createStationary();
		Email email = Email.getBuilder()
					  .withTemplate(template)
					  .withStationary(stationary)
					  .forObject(order)
					  .build();
		Mailer mailer = Mailer.getMailer();
		return mailer.send(email);
	}
}