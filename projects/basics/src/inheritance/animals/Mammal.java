package inheritance.animals;

// Intermediate class: Mammal (inherits from Animal)
public class Mammal extends Animal {

    public void nurse() {
        System.out.println("Nursing the young");
    }

    public void access() {

        // 1. private members not inherited, not accessible:
        // System.out.println("My age: " + age); // CompileERR: The field Animal.age is
        // not visible

        // 2. package-private members inherited by subclass in the same package:
        // not accessible.
        System.out.println("My color: " + color); // OK

        // 3. protected members are accessible to all subclasses,
        // even in different packages.
        System.out.println("My name: " + name); // OK, protected member, inherited.

        // 4. public member, inherited.
        System.out.println("My age: " + getAge()); // OK
    }

    public void test() {
        publicMethodAnimal(); // ✅ Public method of parent - accessible
        protectedMethodAnimal(); // ✅ Protected method of parent - accessible
        packagePrivateMethodAnimal(); // ✅ Package-private method of parent in the same package - visible
        // privateMethodAnimal(); // ❌ Private method of parent - not visible
    }

}
