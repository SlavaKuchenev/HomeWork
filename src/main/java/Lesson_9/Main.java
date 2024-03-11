package Lesson_9;


import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Integer[] numbers = setRandomlyGeneratedNumbers(5);
        System.out.println("Задание 1.");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Количество чётных чисел = "+ countEvenNumbers(numbers));

        ArrayList<String> arrayList = new ArrayList(Arrays.asList("Highload", "High", "Load", "Highload"));
        System.out.println("Задание 2.");
        System.out.println("Cколько раз объект «High» встречается в коллекции ="+countWordInArray(arrayList,"High"));
        System.out.println("Первый элемент таблицы ="+findFirstElementArray(arrayList));
        System.out.println("Последний элемент таблицы ="+findLastElementArray(arrayList));
        System.out.println("Задание 3.");
        ArrayList<String> arrayList2 = new ArrayList( Arrays.asList("f10", "a15", "f2", "f4", "f5", "b54", "a16"));
        System.out.println("Отсортированный массив "+ Arrays.toString(sortingArray(arrayList2)));

    }

    static Integer[] setRandomlyGeneratedNumbers(int sizeArray){
        Integer[] randomlyNumbers = new Integer[sizeArray];
        for (int i = 0; i < sizeArray; i++ ){
            randomlyNumbers[i] = (int)(Math.random()*100);

        }

        return randomlyNumbers;
    }

    static long countEvenNumbers(Integer[] numbers){
        return Arrays.stream(numbers).filter(number -> number % 2 == 0).count();
    }

    static long countWordInArray(ArrayList arrayList,String word){
        return arrayList.stream().filter(s -> s.equals(word)).count();
    }

    static String findFirstElementArray(ArrayList<String> arrayList){
        return arrayList.stream().findFirst().orElse("0");
    }

    static String findLastElementArray(ArrayList<String> arrayList){
        return arrayList.stream().reduce((first, second) -> second).orElse("0");
    }

    static String[] sortingArray(ArrayList<String> arrayList){
        return arrayList.stream().sorted((s1,s2) -> {
            char c1 =s1.charAt(0);
            char c2 =s2.charAt(0);
            if (c1 != c2){
                return Character.compare(c1,c2);
            }else {
                return Integer.compare(Integer.parseInt(s1.substring(1)),Integer.parseInt(s2.substring(1)));
            }
        })
                .toArray(String[] :: new);
    }
}
