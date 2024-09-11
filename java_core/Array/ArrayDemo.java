public class ArrayDemo {
    
    public int getSum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        return sum;
    }
    
    public static void main(String[] args) {
        int[] array = new int[] {7, 2, 3, 4, 5, 6};

        ArrayDemo demo = new ArrayDemo();

        System.out.println(demo.getSum(array));
    }
}