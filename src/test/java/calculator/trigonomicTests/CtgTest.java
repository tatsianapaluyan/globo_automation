package calculator.trigonomicTests;

import calculator.CalculatorDataProvider;
import calculator.ConfigurationTest;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CtgTest extends ConfigurationTest {



    @Test(dataProvider = "DoubleCtgMethodDataProvider", groups = {"exclude_group"}, dataProviderClass = CalculatorDataProvider.class)
       public void testCtgMethod(double a, double expectedResult) throws Exception {
        double result = new Calculator().ctg(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of double ctg, expected: " + expectedResult);
    }

//    @Test(dataProvider = "LongSumMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
//    public void testLongSumTest(long c, long d, long expectedResult) throws Exception {
//        long result1 = new Calculator().sum(c, d);
//        Assert.assertEquals(result1, expectedResult, "Invalid result of long sum, expected: " + expectedResult);
//    }
//
//}


}




