package pageobjects.nomination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;

public class ProgramPage extends BasePage {

    @FindBy(xpath = "(//div[@class='award-program '])[2]")
    private Button program;

    public void selectProgram() throws InterruptedException {
     Thread.sleep(2000);
        program.click();
    }

    public ProgramPage(WebDriver driver) {
        super(driver);
    }
}
