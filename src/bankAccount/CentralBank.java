package bankAccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private final List<Bank> banks = new ArrayList<>();

    public void addBank(Bank bank) {
        if (findBank(bank.getName()) != null) {
            throw new IllegalArgumentException("A bank with that name already exists in the system");
        }
        banks.add(bank);
    }

    public void removeBank(String name) {
        Bank bank = findBank(name);
        if (bank == null) {
            throw new IllegalArgumentException("Bank not found inside the system");
        }
        banks.remove(bank);
    }

    public Bank findBank(String name) {
        for (Bank bank : banks) {
            if (bank.getName().equals(name)) {
                return bank;
            }
        }
        return null;
    }

    public void interBankTransfer(String senderBankName, String senderAccountNumber, String receiverBankName, String receiverAccountNumber, BigDecimal amount, String pin) {
        Bank senderBank = findBank(senderBankName);
        Bank receiverBank = findBank(receiverBankName);
        if (senderBank == null) {
            throw new IllegalArgumentException("Sender bank not found");
        }
        if (receiverBank == null) {
            throw new IllegalArgumentException("Receiver bank not found");
        }
        senderBank.withdraw(senderAccountNumber, amount, pin);
        receiverBank.deposit(receiverAccountNumber, amount);
    }

    public int getNumberOfBanks() {
        return banks.size();
    }
    public List<Bank> getBanks() {
        return banks;
    }
}