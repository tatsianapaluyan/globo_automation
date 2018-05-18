package pageObject.pages.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class LoginPage extends BasePage {

    private final String URL = "https://test-web1-06.corp.globoforce.com/m?client=%s";
    private String clientName = "testclient5013";

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "logInButton")
    private WebElement logInButton;

    @FindBy(xpath = "//span[@class='sidebar-icon font-icon nominateBtn']")
    private WebElement nominateButton;

    public void openMWA() {
        getWebdriver().navigate().to(String.format(URL, clientName));
        waitElementPresent(By.id("username"));
    }

    public void logIn(String user, String pass) {
        userName.sendKeys(user);
        password.sendKeys(pass);
        logInButton.click();
        waitElementPresent(By.xpath("//span[@class='sidebar-icon font-icon nominateBtn']"));

    }

    public void navigateToNominate() {
        nominateButton.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}


