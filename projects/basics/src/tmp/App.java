package tmp;

public class App {
    private int numForks;

    public static void main(String[] args) {

         Object skips = 10;
         switch (skips) {
         case Integer a when a < 10 -> System.out.print(2);
         case Integer b when b>= 10 -> System.out.print(4);
         case null -> System.out.print(6);
         default -> System.out.print(8);
         }

    }
}