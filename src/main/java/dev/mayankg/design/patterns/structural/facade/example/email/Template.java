package dev.mayankg.design.patterns.structural.facade.example.email;

abstract class Template {

	public enum TemplateType {
		Email,
		NewsLetter
	};
	
	public abstract String format(Object obj);
}