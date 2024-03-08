package Lesson_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, List<String>> contacts;

    public PhoneDirectory() {
        contacts = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        contacts.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return contacts.getOrDefault(surname, new ArrayList<>());
    }

}
