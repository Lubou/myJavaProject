package org.kalbeka;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testGetFactorial() {

        int actual = Factorial.getFactorial(4);
        int expected = 24;
        assertEquals(expected, actual);

    }
}