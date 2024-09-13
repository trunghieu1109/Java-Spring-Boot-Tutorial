class ClassFactory {
    private static ClassFactory classFactory = new ClassFactory();

    private String name = "John";

    public ClassFactory() {

    }

    public static synchronized ClassFactory getInstance() {

        if (classFactory == null) {
            classFactory = new ClassFactory();
        }

        return classFactory;
    }

    public void demoMethod() {
        System.out.println("Demo method");
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        ClassFactory classFactory = ClassFactory.getInstance();
        classFactory.demoMethod();
    }
}
