import java.util.Date;

public class MeasuringTime {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            System.out.println(new Date().toString());
            Thread.sleep(5000);

            long end = System.currentTimeMillis();
            System.out.println(new Date().toString());
            System.out.println(end - start);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}