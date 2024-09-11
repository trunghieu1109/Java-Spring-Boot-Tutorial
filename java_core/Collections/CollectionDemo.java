import java.util.ArrayList;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Python");
        list.add("Java");
        list.add("C++");
        list.add("C#");
        System.out.println(list);

        System.out.println("Index of C# is: " + list.indexOf("C#"));

        list.remove(2);
        System.out.println(list);

        System.out.println(list.subList(1,3));
    }
}