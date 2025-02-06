package interfaces;

import domain.Bird;
import domain.SmartPhone;

// reducing implicit public visibility of an interface method
class Device implements Chargeable{

    @Override
    void charge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'charge'");
    }

    @Override
    public void checkBatteryLevel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkBatteryLevel'");
    }

}
public class InterfaceDemo {
    public static void main(String[] args) {

        SmartPhone phone = new SmartPhone();
        phone.turnOn(); // Turning the phone on.
        phone.showStatus(); // Object is powered on. (default method)

        Bird bird = new Bird();
        bird.move(); // Bird is moving.
        bird.fly(); // Bird is flying.

        Moveable bird2 = new Bird();
        bird2.move();
        bird2.fly(); // ERR The method fly() is undefined for the type Moveable
    }
}

