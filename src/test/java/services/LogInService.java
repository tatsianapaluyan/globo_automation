package services;

import businessobjects.User;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;


public class LogInService {

    private WebDriver driver;

    private final String URL = "https://test-web1-06.corp.globoforce.com/m?client=%s";

    public LoginPage openMWA(String clientName) {
        driver.navigate().to(String.format(URL, clientName));
        return new LoginPage(driver);
    }

    public void logIn(String user, String pass) {
        new LoginPage(driver)
                .setUsername(user)
                .setPassword(pass)
                .clickOnLoginButton();
    }

    public void logIn(User user) {
        logIn(user.getUsername(), user.getPassword());
    }

    public LogInService(WebDriver driver) {
        this.driver = driver;
    }

}
