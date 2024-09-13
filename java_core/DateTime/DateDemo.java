import java.util.Date;
import java.text.SimpleDateFormat;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy-MM-dd");
        
        System.out.println(sdf.format(date));
    }
}