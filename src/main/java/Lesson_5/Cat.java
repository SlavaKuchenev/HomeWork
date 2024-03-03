package Lesson_5;

public class Cat extends Animal {
    private static int numberOfCats = 0;
    private String name;
    private int hunger;
    private boolean full;

    public Cat(String name) {
        numberOfCats += 1;
        this.name = name;
        this.hunger = (int) (Math.random() * 5 + 15);
        this.full = false;
    }

    @Override
    public void run(int distans) {
        if (distans <= 200 && distans >= 0) {
            System.out.println("Кот " + this.name + " пробежал " + distans+" метров.");
        } else {
            System.out.println("Кот " + this.name + " не может столько бежать.");
        }
    }

    @Override
    public void swim(int distans) {

        System.out.println("Кот " + this.name + " не может плавать.");
    }
    public int eat(int foodBowl){
        if ((foodBowl - hunger) >= 0) {
            full = true;
            System.out.println(toString());
            return  foodBowl - hunger;
        } else {
            System.out.println(toString());
            return foodBowl;
        }
    }

    public int getHunger() {
        return hunger;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public static int getNumberOfCats() {
        return numberOfCats;
    }

    @Override
    public String toString() {
        return "Кот " +
                  name  +
                " сытый - " + full ;
    }
}

