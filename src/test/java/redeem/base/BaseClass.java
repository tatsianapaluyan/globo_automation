//package redeem.base;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.safari.SafariDriver;
//
//public class BaseClass {
//
//    public static void main(String[] args) {
//
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
//        System.setProperty("webdriver.safari.driver", "src/test/resources/WebDriver.safariextz");
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://test-web1-06.corp.globoforce.com/m");
//
//        protected boolean isElementPresent (By by){
//            try {
//                driver.findElement(by);
//                return true;
//            } catch (NoSuchElementException e) {
//                return false;
//            }
//        }
//
//
//
////        boolean present;
////        try {
////          return driver.findElement(by);
////            present = true;
////        } catch (NoSuchElementException e) {
////            present = false;
////        }
//
//
////        WebDriver driver1 = new SafariDriver();
////
////        driver1.get("http://www.google.co.in");
//
//        driver.close();
//    }
//
//
//}
