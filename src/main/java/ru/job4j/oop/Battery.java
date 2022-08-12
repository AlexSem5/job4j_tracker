package ru.job4j.oop;

public class Battery {
    int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load = this.getLoad() + another.getLoad();
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery charger = new Battery(30);
        Battery another = new Battery(50);
        charger.exchange(another);
        System.out.println(another.getLoad());
    }
}
