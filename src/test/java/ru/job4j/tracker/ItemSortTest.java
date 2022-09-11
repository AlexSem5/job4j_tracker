package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemSortTest {

    @Test
    public void whenItemAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Vasiliy"));
        items.add(new Item("Gennadiy"));
        items.add(new Item("Ivan"));
        items.sort(new ItemAscByName());
        List<Item> expected = List.of(
                new Item("Gennadiy"),
                new Item("Ivan"),
                new Item("Vasiliy")
        );
        assertThat(items).hasSameElementsAs(expected);
    }

    @Test
    public void whenItemDscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Vasiliy"));
        items.add(new Item("Gennadiy"));
        items.add(new Item("Ivan"));
        items.sort(new ItemDescByName());
        List<Item> expected = List.of(
                new Item("Vasiliy"),
                new Item("Ivan"),
                new Item("Gennadiy")
        );
        assertThat(items).hasSameElementsAs(expected);
    }
}