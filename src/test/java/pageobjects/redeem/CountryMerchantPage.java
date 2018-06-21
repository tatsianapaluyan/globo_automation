package pageobjects.redeem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;

public class CountryMerchantPage extends BasePage {

    @FindBy(xpath = "//span[@class='sidebar-icon font-icon redeemBtn']")
    private Button redeemButton;

    @FindBy(css = ".country-view .x-list-parent .x-group-a .x-list-item:nth-child(3)")
    private Button country;

    @FindBy(css = ".merchant-view .redeem-merchants .x-group-c .x-list-item:nth-child(1) .label")
    private Button merchant;

    public void navigateToRedeem() {
        waitElementPresent(By.xpath("//span[@class='sidebar-icon font-icon redeemBtn']"));
        redeemButton.click();
    }

    public boolean isRedeemMenuPresent() {
        return isElementPresent(redeemButton);
    }

    public void selectCountry() {
        waitElementPresent(By.cssSelector(".country-view .x-list-parent .x-group-a .x-list-item:nth-child(3)"));
        country.click();
    }

    public void selectMerchant() {
        waitElementToBeClickable(By.cssSelector(".merchant-view .redeem-merchants .x-group-c .x-list-item:nth-child(1) .label"));
        merchant.click();
    }

    public CountryMerchantPage(WebDriver driver) {
        super(driver);
    }
}
