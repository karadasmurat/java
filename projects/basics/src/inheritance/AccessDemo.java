package inheritance;

import inheritance.animals.Animal;
import inheritance.animals.Mammal;
import inheritance.animals.wild.Fish;
import inheritance.humans.Human;

public class AccessDemo {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.publicMethodAnimal(); // public method
        // animal.protectedMethodAnimal(); // ❌ not visible
        // animal.packagePrivateMethodAnimal(); // ❌ not visible
        // animal.privateMethodAnimal(); // ❌ not visible

        // Create an instance of Mammal
        Mammal mammal = new Mammal();
        // mammal.nurse(); // specialized method for Mammal
        // mammal.test();
        mammal.publicMethodAnimal(); // inherited from Animal
        // mammal.protectedMethodAnimal(); // ❌ not visible
        // mammal.packagePrivateMethodAnimal(); // ❌ not visible

        // Create an instance of Fish
        Fish fish = new Fish();
        // fish.test();
        // fish.swim(); // specialized method for Fish
        // fish.publicMethodAnimal(); // inherited from Animal
        // fish.protectedMethodAnimal(); // inherited from Animal

        Human human = new Human();
        human.publicMethodAnimal();
        human.protectedMethodAnimal(); // ❌ not visible The protected method from the type Animal is not visible
    }

}
