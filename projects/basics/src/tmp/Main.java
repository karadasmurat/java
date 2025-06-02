package tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import domain.Car;
import domain.Vehicle;

class Address {

    private String street;
    private String city;

    public String getCity() {
        return city;
    }
}

class Person {

    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person(" + name + ", " + age + ")";
    }
}

// Generic Type Parameter: <T>

class GenericBox<T> {

    private T value;

    GenericBox(T val) {
        this.value = val;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T val) {
        this.value = val;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Car> cars = Car.sampleCarList();
        System.out.println("All cars: " + cars.size());
        Stream<Car> carStream = cars.stream();
        Predicate<Vehicle> predicateVehicle = Vehicle::isULEZCompliant;
        long cnt = carStream.filter(predicateVehicle).count();
        System.out.println("Compliant cars: " + cnt);

    }
}
