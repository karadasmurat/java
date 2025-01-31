package domain;

import interfaces.Powerable;

public class SmartPhone implements Powerable {

    @Override
    public void turnOn() {
        System.out.println("Smartphone is now on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smartphone is now off.");
    }

}
