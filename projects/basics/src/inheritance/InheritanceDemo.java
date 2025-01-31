package inheritance;

public class InheritanceDemo {

    public static void main(String[] args) {

        Animal animal0 = new Animal("animal0"); //
        Animal dog0 = new Dog("dog0");
        Animal cat0 = new Cat("cat0");

        animal0.makeSound(); // animal0 can make a default sound!
        dog0.makeSound();// dog0 barks!
        cat0.makeSound();// cat0 meows!

        // note that dog0 is an Animal reference!
        // dog0.extraDogBehavior(); // undefined for the type Animal

        // Dog is located in the same package
        // We can access its protected members.
        Dog dog = new Dog("bob");
        dog.extraDogBehavior();
        dog.protectedMethod(); // Animal.protectedMethod()
        dog.doSomething();
        // dog.privateMethod(); // ERR not visible

        // dog2 is an Animal (parent) reference!
        Animal dog2 = new Dog("bark");

        // polymorphism example 2
        Animal animal3 = new Animal("animal3");
        animal3.describeAnimal(); // This animal is animal3. isDomestic: false

        Dog dog3 = new Dog("dog3");

        // calling an inherited method, which calls an overriden method!
        dog3.describeAnimal(); // This animal is dog3. isDomestic: true

        dog3.describeDog(); // This dog is dog3. isDomestic: true

        // Variable Hiding: Reference type determines the variable accessed
        // animal4 is of type Animal
        Animal animal4 = new Animal("animal4");
        System.out.println("Animal name: " + animal4.scientificName); // Generic Animal

        // dog4 is of type Dog
        Dog dog4 = new Dog("dog4");
        System.out.println("Dog name: " + dog4.scientificName); // Canis lupus familiaris

        // No polymorphism
        // polyAnimal is of type Animal
        Animal polyAnimal = new Dog("polyAnimal");
        System.out.println("Polymorphic Animal name: " + polyAnimal.scientificName); // Generic Animal

        // the reference type (Dog) does not override getScientificNameAnimal().
        // So, Java calls the method from the Animal class.
        dog4.getScientificNameAnimal(); // ANIMAL dog4. scientific name: Generic Animal

        dog4.getScientificNameDog(); // DOG dog4. scientific name: Canis lupus familiaris

    }
}
