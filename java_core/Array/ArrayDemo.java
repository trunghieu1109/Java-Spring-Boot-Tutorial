import java.util.Arrays;

public class ArrayDemo {

    public int getSum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 7, 2, 4, 3, 5, 6 };

        ArrayDemo demo = new ArrayDemo();

        System.out.println(demo.getSum(array));

        Arrays.sort(array);

        System.out.println(Arrays.toString(array));

        int[][] array2 = new int[][] { { 1, 2 }, { 3, 4 } };
        int[][] array3 = new int[][] { { 1, 2 }, { 3, 4 } };

        for (int[] row : array2) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println("");
        }

        System.out.println(Arrays.deepEquals(array2, array3));

        System.out.println(array2.length);
    }
}