import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void accountBalance() {
        Account account = new Account(123456789, 12345, 800, 200);
        assertEquals(800, account.accountBalance());
    }

    @Test
    void deposit() {
        Account account = new Account(123456789, 12345, 800, 200);
        account.deposit(400);
        assertEquals(1200, account.accountBalance());
    }

    @Test
    void withdraw() {
        Account account = new Account(123456789, 12345, 800, 200);
        account.withdraw(500);
        assertEquals(300, account.accountBalance());
    }

    @Test
    void withdraw1() {
        Account account = new Account(123456789, 12345, 800, 200);
        account.withdraw(500);
        assertEquals(300, account.accountBalance());
    }

    @Test
    void withdraw2() {
        Account account = new Account(123456789, 12345, 800, 200);
        account.withdraw(900);
        assertEquals(-100, account.accountBalance());
    }

    @Test
    void withdraw3() {
        Account account = new Account(123456789, 12345, 800, 200);
        account.withdraw(1400);
        assertTrue(account.overdrawn);
    }
}