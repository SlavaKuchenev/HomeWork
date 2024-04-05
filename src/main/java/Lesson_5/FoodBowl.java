package Lesson_5;

public class FoodBowl {
    private int countOffoodInBowl;

    public FoodBowl(int countOffoodinBowl) {
        this.countOffoodInBowl = countOffoodinBowl;
    }

    public void addFoodInBowl(int food) {
        this.countOffoodInBowl = countOffoodInBowl + food;
        System.out.println("Добавили "+food+" еды");
    }

    public int getCountOffoodinBowl() {
        return countOffoodInBowl;
    }

    public void setCountOffoodinBowl(int countOffoodinBowl) {
        this.countOffoodInBowl = countOffoodinBowl;
    }

    @Override
    public String toString() {
        return "Количество еды: " +
                countOffoodInBowl ;
    }
}
