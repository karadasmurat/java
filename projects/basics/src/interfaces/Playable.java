package interfaces;

public interface Playable {
    void play(); // Abstract method, every playable item must implement this

    // A default method to pause a playable item
    default void pause() {
        System.out.println("Playable item is paused.");
    }

    // A default method to stop a playable item
    default void stop() {
        System.out.println("Playable item has stopped.");
    }
}
