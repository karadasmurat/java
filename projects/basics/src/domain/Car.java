package domain;

import relationships.Student;

public class Car implements Comparable<Car> {

    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public static Car sample() {
        return new Car("Kia", "Sample", 2007);
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Natural order: Sort by year
    // Implementing compareTo() to sort by ID
    @Override
    public int compareTo(Car other) {
        // return this.year - other.year; // ❌ Risky
        return Integer.compare(this.year, other.year); // No risk of overflow
    }

    @Override
    public String toString() {
        return "Car(" + this.make + ", " + this.model + ", " + this.year + ")";

    }

}
