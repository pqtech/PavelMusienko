package hw1;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcDivTest extends BeforeAfterTestMethods{

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values for division")
    public void divDoubleValuesTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 1E-323);

    }@Test(dataProviderClass = DataProviders.class, dataProvider = "long values for division")
    public void divLongValuesTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected, 1E-323);
    }
}
