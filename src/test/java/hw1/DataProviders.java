package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "double values for division")
    public static Object[][] correctDoubleDivValuesData() {
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE, 1.0},
                {20.00000000000999999, -20.000000000009999990001, -1.0},
                {1E-30, 1E-30, 1.0},
                {100099900000.10121101, -1.00000000001, -1.0009989999910022E11},
                {5.256, 5.257, 0.9998097774396044},
        };
    }

    @DataProvider(name = "long values for division")
    public static Object[][] correctLongDivValuesData() {
        return new Object[][]{
                {Long.MAX_VALUE, Long.MAX_VALUE, 1},
                {625, 25, 25},
                {-99, 3, -33},
                {-10000900012300L, -100000000001123L, 0},
                {0, -1, 0},
        };
    }

    @DataProvider(name = "double values for multiplication")
    public static Object[][] correctDoubleMultValuesData() {
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY},
                {20.00000000000999999, -20.000000000009999990001, -401.0},
                {1E-30, 1E-30, 0.0},
                {100099900000.10121101, -1.00000000001, -1.00099900002E11},
                {5.256, 5.257, 27.0},
        };
    }

    @DataProvider(name = "long values for multiplication")
    public static Object[][] correctLongMultValuesData() {
        return new Object[][]{
                {Long.MAX_VALUE, Long.MAX_VALUE, 1},
                {1, 1, 1},
                {-100, -101, 10100},
                {-10000900012300L, -100000000001123L, -7354003445633007708L},
                {0, -1, 0},
        };
    }
}