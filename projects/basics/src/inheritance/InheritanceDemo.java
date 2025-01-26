package inheritance;

public class InheritanceDemo {

    public static void main(String[] args) {
        // Dog is located in the same package
        // We can access its protected members.
        Dog dog = new Dog("bob");
        dog.protectedMethod();
        dog.doSomething();
    }
}
