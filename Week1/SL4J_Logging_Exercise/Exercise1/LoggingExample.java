import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates logging error and warning level messages using the
 * SLF4J logging facade, backed by the Logback implementation.
 */
public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
