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
        cat1.Run(150);
        cat2.Run(300);
        cat3.Swim(150);
        cat4.Swim(10);
        dog1.Run(150);
        dog2.Run(666);
        dog3.Swim(5);
        dog4.Swim(15);

        Cat[] catsArray = new Cat[4];
        catsArray[0] = cat1;
        catsArray[1] = cat2;
        catsArray[2] = cat3;
        catsArray[3] = cat4;

        FoodBowl foodBowl = new FoodBowl(40);

        for (int i = 0; i < catsArray.length; i++) {
            if (catsArray[i].isFull()) {
                catsArray[i].CatInfo();
            } else {
                if ((foodBowl.getCountOffoodinBowl() - catsArray[i].getHunger()) >= 0) {
                    catsArray[i].setFull(true);
                    catsArray[i].CatInfo();
                    foodBowl.setCountOffoodinBowl(foodBowl.getCountOffoodinBowl() - catsArray[i].getHunger());
                } else {
                    catsArray[i].CatInfo();
                }
            }

        }

        foodBowl.FoodBowlInfo();
        foodBowl.AddFoodInBowl(30);
        foodBowl.FoodBowlInfo();

        for (int i = 0; i < catsArray.length; i++) {
            if (catsArray[i].isFull()) {
                catsArray[i].CatInfo();
            } else {
                if ((foodBowl.getCountOffoodinBowl() - catsArray[i].getHunger()) >= 0) {
                    catsArray[i].setFull(true);
                    catsArray[i].CatInfo();
                    foodBowl.setCountOffoodinBowl(foodBowl.getCountOffoodinBowl() - catsArray[i].getHunger());
                } else {
                    catsArray[i].CatInfo();
                }
            }

        }

        NumberOfAnimals numberOfAnimals = new NumberOfAnimals();
        numberOfAnimals.ShowNumberOfAnimals();

        Triangle triangle = new Triangle("black", "Red", 5, 6, 8);
        Rectangle rectangle = new Rectangle("black", "Red", 5, 6);
        Circle circle = new Circle("black", "Red", 2);
        triangle.Info();
        rectangle.Info();
        circle.Info();
    }


}
