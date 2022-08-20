package ru.job4j.poly;

public interface Transport {
    void ride();

    void takePassengers(int number);

    double fuel(double quantity);
}
