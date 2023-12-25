package org.kalbeka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class FactorialTest {

    @Test
    void getFactorial() {
        Assertions.assertEquals(BigInteger.ONE, Factorial.getFactorial(0));
        Assertions.assertEquals(BigInteger.ONE, Factorial.getFactorial(1));
        Assertions.assertEquals(BigInteger.valueOf(2), Factorial.getFactorial(2));
        Assertions.assertEquals(BigInteger.valueOf(6), Factorial.getFactorial(3));
        Assertions.assertEquals(BigInteger.valueOf(24), Factorial.getFactorial(4));
        Assertions.assertEquals(new BigInteger("2432902008176640000"), Factorial.getFactorial(20));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Factorial.getFactorial(-1);
        });
    }
}