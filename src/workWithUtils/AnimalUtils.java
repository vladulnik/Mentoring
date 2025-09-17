package workWithUtils;

import problemSolvingClasses.animals.Animal;
import problemSolvingClasses.animals.Cat;
import problemSolvingClasses.animals.Dog;

public class AnimalUtils {

    public static void countAnimals(Animal[] animals) {
        int dogCounter = 0;
        int catCounter = 0;
        int birdCounter = 0;

        for(Animal animal : animals) {
            if(animal instanceof Dog) {
                dogCounter++;
            } else if (animal instanceof Cat) {
                catCounter++;
            } else {
                birdCounter++;
            }
        }

        System.out.println("Dogs: " + dogCounter);
        System.out.println("Cats: " + catCounter);
        System.out.println("Birds: " + birdCounter);
    }
}
