package Lesson_4;

public class Worker {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Worker() {
        this.name = "Igor";
        this.position = "Engineer";
        this.email = "igor@mail.com";
        this.phoneNumber = "+122345567";
        this.salary = 3000;
        this.age = 38;
    }

    public void WorkerInfo() {
        System.out.println("Фио: " + name + ", Должность: " + position + ", Еmail: " + email + ", Телефон: " + phoneNumber + ", Зарплата: " + salary + ", Возраст: " + age);
    }

    public Worker(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
