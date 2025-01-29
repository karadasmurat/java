package argpassing;

import domain.Car;

public class ArgPassDemo {

    public void modifyPrimitiveArgNoReturn(int num) {
        num = 100; // Changing the local copy, not the original variable
        System.out.println("Local modification applied:" + num);
    }

    public int modifyPrimitiveArgReturn(int num) {
        num++; // Changing the local copy, not the original variable
        System.out.println("Local modification applied:" + num);
        return num;
    }

    public void modifyReferenceArgNoReturn(Car car) {
        car.setYear(-1); // Modifies the object field (persists)
        System.out.println("reference field modified:" + car);
    }

    public void resetReference(Car car) {

        // Notice that the function receives a copy of the caller’s reference.
        // local copy of the reference itself is reassigned to null.
        // Reassigning the reference inside the method does NOT affect the caller’s
        // reference. (local, does NOT persist)
        car = null;

        System.out.println("local copy of reference itself modified:" + car);
    }

    public void reassignReference(Car car) {
        // Notice that the function receives a copy of the caller’s reference.
        // local copy of the reference itself is reassigned to null.
        // Reassigning the reference inside the method does NOT affect the caller’s
        // reference. (local, does NOT persist)
        car = new Car("BMW", "X1", 2025);

        System.out.println("local copy of reference itself modified:" + car);
    }

    public static void main(String[] args) {

        ArgPassDemo ad = new ArgPassDemo();

        int originalValue = 1;
        Car originalCar = new Car("Kia", "Sorento", 2007);

        ad.modifyPrimitiveArgNoReturn(originalValue);
        System.out.println("Argument after function call:" + originalValue); // 1

        originalValue = ad.modifyPrimitiveArgReturn(originalValue);
        System.out.println("Argument after function call:" + originalValue); // 100

        ad.modifyReferenceArgNoReturn(originalCar);
        System.out.println("Argument after function call:" + originalCar); // Car(Kia, Sorento, -1)

        ad.resetReference(originalCar);
        System.out.println("Argument after function call:" + originalCar); // Car(Kia, Sorento, -1)

        ad.reassignReference(originalCar);
        System.out.println("Argument after function call:" + originalCar); // Car(Kia, Sorento, -1)

    }
}
