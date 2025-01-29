package generics;
/**
 * Generic version of the Box class.
 * 
 * @param <T> the type of the value being boxed
 */
public class GenericBox<T> {

    private T value;

    GenericBox(T val) {
        this.value = val;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T val) {
        this.value = val;
    }

}
