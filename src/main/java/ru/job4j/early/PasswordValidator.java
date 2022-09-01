package ru.job4j.early;

import java.util.Objects;

public class PasswordValidator {
    public static String validate(String password) throws UserInputException {
        if (password == null) {
            throw new IllegalArgumentException("password is null");
        }

        if (password.toLowerCase().contains("qwerty") || password.toLowerCase().contains("12345")
                || password.toLowerCase().contains("password") || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("user")) {
            throw new SubstringException("Пароль не должен содержать qwerty, 12345, password, admin, user без учета регистра");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new LengthException("Длина пароля должна находиться в диапазоне [8, 32]");
        }

        if (Objects.equals(password, password.toLowerCase())) {
            throw new NoUppercaseException("Пароль должен содержать хотя бы один символ в верхнем регистре");
        }

        if (Objects.equals(password, password.toUpperCase())) {
            throw new NoLowercaseException("Пароль должен содержать хотя бы один символ в нижнем регистре");
        }

        int digitsCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.codePointAt(i) >= 48 && password.codePointAt(i) <= 57) {
                digitsCount++;
                break;
            }
        }
        if (digitsCount == 0) {
            throw new DigitsException("Пароль должен содержать хотя бы одну цифру");
        }

        int specialSymbolCount = 0;
        for (int j = 0; j < password.length(); j++) {
            if (!Character.isDigit(password.codePointAt(j))
                    && !Character.isUpperCase(password.codePointAt(j))
                    && !Character.isLowerCase(password.codePointAt(j))) {
                specialSymbolCount++;
                break;
            }
        }
        if (specialSymbolCount == 0) {
            throw new SymbolException("Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)");
        }

        return "Your Password is valid";
    }
}