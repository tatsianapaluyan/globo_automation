package calculator.arithmeticTest;

import calculator.ConfigurationTest;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Date;

import static com.epam.tat.module4.Timeout.sleep;

public class DivTest extends ConfigurationTest {

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



