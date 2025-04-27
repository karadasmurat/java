package inheritance.animals;

public class Animal {

    // static variables shared by all subclasses
    public static final int MAX_AGE = 100;
    protected static int animalCount = 0;

    public String scientificName = "Generic Animal";

    protected String name;

    private int age; // private access

    String color; // package-private access

    // Constructor
    public Animal() {
        System.out.println("Animal(): constructor called.");
    }

    // Constructor with name parameter
    public Animal(String name) {
        animalCount++;
        this.name = name;
        this.age = 0; // default age
        System.out.printf("Animal(%s): constructor called.\n", name);
    }

    public void makeSound() {
        System.out.println(name + " can make a default sound!");
    }

    public boolean isDomestic() {
        return false; // Default behavior for wild animals
    }

    public void describeAnimal() {
        System.out.println("This animal is " + name + ". isDomestic: " + isDomestic());
    }

    public void getScientificNameAnimal() {
        System.out.println("ANIMAL " + name + ". scientific name: " + scientificName);
    }

    public String getScientificName() {
        return "Generic Animal";
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    // Private method - only for internal use, hidden from subclasses. NOT inherited
    // Since a subclass does not inherit a private method, it can NOT override it.
    private void privateMethodAnimal() {
        System.out.println("Animal.privateMethod()");
    }

    // Package private method - only for package friends,
    // hidden from subclasses if they are in different package.
    void packagePrivateMethodAnimal() {
        System.out.println("Animal.packagePrivateMethod()");
    }

    protected void protectedMethodAnimal() {
        System.out.println("Animal.protectedMethod()");
    }

    public void publicMethodAnimal() {
        System.out.println("Animal.publicMethod()");
    }

    // mapper Function
    // takes an Animal (this) and returns String
    public String getAgeCategory() {
        return age < 1 ? "BABY" : "ADULT";
    }

    // public accessor for private field
    public int getAge() {
        return age;
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
