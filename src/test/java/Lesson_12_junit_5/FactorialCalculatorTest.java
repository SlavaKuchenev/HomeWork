package Lesson_12_junit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    @Test
    public void testFactorial(){
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assertEquals(1, factorialCalculator.factorialCalculator(0));
        assertEquals(1, factorialCalculator.factorialCalculator(1));
        assertEquals(2, factorialCalculator.factorialCalculator(2));
        assertEquals(6, factorialCalculator.factorialCalculator(3));
        assertEquals(24, factorialCalculator.factorialCalculator(4));
    }
    @Test
    public void testNegativeInput(){
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assertThrows(IllegalArgumentException.class,() -> factorialCalculator.factorialCalculator(-1));
    }
    @Test
    public void testLargeValue(){
        FactorialCalculator factorialCalculator = new FactorialCalculator();
            assertThrows(ArithmeticException.class,() -> factorialCalculator.factorialCalculator(Integer.MAX_VALUE));
    }
}
