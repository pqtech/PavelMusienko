package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "double values")
    public static Object[][] correctDoubleValuesData() {
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE},
                {20.00000000000999999, -20.000000000009999990001},
                {1E-30, 1E-30},
                {100099900000.10121101, -1.00000000001},
                {5.256, 5.257},
        };
    }

    @DataProvider(name = "long values")
    public static Object[][] correctLongValuesData() {
        return new Object[][]{
                {Long.MAX_VALUE, Long.MAX_VALUE},
                {1, 1},
                {-100, -101},
                {-10000900012300L, -100000000001123L},
                {0, -1},
        };
    }

}
//{9223372036854775807L, -9223372036854775808L},