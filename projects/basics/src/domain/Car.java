package domain;

import java.util.List;

import enums.Fuel;

import java.io.IOException;
import java.time.Year;

public class Car extends Vehicle implements Comparable<Car> {

    private String make;
    private String model;
    // private int year;

    public Car(String make, String model, int year) {
        this(make, model, year, Fuel.PETROL);
    }

    public Car(String make, String model, int year, Fuel fuelType) {
        super(year, fuelType);
        this.make = make;
        this.model = model;
    }

    public static Car sample() {
        return new Car("Kia", "Sample", 2007);
    }

    // Providing a convenient way to create a list of sample Car objects.
    public static List<Car> sampleCarList() {
        return List.of(
                new Car("Kia", "Sorento", 2007, Fuel.DIESEL),
                new Car("Volkswagen", "TROC", 2019),
                new Car("Tesla", "Model Y", 2025, Fuel.ELECTRIC),
                new Car("Toyota", "Corolla", 2010),
                new Car("Ford", "Mustang", 1965),
                new Car("Chevrolet", "Corvette", 1963),
                new Car("Jaguar", "E-Type", 1961),
                new Car("Mercedes-Benz", "A", 2020),
                new Car("Mercedes-Benz", "GLB", 2022),
                new Car("BMW", "X1", 2021),
                new Car("Audi", "A4", 2020));

    }

    // Can a supplier throw checked Exception?
    public static List<Car> maySupply() throws IOException {

        throw new IOException();
    }

    public String getMake() {
        return make;
    }

    // Predicate that determines if a car is classic based on its age
    // Boolean method without arguments
    public boolean isClassic() {
        int currentYear = Year.now().getValue();
        return (currentYear - getYear()) > 20; // Classic if older than 20 years
    }

    // Natural order: Sort by year
    // Implementing compareTo() to sort by ID
    @Override
    public int compareTo(Car other) {
        // return this.year - other.year; // ❌ Risky
        return Integer.compare(getYear(), other.getYear()); // No risk of overflow
    }

    @Override
    public String toString() {
        return "Car(" + this.make + ", " + this.model + ", " + getYear() + ", " + getFuel() + ")";

    }

}
