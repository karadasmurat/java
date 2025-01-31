package domain;

import interfaces.Playable;
import interfaces.Savable;

public class VideoGame implements Playable, Savable {

    @Override
    public void play() {
        System.out.println("Playing the video game!");
    }

    @Override
    public void save() {
        System.out.println("Saving the video game progress.");
    }

}
