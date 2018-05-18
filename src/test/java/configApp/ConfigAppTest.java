package configApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import redeem.base.BaseTest;

import java.util.List;

public class ConfigAppTest extends BaseTest {
       private static final String URL1 = "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";
        private String userName = "bhkb.jshcw@gqfozpkzgb.kbk";
        private String password = "password1";
//
//        @Test
//        public void test() throws MalformedURLException, InterruptedException {
//            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setBrowserName("chrome");
//            cap.setPlatform(Platform.MAC);
//            URL url = new URL("http://192.168.2.1:4444/wd/hub");
//            WebDriver driver = new RemoteWebDriver(url, cap);
//            driver.get("https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home");
//           // Assert.assertEquals(driver.getTitle(), "Log In");
//            Thread.sleep(2000);
//           driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys(userName);
//            driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys(password);
//            driver.findElement(By.xpath("//input[@type='submit']")).click();
//           new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[@class='drop']"))).perform();
//            driver.findElement(By.xpath("//a[@href='/iaf-config-app/']")).click();

   @Test
    public void test() throws InterruptedException {
        //WebDriver driver = new ChromeDriver();
        driver.get("https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home");
           // Assert.assertEquals(driver.getTitle(), "Log In");
            Thread.sleep(2000);
           driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys(userName);
            driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys(password);
            driver.findElement(By.xpath("//input[@type='submit']")).click();
           new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[@class='drop']"))).perform();
            driver.findElement(By.xpath("//a[@href='/iaf-config-app/']")).click();
       driver.findElement(By.xpath("//a[@href='/iaf-config-app/siteSettingsOpen?client=5021&menuid=2_1']")).click();
       driver.findElement(By.xpath("//td[@id='ygtvcontentel39']")).click();
       driver.findElement(By.xpath("//a[@id='ygtvlabelel40']")).click();
       driver.findElement(By.xpath("(//td[@headers='yui-dt0-th-manageLevel '])[1]")).click();


       List<WebElement> items = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
       Actions actions = new Actions(driver);
       Thread.sleep(5000);
       actions.dragAndDrop(items.get(5), items.get(1)).build().perform();
       driver.quit();

            }
        }



