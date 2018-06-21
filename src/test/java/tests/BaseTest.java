package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BaseTest {
    private WebDriver driver;

    ChromeOptions options = new ChromeOptions();

    public WebDriver getWebDriver() {
        return this.driver;
    }

    @Parameters({"browser"})
    @BeforeClass
    public void start(@Optional(value = "chrome") String browser) {
        options.addArguments("--use-fake-ui-for-media-stream=1");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            driver = new ChromeDriver(options);
        } else {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    protected WebElement waitElementToBeClickable(final By by) {
        return new WebDriverWait(driver, 10)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + by)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }
}
