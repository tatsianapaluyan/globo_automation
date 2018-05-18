package configApp;

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
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.MAC);
            URL url = new URL("http://192.168.2.1:3344/wd/hub");
            WebDriver driver = new RemoteWebDriver(url, cap);
            driver.get("https://www.globoforce.com/");
            Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
            driver.quit();
        }
    }

