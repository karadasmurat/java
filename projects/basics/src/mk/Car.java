package mk;

public class Car {
    private String model;
    private int year;

    public Car() {
        System.out.println("long!"); // Should cause a compilation error
        this("Unknown", 0);
    }

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.model);
    }
}