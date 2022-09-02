package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class PasswordValidatorTest {

    @Test
    public void whenSubstrings() {
        SubstringException exception = assertThrows(
                SubstringException.class,
                () -> {
                    PasswordValidator.validate("qwerty");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не должен содержать qwerty, 12345, password, admin, user без учета регистра");
    }

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("password is null");
    }

    @Test
    public void whenInvalidLength() {
        LengthException exception = assertThrows(
                LengthException.class,
                () -> {
                    PasswordValidator.validate("meow");
                });
        assertThat(exception.getMessage()).isEqualTo("Длина пароля должна находиться в диапазоне [8, 32]");
    }

    @Test
    public void whenNoUpperCase() {
        NoUppercaseException exception = assertThrows(
                NoUppercaseException.class,
                () -> {
                    PasswordValidator.validate("meowmeow");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один символ в верхнем регистре");
    }

    @Test
    public void whenNoLowerCase() {
        NoLowercaseException exception = assertThrows(
                NoLowercaseException.class,
                () -> {
                    PasswordValidator.validate("MEOWMEOW");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один символ в нижнем регистре");
    }

    @Test
    public void whenNoDigits() {
        DigitsException exception = assertThrows(
                DigitsException.class,
                () -> {
                    PasswordValidator.validate("Meowmeowmeow");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы одну цифру");
    }

    @Test
    public void whenNoSpecialSymbol() {
        SymbolException exception = assertThrows(
                SymbolException.class,
                () -> {
                    PasswordValidator.validate("Meowmeowmeow1");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)");
    }

    @Test
    public void whenValidPassport() {
        String result = PasswordValidator.validate("$Meooooooowww1");
        String expected = "Your Password is valid";
        assertThat(result).isEqualTo(expected);
    }
}








