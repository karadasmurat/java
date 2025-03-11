package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import domain.Car;

public class ComparatorDemo {

    public void sortComparables() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volkswagen", "TROC", 2019));
        cars.add(new Car("Kia", "Sorento", 2007));
        cars.add(new Car("Mercedes", "GLB", 2025));

        System.out.println("Before sorting:");
        System.out.println(cars);

        // 1. Sort by natural order
        cars.sort(Comparator.naturalOrder()); // Uses the natural order of the elements
        System.out.println(cars);

        // 2. Sort by make
        Comparator<Car> byMake = Comparator.comparing(Car::getMake);
        cars.sort(byMake);
        System.out.println(cars);

        // 3. Null friendly sorting
        
        // Sorting: Null cars first
        // cars.add(null);
        // cars.sort(Comparator.nullsFirst(byMake));

        // Sorting: Null fields first, then sorting alphabetically
        cars.add(new Car(null, "Seltos", 2019));
        cars.sort(Comparator.comparing(Car::getMake, Comparator.nullsFirst(Comparator.naturalOrder())));

        System.out.println(cars);

    }

    public static void main(String[] args) {
        ComparatorDemo demo = new ComparatorDemo();
        demo.sortComparables();
    }

}
