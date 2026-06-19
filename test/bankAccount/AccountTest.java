package bankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AccountTest {
    Account myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new Account();
    }

    @Test
    public void testThatIHaveAnAccountBalanceIsZeroIfIDeposit200BalanceBecomes200() {
        myAccount.deposit(200);
        assertEquals(200, myAccount.getBalance());
    }

    @Test
    public void testThatIHaveAnAccountBalanceIsZeroIfIDeposANegativeAmountBalanceRemainsZero() {
        myAccount.deposit(-500);
        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void testThatIHaveAnAccountBalanceIsZeroIfIWithdraw500BalanceRemainsZero() {
        myAccount.withdraw(300);
        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void testThatIHaveAnAccountBalanceIs500IfIWithdraw300BalanceIs200 () {
        myAccount.deposit(500);
        myAccount.withdraw(300);
        assertEquals(200, myAccount.getBalance());
    }

    @Test
    public void testThatWhenIWithdrawANegativeAmountBalanceDoesNotChange() {
        myAccount.deposit(1000);
        myAccount.withdraw(-500);
        assertEquals(1000, myAccount.getBalance());
    }
}
