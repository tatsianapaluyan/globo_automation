package calculator.arithmeticTest;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest {

    @Test(dataProvider = "DoublSqrtMethodDataProvider", groups = {"include_group"})
    public void testDoubleSqrtMethod(double a, double expectedResult) throws Exception {
        double result = new Calculator().sqrt(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of double sqrt, expected: " + expectedResult);
    }

    @DataProvider(name = "DoublSqrtMethodDataProvider")
    public Object[][] doubleSqrtDataProvider() {
        return new Object[][]{
                {81, 9}
        };
    }


}
