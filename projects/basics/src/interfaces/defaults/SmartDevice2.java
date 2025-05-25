package interfaces.defaults;

public interface SmartDevice2 {

    void turnOn();

    // Default method (can be overridden)
    default void showStatus() {
        System.out.println("Device is operational.");
    }

    // Static method (utility function, cannot be overridden)
    static void reset() {
        System.out.println("Resetting device to factory settings.");
    }
}

class Phone2 implements SmartDevice2 {
    public void turnOn() {
        System.out.println("Phone is turning on.");
    }

    // Overriding default method
    public void showStatus() {
        System.out.println("Phone is fully charged.");
    }

}

class Runner {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        phone.turnOn();
        phone.showStatus(); // Calls overridden method

        SmartDevice.reset(); // Calls static method
    }
}
