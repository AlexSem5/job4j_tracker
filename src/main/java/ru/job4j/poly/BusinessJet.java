package ru.job4j.poly;

public class BusinessJet implements Transport {
    @Override
    public void ride() {
        System.out.println("hihey");
    }

    @Override
    public void takePassengers(int number) {

    }

    @Override
    public double fuel(double quantity) {
        return 0;
    }
}
