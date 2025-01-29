package classes.immutability;

class NotImmutable {

    // mutable field
    private StringBuilder builder;

    public NotImmutable(StringBuilder b) {
        builder = b; // 1. storing a direct reference to mutable object!
    }

    // direct exposure of mutable state!
    public StringBuilder getBuilder() {
        return builder; // 2. direct exposure of mutable state!
    }

    public void print() {
        System.out.println(builder);
    }
}

public class ImmutabilityDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Hello");
        NotImmutable obj = new NotImmutable(sb);

        // 1. External modification (breaking immutability)
        sb.append(" World!");

        // 2. Internal state changed!
        obj.getBuilder().append(" Modified!");

        obj.print();

    }

}
