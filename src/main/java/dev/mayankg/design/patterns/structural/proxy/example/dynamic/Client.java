package dev.mayankg.design.patterns.structural.proxy.example.dynamic;

import dev.mayankg.design.patterns.structural.proxy.example.common.Image;
import dev.mayankg.design.patterns.structural.proxy.example.common.Point2D;


class Client {
    public static void main(String[] args) {
        Image img = ImageFactory.getImage("A.bmp");
        img.setLocation(new Point2D(-10, 0));
        System.out.println(img.getLocation());
        System.out.println("*****************************");
        img.render();
    }
}