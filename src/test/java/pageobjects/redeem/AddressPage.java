package pageobjects.redeem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;

public class AddressPage extends BasePage {
    @FindBy(xpath = "//div[@class='tickbox font-icon']")
    private CheckBox address;

    @FindBy(xpath = "(//div[@class='x-button x-button-normal'])[2]")
    private Button continueButton;


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
