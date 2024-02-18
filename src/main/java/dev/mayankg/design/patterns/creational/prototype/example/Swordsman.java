package dev.mayankg.design.patterns.creational.prototype.example;

//Supports cloning
class Swordsman extends GameUnit {
    private String state = "idle";

    public void attack() {
        this.state = "attacking";
    }

    @Override
    public String toString() {
        return "Swordsman " + state + " @ " + getPosition();
    }

    @Override
    protected void reset() {
        this.state = "idle";
    }
}