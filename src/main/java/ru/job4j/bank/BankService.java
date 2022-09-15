package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает модель банковской системы
 * @Author ALEKSANDR S
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему
     * @param user пользователь, который добавляется в систему
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счёт пользователю
     * @param passport паспорт пользователя
     * @param account уникальный счёт, который требуется добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport паспорт пользователя
     * @return возвращает найденного пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (Objects.equals(user.getPassport(), passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport паспорт пользователя
     * @param requisite реквизиты счёта пользователя
     * @return возвращает найдённый счёт пользователя или null, если счёт не найдён
     */

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (Objects.equals(account.getRequisite(), requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод переводит средства с одного счёта на другой счёт
     * @param srcPassport паспорт пользователя, со счёта которого переводят средства
     * @param srcRequisite реквизиты счёта, с которого переводят средства
     * @param destPassport паспорт пользователя, на счёт которого переводят средства
     * @param destRequisite реквизиты счёта, на который переводят средства
     * @param amount сумма перечисляемых денежных средств
     * @return возвращает true, если на счёте srcAccount достаточно средств или false, если недостаточно
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
                destAccount.setBalance(destAccount.getBalance() + amount);
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                rsl = true;
        }
        return rsl;
    }

    /**
     * Метод для осуществления тестов
     * @param user позователь
     * @return список счетов пользлвателя
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
