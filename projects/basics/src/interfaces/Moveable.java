package interfaces;

public interface Moveable {

    static double MAX_SPEED = 0.0; // implicitly public static final

    void move(); // implicitly public abstract

    void stop();
}