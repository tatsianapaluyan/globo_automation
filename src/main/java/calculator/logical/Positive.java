package calculator.logical;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Positive {

        @Test(dataProvider = "dataForIsPos")
        public void testIsPositive(long a) {
            boolean isPositive = new Calculator().isPositive(a);
            Assert.assertTrue(isPositive, a + " is not positive");
        }

        @DataProvider(name = "dataForIsPos")
        public Object[] getData() {
            return new Object[]{2, 1, 6, 7, 5, 9};
        }
    }

