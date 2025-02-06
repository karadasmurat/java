package interfaces;

public interface Chargeable {

    double FULL = 100.0; // implicitly public, static and final

    void charge();

    void checkBatteryLevel();
}
