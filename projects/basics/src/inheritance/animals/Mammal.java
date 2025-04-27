package inheritance.animals;

// Intermediate class: Mammal (inherits from Animal)
public class Mammal extends Animal {

    public void nurse() {
        System.out.println("Nursing the young");
    }

    public void test() {
        publicMethodAnimal(); // ✅ Public method of parent - accessible
        protectedMethodAnimal(); // ✅ Protected method of parent - accessible
        packagePrivateMethodAnimal(); // ✅ Package-private method of parent in the same package - visible
        // privateMethodAnimal(); // ❌ Private method of parent - not visible
    }

}
