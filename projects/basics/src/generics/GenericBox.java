package generics;
/**
 * Generic version of the Box class.
 * 
 * @param <T> the type of the value being boxed
 */
public class GenericBox<T extends Number> {

    private T value;

    GenericBox(T val) {
        this.value = val;
    }

    public T getValue() { // ✅ We can return T
        return this.value; 
    }

    public void setValue(T val) { // ✅ We can accept T as a parameter
        this.value = val;
    }

}


