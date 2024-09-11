class InnerClass {
        
    int a = 2, b = 3;
    
    InnerClass() {

    }

    int getSum() {
        return a + b;
    }
}

public class ReferenceType {

    public static void main(String[] args) {
        InnerClass InnerClass = new InnerClass();
        System.out.println(InnerClass.getSum());
    }
}