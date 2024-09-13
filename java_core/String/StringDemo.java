import java.util.List;

public class StringDemo {
    public static void main(String[] args) {
        String str = "Hello, world!";

        System.out.println(str.length()); // 13

        System.out.println(str.charAt(3)); // 'l'

        System.out.println(str.concat(" Who are you?")); // Hello, World! Who are you?

        System.out.println(str.contains("llo")); // true

        System.out.println(str.indexOf("llo")); // 2

        System.out.println(str.substring(2, 8)); // llo, w

        System.out.println(str.toUpperCase()); // HELLO, WORLD!

        System.out.println(str.replace('l', 'k')); // Hekko, Workd!

        String[] strList = str.split(",");

        for (String s : strList) {
            System.out.print(s + " ");
        }

    }
}
