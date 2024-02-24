package dev.mayankg.design.patterns.structural.flyweight.example2;

import java.util.HashMap;

class BallFactory {
    private static final HashMap<String, Ball> ballMapCache = new HashMap();

    private BallFactory() {}

    public static Ball getBall(String color, String imageUrl) {
        StringBuilder sb = new StringBuilder();
        sb.append(color);
        sb.append(imageUrl);
        String ballKey = sb.toString();
        Ball ball = ballMapCache.get(ballKey);
        if (ball == null) {
            ball = new Ball(color, imageUrl);
            ballMapCache.put(ballKey, ball);
            System.out.println("Created a new Ball and saved in the cache!");
        }
        return ball;
    }
}