package Lesson_5;

public class NumberOfAnimals {
    private static int numberOfAnimals = 0;
    private static int numberOfCats = 0;
    private static int numberOfDogs = 0;

    public static int getNumberOfCats() {
        return numberOfCats;
    }

    public static void setNumberOfCats(int numberOfCats) {
        NumberOfAnimals.numberOfCats = numberOfCats;
    }

    public static int getNumberOfDogs() {
        return numberOfDogs;
    }

    public static void setNumberOfDogs(int numberOfDogs) {
        NumberOfAnimals.numberOfDogs = numberOfDogs;
    }

    public NumberOfAnimals() {

    }

    public static int getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public static void setNumberOfAnimals(int numberOfAnimals) {
        NumberOfAnimals.numberOfAnimals = numberOfAnimals;
    }

    public void ShowNumberOfAnimals() {
        System.out.println("Количество животных: " + numberOfAnimals + ", количество собак: " + numberOfDogs + ", количество котов: " + numberOfCats);
    }
}
