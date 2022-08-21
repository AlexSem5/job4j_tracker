package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle motorbus = new MotorBus();
        Vehicle jet = new Jet();
        Vehicle train = new Train();
        Vehicle[] vehicles = {motorbus, jet, train};
        for (Vehicle v : vehicles) {
            v.move();
            v.takePassengers(55);
        }
    }
}
