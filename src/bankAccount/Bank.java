package bankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private int nextAccountNumber = 1001;
    private List<Account> accounts = new ArrayList<>();

    public Bank(String name){
        this.name = name;
    }

    public Account registerCustomer(String firstName, String lastName, String pin){
        Account account = new Account(firstName, lastName, pin, nextAccountNumber);
        accounts.add(account);
        nextAccountNumber++;
        return account;
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public void deposit(int accountNumber, int amount){
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, int amount, String pin){
        Account account = findAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public int checkBalance(int accountNumber, String pin){
        Account account = findAccount(accountNumber);
        return account.getBalance(pin);
    }

    public void transfer(int accountOne, int accountTwo, int amount, String pin){
        Account sender = findAccount(accountOne);
        Account receiver = findAccount(accountTwo);
        sender.withdraw(amount, pin);
        receiver.deposit(amount);
//        withdraw(accountOne, amount, pin);
//        deposit(accountTwo, amount);
    }

    public void removeAccount(int accountNumber, String pin){
        Account account = findAccount(accountNumber);
        if(account.validatePin(pin)){
            throw new IllegalArgumentException("Invalid Pin");
        }
        accounts.remove(account);
    }
}
