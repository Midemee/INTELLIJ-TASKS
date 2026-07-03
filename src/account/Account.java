package account;

public class Account {
    private int balance;
    private int atmPin = 4321;

    public int getBalance(int pin){
        if (!validatePin(pin)) {
        throw new IllegalArgumentException("Invalid Pin");
    }
        return balance;
    }

    public void deposit(int depositAmount){
        if(depositAmount > 0){
            balance = balance + depositAmount;
        }
    }

    public void withdraw(int amount, int pin){
        if (!validatePin(pin)) {
            throw new IllegalArgumentException("Invalid Pin");
        }
        if(amount > 0 && amount <= balance){
            balance = balance - amount;
        }
    }

    public boolean validatePin(int pin){
        return pin == atmPin;
    }

}

