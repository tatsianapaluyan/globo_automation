package pageobjects.redeem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;

public class DenominationPage extends BasePage {

    @FindBy(xpath = "(//div[@class='btn font-icon btn-inc'])[3]")
    private Button denomination;

    @FindBy(xpath = "(//div[@class='x-button x-button-normal'])[1]")
    private Button continueButton;

    public void selectDenomination() throws InterruptedException {
        Thread.sleep(2000);
        denomination.click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean isContinueButtonEnabled() {
        return isElementEnabled(continueButton);
    }

    public DenominationPage(WebDriver driver) {
        super(driver);
    }
}
