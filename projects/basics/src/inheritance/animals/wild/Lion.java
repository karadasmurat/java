package inheritance.animals.wild;

import inheritance.animals.Animal;

public class Lion extends Animal {

    void roar() {

        // 1. private members not inherited, not accessible.
        // System.out.println("My age: " + age); // CompileERR: The field Animal.age is
        // not visible

        // 2. package-private members not inherited by subclass in a different package:
        // not accessible.
        // System.out.println("My color: " + color); // CompileERR: The field
        // Animal.color is not visible

        // 3. protected members are accessible to all subclasses,
        // even in different packages.
        System.out.println("My name: " + name); // OK, protected member, inherited.

        // 4. public member, inherited.
        System.out.println("My age: " + getAge()); // OK, public accessor, inherited.
    }
}