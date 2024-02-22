package Lesson_5;

public class FoodBowl {
    private int countOffoodInBowl;

    public FoodBowl(int countOffoodinBowl) {
        this.countOffoodInBowl = countOffoodinBowl;
    }

    public void AddFoodInBowl(int food) {
        this.countOffoodInBowl = countOffoodInBowl + food;
        System.out.println("Добавили еды");
    }

    public int getCountOffoodinBowl() {
        return countOffoodInBowl;
    }

    public void setCountOffoodinBowl(int countOffoodinBowl) {
        this.countOffoodInBowl = countOffoodinBowl;
    }

    public void FoodBowlInfo() {
        System.out.println("Количество еды: " + countOffoodInBowl);
    }
}
