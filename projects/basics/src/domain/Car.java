package domain;

public class Car implements Comparable<Car> {

    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Car other) {
        return this.year - other.year; // Compare cars by year
    }

    @Override
    public String toString() {
        return "Car(" + this.make + ", " + this.model + ", " + this.year + ")";

    }

}
