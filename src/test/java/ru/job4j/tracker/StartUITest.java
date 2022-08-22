package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC", "Upgrade PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created1 = tracker.findAll()[0];
        Item expected1 = new Item("Fix PC");
        StartUI.createItem(input, tracker);
        Item created2 = tracker.findAll()[1];
        Item expected2 = new Item("Upgrade PC");
        assertThat(created1.getName()).isEqualTo(expected1.getName());
        assertThat(created2.getName()).isEqualTo(expected2.getName());
    }
}