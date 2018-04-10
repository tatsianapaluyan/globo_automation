package calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ConfigurationTest {


    Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass: I run only once, before first test start.");
        calculator = new Calculator();
    }

    @AfterClass
    public void afterClass() {
        //Ideal place to perform some cleanup of setup which is shared among all tests.
        System.out.println("@AfterClass: I run only once, after all tests have been done.\n");
        calculator = null;
    }
}

