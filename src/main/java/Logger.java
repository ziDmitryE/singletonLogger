import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static Logger logger;

    private Logger() {
    }

    protected int num = 1;
    public static Date current = new Date();

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("[" + formatter.format(current) + " " + num++ + "] " + msg);
    }
}