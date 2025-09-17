package workWithGenerics.wildcardLimitedAbove.animalsTask;

import workWithGenerics.wildcardLimitedAbove.Box;

import java.util.List;

public class WildcardUtils {

    public static void makeSound(Box<? extends Animal> box) {
        Animal animal = box.getValue();
        if(animal != null) {
            animal.makeSound();
        }
    }

    public static void feedAll(List<? extends Animal> animals) {
        for(Animal x : animals) {
            System.out.println("Feeding " + x.getClass().getSimpleName());
        }
    }
}
