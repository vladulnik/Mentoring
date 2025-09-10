package problemSolvingClasses.music;

import interfaces.MusicalInstrument;

public class Guitar implements MusicalInstrument {

    @Override
    public void play() {
        System.out.println("Guitar");
    }
}
