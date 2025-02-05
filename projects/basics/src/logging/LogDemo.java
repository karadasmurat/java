package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogDemo {
    private static final Logger logger = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {

        // Log to a file instead of console
        FileHandler fileHandler = new FileHandler("app.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

        // By default, JUL logs only INFO and above.
        logger.setLevel(Level.ALL); // Show all logs (default is INFO)

        logger.config("Configuration");
        logger.fine("Fine-grained debug info");
        logger.info("This is an INFO message");
        logger.warning("This is a WARNING message");
        logger.severe("This is a SEVERE message");
    }
}
