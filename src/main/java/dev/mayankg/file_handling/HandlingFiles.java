package dev.mayankg.file_handling;

import java.io.*;
import java.util.Properties;

public class HandlingFiles {

    public static void main(String[] args) {
        try {
            File file = new File("E:\\Coding\\LearningJava\\src\\main\\resources\\filehandling\\demoFile.txt");
            System.out.println(file.getPath());

            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF("This is a demo file of type txt, created by using java programming language!");

            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());

            createPropertiesFile();
        } catch (IOException e) {
            System.out.println("IO Exception occurred!");
        }
    }

    private static void createPropertiesFile() throws IOException {
        Properties p = new Properties();
        OutputStream os = new FileOutputStream("src/main/resources/filehandling/myDataConfig.properties");
        System.out.println("Successfully created a properties file!");

        p.setProperty("url", "localhost:3306\\myDB");
        p.setProperty("userName", "Mayank");
        p.setProperty("pass", "012345678");
        p.store(os, null);

        InputStream is = new FileInputStream("myDataConfig.properties");
        p.load(is);
        p.list(System.out);

        System.out.println(p.getProperty("url"));
    }
}