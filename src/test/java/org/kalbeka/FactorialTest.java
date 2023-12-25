package org.kalbeka;

import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    void getFactorial() {
        assertEquals(BigInteger.ONE, Factorial.getFactorial(0));
        assertEquals(BigInteger.ONE, Factorial.getFactorial(1));
        assertEquals(BigInteger.valueOf(2), Factorial.getFactorial(2));
        assertEquals(BigInteger.valueOf(6), Factorial.getFactorial(3));
        assertEquals(BigInteger.valueOf(24), Factorial.getFactorial(4));
        assertEquals(new BigInteger("2432902008176640000"), Factorial.getFactorial(20));
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.getFactorial(-1);
        });
    }
}