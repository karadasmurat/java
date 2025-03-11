package inheritance.animals.wild;

import inheritance.animals.Animal;

public class Lion extends Animal {

    void roar() {

        // protected members are accessible to all subclasses,
        // even in different packages.
        System.out.println("My name: " + name); // OK, protected member, inherited.

        // System.out.println("My age: " + age); // ERR The field Animal.age is not
        // visible

        System.out.println("My color: " + color); // ERR The field Animal.color is not visible

        System.out.println("My age: " + getAge()); // OK, public accessor, inherited.
    }
}