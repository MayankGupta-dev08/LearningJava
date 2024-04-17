package dev.mayankg.serialization;

import java.io.*;

public class Demo1 {

    public static void main(String[] args) {
        Player p1 = new Player("Cody", 780, 100);
        System.out.println(p1);
        p1.updateHealth(-24);
        p1.setCheckPoint(5);
        p1.updateLives();
        p1.setMinutesSpend(53);

        System.out.println("After playing for "+ p1.getMinutesSpend()+"min.");
        System.out.println(p1);

        try{
            File f = new File("CurrentPlayer_Cody.txt");

            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p1);    //serialization
            System.out.println("Successfully saved the current state of player object");
            System.out.println("-----------------------------------------------------");

            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Player retrieveP1 = (Player) ois.readObject();  //deserialization
            System.out.println("Successfully retrieved the saved state of player object");
            System.out.println("-----------------------------------------------------");

            System.out.println("The details of the saved player is:");
            System.out.println("Player{" +
                    "Name='" + retrieveP1.getName() + '\'' +
                    ", hitPoints=" + retrieveP1.getHitPoints() +
                    ", health=" + retrieveP1.getHealth() +
                    ", lives=" + retrieveP1.getLives() +
                    ", checkPoint=" + retrieveP1.getCheckPoint() +
                    ", minutesSpend=" + retrieveP1.getMinutesSpend() +  //look out for the value of transient variable, it's value won't be stored rather default values like null or 0 will be stored
                    '}');

            fos.close(); oos.close(); fis.close(); ois.close();
        }catch (IOException e){
            System.out.println("IOException occurred!: " + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}