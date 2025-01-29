package domain;

public class Hamster {
    private String color;
    private int weight;

    public Hamster(int weight) { // first constructor
        this(weight, "brown");
        // Hamster(weight, "brown"); // method undefined!
    }

    public Hamster(int weight, String color) { // second constructor
        this.weight = weight;
        this.color = color;
    }
}
