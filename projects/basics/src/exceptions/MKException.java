package exceptions;

public class MKException extends Exception {

    /**
     * Constructs a {@code MKException} with no detail message.
     */
    public MKException() {
        super();
    }

    /**
     * Constructs a {@code MKException} with the specified detail message.
     *
     * @param s the detail message.
     */
    public MKException(String s) {
        super(s);
    }
}
