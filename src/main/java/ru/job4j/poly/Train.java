package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("enjoy railways");
    }

    @Override
    public void takePassengers(int number) {
        if (number == 500) {
            System.out.println("holiday season");
        }
    }
}
