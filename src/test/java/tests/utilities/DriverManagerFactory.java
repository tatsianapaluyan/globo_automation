package tests.utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerFactory {

    public static DriverManager getManager(String browser) {
        DriverManager driverManager = null;
        if (browser.equalsIgnoreCase("chrome")) {
            driverManager = new Chrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverManager = new Firefox();
        }
        return driverManager;
    }
}
