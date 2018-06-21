package tests.configapptests;

import businessobjects.User;
import factories.UserStaticFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class ConfigAppTest extends BaseTest {

    private static final String URL1 = "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";

    @Test
    public void test() throws InterruptedException {
        getWebDriver().get(URL1);

        User user = UserStaticFactory.createConfigAppUser();

        getWebDriver().findElement(By.xpath("//input[@name='j_username']")).sendKeys(user.getUsername());
        getWebDriver().findElement(By.xpath("//input[@name='j_password']")).sendKeys(user.getPassword());
        getWebDriver().findElement(By.xpath("//input[@type='submit']")).click();
        new Actions(getWebDriver()).moveToElement(getWebDriver().findElement(By.xpath("//a[@class='drop']"))).perform();
        getWebDriver().findElement(By.xpath("//a[@href='/iaf-config-app/']")).click();
        getWebDriver().findElement(By.xpath("//a[@href='/iaf-config-app/siteSettingsOpen?client=5021&menuid=2_1']")).click();
        getWebDriver().findElement(By.xpath("//td[@id='ygtvcontentel39']")).click();
        getWebDriver().findElement(By.xpath("//a[@id='ygtvlabelel40']")).click();
        getWebDriver().findElement(By.xpath("(//td[@headers='yui-dt0-th-manageLevel '])[1]")).click();


        List<WebElement> items = getWebDriver().findElements(By.xpath("//ul[@id='current_items']/li"));
        Actions actions = new Actions(getWebDriver());
        actions.dragAndDrop(items.get(2), items.get(0)).build().perform();

        waitElementToBeClickable(By.xpath("//button[@id='save-button']")).click();
    }
}








