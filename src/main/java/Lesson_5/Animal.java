package Lesson_5;

import static Lesson_5.NumberOfAnimals.getNumberOfAnimals;
import static Lesson_5.NumberOfAnimals.setNumberOfAnimals;

public class Animal {

    public Animal() {
        setNumberOfAnimals(getNumberOfAnimals() + 1);
    }

    public void run(int distans) {
        System.out.println("Животное пробежало: " + distans+" метров.");
    }

    public void swim(int distans) {
        System.out.println("Животное пробежало: " + distans+" метров.");
    }

}
