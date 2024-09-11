public class WideningCasting {
    public static void main(String[] args) {
        int a = 5004;
        double b = 5.4;

        // int c = a + b;  // error because of double couldn't be casting to int
        double c = a + b; // ok

        System.out.print(c); 
    }
}