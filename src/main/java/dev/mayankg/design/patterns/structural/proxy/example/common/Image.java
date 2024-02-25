package dev.mayankg.design.patterns.structural.proxy.example.common;


//Interface implemented by proxy and concrete objects
public interface Image {

    Point2D getLocation();

    void setLocation(Point2D point2d);

    void render();

}