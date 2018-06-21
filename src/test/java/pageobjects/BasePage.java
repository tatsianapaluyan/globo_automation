package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected final WebDriver webdriver;

    protected final int PAGE_LOAD_TIMEOUT = 300;
    protected final int IMPLICITLY_WAIT_TIMEOUT = 400;

    public BasePage(WebDriver driver) {
        webdriver = driver;
        Dimension n = new Dimension(352, 712);
        driver.manage().window().setSize(n);
        webdriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        webdriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
        //PageFactory.initElements(webdriver, this);
        HtmlElementLoader.populatePageObject(this, webdriver);
    }

    protected WebElement waitElementToBeClickable(final By by) {
        return new WebDriverWait(webdriver, 10)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + by)
                .until(ExpectedConditions.elementToBeClickable(webdriver.findElement(by)));
    }

    protected WebElement waitElementPresent(final By css) {
        return new WebDriverWait(webdriver, 30)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + css)
                .until(ExpectedConditions.presenceOfElementLocated(css));
    }

    protected WebElement waitElementPresent(WebElement element) {
        return new WebDriverWait(webdriver, 30)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementEnabled(WebElement element) {
        if (isElementPresent(element)) {
            return element.isEnabled();
        }
        return false;
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }
}
