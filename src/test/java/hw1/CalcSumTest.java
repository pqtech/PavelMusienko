package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalcSumTest extends BeforeAfterTestMethods {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values for addition")
    public void sumDoubleValuesTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected, 1E-323);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "long values for addition")
    public void sumLongValuesTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected, 1E-323);
    }
}
