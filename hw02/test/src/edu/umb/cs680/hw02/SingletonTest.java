package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    public void testForNotNullGetInstance() {
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance();

        assertNotNull(gen1);
    }

    @Test
    public void testForSameGetInstance() {
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance();
        SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance();

        assertSame(gen1, gen2);
    }



    @Test
    void primeNumbersFrom1to17() {
        SingletonPrimeGenerator primes = SingletonPrimeGenerator.getInstance();
        primes.primeGenerator(1, 17 );

        primes.generatePrimes();

        Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L, 17L};

        LinkedList<Long> actual = primes.getPrimes();

        if (actual.size() != expected.length) {
            fail("Failure of Test");
        }
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i));
        }
    }


    @Test
    void exceptionForWrongInputs() {
        try {
            SingletonPrimeGenerator primes = SingletonPrimeGenerator.getInstance();
            primes.primeGenerator(-10, 10);
            fail("Failure of Test");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=-10 to=10", e.getMessage());
        }
    }

}