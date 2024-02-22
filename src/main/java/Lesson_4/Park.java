package Lesson_4;

public class Park {


    public class Attraction{
        private String nameAttraction;
        private String workingHours;
        private int price;

        public Attraction(String name, String workingHours, int price) {
            this.nameAttraction = name;
            this.workingHours = workingHours;
            this.price = price;
        }
        public void AttractionInfo() {
            System.out.println("Название аттракциона : "+nameAttraction);
            System.out.println("Время их работы: "+workingHours);
            System.out.println("Стоимость: " +price);
        }

    }
}
