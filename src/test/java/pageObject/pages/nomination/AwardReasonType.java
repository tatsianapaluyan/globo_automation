package pageObject.pages.nomination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class AwardReasonType extends BasePage{


    @FindBy(xpath = "(//div[@class='award-reason'])[2]")
    private WebElement awardReason;

    @FindBy(xpath = "(//div[@class='award-name visible'])[2]")
    private WebElement awardType;

    public void selectReason(){
        //awardReason.click();
    }

    public void selectType(){
        awardType.click();
    }

    public AwardReasonType(WebDriver driver) {
        super(driver);
    }
}
