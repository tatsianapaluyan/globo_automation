package calculator.arithmeticTest;

import calculator.CalculatorDataProvider;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubTest {


    @Test(dataProvider = "DoubleSubMethodDataProvider", groups = {"include_group"}, dataProviderClass = CalculatorDataProvider.class)
    public void testDoubleSubMethod(double a, double b, double expectedResult) throws Exception {
        double result = new Calculator().sub(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of double sub, expected: " + expectedResult);
    }

    @Test(dataProvider = "LongSubMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testLongSubTest(long c, long d, long expectedResult) throws Exception {
        long result1 = new Calculator().sub(c, d);
        Assert.assertEquals(result1, expectedResult, "Invalid result of long sub, expected: " + expectedResult);
    }

}
