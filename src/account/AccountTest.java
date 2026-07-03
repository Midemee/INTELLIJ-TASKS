package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountTest {
    Account myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new Account();
    }

    @Test
    public void testThatIHaveAnAccountBalanceIsZeroIfIDeposit200BalanceBecomes200() {
        myAccount.deposit(200);
        Assertions.assertEquals(200, myAccount.getBalance(4321));
    }

    @Test
    public void testThatIHaveAnAccountBalanceIsZeroIfIDeposANegativeAmountBalanceRemainsZero() {
        myAccount.deposit(-500);
        Assertions.assertEquals(0, myAccount.getBalance(4321));
    }

    @Test
    public void testThatIHaveAnAccountBalanceIsZeroIfIWithdraw500BalanceRemainsZero() {
        myAccount.withdraw(300, 4321);
        Assertions.assertEquals(0, myAccount.getBalance(4321));
    }

    @Test
    public void testThatWhenICheckMyBalanceWithCorrectPinIGetMyBalance(){
        myAccount.deposit(500);
        Assertions.assertEquals(500, myAccount.getBalance(4321));
    }

    @Test
    public void testThatWhenICheckMyBalanceWithWrongPinItThrowsError(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myAccount.getBalance(1234);
        });
    }

    @Test
    public void testThatIHaveAnAccountBalanceIs500IfIWithdraw300BalanceIs200 () {
        myAccount.deposit(500);
        myAccount.withdraw(300, 4321);
        Assertions.assertEquals(200, myAccount.getBalance(4321));
    }

    @Test
    public void testThatWhenIWithdrawANegativeAmountBalanceDoesNotChange() {
        myAccount.deposit(1000);
        myAccount.withdraw(-500, 4321);
        Assertions.assertEquals(1000, myAccount.getBalance(4321));
    }

    @Test
    public void testThatWhenIWithdrawFromAnEmptyAccountBalanceDoesNotChange() {
        myAccount.withdraw(600, 4321);
        Assertions.assertEquals(0, myAccount.getBalance(4321));
    }

    @Test
    public void testThatWhenIWithdrawWithWrongPinItThrowsError(){
        myAccount.deposit(600);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myAccount.withdraw(300, 1234);
        });
    }
}
