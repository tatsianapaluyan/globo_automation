package pageobjects.redeem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//div[@class='tickbox font-icon unticked']")
    private CheckBox acceptTandC;

    @FindBy(xpath = "//div[@class='tickbox font-icon ticked']")
    private CheckBox checkBox;

    @FindBy(xpath = "(//div[@class='x-button x-button-normal'])[3]")
    private Button placeOrderButton;

    @FindBy(xpath = "//div[@id='firstButton']")
    private Button okButton;

    @FindBy(xpath = "//div[@class='message']")
    private TextBlock message;

    public void acceptTandC() {
        waitElementToBeClickable(By.xpath("//div[@class='tickbox font-icon unticked']"));
        acceptTandC.click();
    }

    public void completeOrder() {
        waitElementToBeClickable(By.xpath("(//div[@class='x-button x-button-normal'])[3]"));
        placeOrderButton.click();
        waitElementToBeClickable(By.xpath("//div[@id='firstButton']"));
    }

    public boolean isCheckBoxEnabled() {
        return  isElementEnabled(checkBox);
    }


    public boolean isPopupAppears(){
        return isElementPresent(okButton);
    }

    public boolean isMessageAppears(){
        return isElementPresent(message);
    }

    public void closeMessagePopup() {
        okButton.click();
    }

    public String getOkButtontext() {
        return okButton.getText();
    }

    public String getSuccessfultext() {
        return message.getText();
    }

    public OrderPage(WebDriver driver) {
        super(driver);
    }
}
