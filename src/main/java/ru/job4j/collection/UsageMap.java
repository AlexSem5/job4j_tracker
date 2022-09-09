package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("volodya@yandex.ru", "Volodya Ivanov");
        map.put("vasiliy@yandex.ru", "Vasiliy Petrov");
        map.put("gennadiy@yandex.ru", "Gennadiy Semenov");
        for (String key: map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
