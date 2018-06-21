package pageobjects.approval;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;

public class ApprovalList extends BasePage {

    @FindBy(xpath = "//span[@class='sidebar-icon font-icon approvalsBtn']")
    private Button approvalMenu;

    @FindBy(xpath = "(//div[@class='approval-check font-icon'])[1]")
    private CheckBox approvalItem;

    @FindBy(xpath = "//div[@id='approveListButton']")
    private Button approveButton;

    @FindBy(xpath = "//div[@id='firstButton']")
    private Button okButton;


    public void clickApprove() {
        waitElementPresent(By.xpath("//span[@class='sidebar-icon font-icon approvalsBtn']"));
        approvalMenu.click();
    }

    public void selectApproval() {
        waitElementPresent(By.xpath("(//div[@class='approval-check font-icon'])[1]"));
        approvalItem.click();
    }

    public void approveAward() {
        waitElementPresent(By.xpath("//div[@id='approveListButton']"));
        approveButton.click();
    }

    public void confirmApproveAward() {
        waitElementPresent(By.xpath("//div[@id='approveListButton']"));
        approveButton.click();
    }

    public void completeApproval() {
        waitElementToBeClickable(By.xpath("//div[@id='firstButton']"));
        okButton.click();
    }

    public String getOKButtonText() {
        return okButton.getText();
    }


    public ApprovalList(WebDriver driver) {
        super(driver);
    }
}
