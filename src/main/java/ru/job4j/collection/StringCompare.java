package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int minLength = Math.min(o1.length(), o2.length());
        for (int i = 0; i < minLength - 1; i++) {
            int compare = Character.compare(o1.charAt(i), o2.charAt(i));
            if (compare != 0) {
                result = compare;
                break;
            }
            result = Integer.compare(o1.length(), o2.length());
        }
        return result;
    }
}
