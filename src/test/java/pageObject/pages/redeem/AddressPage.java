package pageObject.pages.redeem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {
    @FindBy(xpath = "//div[@class='tickbox font-icon']")
    private WebElement address;

    @FindBy(xpath = "(//div[@class='x-button x-button-normal'])[2]")
    private WebElement continueButton;


    public void selectAddress() {
        if (isElementPresent(continueButton)) {
            continueButton.click();
        } else {
            System.out.println("No address");
        }
    }

    public AddressPage(WebDriver driver) {
        super(driver);
    }
}
