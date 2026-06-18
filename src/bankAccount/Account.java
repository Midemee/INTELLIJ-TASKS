package bankAccount;

public class Account {
    private int balance;

    public int getBalance(){
        return balance;
    }

    public void deposit(int depositAmount){
        if(depositAmount > 0){
            balance = balance + depositAmount;
        }
    }

    public void withdraw(int amount){
        if(amount <= balance){
            balance = balance - amount;
        }
    }

    public void transfer(int amount){
        if(amount > 0 && amount <= balance){
            balance = balance - amount;
        }
    }
}

