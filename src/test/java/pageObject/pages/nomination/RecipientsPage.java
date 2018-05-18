package pageObject.pages.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class RecipientsPage extends BasePage {

    @FindBy(xpath = "(//div[@class='recipient-item'])[1]")
    private WebElement selectRecipient;

    @FindBy(xpath = "//div[@class='x-button next-button x-button-plain']")
    private WebElement nextButton;

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
