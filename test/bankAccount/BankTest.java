package bankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {
    Bank myBank;
    @BeforeEach
    public void setUp(){
        myBank = new Bank("Access Bank");
    }
    @Test
    public void registerAccount_AssignsNameToCustomer(){
        Account mideAccount = myBank.registerCustomer("Aramide", "Ashiwaju", "4321");
        assertEquals("Aramide Ashiwaju", mideAccount.getName());
        assertEquals(1001, mideAccount.getNumber());
    }

    @Test
    public void registerAccount_AssignsNumberToCustomer(){
        Bank myBank = new Bank("Access Bank");
        myBank.registerCustomer("Aramide", "Ashiwaju", "4321");
        Account tobiAccount = myBank.registerCustomer("tobi", "Lander", "1234");
        assertEquals(1002, tobiAccount.getNumber());
    }

    @Test
    public void findAccountWithAccountNumber_ReturnCorrectAccount(){
        Account registeredAccount = myBank.registerCustomer("Mide", "Charles", "1914");
        Account found = myBank.findAccount(registeredAccount.getNumber());
        assertEquals(registeredAccount, found);
    }

    @Test
    public void findAccountWithUnknownNumberThrowsError(){
        assertThrows(IllegalArgumentException.class,()-> {
            myBank.findAccount(2222);
        });
    }

    @Test
    public void depositToAccount_AccountBalanceIncreases(){
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");
        myBank.deposit(account.getNumber(), 1000);
        assertEquals(1000, account.getBalance("1914"));
    }

    @Test
    public void depositToUnknownAccount_ThrowsError(){
        assertThrows(IllegalArgumentException.class,()-> {
            myBank.deposit(2222, 2000);
        });
    }

    @Test
    public void withdrawAnAmount_balanceDecreases(){
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");
        myBank.deposit(account.getNumber(), 2000);
        myBank.withdraw(account.getNumber(),1000, "1914");
        assertEquals(1000, account.getBalance("1914"));
    }

    @Test
    public void withdrawAnAmountWithWrongPin_ThrowsError(){
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");
        myBank.deposit(account.getNumber(), 2000);
        assertThrows(IllegalArgumentException.class,()->{
            myBank.withdraw(account.getNumber(),1000, "1922");
        });
    }

    @Test
    public void withdrawAnAmountFromUnknownAccountThrowsError(){
        assertThrows(IllegalArgumentException.class,()-> {
            myBank.withdraw(2222, 2000, "1914");
        });
    }

    @Test
    public void checkBalanceWithAccountNumberAndPasswordTest(){
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");
        myBank.deposit(account.getNumber(), 2000);
        assertEquals(2000, myBank.checkBalance(account.getNumber(), "1914"));
    }

    @Test
    public void checkBalanceWithWrongPinThrowsError(){
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");
        myBank.deposit(account.getNumber(), 2000);
        assertThrows(IllegalArgumentException.class,()-> {
            myBank.checkBalance(account.getNumber(), "2222");
        });
    }

    @Test
    public void checkBalanceOfAnUnknownAccountThrowsError(){
        assertThrows(IllegalArgumentException.class,()-> {
            myBank.checkBalance(2222, "1914");
        });
    }

    @Test
    public void transferAmountFromOneAccount_ToAnotherAccountTest(){
        Account mideAccount = myBank.registerCustomer("Mide", "Charles", "1914");
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");
        myBank.deposit(mideAccount.getNumber(), 5000);
        myBank.transfer(mideAccount.getNumber(), toluAccount.getNumber(), 3000, "1914");

        assertEquals(2000, myBank.checkBalance(mideAccount.getNumber(), "1914"));
        assertEquals(3000, myBank.checkBalance(toluAccount.getNumber(), "4321"));
    }

    @Test
    public void transferAmountFromOneAccount_ToAnotherAccount_WithAWrongPin_ThrowsErrorAndLeaveBalanceUnchangedTest(){
        Account mideAccount = myBank.registerCustomer("Mide", "Charles", "1914");
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");
        myBank.deposit(mideAccount.getNumber(), 5000);
        assertThrows(IllegalArgumentException.class,()->{
            myBank.transfer(mideAccount.getNumber(), toluAccount.getNumber(), 3000, "2222");
        });

        assertEquals(5000, mideAccount.getBalance("1914"));
        assertEquals(0, toluAccount.getBalance("4321"));
    }

    @Test
    public void transferAmountMoreThanBalance_ThrowsError_AndLeavesBalanceUnchangedTest(){
        Account mideAccount = myBank.registerCustomer("Mide", "Charles", "1914");
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");
        myBank.deposit(mideAccount.getNumber(), 1000);
        assertThrows(IllegalArgumentException.class,()->{
            myBank.transfer(mideAccount.getNumber(), toluAccount.getNumber(), 3000, "1914");
        });

        assertEquals(1000, mideAccount.getBalance("1914"));
        assertEquals(0, toluAccount.getBalance("4321"));
    }

    @Test
    public void transferFromNonExistingAccount_ThrowsError_AndReceiverBalanceIsUnchangedTest(){
        Account receiver = myBank.registerCustomer("Mide", "Charles", "1914");
        assertThrows(IllegalArgumentException.class,()->{
            myBank.transfer(2222, receiver.getNumber(), 3000, "4321");
        });
        assertEquals(0, receiver.getBalance("1914"));
    }

    @Test
    public void transferToNonExistingAccount_ThrowsError_AndDoesNotWithdrawTest(){
        Account sender = myBank.registerCustomer("Mide", "Charles", "1914");
        myBank.deposit(sender.getNumber(), 5000);
        assertThrows(IllegalArgumentException.class,()->{
            myBank.transfer(sender.getNumber(), 2222, 1000, "1914");
        });
        assertEquals(5000, sender.getBalance("1914"));
    }

    @Test
    public void removeAccount_RemovesTheAccountTest(){
        Account mideAccount = myBank.registerCustomer("Mide", "Charles", "1914");
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");
        Account seunAccount = myBank.registerCustomer("Seun", "Jacob", "1234");
        myBank.removeAccount(toluAccount.getNumber(), "4321");
        assertThrows(IllegalArgumentException.class,()->{
            myBank.findAccount(toluAccount.getNumber());
        });
    }

    @Test
    public void removeAccountWithWrongPin_ThrowsErrorAndLeavesAccountTest(){
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");
        assertThrows(IllegalArgumentException.class,()->{
            myBank.removeAccount(toluAccount.getNumber(), "2222");
        });
        assertEquals(toluAccount, myBank.findAccount(toluAccount.getNumber()));
    }

    @Test
    public void removeNonExistingAccountThrowsExceptionTest(){
        assertThrows(IllegalArgumentException.class,()->{
            myBank.removeAccount(4444, "2222");
        });
    }

}
