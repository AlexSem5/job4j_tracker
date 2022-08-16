package ru.job4j.pojo;

import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Василий Васильевич Васильев");
        student1.setGroup(5);
        student1.setEntrance(1980, 9, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        System.out.println("ФИО: " + student1.getName());
        System.out.println("Группа: " + student1.getGroup());
        System.out.println("Дата поступления: " + student1.getEntrance().format(formatter));
    }
}
