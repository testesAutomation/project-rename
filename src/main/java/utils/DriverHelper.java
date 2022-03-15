package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverHelper {
    private static final int TIME_WAIT = 50;
    public static WebDriver driver;


    private static WebDriver initChromeDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--ignore-ssl-errors","--disable-notification", "–-no-sandbox", "--disable-infobars", "--ignore-certificate-errors", "--disable-web-security");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(TIME_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriverWeb() {
        if (driver == null) {
            initChromeDriver();
        }
        return driver;
    }
    public static void closeDriverWeb() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void resetDriver(String url) {
        if (driver != null) {
            driver.get(url);
        }
    }

}
