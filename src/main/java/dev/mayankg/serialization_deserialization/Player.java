package dev.mayankg.serialization_deserialization;

import java.io.Serializable;

public class Player implements Serializable {
    private final String Name;
    private final int hitPoints;
    private int health;
    private short lives;
    private int checkPoint;

    private transient int minutesSpend;
    public Player(String name, int hitPoints, int health) {
        Name = name;
        this.hitPoints = hitPoints;
        this.health = health;
        lives = 3;
        checkPoint = 0;
        System.out.println("Created a new player");
    }

    public String getName() {
        return Name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getHealth() {
        return health;
    }

    public short getLives() {
        return lives;
    }

    public int getCheckPoint() {
        return checkPoint;
    }

    public void updateHealth(int updateValue) {
        this.health += updateValue;
    }

    public void updateLives() {
        this.lives--;
    }

    public void setCheckPoint(int checkPoint) {
        this.checkPoint = checkPoint;
    }

    public void setMinutesSpend(int minutesSpend) {
        this.minutesSpend = minutesSpend;
    }

    public int getMinutesSpend() {
        return minutesSpend;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Name='" + Name + '\'' +
                ", hitPoints=" + hitPoints +
                ", health=" + health +
                ", lives=" + lives +
                ", checkPoint=" + checkPoint +
                ", minutesSpend=" + minutesSpend +
                '}';
    }
}