package inheritance.animals.domestic;

import inheritance.animals.Animal;

public class Cat extends Animal {

    // Variable hiding - same name as in Animal
    public String scientificName = "Felis catus";

    public Cat(String name) {
        super(name); // Explicitly call the superclass constructor
        System.out.printf("Cat(%s): constructor called.\n", name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows!");
    }

    @Override
    public boolean isDomestic() {
        return true; // Cats are domesticated
    }

    public void describeCat() {
        System.out.println("This cat is " + name + ". isDomestic: " + isDomestic());
    }

    public void getScientificNameCat() {
        System.out.println("CAT " + name + ". scientific name: " + scientificName);
    }

    @Override
    public String getScientificName() {
        return "Felis catus";
    }

    public static void incrementAnimalCount() {
        Animal.animalCount++;
    }

}
