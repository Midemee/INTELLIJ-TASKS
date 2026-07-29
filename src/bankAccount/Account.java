package bankAccount;

import java.math.BigDecimal;

public class Account {
    private final String name;
    private BigDecimal balance;
    private final String pin;
    private final String number;

    public Account(String firstName, String lastName, String pin, String number){
        this.name = firstName + " " + lastName;
        this.pin = pin;
        this.number = number;
        this.balance = BigDecimal.ZERO;
    }

    public String getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public BigDecimal getBalance(String pin){
        if (!isValidPin(pin)) {
        throw new IllegalArgumentException("Invalid Pin");
    }
        return balance;
    }

    public void deposit(BigDecimal depositAmount){
        if(depositAmount.compareTo(BigDecimal.ZERO) > 0){
            balance = balance.add(depositAmount);
        }else{
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }

    public void withdraw(BigDecimal amount, String pin){
        if (!isValidPin(pin)) {
            throw new IllegalArgumentException("Invalid Pin");
        }
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Invalid amount");
        }
        if(balance.compareTo(amount) < 0){
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
    }

    public boolean isValidPin(String pin){
        return this.pin.equals(pin);
    }

}

