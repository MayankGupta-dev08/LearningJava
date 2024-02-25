package dev.mayankg.design.patterns.structural.proxy.example.normal;

import dev.mayankg.design.patterns.structural.proxy.example.common.Image;

//Factory to get image objects.
class ImageFactory {
	//We'll provide proxy to caller instead of a real object
	public static Image getImage(String name) {
		return new ImageProxy(name);
	}
}