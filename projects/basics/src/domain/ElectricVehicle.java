package domain;

import interfaces.SmartElectric;

public class ElectricVehicle implements SmartElectric {

    @Override
    public void enableAutopilot() {
        System.out.println("Driving autonomously...");
    }

    @Override
    public void parkAutomatically() {
        System.out.println("Parking autonomously...");
    }

    @Override
    public void charge() {
        System.out.println("Charging...");
    }

    @Override
    public void checkBatteryLevel() {
        System.out.println("Checking battery level...");
    }

    @Override
    public void runSelfDiagnostics() {
        // Simulate diagnostics output
        System.out.println("All systems are operational.");
    }

}
