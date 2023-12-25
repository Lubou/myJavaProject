package org.kalbeka;

import java.math.BigInteger;

public class Factorial {
    static BigInteger getFactorial(int f) {

        if (f < 0) {
            throw new IllegalArgumentException("Факториал не может быть рассчитан для отрицательных чисел");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= f; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}