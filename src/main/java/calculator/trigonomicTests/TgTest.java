package calculator.trigonomicTests;

import calculator.ConfigurationTest;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgTest extends ConfigurationTest {

    @Test(dataProvider = "DoubleTgMethodDataProvider", groups = {"exclude_group"})
    public void testTgMethod(double a, double expectedResult) throws Exception {
        double result = new Calculator().tg(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of double ctg, expected: " + expectedResult);
    }

    @DataProvider(name = "DoubleTgMethodDataProvider")
    public Object[][] tgDataProvider() {
        return new Object[][]{
                {90.0, 1.0},
                {180.0, 1.0}
        };
    }
}
