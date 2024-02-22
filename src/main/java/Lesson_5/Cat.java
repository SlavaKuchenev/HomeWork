package Lesson_5;

import static Lesson_5.NumberOfAnimals.getNumberOfCats;
import static Lesson_5.NumberOfAnimals.setNumberOfCats;

public class Cat extends Animal {
    private String name;
    private int hunger;
    private boolean full;

    public Cat(String name) {
        setNumberOfCats(getNumberOfCats() + 1);
        this.name = name;
        this.hunger = (int) (Math.random() * 5 + 15);
        this.full = false;
    }

    public void CatInfo() {
        System.out.println("Кот " + this.name + " сытый - " + full);
    }

    @Override
    public void Run(int distans) {
        if (distans <= 200 && distans >= 0) {
            System.out.println("Кот " + this.name + " пробежал " + distans+" метров.");
        } else {
            System.out.println("Кот " + this.name + " не может столько бежать.");
        }
    }

    @Override
    public void Swim(int distans) {

        System.out.println("Кот " + this.name + " не может плавать.");
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public String getName() {
        return name;
    }
}
