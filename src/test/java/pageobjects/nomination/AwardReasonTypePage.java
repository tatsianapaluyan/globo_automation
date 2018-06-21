package pageobjects.nomination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;

public class AwardReasonTypePage extends BasePage{


    @FindBy(xpath = "(//div[@class='award-reason'])[2]")
    private Button awardReason;

    @FindBy(xpath = "(//div[@class='award-name visible'])[2]")
    private Button awardType;

    @FindBy(xpath = " (//div[@class='x-button next-button x-button-plain'])[2]")
    private Button awardPeriod;

    public void selectReason(){
        //awardReason.click();
    }

    public void selectType(){
        awardType.click();
    }

    public void selectAwardPeriod(){
        awardPeriod.click();
    }

    public AwardReasonTypePage(WebDriver driver) {
        super(driver);
    }
}
