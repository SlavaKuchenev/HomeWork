package org.example.Lesson_12_junit_5;

public class FactorialCalculator {
    public int factorialCalculator(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел.");
        }
        if (n == 0) {
            return 1;
        }
        int factorial = 1;
        try {
            while (n > 0) {
                if (factorial * n < 0) {
                    throw new ArithmeticException("Переполнение при вычислении факториала для числа: " + n);
                }
                factorial = factorial * n;
                n--;
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Переполнение при вычислении факториала для числа: " + n);
        }
        return factorial;
    }
}
