package dev.mayankg.design.patterns.creational.prototype.example;

//Doesn't support cloning
class General extends GameUnit {
    private String state = "idle";

    public void boostMorale() {
        this.state = "morale boost";
    }

    @Override
    public String toString() {
        return "General " + state + " @ " + getPosition();
    }

    @Override
    public GameUnit clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Generals are unique!");
    }

    @Override
    protected void reset() {
        throw new UnsupportedOperationException("Reset is not supported!!");
    }
}