package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int compareLength = Integer.compare(o1.length(), o2.length());
        if (compareLength < 0) {
            for (int i = 0; i < o1.length() - 1; i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    result = o1.charAt(i) - o2.charAt(i);
                    break;
                }
                result = compareLength;
            }
        }
        if (compareLength > 0) {
            for (int i = 0; i < o2.length() - 1; i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    result = o1.charAt(i) - o2.charAt(i);
                    break;
                }
                result = compareLength;
            }
        }
        if (compareLength == 0) {
            for (int i = 0; i < o2.length() - 1; i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    result = o1.charAt(i) - o2.charAt(i);
                    break;
                }
            }
        }
        return result;
    }
}
