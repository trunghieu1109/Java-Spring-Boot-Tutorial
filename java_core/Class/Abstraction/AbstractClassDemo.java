abstract class Animal {
    String name, color;
    Animal() {

    }

    Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    abstract void bark();

    void check() {
        System.out.println("Checking in the garden...");
    }
}

class Dog extends Animal {
    Dog() {
        super();
    }

    Dog(String name, String color) {
        super(name, color);
    }

    void bark() {
        System.out.println(color + " " + name);
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Dog animal = new Dog("Jerry", "Pink");
        animal.bark();
        animal.check();
    }
}