package bankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CentralBankTest {

    private CentralBank centralBank;
    private Bank accessBank;
    private Bank firstBank;

    @BeforeEach
    public void setUp() {
        centralBank = new CentralBank();
        accessBank = new Bank("Access Bank", BankCode.ACCESS_BANK);
        firstBank = new Bank("First Bank", BankCode.FIRST_BANK);
    }

    @Test
    public void addBank_BankIsAddedToCentralBankTest() {
        centralBank.addBank(accessBank);
        assertEquals(1, centralBank.getNumberOfBanks());
    }

    @Test
    public void addTwoBanks_NumberOfBanksBecomesTwoTest() {
        centralBank.addBank(accessBank);
        centralBank.addBank(firstBank);
        assertEquals(2, centralBank.getNumberOfBanks());
    }

    @Test
    public void addDuplicateBank_ThrowsExceptionTest() {
        centralBank.addBank(accessBank);
        assertThrows(IllegalArgumentException.class, () -> {centralBank.addBank(accessBank);});
    }

    @Test
    public void findExistingBank_ReturnsBankTest() {
        centralBank.addBank(accessBank);
        Bank found = centralBank.findBank("Access Bank");
        assertEquals(accessBank, found);
    }

    @Test
    public void findNonExistingBank_ReturnsNullTest() {
        assertNull(centralBank.findBank("UBA"));
    }

    @Test
    public void removeBank_RemovesBankTest() {
        centralBank.addBank(accessBank);
        centralBank.removeBank("Access Bank");
        assertEquals(0, centralBank.getNumberOfBanks());
    }

    @Test
    public void removeNonExistingBank_ThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            centralBank.removeBank("GTBank");
        });
    }

    @Test
    public void interBankTransfer_MoneyMovesSuccessfullyTest() {
        centralBank.addBank(accessBank);
        centralBank.addBank(firstBank);
        Account sender = accessBank.registerCustomer("Mide", "Charles", "1914");
        Account receiver = firstBank.registerCustomer("Tolu", "Babs", "4321");
        accessBank.deposit(sender.getNumber(), BigDecimal.valueOf(5000));

        centralBank.interBankTransfer("Access Bank", sender.getNumber(), "First Bank", receiver.getNumber(), BigDecimal.valueOf(2000), "1914");
        assertEquals(BigDecimal.valueOf(3000), accessBank.checkBalance(sender.getNumber(), "1914"));
        assertEquals(BigDecimal.valueOf(2000), firstBank.checkBalance(receiver.getNumber(), "4321"));
    }

    @Test
    public void interBankTransfer_WithWrongSenderBank_ThrowsExceptionTest() {
        centralBank.addBank(firstBank);
        Account receiver = firstBank.registerCustomer("Tolu", "Babs", "4321");
        assertThrows(IllegalArgumentException.class, () -> {centralBank.interBankTransfer("GTBank", "1111111111", "First Bank", receiver.getNumber(), BigDecimal.valueOf(1000), "1914");
        });
    }

    @Test
    public void interBankTransfer_WithWrongReceiverBank_ThrowsExceptionTest() {
        centralBank.addBank(accessBank);
        Account sender = accessBank.registerCustomer("Mide", "Charles", "1914");
        accessBank.deposit(sender.getNumber(), BigDecimal.valueOf(5000));
        assertThrows(IllegalArgumentException.class, () -> {centralBank.interBankTransfer("Access Bank", sender.getNumber(), "GTBank", "1111111111", BigDecimal.valueOf(1000), "1914");
        });
    }

    @Test
    public void interBankTransfer_WithWrongPin_ThrowsExceptionAndLeavesBalancesUnchangedTest() {
        centralBank.addBank(accessBank);
        centralBank.addBank(firstBank);
        Account sender = accessBank.registerCustomer("Mide", "Charles", "1914");
        Account receiver = firstBank.registerCustomer("Tolu", "Babs", "4321");
        accessBank.deposit(sender.getNumber(), BigDecimal.valueOf(5000));
        assertThrows(IllegalArgumentException.class, () -> {centralBank.interBankTransfer("Access Bank", sender.getNumber(), "First Bank", receiver.getNumber(), BigDecimal.valueOf(1000), "1234");
        });
        assertEquals(BigDecimal.valueOf(5000), accessBank.checkBalance(sender.getNumber(), "1914"));
        assertEquals(BigDecimal.ZERO, firstBank.checkBalance(receiver.getNumber(), "4321"));
    }

    @Test
    public void interBankTransfer_InsufficientFunds_ThrowsExceptionAndLeavesBalancesUnchangedTest() {
        centralBank.addBank(accessBank);
        centralBank.addBank(firstBank);

        Account sender = accessBank.registerCustomer("Mide", "Charles", "1914");
        Account receiver = firstBank.registerCustomer("Tolu", "Babs", "4321");
        accessBank.deposit(sender.getNumber(), BigDecimal.valueOf(1000));
        assertThrows(IllegalArgumentException.class, () -> {centralBank.interBankTransfer("Access Bank", sender.getNumber(), "First Bank", receiver.getNumber(), BigDecimal.valueOf(3000), "1914");
        });
        assertEquals(BigDecimal.valueOf(1000), accessBank.checkBalance(sender.getNumber(), "1914"));
        assertEquals(BigDecimal.ZERO, firstBank.checkBalance(receiver.getNumber(), "4321"));
    }
}