package tests.nominationscenarios;

import businessobjects.User;
import factories.UserStaticFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.nomination.*;
import services.LogInService;
import tests.BaseTest;

public class NominationTest extends BaseTest {

    private User mobileUser = UserStaticFactory.createNominator();

    @BeforeClass
    public void login() {
        LogInService loginService = new LogInService(getWebDriver());
        loginService.openMWA("testclient5013");
        loginService.logIn(mobileUser);
    }


    @Test
    private void myNominationTest() throws InterruptedException {


        RecipientsPage recipientsPage = new RecipientsPage(getWebDriver());

        Assert.assertTrue(recipientsPage.isNominateMenuPresent(), "Nomination Menu is not present");

        recipientsPage.clickNominate();
        recipientsPage.selectRecipient();
        recipientsPage.nextButton();
        ProgramPage programPage = new ProgramPage(getWebDriver());
        programPage.selectProgram();
        AwardReasonTypePage awardReasonType = new AwardReasonTypePage(getWebDriver());
        awardReasonType.selectReason();
        awardReasonType.selectType();
        awardReasonType.selectAwardPeriod();

        MessagePage messagePage = new MessagePage(getWebDriver());
        messagePage.addAwardTitle("Award Title");
        messagePage.addMessageToRecipient("Message to Recipient");
        messagePage.createNomination();

        Assert.assertEquals(messagePage.getCloseButtontext(), "Close");
        Assert.assertEquals(messagePage.getSuccessfulMessageText(), "Nomination Submitted Successfully");
        messagePage.closeMessagePopup();
    }
}