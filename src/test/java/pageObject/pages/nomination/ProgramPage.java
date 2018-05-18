package pageObject.pages.nomination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class ProgramPage extends BasePage {

    @FindBy(xpath = "(//div[@class='award-program '])[2]")
    private WebElement program;

    public void selectProgram() throws InterruptedException {
     Thread.sleep(2000);
        program.click();
    }

    public ProgramPage(WebDriver driver) {
        super(driver);
    }
}
