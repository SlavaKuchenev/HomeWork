package Lesson_8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>(Arrays.asList(
                "Стол", "Мел", "Ручка", "Мел", "Емкость",
                "Стол", "Знак", "Фартук", "Фартук", "Холодильник",
                "Хранилище", "Телефон", "Холодильник", "Шкаф", "Телефон",
                "Перчатки", "Телефон", "Холодильник", "Стол", "Мел"));

        System.out.println(listWithOutDuplicates(array));
        System.out.println(listWithOutDuplicates2(array));
        subsetUniqueWords(array).forEach(System.out::println);
        subsetUniqueWords2(array).forEach((k, v) -> System.out.println("Слово " + k + " встречается - " + v));


        PhoneDirectory phoneDirectory = new PhoneDirectory();
        PhoneDirectory2 phoneDirectory2 = new PhoneDirectory2();
        phoneDirectory.add("Иванов", "+375259556433");
        phoneDirectory.add("Петров", "+375259556444");
        phoneDirectory.add("Иванов", "+3752576567485");
        phoneDirectory.add("Иванов", "+3457547454555");
        phoneDirectory2.add("+375259556433", "Иванов");
        phoneDirectory2.add("+375259556444", "Петров");
        phoneDirectory2.add("+3752576567485", "Иванов");
        phoneDirectory2.add("+3457547454555", "Иванов");


        System.out.println("Иванов телефоны:" + phoneDirectory.get("Иванов"));
        System.out.println("Иванов телефоны:" + phoneDirectory2.get("Иванов"));
    }

    static ArrayList<Object> subsetUniqueWords(ArrayList<String> arrayList) {
        ArrayList<Object> word = new ArrayList<>();
        ArrayList<String> subsetArray = new ArrayList<>(arrayList);
        for (int i = 0; i < subsetArray.size(); i++) {
            int n = 1;
            for (int j = i + 1; j < subsetArray.size(); j++) {
                if (subsetArray.get(i).equals(subsetArray.get(j))) {
                    n = ++n;
                    subsetArray.remove(j);
                }
            }
            word.add(new Word(subsetArray.get(i), n));

        }
        return word;
    }

    static ArrayList<String> listWithOutDuplicates(ArrayList<String> arrayList) {
        ArrayList<String> listWithDuplicates = new ArrayList<>(arrayList);
        for (int i = 0; i < listWithDuplicates.size(); i++) {
            for (int j = i + 1; j < listWithDuplicates.size(); j++) {
                if (listWithDuplicates.get(i).equals(listWithDuplicates.get(j))) {
                    listWithDuplicates.remove(j);
                }
            }
        }
        return arrayList;
    }

    static List<String> listWithOutDuplicates2(ArrayList<String> arrayList) {
        return arrayList.stream().distinct().collect(Collectors.toList());
    }

    static Map<String, Long> subsetUniqueWords2(ArrayList<String> arrayList) {
        return arrayList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
