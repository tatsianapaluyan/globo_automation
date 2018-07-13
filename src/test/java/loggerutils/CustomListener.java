package loggerutils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import org.openqa.selenium.WebDriver;



public class CustomListener implements ITestListener {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' FAILED");
      //  ScreenshotUtils.captureScreenshot(BaseTest.getDriver(), result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' correspond threshold of success rate");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("Test class '" + iTestContext.getName()+ "' STARTED");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("Test class '" + iTestContext.getName()+ "' FINISHED");
    }
}
