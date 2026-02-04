package generics;

/**
 * Generic version of the Box class.
 * 
 * @param <T> the type of the value being boxed
 */
public class GenericBox<T> {

    private T value;

    public GenericBox(T val) {
        this.value = val;
    }

    public T getValue() { // ✅ We can return T
        return this.value;
    }

    public void setValue(T val) { // ✅ We can accept T as a parameter
        this.value = val;
    }

    public void identityInfo() {
        if (value != null) {
            System.out.println("I am: " + getClass().getName());
            System.out.println("I contain an instance of: " + value.getClass().getName());
        } else {
            System.out.println("Box is empty (Type: " + getClass().getName() + ")");
        }
    }

}
