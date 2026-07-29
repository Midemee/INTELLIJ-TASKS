package bankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    Bank myBank;

    @BeforeEach
    public void setUp() {
        myBank = new Bank("Access Bank", BankCode.ACCESS_BANK);
    }

    @Test
    public void registerAccount_AssignsNameToCustomer() {
        Account mideAccount = myBank.registerCustomer("Aramide", "Ashiwaju", "4321");

        assertEquals("Aramide Ashiwaju", mideAccount.getName());
        assertNotNull(mideAccount.getNumber());
    }

    @Test
    public void registerAccount_AssignsNumberToCustomer() {
        myBank.registerCustomer("Aramide", "Ashiwaju", "4321");
        Account tobiAccount = myBank.registerCustomer("Tobi", "Lander", "1234");

        assertNotNull(tobiAccount.getNumber());
    }

    @Test
    public void findAccountWithAccountNumber_ReturnCorrectAccount() {
        Account registeredAccount = myBank.registerCustomer("Mide", "Charles", "1914");

        Account found = myBank.findAccount(registeredAccount.getNumber());

        assertEquals(registeredAccount, found);
    }

    @Test
    public void findAccountWithUnknownNumberThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            myBank.findAccount("2222222222");
        });
    }

    @Test
    public void depositToAccount_AccountBalanceIncreases() {
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");

        myBank.deposit(account.getNumber(), BigDecimal.valueOf(1000));

        assertEquals(BigDecimal.valueOf(1000), account.getBalance("1914"));
    }

    @Test
    public void depositToUnknownAccount_ThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            myBank.deposit("2222222222", BigDecimal.valueOf(2000));
        });
    }

    @Test
    public void withdrawAnAmount_balanceDecreases() {
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");

        myBank.deposit(account.getNumber(), BigDecimal.valueOf(2000));
        myBank.withdraw(account.getNumber(), BigDecimal.valueOf(1000), "1914");

        assertEquals(BigDecimal.valueOf(1000), account.getBalance("1914"));
    }

    @Test
    public void withdrawAnAmountWithWrongPin_ThrowsError() {
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");

        myBank.deposit(account.getNumber(), BigDecimal.valueOf(2000));

        assertThrows(IllegalArgumentException.class, () -> {
            myBank.withdraw(account.getNumber(), BigDecimal.valueOf(1000), "1922");
        });
    }

    @Test
    public void withdrawAnAmountFromUnknownAccountThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            myBank.withdraw("2222222222", BigDecimal.valueOf(2000), "1914");
        });
    }

    @Test
    public void checkBalanceWithAccountNumberAndPasswordTest() {
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");

        myBank.deposit(account.getNumber(), BigDecimal.valueOf(2000));

        assertEquals(BigDecimal.valueOf(2000),
                myBank.checkBalance(account.getNumber(), "1914"));
    }

    @Test
    public void checkBalanceWithWrongPinThrowsError() {
        Account account = myBank.registerCustomer("Mide", "Charles", "1914");

        myBank.deposit(account.getNumber(), BigDecimal.valueOf(2000));

        assertThrows(IllegalArgumentException.class, () -> {
            myBank.checkBalance(account.getNumber(), "2222");
        });
    }

    @Test
    public void checkBalanceOfAnUnknownAccountThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            myBank.checkBalance("2222222222", "1914");
        });
    }

    @Test
    public void transferAmountFromOneAccount_ToAnotherAccountTest() {
        Account mideAccount = myBank.registerCustomer("Mide", "Charles", "1914");
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");

        myBank.deposit(mideAccount.getNumber(), BigDecimal.valueOf(5000));

        myBank.transfer(
                mideAccount.getNumber(),
                toluAccount.getNumber(),
                BigDecimal.valueOf(3000),
                "1914"
        );

        assertEquals(BigDecimal.valueOf(2000),
                myBank.checkBalance(mideAccount.getNumber(), "1914"));

        assertEquals(BigDecimal.valueOf(3000),
                myBank.checkBalance(toluAccount.getNumber(), "4321"));
    }

    @Test
    public void transferAmountFromOneAccount_ToAnotherAccount_WithAWrongPin_ThrowsErrorAndLeaveBalanceUnchangedTest() {
        Account mideAccount = myBank.registerCustomer("Mide", "Charles", "1914");
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");

        myBank.deposit(mideAccount.getNumber(), BigDecimal.valueOf(5000));

        assertThrows(IllegalArgumentException.class, () -> {
            myBank.transfer(
                    mideAccount.getNumber(),
                    toluAccount.getNumber(),
                    BigDecimal.valueOf(3000),
                    "2222"
            );
        });

        assertEquals(BigDecimal.valueOf(5000),
                mideAccount.getBalance("1914"));

        assertEquals(BigDecimal.ZERO,
                toluAccount.getBalance("4321"));
    }

    @Test
    public void transferAmountMoreThanBalance_ThrowsError_AndLeavesBalanceUnchangedTest() {
        Account mideAccount = myBank.registerCustomer("Mide", "Charles", "1914");
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");

        myBank.deposit(mideAccount.getNumber(), BigDecimal.valueOf(1000));

        assertThrows(IllegalArgumentException.class, () -> {
            myBank.transfer(
                    mideAccount.getNumber(),
                    toluAccount.getNumber(),
                    BigDecimal.valueOf(3000),
                    "1914"
            );
        });

        assertEquals(BigDecimal.valueOf(1000),
                mideAccount.getBalance("1914"));

        assertEquals(BigDecimal.ZERO,
                toluAccount.getBalance("4321"));
    }

    @Test
    public void transferFromNonExistingAccount_ThrowsError_AndReceiverBalanceIsUnchangedTest() {
        Account receiver = myBank.registerCustomer("Mide", "Charles", "1914");

        assertThrows(IllegalArgumentException.class, () -> {
            myBank.transfer(
                    "2222222222",
                    receiver.getNumber(),
                    BigDecimal.valueOf(3000),
                    "4321"
            );
        });

        assertEquals(BigDecimal.ZERO,
                receiver.getBalance("1914"));
    }

    @Test
    public void transferToNonExistingAccount_ThrowsError_AndDoesNotWithdrawTest() {
        Account sender = myBank.registerCustomer("Mide", "Charles", "1914");

        myBank.deposit(sender.getNumber(), BigDecimal.valueOf(5000));

        assertThrows(IllegalArgumentException.class, () -> {
            myBank.transfer(
                    sender.getNumber(),
                    "2222222222",
                    BigDecimal.valueOf(1000),
                    "1914"
            );
        });

        assertEquals(BigDecimal.valueOf(5000),
                sender.getBalance("1914"));
    }

    @Test
    public void removeAccount_RemovesTheAccountTest() {
        myBank.registerCustomer("Mide", "Charles", "1914");
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");
        myBank.registerCustomer("Seun", "Jacob", "1234");

        myBank.removeAccount(toluAccount.getNumber(), "4321");

        assertThrows(IllegalArgumentException.class, () -> {
            myBank.findAccount(toluAccount.getNumber());
        });
    }

    @Test
    public void removeAccountWithWrongPin_ThrowsErrorAndLeavesAccountTest() {
        Account toluAccount = myBank.registerCustomer("Tolu", "Babs", "4321");

        assertThrows(IllegalArgumentException.class, () -> {
            myBank.removeAccount(toluAccount.getNumber(), "2222");
        });

        assertEquals(toluAccount,
                myBank.findAccount(toluAccount.getNumber()));
    }

    @Test
    public void removeNonExistingAccountThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            myBank.removeAccount("4444444444", "2222");
        });
    }
}