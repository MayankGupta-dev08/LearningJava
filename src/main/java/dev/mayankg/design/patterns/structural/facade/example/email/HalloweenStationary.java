package dev.mayankg.design.patterns.structural.facade.example.email;

class HalloweenStationary implements Stationary {

	@Override
	public String getHeader() {
		return "It's Halloween!!";
	}

	@Override
	public String getFooter() {
		return "BUY MORE STUFF! It's Halloween, c'mon!!";
	}
}