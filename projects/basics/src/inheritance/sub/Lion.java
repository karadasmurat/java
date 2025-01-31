package inheritance.sub;

import inheritance.Animal;

public class Lion extends Animal {

    void roar() {

        // protected members are accessible to all subclasses,
        // even in different packages.
        System.out.println("The lion" + name + " says Hi!");

        // private fields are not inherited by subclasses.
        // ERR The field Animal.age is not visible
        // System.out.println("I am " + age + " years old.");

        System.out.println("I am " + getAge() + " years old."); // OK, inherits public accessor
    }
}