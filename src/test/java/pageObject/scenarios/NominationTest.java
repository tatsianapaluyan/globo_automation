package pageObject.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.pages.nomination.*;
import redeem.base.BaseTest;

public class NominationTest extends BaseTest {

    @Test
    private void myNominationTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openMWA();
        loginPage.logIn("adam_admin", "pass");
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='sidebar-icon font-icon nominateBtn']")).isDisplayed(), "Login Failed");
        loginPage.navigateToNominate();


        RecipientsPage recipientsPage = new RecipientsPage(driver);
        recipientsPage.selectRecipient();
        recipientsPage.nextButton();
        ProgramPage programPage = new ProgramPage(driver);
        programPage.selectProgram();
        AwardReasonType awardReasonType = new AwardReasonType(driver);
        awardReasonType.selectReason();
        awardReasonType.selectType();


        MessagePage messagePage = new MessagePage(driver);
        messagePage.addAwardTitle("Award Title");
        messagePage.addMessageToRecipient("Message to Recipient");
        messagePage.createNomination();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='secondButton']")).getText(), "Close");
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='title'])[2]")).getText(), "Nomination Submitted Successfully");
        messagePage.closeMessagePopup();
    }
}