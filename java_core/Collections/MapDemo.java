import java.util.Map;
import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "hieu");
        map.put("age", "18");
        map.put("sex", "male");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        for (String str : map.keySet()) {
            System.out.println("Key: " + str + ", Value: " + map.get(str));
        }

        System.out.println(map.containsKey("name"));
    }
}
