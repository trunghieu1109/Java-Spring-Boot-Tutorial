package Class;

class Animal {

    final String type = "Animal";

    private String name;
    private int age;
    private String color;
    private String sound;

    Animal() {
        
    }

    Animal(String name, int age, String color, String sound) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.sound = sound;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    String getSound() {
        return sound;
    }

    void setSound(String sound) {
        this.sound = sound;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    void barking() {
        System.out.println(this.sound + "...." + this.sound);
    }

    void scaleAge(int scale) {
        System.out.println("Scaled age: " + age * scale);
    }

    // overloading above function
    void scaleAge(double scale) { 
        System.out.println("Scaled age: " + age * scale);
    }

    double calculateMax(double... values) {
        if (values.length == 0) {
            System.out.println("No arguments passed");
            return 0;
        }

        double result = 0;

        for (double d : values) {
            if (result < d) {
                result = d;
            }
        }

        return result;

    }

}

class Dog extends Animal {
    Dog(String name, int age, String color, String sound) {
        super(name, age, color, sound);
    }

    void barking() {
        System.out.println("Gou Gou Gou");
        super.barking();
    }
}

public class DemoClass {
    public static void main(String[] args) {
        Animal animal = new Animal("Bae", 5, "Black", "Gou");
        
        animal.barking();

        // animal.type = "Animal"; // error because it can't assign to final variable

        System.out.println(animal.getName());

        animal.scaleAge(5);
        animal.scaleAge(5.5);

        Animal animal2 = new Animal(args[0], 12, args[1], args[2]); // use command line arguments
        animal2.barking();

        System.out.println(animal.calculateMax(new double[]{1, 2, 3, 4, 7}));

        Dog dog = new Dog("Je", 16, "Brown", "Gou");
        dog.barking();
    }
}