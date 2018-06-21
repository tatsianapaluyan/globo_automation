package tests.redeemscenarios;

import businessobjects.User;
import factories.UserStaticFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.redeem.*;
import services.LogInService;
import tests.BaseTest;

public class RedeemTest extends BaseTest {

    private User mobileUser = UserStaticFactory.createRedeemUser();

    @BeforeClass
    public void login() {
        LogInService loginService = new LogInService(getWebDriver());
        loginService.openMWA("testclient5013");
        loginService.logIn(mobileUser);
    }

    @Test
    private void myRedeemTest() throws InterruptedException {

        CountryMerchantPage countryMerchantPage = new CountryMerchantPage(getWebDriver());
        Assert.assertTrue(countryMerchantPage.isRedeemMenuPresent(), "RedeemMenu is not present");
        countryMerchantPage.navigateToRedeem();
        countryMerchantPage.selectCountry();
        countryMerchantPage.selectMerchant();
        DenominationPage denominationPage = new DenominationPage(getWebDriver());
        denominationPage.selectDenomination();
        Assert.assertTrue(denominationPage.isContinueButtonEnabled(), "Continue is disabled");
        denominationPage.clickContinue();
        AddressPage addressPage = new AddressPage(getWebDriver());
        addressPage.selectAddress();
        PaymentPage paymentPage = new PaymentPage(getWebDriver());
        paymentPage.selectPayment();
        OrderPage orderPage = new OrderPage(getWebDriver());
        orderPage.acceptTandC();
        Assert.assertTrue(orderPage.isCheckBoxEnabled(),"T&C CheckBox is not enabled");
        orderPage.completeOrder();
        Assert.assertEquals(orderPage.getOkButtontext(), "OK");
        Assert.assertEquals(orderPage.getSuccessfultext(), "Your order has been successful.");
        orderPage.closeMessagePopup();
    }
}