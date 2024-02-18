package dev.mayankg.design.patterns.creational.prototype.example;

/**
 * Abstract Prototype which defines clone method.
 * Useful where u have large objects and the majority states are unchanged b/w instances & u could identify the state.
 */
abstract class GameUnit implements Cloneable {
    private Point3D position;

    public GameUnit() {
        this.position = Point3D.ZERO;
    }

    public GameUnit(float x, float y, float z) {
        this.position = new Point3D(x, y, z);
    }

    @Override
    public GameUnit clone() throws CloneNotSupportedException {
        // creating a new Object with the exact same value as the caller object
        GameUnit unit = (GameUnit) super.clone();
        unit.initialize();
        return unit;
    }

    protected void initialize() {
        this.position = Point3D.ZERO;
        reset();
    }

    protected abstract void reset();

    public Point3D getPosition() {
        return position;
    }

    public void move(Point3D direction, float distance) {
        Point3D finalMove = direction.normalize();
        finalMove = finalMove.multiply(distance);
        this.position = position.add(finalMove);
    }
}