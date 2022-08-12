package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public int multiply(int a) {
        return x * a;
    }

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int k) {
        return k / x;
    }

    public int sumAllOperations(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        Calculator calculator1 = new Calculator();
        int sum = sum(10);
        int multiply = calculator1.multiply(1);
        int minus = minus(3);
        int divide = calculator1.divide(5);
        int totalSum = calculator1.sumAllOperations(7);
    }
}
