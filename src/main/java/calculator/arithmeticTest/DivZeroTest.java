package calculator.arithmeticTest;

import calculator.ConfigurationTest;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivZeroTest extends ConfigurationTest {

    @Test(dataProvider = "LongDivMethodDataProvider", groups = {"include_group"}, expectedExceptions = NumberFormatException.class)
    public void testLongDivMethod(long c, long d, long expectedResult) throws Exception {
       // System.out.println("@Test - testDivby0 with exception");
        long result1 = new Calculator().div(c, d);
        Assert.assertEquals(result1, expectedResult, "Invalid result of double div, expected: " + expectedResult);
    }

    @DataProvider(name = "LongDivMethodDataProvider")
    public Object[][] longDivDataProvider() {
        return new Object[][]{
                {3, 0, 3},
        };
    }
}
