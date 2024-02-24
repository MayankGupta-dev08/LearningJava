package dev.mayankg.design.patterns.structural.facade.example.email;

class StationaryFactory {

	public static Stationary createStationary() {
		return new HalloweenStationary();
	}
}