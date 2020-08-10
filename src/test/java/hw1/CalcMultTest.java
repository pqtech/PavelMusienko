package hw1;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcMultTest extends BeforeAfterTestMethods{

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values")
    public void multDoubleValuesTest(double a, double b) {
        double actual = calculator.mult(a, b);
        double expected = Math.floor(a * b);
        assertEquals(actual, expected, 1E-323);

    }@Test(dataProviderClass = DataProviders.class, dataProvider = "long values")
    public void multLongValuesTest(long a, long b) {
        long actual = calculator.mult(a, b);
        long expected = a * b;
        assertEquals(actual, expected, 1E-323);
    }
}
