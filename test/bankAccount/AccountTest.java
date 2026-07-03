package bankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountTest {
    Account myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new Account("Aramide", "Ashiwaju", "4321", 1001);
    }

    @Test
    public void testThatAccountHasAccountNumber(){
        assertEquals(1001, myAccount.getNumber());
    }

    @Test
    public void testThatIHaveAnAccountBalanceIsZeroIfIDeposit200BalanceBecomes200() {
        myAccount.deposit(200);
       assertEquals(200, myAccount.getBalance("4321"));
    }

    @Test
    public void testThatIDeposANegativeAmount_ItThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            myAccount.deposit(-500);
        });
    }

    @Test
    public void testThatWhenICheckMyBalanceWithCorrectPinIGetMyBalance(){
        myAccount.deposit(500);
        assertEquals(500, myAccount.getBalance("4321"));
    }

    @Test
    public void testThatWhenICheckMyBalanceWithWrongPinItThrowsError(){
        assertThrows(IllegalArgumentException.class, () -> {
            myAccount.getBalance("1234");
        });
    }

    @Test
    public void testThatIHaveAnAccountBalanceIs500IfIWithdraw300BalanceIs200 () {
        myAccount.deposit(500);
        myAccount.withdraw(300, "4321");
        assertEquals(200, myAccount.getBalance("4321"));
    }

    @Test
    public void testThatWhenIWithdrawWithWrongPinItThrowsError(){
        myAccount.deposit(600);
        assertThrows(IllegalArgumentException.class, () -> {
            myAccount.withdraw(300, "1234");
        });
    }

    @Test
    public void testThatWithdrawalMoreThanTheBalanceThrowsError(){
        myAccount.deposit(600);

        assertThrows(IllegalArgumentException.class, () -> {
            myAccount.withdraw(5000, "1234");
        });
    }
}
