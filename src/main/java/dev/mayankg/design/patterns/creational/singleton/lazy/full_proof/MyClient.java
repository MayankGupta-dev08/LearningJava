package dev.mayankg.design.patterns.creational.singleton.lazy.full_proof;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyClient {
    public static void main(String[] args) {
        LazySingleton_100 lazySingletonIH1 = LazySingleton_100.getInstance();
        System.out.printf("%s: %d%n", lazySingletonIH1.toString(), lazySingletonIH1.hashCode());

        try {
            check1UsingCloning(lazySingletonIH1);
        } catch (CloneNotSupportedException e) {
            System.err.println("Clone is not supported for LazySingleton_100 class");
            // throw new CloneFailedException(e);
        }

        try {
            check2UsingReflectionApi(lazySingletonIH1);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.err.println("Creating new instance of LazySingleton_100 class using Java Reflection Api failed!");
            // throw new IllegalAccessException(e);
        }

        try {
            check3UsingSerialization(lazySingletonIH1);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Serialization-Deserialization of LazySingleton_100 class not allowed!");
            // throw new RuntimeException(e);
        }
    }

    private static void check1UsingCloning(LazySingleton_100 lazySingletonIH1) throws CloneNotSupportedException {
        LazySingleton_100 clonedInstance = (LazySingleton_100) lazySingletonIH1.clone();

        System.out.printf("%s: %d%n", clonedInstance.toString(), clonedInstance.hashCode());
        System.out.println(lazySingletonIH1.hashCode() == clonedInstance.hashCode());
    }

    private static void check2UsingReflectionApi(LazySingleton_100 lazySingletonIH1) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        LazySingleton_100 reflectionInstance = null;

        Constructor[] constructors = LazySingleton_100.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            reflectionInstance = (LazySingleton_100) constructor.newInstance();
        }

        System.out.printf("%s: %d%n", reflectionInstance.toString(), reflectionInstance.hashCode());
        System.out.println(lazySingletonIH1.hashCode() == reflectionInstance.hashCode());
    }

    private static void check3UsingSerialization(LazySingleton_100 lazySingletonIH1) throws IOException, ClassNotFoundException {
        String resourceFolderPath = "src/main/resources/design-patterns/singleton";

        //serializing the singleton object to the file
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream(resourceFolderPath + File.separator + "singleton.ser"))) {
            out.writeObject(lazySingletonIH1);
        }

        //deserializing the singleton object from the same file
        LazySingleton_100 deserializedInstance;
        try (ObjectInput in = new ObjectInputStream(new FileInputStream(resourceFolderPath + File.separator + "singleton.ser"))) {
            deserializedInstance = (LazySingleton_100) in.readObject();
        }

        System.out.printf("%s: %d%n", deserializedInstance.toString(), deserializedInstance.hashCode());
        System.out.println(lazySingletonIH1.hashCode() == deserializedInstance.hashCode());
    }
}