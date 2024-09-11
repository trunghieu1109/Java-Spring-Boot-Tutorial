public class InstanceVariables {

    public static int c = 4;

    public void plus() {
        // int a = 2, b; // This line has not declared b variables yet
        int a = 2, b = 3;
        System.out.println(a + b + c); // 9
    }

    public static void main(String[] args) {
        LocalVariables local = new LocalVariables();
        local.plus();

        // System.out.println(a); // This line should throw an exception because a it a local variables in 'plus' function, so it couldn't be used in main function
    }
}