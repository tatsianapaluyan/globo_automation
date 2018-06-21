package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private final String URL = "https://test-web1-06.corp.globoforce.com/m?client=%s";

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "logInButton")
    private WebElement logInButton;

    public LoginPage setUsername(String username) {
        waitElementPresent(userNameInput);
        userNameInput.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickOnLoginButton() {
        logInButton.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}

