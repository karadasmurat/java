package interfaces;

interface Logger {

    // Public abstract method
    void log(String message);

    // Default method using private method
    default void logInfo(String message) {
        logWithTimestamp("INFO", message);
    }

    // Static method using private method
    static void logError(String message) {
        logWithTimestamp("ERROR", message);
    }

    // Private method (introduced in Java 9)
    private static void logWithTimestamp(String level, String message) {
        System.out.println(level + " [" + System.currentTimeMillis() + "]: " + message);
    }
}
