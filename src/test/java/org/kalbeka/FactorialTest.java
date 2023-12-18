package org.kalbeka;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @org.junit.jupiter.api.Test
    void getFactorial() {
        Factorial factorial = new Factorial();
        int actual = factorial.getFactorial(4);
        int expected = 24;
        assertEquals(expected, actual);
    }
}