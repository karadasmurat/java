package interfaces;

import domain.Car;

// Define a single abstract method (test), making it a functional interface.
// This allows for the use of lambda expressions instead of concrete classes (AgeCheck and MakeCheck).
// Since CheckTrait is a functional interface,it is a good practice to annotate it with @FunctionalInterface.
// This ensures functional interface compliance at compile-time (prevents accidental method additions).
@FunctionalInterface
public interface CheckTrait {
    boolean test(Car car);
}
