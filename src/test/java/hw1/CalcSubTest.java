package hw1;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcSubTest extends BeforeAfterTestMethods{

    @Test(dataProviderClass = DataProviders.class, dataProvider = "double values")
    public void subDoubleValuesTest(double a, double b) {
        double actual = calculator.sub(a, b);
        double expected = a - b;
//        System.out.println(a + "-" + b +
//                ": Actual: " + actual +
//                " | Expected: " + expected + "\n" );
        assertEquals(actual, expected, 1E-323);

    }@Test(dataProviderClass = DataProviders.class, dataProvider = "long values")
    public void subLongValuesTest(long a, long b) {
        long actual = calculator.sub(a, b);
        long expected = a - b;
        assertEquals(actual, expected, 1E-323);
    }
}
