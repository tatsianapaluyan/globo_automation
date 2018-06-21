package pageobjects.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class MessagePage extends BasePage {

    @FindBy(xpath = "//textarea[@class='award-title']")
    private TextInput addAwardTitle;

    @FindBy(xpath = "//textarea[@class='award-message']")
    private TextInput messageToRecipient;

    @FindBy(xpath = "//div[@class='x-button submit-button x-button-plain']")
    private Button sendButton;

    @FindBy(xpath = "//div[@id='secondButton']")
    private Button closeButton;

    @FindBy(xpath = "(//div[@class='title'])[3]")
    private TextBlock nominationSuccessfulMessage;


    public void addAwardTitle(String awardTitle) {
        addAwardTitle.sendKeys(awardTitle);
    }

    public void addMessageToRecipient(String recipientMessage) {
        messageToRecipient.sendKeys(recipientMessage);
    }

    public void createNomination() throws InterruptedException {
        Thread.sleep(2000);
        messageToRecipient.click();
        sendButton.isEnabled();
        Thread.sleep(2000);
        sendButton.click();
        waitElementToBeClickable(By.xpath("//div[@id='secondButton']"));
    }

    public void closeMessagePopup() {
        closeButton.click();
    }

    public MessagePage(WebDriver driver) {
        super(driver);
    }


    public boolean isClosePopUpAppears() {
        return isElementPresent(closeButton);
    }


    public String getCloseButtontext() {
        return closeButton.getText();
    }

    public String getSuccessfulMessageText() {
        return nominationSuccessfulMessage.getText();
    }

    public boolean isMessageAppears() {
        return isElementPresent(nominationSuccessfulMessage);
    }
}