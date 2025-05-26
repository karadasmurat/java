package access;

import access.one.A;
import access.two.SpecialATwo;

public class AccessDemo {

    // private access.subpackage.A1 a1;
    // private access.subpackage.A2 a2; // ERR A2 is not public in
    // access.subpackage; cannot be accessed from outside
    // package

    public static void main(String[] args) {

        A a = new A();
        // SpecialA specialA = new SpecialA();
        // specialA.publicMethodA(); // ✅ Public method from A
        // specialA.publicGatewayToParentsProtectedMethod(); // ✅ Accessing protected
        // method from A
        // specialA.protectedMethodA();

        // Animal animal = new Animal("ani");
        // animal.publicMethodAnimal();
        // // animal.protectedMethod(); // ERR The protectedMethod() from the type
        // Animal
        // // is not visible.

        // // Dog is located in a different package, we will not access its protected
        // // members.
        // Dog dog = new Dog("bob");
        // // dog.protectedMethod(); // ERR The method protectedMethod from the type
        // Animal
        // // is not visible
        // dog.doSomething();
    }
}
