import java.util.Comparator;

class Product implements Comparable<Product> {

    private int id;
    private String name;

    public int hashCode() {
        return id;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Product other)
            return this.id == other.id;
        return false;
    }

    public int compareTo(Product obj) {
        return this.name.compareTo(obj.name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Comparator<Product> byId = new Comparator<>() {
            public int compare(Product p1, Product p2) {
                return Integer.compare(p1.getId(), p2.getId());
            }
        };

        Comparator<Product> byName = (p1, p2) -> p1.getName().compareTo(p2.getName());

        Comparator<Product> byName2 = Comparator.comparing(Product::getName);
        Comparator<Product> byId2 = Comparator.comparingInt(Product::getId);

        Comparator<Product> byName = Comparator.comparing(Product::getName, Comparator.naturalOrder());
        Comparator<Product> byNameDesc = Comparator.comparing(Product::getName).reversed();

    }
}