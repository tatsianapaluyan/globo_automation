package calculator.trigonomicTests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosTest {

    @Test(dataProvider = "DoubleCosMethodDataProvider", groups = {"exclude_group"})
    public void testDoubleCosMethod(double a, double expectedResult) throws Exception {
        double result = new Calculator().cos(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of double sin, expected: " + expectedResult);
    }

    @DataProvider(name = "DoubleCosMethodDataProvider")
    public Object[][] doubleCosDataProvider() {
        return new Object[][]{
                {90, 0.8939966636005579},
                {180, -0.8011526357338304},
                {270, -0.1760459464712114},
        };
    }

}


