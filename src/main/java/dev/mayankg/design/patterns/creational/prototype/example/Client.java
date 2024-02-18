package dev.mayankg.design.patterns.creational.prototype.example;

class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Swordsman swordsman1 = new Swordsman();
        swordsman1.move(new Point3D(-10.0f, 0, 0), 20);
        swordsman1.attack();
        System.out.println("Original: " + swordsman1);

        /*Here we are doing shallow copy: copying the states of the properties and
         not creating new objects pointing at all to same --> works when an object is immutable
         (values are set at the time of creation doesn't change) doesn't work when objects are mutable*/
        Swordsman swordsman2 = (Swordsman) swordsman1.clone();
        System.out.println("Cloned: " + swordsman2);
    }
}