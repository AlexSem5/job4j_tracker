package ru.job4j.poly;

public class Bus implements Transport {
    private double pricePerLitre = 5.05;

    @Override
    public void ride() {
        System.out.print("Let us go");
    }

    @Override
    public void takePassengers(int number) {
        if (number > 100) {
            System.out.println("Rush hour");
        }
    }

    @Override
    public double fuel(double quantity) {
        return pricePerLitre * quantity;
    }
}
