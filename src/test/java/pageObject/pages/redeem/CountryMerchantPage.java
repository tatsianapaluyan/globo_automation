package pageObject.pages.redeem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.redeem.BasePage;

public class CountryMerchantPage extends BasePage {

    @FindBy(css = ".country-view .x-list-parent .x-group-a .x-list-item:nth-child(3)")
    private WebElement country;

    @FindBy(css = ".merchant-view .redeem-merchants .x-group-c .x-list-item:nth-child(1) .label")
    private WebElement merchant;


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
