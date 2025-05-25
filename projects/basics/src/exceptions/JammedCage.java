package exceptions;

// This class implements the AutoCloseable interface,
// which means it can be used in a try-with-resources statement.
class JammedCage implements AutoCloseable {

    public void close() {

        // Simulate a situation where closing the resource fails.
        // Note: will be added as a suppressed exception to the original Exception
        throw new IllegalStateException("Cage door does not close");
    }
}
