package inheritance.animals.wild;

import inheritance.animals.Animal;

// Class representing a Fish (inherits from Animal)
public class Fish extends Animal {

    public void swim() {
        System.out.println("Fish is swimming");
    }

    public void test() {
        publicMethodAnimal(); // ✅ Public method of parent - accessible
        protectedMethodAnimal(); // ✅ Protected method of parent - inherited
                                 // can be accessed directly as if it was declared in Fish itself.
        // packagePrivateMethodAnimal(); // ❌ Package-private method of parent in
        // another package - not visible
        // privateMethodAnimal(); // ❌ Private method of parent - not visible
    }

}
