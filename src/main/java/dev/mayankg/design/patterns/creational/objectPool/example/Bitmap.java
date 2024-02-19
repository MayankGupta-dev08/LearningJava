package dev.mayankg.design.patterns.creational.objectPool.example;

/**
 * Concrete Resuable Product
 */
class Bitmap implements Image {
    private String name;
    private Point2D location;

    public Bitmap(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + name + " @ " + location);
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public void setLocation(Point2D location) {
        this.location = location;
    }

    @Override
    public void reset() {
        location = null;
        System.out.println("Bitmap is reset");
    }
}