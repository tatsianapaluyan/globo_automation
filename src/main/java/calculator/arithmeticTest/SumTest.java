package calculator.arithmeticTest;

import calculator.CalculatorDataProvider;
import calculator.ConfigurationTest;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SumTest extends ConfigurationTest {


    @Test(dataProvider = "DoubleSumMethodDataProvider", groups = {"include_group"}, dataProviderClass = CalculatorDataProvider.class)
    public void testDoubleSumMethod(double a, double b, double expectedResult) throws Exception {
        double result = new Calculator().sum(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of double sum, expected: " + expectedResult);
    }

    @Test(dataProvider = "LongSumMethodDataProvider", groups = "SumTest", dataProviderClass = CalculatorDataProvider.class)
    public void testLongSumTest(long c, long d, long expectedResult) throws Exception {
        long result1 = new Calculator().sum(c, d);
        Assert.assertEquals(result1, expectedResult, "Invalid result of long sum, expected: " + expectedResult);
    }

}



