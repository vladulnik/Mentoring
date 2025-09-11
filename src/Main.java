import problemSolvingClasses.animals.Animal;
import problemSolvingClasses.animals.Bird;
import problemSolvingClasses.animals.Cat;
import problemSolvingClasses.animals.Dog;
import utils.AnimalUtils;

public class Main {
    public static void main(String[] args) {

        Animal[] animal = {
                new Dog(),
                new Cat(),
                new Bird(),
                new Dog(),
                new Cat(),
                new Bird(),
                new Bird(),
                new Bird()
        };

        AnimalUtils.countAnimals(animal);
    }
}
