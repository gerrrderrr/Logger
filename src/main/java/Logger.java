import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private int num = 1;
    private static Logger logger;
    StringBuilder sb = new StringBuilder();

    private Logger() {
    }

    public void log(String msg) {
        sb.append("[")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss, dd.MM.yyyy")))
                .append(" [")
                .append(num++)
                .append("]]: ")
                .append(msg)
                .append("\n");
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void print() {
        System.out.println(sb);
    }
}