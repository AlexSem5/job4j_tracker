package ru.job4j.poly;

public class Jet implements Vehicle {
    @Override
    public void move() {
        System.out.println("catching fresh air");
    }

    @Override
    public void takePassengers(int number) {
        if (number < 50) {
            System.out.println("survive restrictions ");
        }
    }
}
