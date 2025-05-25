package generics;

class Crate2<T> {
}

public class Handler2 {
    public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
    }

    public static <T> Crate<T> ship(T t) {
        System.out.println("Shipping " + t);
        return new Crate<T>();
    }

    public static void main(String[] args) {

        // You can call a generic method normally, and the compiler will try to figure
        // out
        Handler.ship("String");

        // Alternatively, you can specify the type explicitly
        Handler.<String>ship("String");

        Handler.<Integer>ship(1);
    }
}
