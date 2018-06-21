package tests.remote;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigAppRemoteWebDriver {

    @Test
    public void test() throws MalformedURLException {

        String platform = System.getProperty("platform");
        String browserType = System.getProperty("browserType");

        DesiredCapabilities cap = new DesiredCapabilities();


//Platforms
        if (platform.equalsIgnoreCase("linux"))
            cap.setPlatform(Platform.LINUX);
        else if (platform.equalsIgnoreCase("mac"))
            cap.setPlatform(Platform.MAC);

//Browsers
        if (browserType.equalsIgnoreCase("firefox"))
            cap = DesiredCapabilities.firefox();
        else if (browserType.equalsIgnoreCase("chrome"))
            cap = DesiredCapabilities.chrome();

        // cap.setBrowserName(System.getProperty("browser", "chrome"));
        //cap.setPlatform(Platform.valueOf(System.getProperty("platform", "LINUX")));
        URL url = new URL("http://192.168.2.1:3344/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("https://www.globoforce.com/");
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
        driver.quit();
    }
}

