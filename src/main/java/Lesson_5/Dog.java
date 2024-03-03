package Lesson_5;

public class Dog extends Animal {
    private static int numberOfDogs = 0;
    private String name;

    public Dog(String name) {
        numberOfDogs += 1;
        this.name = name;
    }

    @Override
    public void run(int distans) {
        if (distans <= 500 && distans >= 0) {
            System.out.println("Сабака " + this.name + " пробежал " + distans+" метров.");
        } else {
            System.out.println("Сабака " + this.name + " не может столько бежать.");
        }
    }

    @Override
    public void swim(int distans) {
        if (distans <= 10 && distans >= 0) {
            System.out.println("Сабака " + this.name + " проплыл " + distans+" метров.");
        } else {
            System.out.println("Собака " + this.name + " не может столько плыть");
        }
    }

    public static int getNumberOfDogs() {
        return numberOfDogs;
    }
}
