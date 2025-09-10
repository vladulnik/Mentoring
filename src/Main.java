import Interfaces.MusicalInstrument;
import Interfaces.Shape;
import ProblemSolvingClasses.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Triangle(3, 4, 5);

        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());
    }
}
