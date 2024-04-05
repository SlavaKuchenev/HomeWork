package Lesson_8;

import java.util.*;

public class PhoneDirectory2 {
    private Map<String, String> contacts;

    public PhoneDirectory2() {
        contacts = new HashMap<>();
    }

    public void add(String phoneNumber, String surname) {
        contacts.put(phoneNumber, surname);
    }

    public List<String> get(String surname) {
        List<String> list = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = contacts.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals(surname)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

}
