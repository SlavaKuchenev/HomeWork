package Lesson_5;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Жорик");
        Cat cat2 = new Cat("Кеша");
        Cat cat3 = new Cat("Барсик");
        Cat cat4 = new Cat("Тоби");
        Dog dog1 = new Dog("Пес");
        Dog dog2 = new Dog("Харди");
        Dog dog3 = new Dog("Викинг");
        Dog dog4 = new Dog("Батлер");
        cat1.run(150);
        cat2.run(300);
        cat3.swim(150);
        cat4.swim(10);
        dog1.run(150);
        dog2.run(666);
        dog3.swim(5);
        dog4.swim(15);
        Cat[] catsArray = new Cat[4];
        catsArray[0] = cat1;
        catsArray[1] = cat2;
        catsArray[2] = cat3;
        catsArray[3] = cat4;

        FoodBowl foodBowl = new FoodBowl(40);

        for (Cat cat : catsArray) {
            if (cat.isFull()) {
                System.out.println(cat.toString());
            } else {
                if ((foodBowl.getCountOffoodinBowl() - cat.getHunger()) >= 0) {
                    cat.setFull(true);
                    System.out.println(cat.toString());
                    foodBowl.setCountOffoodinBowl(foodBowl.getCountOffoodinBowl() - cat.getHunger());
                } else {
                    System.out.println(cat.toString());
                }
            }

        }

        System.out.println(foodBowl.toString());
        foodBowl.addFoodInBowl(30);
        System.out.println(foodBowl.toString());

        for (Cat cat : catsArray) {
            if (cat.isFull()) {
                System.out.println(cat.toString());
            } else {
                if ((foodBowl.getCountOffoodinBowl() - cat.getHunger()) >= 0) {
                    cat.setFull(true);
                    System.out.println(cat.toString());
                    foodBowl.setCountOffoodinBowl(foodBowl.getCountOffoodinBowl() - cat.getHunger());
                } else {
                    System.out.println(cat.toString());
                }
            }

        }

        NumberOfAnimals numberOfAnimals = new NumberOfAnimals();
        System.out.println(numberOfAnimals.toString());

        Triangle triangle = new Triangle("black", "Red", 5, 6, 8);
        Rectangle rectangle = new Rectangle("black", "Red", 5, 6);
        Circle circle = new Circle("black", "Red", 2);
        System.out.println(triangle.toString());
        System.out.println(rectangle.toString());
        System.out.println(circle.toString());
    }


}
