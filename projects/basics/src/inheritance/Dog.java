package inheritance;

public class Dog extends Animal {

    // Variable hiding - same name as in Animal
    public String scientificName = "Canis lupus familiaris";

    public Dog(String name) {
        super(name); // Explicitly call the superclass constructor
        System.out.printf("Dog(%s): constructor called.\n", name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks!");
    }

    @Override
    public boolean isDomestic() {
        return true; // Dogs are domesticated
    }

    public void describeDog() {
        System.out.println("This dog is " + name + ". isDomestic: " + isDomestic());
    }

    public void getScientificNameDog() {
        System.out.println("DOG " + name + ". scientific name: " + scientificName);
    }

    // Preferred over variable hiding
    @Override
    public String getScientificName() {
        return "Canis lupus familiaris";
    }

    public void extraDogBehavior() {
        System.out.println("Dog.extraDogBehavior()");
    }

    // Dog extends Animal, therefore inherits protected methods from Animal.
    // It will not be directly accessible from outside the Person class or its
    // subclasses.
    public void doSomething() {
        protectedMethod(); // inherited, but accessible like a local method
        privateMethod();
    }

    // Private methods are not inherited by subclasses.
    // A completely independent method
    public String privateMethod() {
        System.out.println("Dog.privateMethod()");
        return "Dog.privateMethod";
    }

    @Override
    public String toString() {
        return "Dog(" + name + ")";
    }

}
