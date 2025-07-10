package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import util.TotalBillCalculator;

public class TotalBillCalculatorTest {

    @Test
    void testXLWith5Toppings() {
        double result = TotalBillCalculator.calculateTotal("XL", 5);
        assertEquals(25.88, result, 0.01);
    }

    @Test
    void testLWith2Toppings() {
        double result = TotalBillCalculator.calculateTotal("L", 2);
        assertEquals(17.25, result, 0.01);
    }

    @Test
    void testSWithZeroToppings() {
        double result = TotalBillCalculator.calculateTotal("S", 0);
        assertEquals(9.20, result, 0.01);
    }

    @Test
    void testInvalidSize() {
        double result = TotalBillCalculator.calculateTotal("XXL", 3);
        assertEquals(5.18, result, 0.01); // 0 + (3×1.5) + 15% = 5.18
    }

    @Test
    void testMaxToppings() {
        double result = TotalBillCalculator.calculateTotal("M", 10);
        assertEquals(27.03, result, 0.01);
    }
}
