package tests.remote;

import loggerutils.CustomListener;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners(CustomListener.class)

public class BaseRemoteDriverTest {

    private RemoteWebDriver remoteDriver;

    @BeforeClass
    public void startTest() throws MalformedURLException {
        String platform = System.getProperty("platform");
        String browserType = System.getProperty("browserType");
        DesiredCapabilities cap = new DesiredCapabilities();
        if (platform.equalsIgnoreCase("linux"))
            cap.setPlatform(Platform.LINUX);
        else if (platform.equalsIgnoreCase("mac"))
            cap.setPlatform(Platform.MAC);
        if (browserType.equalsIgnoreCase("firefox"))
            cap = DesiredCapabilities.firefox();
        else if (browserType.equalsIgnoreCase("chrome"))
            cap = DesiredCapabilities.chrome();
        URL url = new URL("http://192.168.2.1:3344/wd/hub");
        remoteDriver = new RemoteWebDriver(url, cap);
    }

    protected RemoteWebDriver getRemoteDriver() {
        return remoteDriver;
    }

    @AfterClass
    public void quiteRemoteDriver() {
        remoteDriver.quit();
    }
}
