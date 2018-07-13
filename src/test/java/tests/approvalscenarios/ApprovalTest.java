package tests.approvalscenarios;

import businessobjects.User;
import factories.UserStaticFactory;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.approval.ApprovalList;
import services.LogInService;
import tests.BaseTest;

public class ApprovalTest extends BaseTest {

    private Logger logger = Logger.getLogger(getClass());
    private User mobileUser = UserStaticFactory.createApproverUser();

    @BeforeClass
    public void login() {
        LogInService loginService = new LogInService(getWebDriver());
        loginService.openMWA("testclient5013");
        loginService.logIn(mobileUser);
        logger.info("Navigate to the Dashboard");
    }


    @Test
    private void myApprovalTest() throws InterruptedException {

        ApprovalList approvalList = new ApprovalList(getWebDriver());
        logger.info("Navigate to the Approvals");
        approvalList.clickApprove();
        approvalList.selectApproval();
        approvalList.approveAward();
        approvalList.confirmApproveAward();
        logger.info("Approve the nomination");
        approvalList.completeApproval();
        Assert.assertEquals(approvalList.getOKButtonText(), "OK_button");
    }
}


