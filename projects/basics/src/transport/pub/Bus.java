package transport.pub;

import transport.Vehicle;
import inheritance.animals.Animal;

public class Bus extends Vehicle {

    void accessTest() {
        Vehicle vehicle = new Vehicle();
        // vehicle.mprivate(); // CompileERR not visible
        // vehicle.mpackage();// CompileERR not visible
        // vehicle.mprotected();// CompileERR not visible
        vehicle.mpublic();
    }

}
