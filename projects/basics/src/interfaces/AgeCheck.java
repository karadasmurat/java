package interfaces;

import domain.Car;

// concrete implementation of a functional interface
// valid, but add unnecessary boilerplate
// You can replace it with lambda expressions.
public class AgeCheck implements CheckTrait {

    @Override
    public boolean test(Car car) {
        return car.getYear() > 2020;
    }

}
