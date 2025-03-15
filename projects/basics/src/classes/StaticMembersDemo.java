package classes;

class Penguin {

    // an instance variable: each Penguin object has its own copy.
    String name;

    // static variable: belongs to the class and is shared by all instances.
    static String nameOfTallestPenguin;
}

public class StaticMembersDemo {

    // instance method
    void instanceMethod() {
        // instance method can access instance variables and static variables
        System.out.println("Instance method");
    }

    public static void main(String[] args) {

        Penguin p1 = new Penguin();
        p1.name = "Pingu";

        Penguin.nameOfTallestPenguin = "Pingu";

        System.out.println("p1: " + p1.name);
        System.out.println("tallest: " + Penguin.nameOfTallestPenguin);

        // 🚫 Avoid accessing static variables via instances (even though it compiles):
        System.out.println("tallest: " + p1.nameOfTallestPenguin);

        p1 = null;
        // System.out.println("p1: " + p1.name); // ERR NullPointerException

        // Accessing static members through a null reference Works!
        System.out.println("static member through null instance?: " + p1.nameOfTallestPenguin); // Works!

        // To call instance method, you must create an instance first!
        // instanceMethod(); // ERR Cannot make a static reference to the non-static method

        StaticMembersDemo smd = new StaticMembersDemo();
        smd.instanceMethod(); // Works!
    }

}
