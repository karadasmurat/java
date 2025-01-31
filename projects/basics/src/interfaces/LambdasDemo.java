package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import domain.Car;
import util.Util;

public class LambdasDemo {

    // Dependency Injection
    // The check method in InterfaceDemo does not hardcode any condition but
    // instead delegates it to an injected CheckTrait instance.
    // The check method can work with any implementation of CheckTrait
    void check(Car car, CheckTrait checker) {

        if (checker.test(car)) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

    }

    void concreteDemo() {

        Util.header("Concrete Implementations of a Function Interface");
        Car car = Car.sample();

        CheckTrait checker1 = new AgeCheck();
        CheckTrait checker2 = new MakeCheck();

        check(car, checker1);
        check(car, checker2);
    }

    void lambdasDemo() {
        Util.header("Lambda Expressions for a Function Interface");
        Car car = Car.sample();

        CheckTrait checker1 = c -> c.getYear() > 2020;
        CheckTrait checker2 = c -> c.getMake().equalsIgnoreCase("KIA");

        check(car, checker1);
        check(car, checker2);
    }

    void predicateDemo() {
        Predicate<Integer> isEven = num -> num % 2 == 0;

        int x = 6;
        if (isEven.test(x)) {
            System.out.println("Even number! " + x);
        }
    }

    void removeIfDemo() {

        List<String> bunnies = new ArrayList<>();

        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");

        System.out.println(bunnies); // [long ear, floppy, hoppy]

        bunnies.removeIf(s -> s.charAt(0) != 'h');

        System.out.println(bunnies); // [hoppy]
    }

    public static void main(String[] args) {

        LambdasDemo id = new LambdasDemo();
        // id.concreteDemo();
        // id.lambdasDemo();
        // id.predicateDemo();
        id.removeIfDemo();
    }
}
