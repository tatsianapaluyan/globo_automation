package calculator.logical;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Negative {

    @Test(dataProvider = "dataForIsNeg")
    public void testIsNegative(long a) {
        boolean isNegative = new Calculator().isNegative(a);
        Assert.assertTrue(isNegative, a + " is positive");
    }

    @DataProvider(name = "dataForIsNeg")
    public Object[] getData() {
        return new Object[]{-2, -1, -6, -7, -5, -9};
    }
}
