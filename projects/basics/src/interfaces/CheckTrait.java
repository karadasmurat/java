package interfaces;

import domain.Car;

// Define a single abstract method (test), making it a functional interface.
// This allows for the use of lambda expressions instead of concrete classes (AgeCheck and MakeCheck).
public interface CheckTrait {
    boolean test(Car car);
}
