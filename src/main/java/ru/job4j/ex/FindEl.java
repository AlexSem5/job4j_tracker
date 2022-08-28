package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(key, value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element has not been found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] names = {"Tom", "Bob", "Fed", "Bob"};
        try {
            indexOf(names, "Brad");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
