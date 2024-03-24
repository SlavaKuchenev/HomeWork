package org.example.Lesson_12_testng;

import org.example.Lesson_12_junit_5.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FactorialCalculatorTest {
    @Test
    public void testFactorialCalculator() {
        FactorialCalculator factorial = new FactorialCalculator();
        Assert.assertEquals(1, factorial.factorialCalculator(0));
        Assert.assertEquals(1, factorial.factorialCalculator(1));
        Assert.assertEquals(2, factorial.factorialCalculator(2));
        Assert.assertEquals(6, factorial.factorialCalculator(3));
        Assert.assertEquals(24, factorial.factorialCalculator(4));
        Assert.assertEquals(120, factorial.factorialCalculator(5));
    }

    @Test
    public void testNegativeInput() {
        FactorialCalculator factorial = new FactorialCalculator();
        Assert.assertThrows(IllegalArgumentException.class, () -> factorial.factorialCalculator(-1));
    }

    @Test
    public void testLargeValue() {
        FactorialCalculator factorial = new FactorialCalculator();
        Assert.assertThrows(ArithmeticException.class, () -> factorial.factorialCalculator(Integer.MAX_VALUE));
    }
}
