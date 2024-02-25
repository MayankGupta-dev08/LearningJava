package dev.mayankg.design.patterns.structural.proxy.example.normal;

import dev.mayankg.design.patterns.structural.proxy.example.common.Image;
import dev.mayankg.design.patterns.structural.proxy.example.common.Point2D;

class Client {
    public static void main(String[] args) {
        Image img = ImageFactory.getImage("A1.bmp");

        img.setLocation(new Point2D(10, 10));
        System.out.println("Image location :" + img.getLocation());
        System.out.println("rendering image now.....");
        img.render();
    }
}