package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalcSqrtTest extends BeforeAfterTestMethods {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values for sqrt")
    public void sqrtDoubleValuesTest(double a, double expected) {
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected, 1E-323);
    }
}
