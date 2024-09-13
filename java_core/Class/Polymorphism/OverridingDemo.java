package polymorphism;

class Animal {
    private String name;
    private String color;

    Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void bark() {
        System.out.println("My name is " + color + " " + name + " Animal !");
    }

    String getName() {
        return name;
    }

    String getColor() {
        return color;
    }

}

class Dog extends Animal {

    Dog(String name, String color) {
        super(name, color);
    }

    public void bark() {
        System.out.println("My name is " + getColor() + " " + getName() + " Dog !"); // overriding
    }
}

public class OverridingDemo {
    public static void main(String[] args) {
        Animal animal = new Animal("Jerry", "Pink");
        animal.bark();

        Dog dog = new Dog("Check", "Brown");
        dog.bark();
    }
}