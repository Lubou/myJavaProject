package org.kalbeka;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @org.junit.jupiter.api.Test
    void getFactorial() {
        int actual = Factorial.getFactorial(4);
        int expected = 24;
        assertEquals(expected, actual);
    }
}