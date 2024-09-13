import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class SetDemo {

    public static void print(Set<String> set) {

        System.out.println("***********");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Java");
        set.add("Python");
        set.add("Java");
        set.add("JavaScript");

        SetDemo.print(set);

        set.remove("Java");

        SetDemo.print(set);

        System.out.println(set.contains("Python"));

        TreeSet<String> treeSet = new TreeSet<>(set);

        SetDemo.print(treeSet);

    }
}
