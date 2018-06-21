package tests.unittests.arithmetictest;

import tests.unittests.base.ConfigTest;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivTest extends ConfigTest {

    @Parameters({"firstvalue", "secondvalue", "result"})
    @Test(groups = {"include_group"})
    public void testDoubleDivMethod(double a, double b, double expectedResult) throws Exception {
        double result = new Calculator().div(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of double div, expected: " + expectedResult);
    }

//    @DataProvider(name = "DoubleDivMethodDataProvider")
//    public Object[][] doubleDivDataProvider() {
//        return new Object[][]{
//                {3, 2, 1.5},
//                {-3, 3, -1},
//                {-100, 100, -1},
//        };
//    }
}



