package pageObject.pages.redeem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class DenominationPage extends BasePage {

    @FindBy(xpath = "(//div[@class='btn font-icon btn-inc'])[3]")
    private WebElement denomination;

    @FindBy(xpath = "(//div[@class='x-button x-button-normal'])[1]")
    private WebElement continueButton;

    public void selectDenomination() throws InterruptedException {
        Thread.sleep(2000);
        denomination.click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public DenominationPage(WebDriver driver) {
        super(driver);
    }
}
