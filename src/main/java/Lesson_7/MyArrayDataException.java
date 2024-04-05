package Lesson_7;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int line, int row) {
        super("Неверные данные лежат в ячеёки : "+line+", "+row);
    }

}
