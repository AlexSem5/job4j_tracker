package ru.job4j.pojo;

import java.time.LocalDate;

public class Student {
    private String  name;
    private int group;
    private LocalDate entrance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDate getEntrance() {
        return entrance;
    }

    public void setEntrance(int year, int month, int day) {
        this.entrance = LocalDate.of(year, month, day);
    }
}
