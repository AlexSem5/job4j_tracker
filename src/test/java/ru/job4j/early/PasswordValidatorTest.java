package ru.job4j.early;

import org.junit.jupiter.api.Test;
import ru.job4j.ex.Fact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class PasswordValidatorTest {

    @Test
    public void whenSubstrings() {
        String result = PasswordValidator.validate("Qwertyqwerty");
        String expected = "Пароль не должен содержать qwerty, 12345, password, admin, user без учета регистра";
        assertThat(result).isEqualTo(expected);
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
        String result = PasswordValidator.validate("hi");
        String expected = "Длина пароля должна находиться в диапазоне [8, 32]";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNoUpperCase() {
        String result = PasswordValidator.validate("meowmeow");
        String expected = "Пароль должен содержать хотя бы один символ в верхнем регистре";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNoLowerCase() {
        String result = PasswordValidator.validate("MEOWMEOW");
        String expected = "Пароль должен содержать хотя бы один символ в нижнем регистре";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNoDigits() {
        String result = PasswordValidator.validate("MeowMeow");
        String expected = "Пароль должен содержать хотя бы одну цифру";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNoSpecialSymbol() {
        String result = PasswordValidator.validate("MeowMeow1");
        String expected = "Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenValidPassport() {
        String result = PasswordValidator.validate("$Meooooooowww1");
        String expected = "$Meooooooowww1";
        assertThat(result).isEqualTo(expected);
    }
}








