import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.add("Java");
        queue.add("Python");
        queue.add("C++");

        int cnt = 0;

        while (cnt < queue.size()) {

            cnt += 1;

            System.out.println(queue.peek());
            queue.remove();
        }

    }
}
