package dev.mayankg.design.patterns.structural.flyweight.example2;

class Ball {
    private String color;
    private String imageUrl;
    private int coordX;
    private int coordY;
    private int radius;

    public Ball(String color, String imageUrl) {
        this.color = color;
        this.imageUrl = imageUrl;
    }

    public void setCoordX(int x) {
        this.coordX = x;
    }

    public void setCoordY(int y) {
        this.coordY = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        //logic to draw on the canvas
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Ball[color='%s', imageUrl='%s', coordX=%d, coordY=%d, radius=%d]".formatted(color, imageUrl, coordX, coordY, radius);
    }
}