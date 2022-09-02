package ru.job4j.early;

public class NoLowercaseException extends RuntimeException {
    public NoLowercaseException(String message) {
        super(message);
    }
}
