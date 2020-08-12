package hw1;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcSubTest extends BeforeAfterTestMethods{

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values for subtraction")
    public void subDoubleValuesTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected, 1E-323);

    }@Test(dataProviderClass = DataProviders.class, dataProvider = "long values for subtraction")
    public void subLongValuesTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected, 1E-323);
    }
}
