import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

class LengthComparator implements Comparator<String> {
    public int compare(String t1, String t2) {
        return t1.length() - t2.length();
    }
}

public class ListDemo {

    public static void print(List<String> list) {
        System.out.println("******************************");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Javascripts");
        list.add("C++");
        list.add("Python");

        ListDemo.print(list);

        list.remove(2);

        ListDemo.print(list);

        System.out.println(list.get(2));

        list.remove("Python");

        ListDemo.print(list);

        System.out.println(list.contains("Java"));

        List<String> llist = new LinkedList<>(list);

        ListDemo.print(llist);

        String[] str = new String[] { "Python", "Java", "C++" };

        Arrays.sort(str, (str1, str2) -> str1.length() - str2.length());

        Arrays.sort(str, new LengthComparator());

        for (String s : str) {
            System.out.println(s + " ");
        }

        list.forEach(System.out::println);

    }
}
