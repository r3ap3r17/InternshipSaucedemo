package utils;

import constants.CommonStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class BaseActions {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static WebElement element;
    private int counter = 1;
    protected void comment(String message) {
        System.out.println("STEP " + counter + ": " + message.toUpperCase());
        counter++;
    }

    protected void restartCounter() {
        counter = 1;
    }
    private void init(String url) throws MalformedURLException {
        switch (ReadProperties.readConfigBrowser().toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ReadProperties.readConfigChromePath());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", ReadProperties.readConfigFirefoxPath());
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", ReadProperties.readConfigEdgePath());
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Please make sure to provide a valid browser name in 'Configurations.properties' file !");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
    }
    public void openUrl(String URL) {
        try {
            this.init(URL);
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    // Closes Current Tab
    public void closeDriver() {
        driver.close();
    }
    // Closes All Tabs
    public void quitDriver() {
        driver.quit();
    }
    // Waits until element is visible and returns WebElement obj
    protected WebElement waitForVisible(By locator, int time) {
        wait  = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Just waits for WebElement to be visible
    protected void waitToBeVisible(By locator, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void clickOnElement(By locator) {
        element = waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM);
        element.click();
    }
    protected void enterText(By locator, String text) {
        element = waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM);
        element.sendKeys(text);
    }
    protected void enterTextWithClear(By locator, String text) {
        WebElement element = waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM);
        element.clear();
        element.sendKeys(text);
    }
}
