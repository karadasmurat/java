package inheritance;

public class Dog extends Animal {

    public Dog(String name) {
        super(name); // Explicitly call the superclass constructor
        System.out.printf("Dog(%s): constructor called.\n", name);
    }

    // Dog extends Animal, therefore inherits protected methods from Animal.
    // It will not be directly accessible from outside the Person class or its
    // subclasses.
    public void doSomething() {
        protectedMethod(); // accessible within the Person like a local method
    }

    @Override
    public String toString() {
        return "Dog(" + name + ")";
    }

}
