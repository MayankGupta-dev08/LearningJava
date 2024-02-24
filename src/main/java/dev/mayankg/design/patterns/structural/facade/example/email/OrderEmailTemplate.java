package dev.mayankg.design.patterns.structural.facade.example.email;

class OrderEmailTemplate extends Template {

	@Override
	public String format(Object obj) {
		return "TEMPLATE";
	}
}