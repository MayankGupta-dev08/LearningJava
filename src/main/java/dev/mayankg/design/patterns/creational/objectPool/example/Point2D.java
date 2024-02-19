package dev.mayankg.design.patterns.creational.objectPool.example;

class Point2D {
    private float x, y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D @ (x=%s, y=%s)".formatted(x, y);
    }
}