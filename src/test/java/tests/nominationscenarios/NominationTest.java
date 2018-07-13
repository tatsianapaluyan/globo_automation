package tests.nominationscenarios;

import businessobjects.User;
import factories.UserStaticFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.nomination.*;
import services.LogInService;
import tests.BaseTest;

public class NominationTest extends BaseTest {

    private User mobileUser = UserStaticFactory.createNominator();
    private Logger logger = Logger.getLogger(getClass());

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
        logger.info("Click Recognize tab menu");
        recipientsPage.clickNominate();
        logger.info("Select recipient");
        recipientsPage.selectRecipient();
        recipientsPage.nextButton();
        ProgramPage programPage = new ProgramPage(getWebDriver());
        logger.info("Select award program");
        programPage.selectProgram();
        AwardReasonTypePage awardReasonType = new AwardReasonTypePage(getWebDriver());
        logger.info("Select award reason");
        awardReasonType.selectReason();
        logger.info("Select award type");
        awardReasonType.selectType();
        awardReasonType.selectAwardPeriod();

        MessagePage messagePage = new MessagePage(getWebDriver());
        logger.info("Enter the information for the Nomination fields and send award");
        messagePage.addAwardTitle("Award Title");
        messagePage.addMessageToRecipient("Message to Recipient");
        messagePage.createNomination();

        Assert.assertEquals(messagePage.getCloseButtontext(), "Close");
        Assert.assertEquals(messagePage.getSuccessfulMessageText(), "Nomination Submitted Successfully");
        logger.info("Close nomination panel");
        messagePage.closeMessagePopup();
    }
}