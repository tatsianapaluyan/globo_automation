package pageObject.pages.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class MessagePage extends BasePage {

    @FindBy(xpath = "//textarea[@class='award-title']")
    private WebElement addAwardTitle;

    @FindBy(xpath = "//textarea[@class='award-message']")
    private WebElement messageToRecipient;

    @FindBy(xpath = "//div[@class='x-button submit-button x-button-plain']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@id='secondButton']")
    private WebElement closeButton;


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
}
