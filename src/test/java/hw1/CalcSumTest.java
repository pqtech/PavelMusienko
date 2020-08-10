package hw1;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcSumTest extends BeforeAfterTestMethods{

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values")
    public void sumDoubleValuesTest(double a, double b) {
        double actual = calculator.sum(a, b);
        double expected = a + b;
        assertEquals(actual, expected, 1E-323);

    }@Test(dataProviderClass = DataProviders.class, dataProvider = "long values")
    public void sumLongValuesTest(long a, long b) {
        long actual = calculator.sum(a, b);
        long expected = a + b;
        assertEquals(actual, expected, 1E-323);
    }
}
