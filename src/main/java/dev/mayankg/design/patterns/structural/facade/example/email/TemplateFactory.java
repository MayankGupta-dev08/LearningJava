package dev.mayankg.design.patterns.structural.facade.example.email;

import dev.mayankg.design.patterns.structural.facade.example.email.Template.TemplateType;

class TemplateFactory {

	public static Template createTemplateFor(TemplateType type) {
		switch (type) {
		case Email:
			return new OrderEmailTemplate();
		default:
			throw new IllegalArgumentException("Unknown TemplateType");
		}
		
	}
}