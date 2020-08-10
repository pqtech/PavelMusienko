package hw1;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcSqrtTest extends BeforeAfterTestMethods {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values")
    public void sqrtDoubleValuesTest(double a, double b) {
        double actual = calculator.sqrt(a);
        double expected = Math.sqrt(a);
        assertEquals(actual, expected, 1E-323);
    }
}
