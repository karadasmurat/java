package clone;

public class CloneDemo1 {

    public static void main(String[] args) {
        Person person1 = new Person("Bob");

        Object p2 = person1.clone(); // ERR The method clone() from the type Object is not visible.
    }
}
