package ru.job4j.early;

public class NoLowercaseException extends UserInputException {
    public NoLowercaseException(String message) {
        super(message);
    }
}
