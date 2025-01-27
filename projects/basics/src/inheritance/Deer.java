package inheritance;

public class Deer {

    public Deer() {
        System.out.print("Deer");
    }

    public Deer(int age) {
        System.out.print("DeerAge");
    }

    private boolean hasHorns() {
        System.out.println("private members are hidden from subclasses, so cannot be overriden!");
        return false;
    }

    public static void main(String[] args) {
        Deer deer = new Reindeer(5);
        System.out.println("," + deer.hasHorns());
    }
}

class Reindeer extends Deer {

    public Reindeer(int age) {
        // no explicit call to the parent constructor
        // default constructor super() will be inserted.
        System.out.print("Reindeer");
    }


    public boolean hasHorns() {
        return true;
    }
}
