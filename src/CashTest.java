import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashTest {

    @Test
    void withdrawCash() {
        Cash cash = new Cash(1500);
        cash.withdrawCash(500);
        assertEquals(1000, cash.total_count);
    }

    @Test
    void withdrawCash2() {
        Cash cash = new Cash(1500);
        cash.withdrawCash(1300);
        assertEquals(200, cash.total_count);
    }

    @Test
    void withdrawCash3() {
        Cash cash = new Cash(1500);
        cash.withdrawCash(1600);
        assertTrue(cash.overdraw_fail);
    }

    @Test
    void withdrawCash4() {
        Cash cash = new Cash(1500);
        cash.withdrawCash(0);
        assertEquals(1500, cash.total_count);
    }
}