package inheritance.animals;

import inheritance.animals.wild.Fish;
import inheritance.humans.Human;

public class AnimalDemo {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.protectedMethodAnimal(); // ✅ protected method - accessible through instance

        // AnimalDemo is in the same package as Mammal.
        // Mammal inherits protectedMethodAnimal() from Animal.
        // Any other class residing in the same package as the class declaring the
        // protected member can access that member through an instance of that class or
        // any of its subclasses.
        Mammal mammal = new Mammal();
        mammal.publicMethodAnimal(); // ✅ Public method - accessible
        mammal.protectedMethodAnimal(); // ✅ inherited protected method - accessible through instance
                                        // remember, Protected access allows everything that package access does

        Fish fish = new Fish();
        fish.publicMethodAnimal(); // ✅ Public method - accessible
        fish.protectedMethodAnimal(); // ✅ inherited protected method - accessible through instance

        Human human = new Human();
        human.publicMethodAnimal(); // ✅ Public method - accessible
        human.protectedMethodAnimal(); // 
    }

}
