package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.fail;
import static utils.DriverHelper.getDriverWeb;

public class GeralPage {
    private final int TIME_WAIT = 60;
    public WebDriver driver = getDriverWeb();

    public void expectElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    public void expectElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    public void sendKeys(By by, String value) {
        try {
            expectElementVisible(by);
            WebElement element = driver.findElement(by);
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    public void clickAndHighlight(By by) {
        try {
            expectElementClickable(by);
            WebElement element = driver.findElement(by);
            element.click();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
