package domain;

import enums.Fuel;

public class Bus extends Vehicle {

    int seats;

    public Bus(int seats, int year) {
        this(seats, year, Fuel.PETROL);
    }

    public Bus(int seats, int year, Fuel fuelType) {
        super(year, fuelType);
        this.seats = seats;
    }

    public int getSeats() {
        return this.seats;
    }

    @Override
    public String toString() {
        return "Bus(" + this.seats + ", " + this.getYear() + ", " + getFuel() + ")";

    }

}
