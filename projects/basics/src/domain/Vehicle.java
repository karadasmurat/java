package domain;

import enums.Fuel;

public class Vehicle {

    private int year;
    private Fuel fuelType;

    public Vehicle(int year, Fuel fuelType) {
        this.year = year;
        this.fuelType = fuelType;
    }


    public int getYear() {
        return year;
    }

    public Fuel getFuel() {
        return fuelType;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void move() {
        System.out.println("VEHICLE is moving");
    }

    // The ULEZ is enforced based on the declared emissions of the vehicle
    // rather than the age
    public boolean isULEZCompliant() {
        return fuelType != Fuel.DIESEL;
    }
}
