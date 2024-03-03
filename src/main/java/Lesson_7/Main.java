package Lesson_7;

public class Main {
    public static void main(String[] args) {
        String[][] testArray = {
                {"1", "1", "1", "1"},
                {"1", "2", "2", "1","1"},
                {"1", "1", "a", "1"},
                {"1", "1", "1", "1"}
        };
        try {
            System.out.println("Сумма элементов массива: " + sumElementArray(testArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumElementArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
