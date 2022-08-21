package ru.job4j.poly;

public class MotorBus implements Vehicle {
    @Override
    public void move() {
        System.out.println("getting stuck in a traffic jam");
    }

    @Override
    public void takePassengers(int number) {
        if (number > 100) {
            System.out.println("survive a rush hour");
        }
    }
}
