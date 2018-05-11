package redeem.testRedeem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class PageObject {

    @FindBy(xpath="//span[@class='sidebar-icon font-icon redeemBtn']")
    public WebElement Redeem;

}
