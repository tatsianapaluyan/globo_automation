package redeemfirsttask.testRedeem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import redeemfirsttask.base.BasePage;

import java.util.concurrent.TimeUnit;


public class ReedemTest extends BasePage {

    private static final int implicitTimeout = 15;
    private static final String URL = "https://test-web1-06.corp.globoforce.com/m?client=%s";
    private String clientName = "testclient5013";
    private String userName = "renee_recipient1";
    private String password = "renee_recipient11";

    protected ReedemTest(WebDriver driver) {
        super(driver);
    }

    @Test
    public void verifyLogin() {
        driver.navigate().to(String.format(URL, clientName));
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("logInButton")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='sidebar-icon font-icon redeemBtn']")).isDisplayed(), "Login Failed");

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        verifyGDPR();
        driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
    }
//    @Test(priority = 2)
//    public void verifyRedeemMenu() {
//      By redeemfirsttask = By.xpath("//span[@class='sidebar-icon font-icon redeemBtn']");
//        driver.findElement(redeemfirsttask).click();
//        pageobjects.Redeem.click();
//    }
//        boolean isElementPresent = driver.
//        if ( driver.findElements(By.xpath("//button[@id='acceptButton']")).
//                System.out.println();
//       else(driver.findElements(By.xpath("//button[@id='acceptButton']")).Count != 0);


    @Test(dependsOnMethods = "verifyLogin")
    public void verifyRedeemTest() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='sidebar-icon font-icon redeemBtn']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='sidebar-icon font-icon redeemBtn']")).isDisplayed(), "Redeem not found");

        waitElementToBeClickable(By.cssSelector(".country-view .x-list-parent .x-group-a .x-list-item:nth-child(3)"));
        driver.findElement(By.cssSelector(".country-view .x-list-parent .x-group-a .x-list-item:nth-child(3)")).click();
        waitElementToBeClickable(By.cssSelector(".merchant-view .redeemfirsttask-merchants .x-group-c .x-list-item:nth-child(1) .label"));
        driver.findElement(By.cssSelector(".merchant-view .redeemfirsttask-merchants .x-group-c .x-list-item:nth-child(1) .label")).click();

        waitElementPresent(By.xpath("(//div[@class='btn font-icon btn-inc'])[3]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='x-button x-button-normal'])[1]")).isEnabled(), "Continue is disabled");
        driver.findElement(By.xpath("(//div[@class='x-button x-button-normal'])[1]")).click();


        if (isElementPresent(driver.findElement(By.xpath("(//div[@class='x-button x-button-normal'])[2]")))) {
            driver.findElement(By.xpath("(//div[@class='x-button x-button-normal'])[2]")).click();
        } else {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='tickbox font-icon']")).isSelected(), "Address is not selected");
            System.out.println("No address");
        }


        waitElementPresent(By.xpath("(//div[@class='award-item'])[1]"));
        driver.findElement(By.xpath("(//div[@class='award-item'])[1]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='x-button continue-button x-button-normal'])[1]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='tickbox font-icon unticked']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='tickbox font-icon ticked']")).isEnabled());


        waitElementToBeClickable(By.xpath("(//div[@class='x-button x-button-normal'])[3]")).click();
        waitElementToBeClickable(By.xpath("//div[@id='firstButton']"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='firstButton']")).getText(), "OK");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message']")).getText(), "Your order has been successful.");
        waitElementToBeClickable(By.xpath("//div[@id='firstButton']")).click();
    }

    private void verifyGDPR() {
        By acceptButton = By.xpath("//button[@id='acceptButton']");
        if (isElementPresent(acceptButton)) {
            driver.findElement(acceptButton).click();
        }
    }
}
