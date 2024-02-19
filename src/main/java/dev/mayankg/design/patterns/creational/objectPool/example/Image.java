package dev.mayankg.design.patterns.creational.objectPool.example;

/**
 * Abstract reusable Product
 */
interface Image extends Poolable {
    void draw();

    Point2D getLocation();

    void setLocation(Point2D location);
}