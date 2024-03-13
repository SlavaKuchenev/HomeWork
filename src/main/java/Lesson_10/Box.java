package Lesson_10;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public Box() {

    }

    public void addFruit(T fruit, int amount) {


        if (fruits.isEmpty() || fruits.get(0).getClass() == fruit.getClass()) {
            for (int i = 0; i < amount; i++) {
                fruits.add(fruit);
            }
        } else {
            System.out.println("Нельзя смешивать фрукты");
        }
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit instanceof Apple ? 1.0f : 1.5f;
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void sprinkle(Box<T> anotherBox) {
        if (this == anotherBox) {
            System.out.println("Нельзя пересыпать в ту же коробку");
            return;
        }
        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}


