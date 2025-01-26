package access;

import inheritance.Animal;
import inheritance.Dog;

public class AccessDemo {

    private access.a.A1 a1;
    // private access.a.A2 a2; // ERR The type access.a.A2 is not visible!

    public static void main(String[] args) {
        Animal animal = new Animal("ani");
        animal.publicMethod();
        // animal.protectedMethod(); // ERR The protectedMethod() from the type Animal
        // is not visible.

        // Dog is located in a different package, we will not access its protected
        // members.
        Dog dog = new Dog("bob");
        // dog.protectedMethod(); // ERR The method protectedMethod from the type Animal
        // is not visible
        dog.doSomething();
    }
}
