package bankAccount;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final BankCode bankCode;
    private final String name;
    private final List<Account> accounts = new ArrayList<>();

    public Bank(String name, BankCode bankCode){
        this.name = name;
        this.bankCode = bankCode;
    }

    public Account registerCustomer(String firstName, String lastName, String pin){
        String accountNumber = generateAccountNumber();
        Account account = new Account(firstName, lastName, pin, accountNumber);
        accounts.add(account);
        return account;
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public void deposit(String accountNumber, BigDecimal amount){
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(String accountNumber, BigDecimal amount, String pin){
        Account account = findAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public BigDecimal checkBalance(String accountNumber, String pin){
        Account account = findAccount(accountNumber);
        return account.getBalance(pin);
    }

    public void transfer(String accountOne, String accountTwo, BigDecimal amount, String pin){
        Account sender = findAccount(accountOne);
        Account receiver = findAccount(accountTwo);
        sender.withdraw(amount, pin);
        receiver.deposit(amount);
    }

    public void removeAccount(String accountNumber, String pin){
        Account account = findAccount(accountNumber);
        if(!account.isValidPin(pin)){
            throw new IllegalArgumentException("Invalid Pin");
        }
        accounts.remove(account);
    }

    private String generateAccountNumber(){
        SecureRandom randomGenerator = new SecureRandom();
        int serialNumber = randomGenerator.nextInt(1_000_000_000);
        String nubanSerial = String.format("%09d", serialNumber);
        String digits = bankCode.getCode() + nubanSerial;
        int [] multipliers = {3,7,3,3,7,3,3,7,3,3,7,3};
        int total = 0;
        for(int index = 0; index < digits.length(); index++){
            int digit = Character.getNumericValue(digits.charAt(index));
            total+= digit * multipliers[index];
        }

        int remainder = total % 10;
        int checkDigit = 10 - remainder;
        if (checkDigit == 10){
            checkDigit = 0;
        }
        return nubanSerial + checkDigit;
    }
    public String getName() {
        return name;
    }
}
