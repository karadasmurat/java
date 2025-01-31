package interfaces;

public interface Powerable {

    // Abstract method: Every powerable object should be able to turn on
    void turnOn();

    // Default method: Provides default implementation for turning off
    void turnOff();

    // Default method:
    // Provides default implementation to show the status
    default void showStatus() {
        System.out.println("Object is powered on.");
    }
}
