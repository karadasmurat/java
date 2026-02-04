package domain;

// The Data Models
public abstract class Package {

    // A static nested class inside an abstract class
    // Can access private static members of the abstract outer class, 
    // but cannot access instance variables 
    // (which makes sense, as the outer class cannot be instantiated anyway).
    public static class Box extends Package {
        public double getWeight() {
            return 10.5;
        }
    }

    // A static nested class inside an abstract class
    public static class Envelope extends Package {
        public boolean isPadded() {
            return true;
        }
    }
}

