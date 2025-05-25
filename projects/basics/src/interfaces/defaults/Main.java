package interfaces.defaults;

interface SmartDevice {
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

class Phone implements SmartDevice {
    public void turnOn() {
        System.out.println("Phone is turning on.");
    }

    // Overriding default method
    public void showStatus() {
        System.out.println("Phone is fully charged.");
    }
}

class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.turnOn();
        phone.showStatus(); // Calls overridden method

        SmartDevice.reset(); // Calls static method
    }
}
