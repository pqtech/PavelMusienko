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
                {Long.MAX_VALUE, Long.MAX_VALUE, 1L},
                {625L, 25L, 25L},
                {-99L, 3L, -33L},
                {-10000900012300L, -100000000001123L, 0L},
                {0L, -1, 0L},
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
                {Long.MAX_VALUE, Long.MAX_VALUE, 1L},
                {1L, 1L, 1L},
                {-100L, -101L, 10100L},
                {-10000900012300L, -100000000001123L, -7354003445633007708L},
                {0L, -1L, 0L},
        };
    }

    @DataProvider(name = "double values for subtraction")
    public static Object[][] correctDoubleSubValuesData() {
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE, 0.0},
                {20.00000000000999999, -20.000000000009999990001, 40.00000000002},
                {1E-30, 1E-30, 0.0},
                {100099900000.10121101, -1.00000000001, 1.0009990000110121E11},
                {5.256, 5.257, -9.999999999994458E-4},
        };
    }

    @DataProvider(name = "long values for subtraction")
    public static Object[][] correctLongSubValuesData() {
        return new Object[][]{
                {Long.MAX_VALUE, Long.MAX_VALUE, 0L},
                {1L, 1L, 0L},
                {-100L, -101L, 1L},
                {-10000900012300L, -100000000001123L, 89999099988823L},
                {0L, -1L, 1L},
        };
    }

    @DataProvider(name = "double values for addition")
    public static Object[][] correctDoubleSumValuesData() {
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY},
                {20.00000000000999999, -20.000000000009999990001, 0.0},
                {1E-30, 1E-30, 2.0E-30},
                {100099900000.10121101, -1.00000000001, 1.0009989999910121E11},
                {5.256, 5.257, 10.513},
        };
    }

    @DataProvider(name = "long values for addition")
    public static Object[][] correctLongSumValuesData() {
        return new Object[][]{
                {Long.MAX_VALUE, Long.MAX_VALUE, -2L},
                {1L, 1L, 2L},
                {-100L, -101L, -201L},
                {-10000900012300L, -100000000001123L, -110000900013423L},
                {0L, -1L, -1L},
        };
    }

    @DataProvider(name = "double values for sqrt")
    public static Object[][] correctDoubleSqrtValuesData() {
        return new Object[][]{
                {Double.MAX_VALUE, 1.3407807929942596E154},
                {20.00000000000999999, 4.472135955000698},
                {1E-30, 1.0E-15},
                {100099900000.10121101, 316385.68235636264},
                {5.256, 2.292596780945136},
        };
    }
}