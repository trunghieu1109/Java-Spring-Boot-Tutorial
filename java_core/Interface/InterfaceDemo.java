
interface Animal {
    public void bark();
    public void jump();
    public void walk();
}

interface Mammal extends Animal {
    public void breed();
    public void run();
}

class Dog implements Mammal {
    public void bark() {
        System.out.println("Barking");
    }

    public void jump() {
        System.out.println("Jumping");
    }

    public void walk() {
        System.out.println("Walking");
    }

    public void breed() {
        System.out.println("Breeding");
    }

    public void run() {
        System.out.println("Running");
    }
}



public class InterfaceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.jump();
        dog.walk();
        dog.breed();
        dog.run();
    }   
}