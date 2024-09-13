public class NarrowingCasting {
    public static void main(String[] args) {
        int num = 5004;
        double num_conv = (double) num;
        int num2 = (int) num_conv;
        System.out.println(num2);
    }
}