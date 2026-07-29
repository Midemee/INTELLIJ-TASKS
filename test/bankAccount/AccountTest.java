package bankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Account myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new Account("Aramide", "Ashiwaju", "4321", "0000000018");
    }

    @Test
    public void testThatAccountHasAccountNumber() {
        assertEquals("0000000018", myAccount.getNumber());
    }

    @Test
    public void testThatIHaveAnAccountBalanceIsZeroIfIDeposit200BalanceBecomes200() {
        myAccount.deposit(BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(200), myAccount.getBalance("4321"));
    }

    @Test
    public void testThatIDeposANegativeAmount_ItThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            myAccount.deposit(BigDecimal.valueOf(-500));
        });
    }

    @Test
    public void testThatWhenICheckMyBalanceWithCorrectPinIGetMyBalance() {
        myAccount.deposit(BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(500), myAccount.getBalance("4321"));
    }

    @Test
    public void testThatWhenICheckMyBalanceWithWrongPinItThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            myAccount.getBalance("1234");
        });
    }

    @Test
    public void testThatIHaveAnAccountBalanceIs500IfIWithdraw300BalanceIs200() {
        myAccount.deposit(BigDecimal.valueOf(500));
        myAccount.withdraw(BigDecimal.valueOf(300), "4321");
        assertEquals(BigDecimal.valueOf(200), myAccount.getBalance("4321"));
    }

    @Test
    public void testThatWhenIWithdrawWithWrongPinItThrowsError() {
        myAccount.deposit(BigDecimal.valueOf(600));
        assertThrows(IllegalArgumentException.class, () -> {
            myAccount.withdraw(BigDecimal.valueOf(300), "1234");
        });
    }

    @Test
    public void testThatWithdrawalMoreThanTheBalanceThrowsError() {
        myAccount.deposit(BigDecimal.valueOf(600));

        assertThrows(IllegalArgumentException.class, () -> {
            myAccount.withdraw(BigDecimal.valueOf(5000), "1234");
        });
    }
}