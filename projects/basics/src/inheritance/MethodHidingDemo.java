package inheritance;

import inheritance.animals.wild.Bear;
import inheritance.animals.wild.Panda;

public class MethodHidingDemo {

    public static void main(String[] args) {
        Bear.eat(); // Bear is eating
        Panda.eat(); // Panda bear is chewing

        Bear bearRef = new Panda();

        // generates warning: static methods should be accessed in a static way
        // Since eat() is static, it is resolved at compile time,
        // based on the reference type (Bear)
        // No polymorphism with static methods
        bearRef.eat(); // Bear is eating

    }
}
