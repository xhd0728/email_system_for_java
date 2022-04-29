import java.text.SimpleDateFormat;
import java.util.Date;

public class SysDate{
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    static Date date = new Date(System.currentTimeMillis());
    public static void showDate() {
        System.out.println("\t" + formatter.format(date));
    }
    public static String getDate(){
        return formatter.format(date);
    }
}