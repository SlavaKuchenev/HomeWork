package Lesson_8;

public class Word {
    private String name;
    private int count;

    public Word(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Слово " + name +
                " встречается - " + count;
    }
}
