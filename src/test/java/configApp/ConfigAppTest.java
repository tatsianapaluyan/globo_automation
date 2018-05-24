package configApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import redeem.base.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ConfigAppTest extends BaseTest {
    private static final String URL1 = "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";
    private String userName = "bhkb.jshcw@gqfozpkzgb.kbk";
    private String password = "password1";

    @Test
    public void test() throws InterruptedException {
        //WebDriver driver = new ChromeDriver();
        driver.get("https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home");
        // Assert.assertEquals(driver.getTitle(), "Log In");
    //    Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[@class='drop']"))).perform();
        driver.findElement(By.xpath("//a[@href='/iaf-config-app/']")).click();
        driver.findElement(By.xpath("//a[@href='/iaf-config-app/siteSettingsOpen?client=5021&menuid=2_1']")).click();
        driver.findElement(By.xpath("//td[@id='ygtvcontentel39']")).click();
        driver.findElement(By.xpath("//a[@id='ygtvlabelel40']")).click();
        driver.findElement(By.xpath("(//td[@headers='yui-dt0-th-manageLevel '])[1]")).click();


        List<WebElement> items = driver.findElements(By.xpath("//ul[@id='current_items']/li"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(items.get(2), items.get(0)).build().perform();

        waitElementToBeClickable(By.xpath("//button[@id='save-button']")).click();


    }
}




