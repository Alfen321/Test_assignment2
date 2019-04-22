import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank = new Bank();

    @Test
    void testCalculateYearlyInterestNeativeBalance() {
        double result = bank.calculateYearlyInterest(new Account(-1));
        double expected = 0;

        assertEquals(expected, result, 0.00001);
    }

    @Test
    void testCalculateYearlyInterestNotEquals() {
        double result = bank.calculateYearlyInterest(new Account(1000));
        double expected = 4343;

        assertNotEquals(expected, result);
    }

    @Test
    void calculateYearlyInterest3PercentBalance() {
        double result1 = bank.calculateYearlyInterest(new Account(1));
        double result2 = bank.calculateYearlyInterest(new Account(10));
        double result3 = bank.calculateYearlyInterest(new Account(100));
        double[] restults = new double[3];
        restults[0] = result1;
        restults[1] = result2;
        restults[2] = result3;
        double[] expected = {0.03, 0.3, 3};

        assertArrayEquals(restults, expected, 0.0001);
    }

    @Test
    void calculateYearlyInterest5PercentBalance() {
        double result = bank.calculateYearlyInterest(new Account(1000));
        double expected = 50;

        assertTrue(result == expected);
    }

    @Test
    void calculateYearlyInterest7PercentBalanceNotNull() {
        double result = bank.calculateYearlyInterest(new Account(2000));

        assertNotNull(result);
    }

    @Test
    void calculateYearlyInterest7PercentBalanceDoesNotFail() {
        double result = bank.calculateYearlyInterest(new Account(2000));
        if (result != 140) {
            fail("Something went wrong!");
        }
    }

    @Test
    void assertSameTest() {
        assertSame(bank, bank);
    }

    @Test
    void assertNotSameTest() {
        assertNotSame(bank, new Account(1000));
    }

    @Test
    void assertAllTest() {
        assertAll("All working",
                () -> assertEquals(bank.calculateYearlyInterest(new Account(10)), 0.3, 0.001),

                () -> assertNotEquals(bank.calculateYearlyInterest(new Account(100)), 0.3),

                () -> assertArrayEquals(
                        new double[] {
                                bank.calculateYearlyInterest(new Account(1000)),
                                bank.calculateYearlyInterest(new Account(1000))
                        },
                        new double[] {50,50},
                        0.001),

                () -> assertNotNull(bank.calculateYearlyInterest(new Account(2000))),

                () -> assertTrue(bank.calculateYearlyInterest(new Account(1000)) == 50),

                () -> { if(bank.calculateYearlyInterest(new Account(32)) == 323) fail("Something went wrong!");},

                () -> assertSame(bank, bank),

                () -> assertNotSame(bank, new Account(1000))

        );
    }

    @Test
    void assertRandom(){
        assertTrue(Math.random() < 0.5);
    }
}