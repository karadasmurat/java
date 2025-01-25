package inheritance;

public class Cat extends Animal {

    public Cat(String name) {
        super(name); // Explicitly call the superclass constructor
        System.out.printf("Cat(%s): constructor called.\n", name);
    }

    public static void incrementAnimalCount() {
        Animal.animalCount++;
    }

}
