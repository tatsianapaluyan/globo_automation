package pageobjects.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;

public class RecipientsPage extends BasePage {


    @FindBy(xpath = "//span[@class='sidebar-icon font-icon nominateBtn']")
    private Button nominateButton;

    @FindBy(xpath = "(//div[@class='recipient-item'])[1]")
    private Button selectRecipient;

    @FindBy(xpath = "//div[@class='x-button next-button x-button-plain']")
    private Button nextButton;

    public boolean isNominateMenuPresent() {
        return isElementPresent(nominateButton);
    }

    public void clickNominate() {
        waitElementPresent(By.xpath("//span[@class='sidebar-icon font-icon nominateBtn']"));
        nominateButton.click();
    }


    public void selectRecipient() throws InterruptedException {
        selectRecipient.click();
        waitElementToBeClickable(By.xpath("//span[@class='x-button-label']"));
    }

    public void nextButton() {
        nextButton.click();
    }


    public RecipientsPage(WebDriver driver) {
        super(driver);
    }
}
