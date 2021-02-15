import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    void run() {
        ATM atm  = new ATM();
        assertNotNull(atm);
    }

    @Test
    void verifyUser() {
        ATM atm  = new ATM();
        atm.verifyUser(123456789, 12345);
        assertTrue(atm.authenticated);
    }
}