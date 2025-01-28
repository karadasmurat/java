package initialization;

public class Chick {

    // NOT A CONSTRUCTOR
    // Constructors do not have a return type!
    // However, this is a valid method definition even if it has a constructor name

    public void Chick() {
        System.out.println("We are in a method.");
    }

    public static void main(String[] args) {
        Chick chick = new Chick(); // compiler defined default constructor!

        // method call:
        chick.Chick(); // prints "We are in a method."
    }
}
