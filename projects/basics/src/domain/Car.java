package domain;

import java.util.List;
import java.time.Year;
import java.util.ArrayList;

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

    // Providing a convenient way to create a list of sample Car objects.
    public static List<Car> sampleCarList() {
        return List.of(
                new Car("Kia", "Sorento", 2007),
                new Car("Volkswagen", "TROC", 2019),
                new Car("BMW", "3", 2014),
                new Car("Toyota", "Corolla", 2010),
                new Car("Ford", "Mustang", 1965),
                new Car("Chevrolet", "Corvette", 1963),
                new Car("Jaguar", "E-Type", 1961),
                new Car("Mercedes-Benz", "GLB", 2022),
                new Car("BMW", "X1", 2021),
                new Car("Audi", "A4", 2020));

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

    // Predicate that determines if a car is classic based on its age
    // Boolean method without arguments
    public boolean isClassic() {
        int currentYear = Year.now().getValue();
        return (currentYear - this.year) > 20; // Classic if older than 20 years
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
