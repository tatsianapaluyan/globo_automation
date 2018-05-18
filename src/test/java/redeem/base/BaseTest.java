package redeem.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Parameters({"browser"})
    @BeforeClass
    public void start(@Optional(value = "chrome") String browser) {
        // options.addArguments("--disable-notifications");
        options.addArguments("--use-fake-ui-for-media-stream=1");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } else {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    protected Object waitElementAndClick(By webElement) {
        return new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitElementToBeClickable(final By by) {
        return new WebDriverWait(driver, 10)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + by)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }


    protected WebElement waitElementPresent(final By css) {
        return new WebDriverWait(driver, 20)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + css)
                .until(ExpectedConditions.presenceOfElementLocated(css));
    }
}

