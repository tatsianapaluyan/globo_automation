package calculator;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {


    @DataProvider(name = "DoubleSumMethodDataProvider")
    public Object[][] doubleSumDataProvider() {
        return new Object[][]{
                {3.0, 2.3, 5.3},
                {-3, 3, 0},
                {-100, 100, 0},
        };
    }

    @DataProvider(name = "LongSumMethodDataProvider")
    public Object[][] LongSumDataProvider() {
        return new Object[][]{
                {3L, 2L, 5L},
                {-6, 3, -3},
                {-1, 100, 99},
        };
    }

    @DataProvider(name = "DoubleSubMethodDataProvider")
    public Object[][] doubleSubDataProvider() {
        return new Object[][]{
                {"3", "2", 5.0},
                {"-3", "3", 0.0},
                {"-100", "100", 0.0},
        };
    }

    @DataProvider(name = "LongSubMethodDataProvider")
    public Object[][] LongSubDataProvider() {
        return new Object[][]{
                {32, -2, 34},
                {-30, -30, 0},
                {100, 50, 50},
        };
    }

    @DataProvider(name = "DoubleMultMethodDataProvider")
    public Object[][] doubleMultDataProvider() {
        return new Object[][]{
                {3, 2, 6},
                {-3, 3, -9},
                {-100, 100, -10000},
        };
    }

    @DataProvider(name = "LongMultMethodDataProvider")
    public Object[][] LongMultDataProvider() {
        return new Object[][]{
                {3, 2, 5},
                {-3, 3, 0},
                {-100, 100, 0},
        };
    }


    @DataProvider(name = "DoubleCtgMethodDataProvider")
    public Object[][] ctgDataProvider() {
        return new Object[][]{
                {90.0, 1.0},
                {180.0, 1.0}
        };
    }
}

