package pageObject.pages.redeem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "(//div[@class='award-item'])[1]")
    private WebElement selectAward;

    @FindBy(xpath = "(//div[@class='x-button continue-button x-button-normal'])[1]")
    private WebElement clickContinue;


    public void selectPayment() throws InterruptedException {

        waitElementToBeClickable(By.xpath("(//div[@class='award-item'])[1]"));
        Thread.sleep(2000);
        selectAward.click();
        clickContinue.click();
    }

    public PaymentPage(WebDriver driver) {
        super(driver);
    }
}
