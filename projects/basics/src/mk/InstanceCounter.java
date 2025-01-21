package mk;

public class InstanceCounter {

    // static, ensuring that it's shared among all instances of the class.
    private static int count;

    public InstanceCounter() {
        ++count;
        System.out.println("Creating an instance..");
    }

    public static int getCount() {
        return count;
    }
}
