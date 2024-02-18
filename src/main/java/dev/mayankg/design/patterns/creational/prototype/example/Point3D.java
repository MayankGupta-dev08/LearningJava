package dev.mayankg.design.patterns.creational.prototype.example;

/**Immutable --> No setters are their, and everytime new objects are being created*/
class Point3D {
    public static final Point3D ZERO = new Point3D(0.0f, 0.0f, 0.0f);
    private float x;
    private float y;
    private float z;

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D normalize() {
        float mag = magnitude();
        return new Point3D(x / mag, y / mag, z / mag);
    }

    private float magnitude() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Point3D multiply(float scale) {
        return new Point3D(x * scale, y * scale, z * scale);
    }

    public Point3D add(Point3D vector) {
        return new Point3D(x + vector.x, y + vector.y, z + vector.z);
    }

    @Override
    public String toString() {
        return "Point3D (x=%s, y=%s, z=%s)".formatted(x, y, z);
    }
}