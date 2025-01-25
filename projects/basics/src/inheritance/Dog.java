package inheritance;

public class Dog extends Animal {

    public Dog(String name) {
        super(name); // Explicitly call the superclass constructor
        System.out.printf("Dog(%s): constructor called.\n", name);
    }

}
