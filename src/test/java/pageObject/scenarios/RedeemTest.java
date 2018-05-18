package pageObject.scenarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.pages.redeem.*;
import redeem.base.BaseTest;

public class RedeemTest extends BaseTest {

    @Test
    private void myRedeemTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openMWA();
        loginPage.logIn("renee_recipient1", "renee_recipient11");
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='sidebar-icon font-icon redeemBtn']")).isDisplayed(), "Login Failed");
        loginPage.navigateToRedeem();


        CountryMerchantPage countryMerchantPage = new CountryMerchantPage(driver);
        countryMerchantPage.selectCountry();
        countryMerchantPage.selectMerchant();
        DenominationPage denominationPage = new DenominationPage(driver);
        denominationPage.selectDenomination();
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='x-button x-button-normal'])[1]")).isEnabled(), "Continue is disabled");
        denominationPage.clickContinue();
        AddressPage addressPage = new AddressPage(driver);
        addressPage.selectAddress();
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.selectPayment();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.acceptTandC();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='tickbox font-icon ticked']")).isEnabled());
        orderPage.completeOrder();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='firstButton']")).getText(), "OK");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message']")).getText(), "Your order has been successful.");
        orderPage.closeMessagePopup();
    }
}