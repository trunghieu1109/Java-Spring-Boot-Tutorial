
import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        String[] strs = {"Char", "Integer", "Double", "Float", "Boolean"};

        for (String x : strs) {
            System.out.println(" " + x);
        }

    }
}