package bankAccount;

public class Account {
    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String firstName, String lastName, String pin, int number){
        this.name = firstName + " " + lastName;
        this.pin = pin;
        this.number = number;
        this.balance = 0;
    }

    public int getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public int getBalance(String pin){
        if (validatePin(pin)) {
        throw new IllegalArgumentException("Invalid Pin");
    }
        return balance;
    }

    public void deposit(int depositAmount){
        if(depositAmount > 0){
            balance = balance + depositAmount;
        }else{
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }

    public void withdraw(int amount, String pin){
        if (validatePin(pin)) {
            throw new IllegalArgumentException("Invalid Pin");
        }
        if(amount > 0 && amount <= balance){
            balance = balance - amount;
        }else{
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public boolean validatePin(String pin){
        return !this.pin.equals(pin);
    }

}

