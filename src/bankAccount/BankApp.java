package bankAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankApp {

    private static final CentralBank centralBank = new CentralBank();

    private static final Bank accessBank =
            new Bank("Access Bank", BankCode.ACCESS_BANK);

    private static final Bank firstBank =
            new Bank("First Bank", BankCode.FIRST_BANK);

    private static final Scanner inputCollector = new Scanner(System.in);

    static {
        centralBank.addBank(accessBank);
        centralBank.addBank(firstBank);
    }

    public static void main(String[] args) {
        goToBankMenu();
    }

    private static void goToBankMenu() {
        String prompt = """
                ======================================
                Welcome to the Nigerian Banking System
                ======================================
                1. Create Access Bank Account
                2. Deposit
                3. Withdraw
                4. Transfer Within Access Bank
                5. Inter-Bank Transfer
                6. Check Balance
                7. Remove Account
                8. Exit
                """;

        print(prompt);
        char userResponse = input("Select an option: ").charAt(0);

        switch (userResponse) {
            case '1' -> createAccount();
            case '2' -> deposit();
            case '3' -> withdraw();
            case '4' -> transfer();
            case '5' -> interBankTransfer();
            case '6' -> checkBalance();
            case '7' -> removeAccount();
            case '8' -> exit();
            default -> {
                print("Invalid input. Please try again.");
                goToBankMenu();
            }
        }
    }

    private static void createAccount() {
        try {
            String firstName = input("Enter first name: ");
            String lastName = input("Enter last name: ");
            String pin = input("Enter pin: ");
            Account account = accessBank.registerCustomer(firstName, lastName, pin);

            print("\nAccount created successfully!");
            print("Account Name: " + account.getName());
            print("Account Number: " + account.getNumber());

        } catch (Exception e) {
            print(e.getMessage());
        }
        goToBankMenu();
    }

    private static void deposit() {
        try {
            String accountNumber = input("Enter account number: ");
            BigDecimal amount = new BigDecimal(input("Enter amount: "));
            accessBank.deposit(accountNumber, amount);
            print("Deposit successful!");
        } catch (Exception e) {
            print(e.getMessage());
        }
        goToBankMenu();
    }

    private static void withdraw() {
        try {
            String accountNumber = input("Enter account number: ");
            BigDecimal amount = new BigDecimal(input("Enter amount: "));
            String pin = input("Enter pin: ");
            accessBank.withdraw(accountNumber, amount, pin);
            BigDecimal balance = accessBank.checkBalance(accountNumber, pin);

            print("Withdrawal successful!");
            print("Current Balance: ₦" + balance);

        } catch (Exception e) {
            print(e.getMessage());
        }

        goToBankMenu();
    }

    private static void transfer() {
        try {
            String sender = input("Enter your account number: ");
            String receiver = input("Enter receiver account number: ");
            BigDecimal amount = new BigDecimal(input("Enter amount: "));
            String pin = input("Enter pin: ");
            accessBank.transfer(sender, receiver, amount, pin);
            BigDecimal balance = accessBank.checkBalance(sender, pin);

            print("Transfer successful!");
            print("Current Balance: ₦" + balance);

        } catch (Exception e) {
            print(e.getMessage());
        }

        goToBankMenu();
    }

    private static void interBankTransfer() {
        try {
            String senderBank = input("Enter your bank name: ");
            String senderAccount = input("Enter your account number: ");
            String receiverBank = input("Enter receiver bank name: ");
            String receiverAccount = input("Enter receiver account number: ");

            BigDecimal amount = new BigDecimal(input("Enter amount: "));

            String pin = input("Enter pin: ");

            centralBank.interBankTransfer(senderBank, senderAccount, receiverBank, receiverAccount, amount, pin);
            print("Inter-bank transfer successful!");

        } catch (Exception e) {
            print(e.getMessage());
        }
        goToBankMenu();
    }

    private static void checkBalance() {
        try {
            String accountNumber = input("Enter account number: ");
            String pin = input("Enter pin: ");
            BigDecimal balance = accessBank.checkBalance(accountNumber, pin);
            print("Your balance is: ₦" + balance);

        } catch (Exception e) {
            print(e.getMessage());
        }
        goToBankMenu();
    }

    private static void removeAccount() {
        try {
            String accountNumber = input("Enter account number: ");
            String pin = input("Enter pin: ");
            accessBank.removeAccount(accountNumber, pin);
            print("Account removed successfully!");

        } catch (Exception e) {
            print(e.getMessage());
        }

        goToBankMenu();
    }

    private static void exit() {
        print("Thank you for banking with us!");
        System.exit(0);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static String input(String prompt) {
        System.out.print(prompt);
        return inputCollector.nextLine();
    }
}