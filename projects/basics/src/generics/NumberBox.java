package generics;

// Generic Type Parameter: <T extends Number>  
// Type Parameter: T is a type parameter, which acts as a placeholder for a specific type.
// Upper Bound: Number is an upper bound. This means that T must be a Number or subtype of Number.
public class NumberBox<T extends Number> {
    private T value;

    NumberBox(T val) {
        this.value = val;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T val) {
        this.value = val;
    }
}
