package dev.mayankg.design.patterns.structural.proxy.example.dynamic;

import dev.mayankg.design.patterns.structural.proxy.example.common.Image;

import java.lang.reflect.Proxy;

//Factory to get image objects.
class ImageFactory {
    //We'll provide a proxy to caller instead of a real object
    public static Image getImage(String name) {
        return (Image) Proxy.newProxyInstance(ImageFactory.class.getClassLoader(), new Class[]{Image.class},
                new ImageInvocationHandler(name));
    }
}