package dev.mayankg.design.patterns.structural.flyweight.example2;

import java.util.AbstractMap;
import java.util.Map;

class Client {
    private static final String colors[] = {"Green", "Red", "Blue"};
    private static final Map<String, String> urlMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("Red", "url1"),
            new AbstractMap.SimpleEntry<>("Green", "url2"),
            new AbstractMap.SimpleEntry<>("Blue", "url3")
    );

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            String color = getColor();
            String imageUrl = urlMap.get(color);
            //Getting a ball from cache if already present using intrinsic properties
            Ball ball = BallFactory.getBall(color, imageUrl);

            //setting the extrinsic property of the ball
            ball.setCoordX(getXCoord());
            ball.setCoordY(getYCoord());
            ball.setRadius((int) (Math.random() * 100));
            ball.draw();
            System.out.println(ball.hashCode());
        }
    }

    private static int getXCoord() {
        return (int) (Math.random() * 50);
    }

    private static int getYCoord() {
        return getXCoord();
    }

    private static String getColor() {
        return colors[(int) (Math.random() * colors.length)];
    }
}