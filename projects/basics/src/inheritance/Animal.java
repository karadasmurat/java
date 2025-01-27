package inheritance;

public class Animal {

    // static variables shared by all subclasses
    public static final int MAX_AGE = 100;
    protected static int animalCount = 0;

    String name;

    // Assume there is no default constructor
    public Animal(String name) {
        animalCount++;
        this.name = name;
        System.out.printf("Animal(%s): constructor called.\n", name);
    }

    // public Animal() {
    // System.out.println("Animal(): constructor called.");
    // }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String publicMethod() {
        return "Animal.publicMethod";
    }

    protected String protectedMethod() {
        return "Animal.protectedMethod";
    }

    // inherited by subclasses
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal(" + name + ")";
    }

}
