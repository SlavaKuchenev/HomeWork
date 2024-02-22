package Lesson_4;

public class Main {
    public static void main(String[] args) {
        Worker Worker = new Worker();

        Worker.WorkerInfo();

        Worker[] workerArray = new Worker[5];

        workerArray[0] = new Worker("Panin Maksim Semyonovich", "Engineer", "Panin@mail.com", "5656311", 3000, 53);
        workerArray[1] = new Worker("Kuznecova Sofya Maksimovna", "Art Director", "Kuznecova@mail.com", "2521311", 4000, 26);
        workerArray[2] = new Worker("Tumanova Darya Markovna", "HR Specialist", "Tumanova@mail.com", "25125311", 7000, 41);
        workerArray[3] = new Worker("Vlasova Anna Kirillovna", "Area Manager", "Vlasova@mail.com", "52582311", 6000, 44);
        workerArray[4] = new Worker("Krasnova Taisiya Vladislavovna", "Sales Manager", "Krasnova@mail.com", "2583311", 5000, 34);

        System.out.println();

        for (int i = 0; i < workerArray.length; i++) {
            workerArray[i].WorkerInfo();
        }
        System.out.println();
        Park.Attraction Attraction=new Park().new Attraction("Рамашка","16:00-20:00",23);
        Attraction.AttractionInfo();
    }
}
