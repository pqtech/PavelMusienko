package hw1;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcDivTest extends BeforeAfterTestMethods{

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values")
    public void divDoubleValuesTest(double a, double b) {
        double actual = calculator.div(a, b);
        double expected = a / b;
        assertEquals(actual, expected, 1E-323);

    }@Test(dataProviderClass = DataProviders.class, dataProvider = "long values")
    public void divLongValuesTest(long a, long b) {
        long actual = calculator.div(a, b);
        long expected = a / b;
        assertEquals(actual, expected, 1E-323);
    }
}
