import Interfaces.MusicalInstrument;
import ProblemSolvingClasses.Drum;
import ProblemSolvingClasses.Guitar;
import ProblemSolvingClasses.Piano;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Drum drum = new Drum();
        Guitar guitar = new Guitar();
        Piano piano = new Piano();

        List<MusicalInstrument> musicalInstrumentList = new ArrayList<>();

        musicalInstrumentList.add(drum);
        musicalInstrumentList.add(guitar);
        musicalInstrumentList.add(piano);

        for(MusicalInstrument instrument : musicalInstrumentList) {
            instrument.play();
        }
    }
}
