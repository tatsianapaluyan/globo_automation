package calculator.arithmeticTest;

import calculator.CalculatorDataProvider;
import calculator.ConfigurationTest;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultTest extends ConfigurationTest {


    @Test(dataProvider = "DoubleMultMethodDataProvider", groups = {"include_group"}, dataProviderClass = CalculatorDataProvider.class)
    public void testDoubleMultMethod(double a, double b, double expectedResult) throws Exception {
        double result = new Calculator().mult(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of double mult, expected: " + expectedResult);
    }

    @Test(dataProvider = "LongMultMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testLongMultTest(long c, long d, long expectedResult) throws Exception {
        long result1 = new Calculator().sum(c, d);
        Assert.assertEquals(result1, expectedResult, "Invalid result of long mult, expected: " + expectedResult);
    }
}
