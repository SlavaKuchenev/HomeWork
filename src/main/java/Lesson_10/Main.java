package Lesson_10;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>(new ArrayList<>(Arrays.asList(new Apple(), new Apple(), new Apple())));
        appleBox.addFruit(new Apple(), 4);
        System.out.println(appleBox);
        System.out.println("Вес коробки appleBox = " + appleBox.getWeight());
        System.out.println(appleBox2);
        System.out.println("Вес коробки appleBox2 = " + appleBox2.getWeight());
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(), 2);
        System.out.println(orangeBox);
        System.out.println("Вес коробки orangeBox = " + orangeBox.getWeight());
        System.out.println("Сравниваем вес коробок appleBox и orangeBox = " + appleBox.compare(orangeBox));
        System.out.println("Сравниваем вес коробок appleBox2 и orangeBox = " + appleBox2.compare(orangeBox));
        appleBox.sprinkle(appleBox2);
        System.out.println("Вес коробки appleBox после пересыпания = " + appleBox.getWeight());
        System.out.println("Вес коробки appleBox2 после пересыпания = " + appleBox2.getWeight());
    }
}
