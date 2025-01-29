package interfaces;

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

    public static void main(String[] args) {

        LambdasDemo id = new LambdasDemo();
        // id.concreteDemo();
        id.lambdasDemo();
    }
}
