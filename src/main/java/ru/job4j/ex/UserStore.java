package ru.job4j.ex;

import java.util.Objects;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User user1 : users) {
            if (Objects.equals(user1.getUsername(), login)) {
                user = user1;
                break;
            }
        }

        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }

        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!(user.isValid() && user.getUsername().length() > 3)) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return user.isValid() && user.getUsername().length() > 3;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };

        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}