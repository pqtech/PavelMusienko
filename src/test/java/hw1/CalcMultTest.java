package hw1;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcMultTest extends BeforeAfterTestMethods{

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values for multiplication")
    public void multDoubleValuesTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 1E-323);

    }@Test(dataProviderClass = DataProviders.class, dataProvider = "long values for multiplication")
    public void multLongValuesTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected, 1E-323);
    }
}
