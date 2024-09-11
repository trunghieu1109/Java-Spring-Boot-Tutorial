package polymorphism;

class Cat extends Animal {
    Cat(String name, String color) {
        super(name, color);
    }

    public void bark() {
        System.out.println("I'm just a cat :)");
    }

    void bark(String sound) {
        System.out.println("I'm just a cat, " + sound);
    }
}

public class OverloadingDemo {
    public static void main(String[] args) {
        Animal animal = new Animal("Jerry", "Pink");
        animal.bark();

        Cat cat = new Cat("Check", "Brown");
        cat.bark();

        cat.bark("Meow");
    }
}