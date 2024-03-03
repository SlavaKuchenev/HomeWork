package Lesson_5;

public class Animal {
    private static int numberOfAnimals = 0;

    public Animal() {
        numberOfAnimals += 1;
    }

    public void run(int distans) {
        System.out.println("Животное пробежало: " + distans+" метров.");
    }

    public void swim(int distans) {
        System.out.println("Животное пробежало: " + distans+" метров.");
    }

    public static int getNumberOfAnimals() {
        return numberOfAnimals;
    }
}
