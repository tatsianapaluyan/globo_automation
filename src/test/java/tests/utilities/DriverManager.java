package tests.utilities;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createWebDriver();

    public WebDriver getInstance() {
        if (null == driver) {
            createWebDriver();
        }
        return driver;
    }
}
