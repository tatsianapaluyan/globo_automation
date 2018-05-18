package pageObject.pages.redeem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//div[@class='tickbox font-icon unticked']")
    private WebElement acceptTandC;

    @FindBy(xpath = "(//div[@class='x-button x-button-normal'])[3]")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//div[@id='firstButton']")
    private WebElement okButton;

    public void acceptTandC() {
        waitElementToBeClickable(By.xpath("//div[@class='tickbox font-icon unticked']"));
        acceptTandC.click();
    }

    public void completeOrder() {
        waitElementToBeClickable(By.xpath("(//div[@class='x-button x-button-normal'])[3]"));
        placeOrderButton.click();
        waitElementToBeClickable(By.xpath("//div[@id='firstButton']"));
    }

    public void closeMessagePopup() {
        okButton.click();
    }

    public OrderPage(WebDriver driver) {
        super(driver);
    }
}
