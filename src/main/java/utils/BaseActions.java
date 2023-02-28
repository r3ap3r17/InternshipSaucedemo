package utils;

import constants.CommonStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class BaseActions {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static WebElement element;
    protected static Select select;
    private static int counter = 1;
    // Prints a comment to console
    protected void comment(String message) {
        System.out.println("STEP " + counter + ": " + message.toUpperCase());
        counter++;
    }
    protected void restartCounter() {
        counter = 1;
    }
    // Reads browser key value in Configurations.properties file and creates a driver object based on that value
    private void init(String url) throws MalformedURLException {
        counter = 1; // Restarts counter to 1, every time Driver is initiated
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

    // Just handles init methode
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
    // Waits for url to change
    public void waitForUrlChange(String url, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.urlToBe(url));
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
    // Just waits for WebElement not to be visible
    protected void waitNotToBeVisible(By locator, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    // Waits until all elements are visible and returns WebElements
    protected List<WebElement> waitForVisibleElements(By locator, int time) {
        wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    // Returns String list of all prices
    protected List<Double> getTextFromWebElements(By locator, int time) {
        List<WebElement> elementList = new ArrayList<WebElement>(waitForVisibleElements(locator, time));
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < elementList.size(); i++) {
            list.add(Double.parseDouble(elementList.get(i).getText().replaceAll("\\$", "")));
            System.out.println(list.get(i));
        }
        return list;
    }
    // Just example
    protected void getTextFromWebElementsVoid(By locator, int time) {
        List<WebElement> elementList = new ArrayList<WebElement>(waitForVisibleElements(locator, time));
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < elementList.size(); i++) {
            list.add(Double.parseDouble(elementList.get(i).getText().replaceAll("\\$", "")));
            System.out.println(list.get(i));
        }
    }
    // Clicks WebElement
    protected void clickOnElement(By locator) {
        element = waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM);
        element.click();
    }
    // Enters text to WebElement
    protected void enterText(By locator, String text) {
        element = waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM);
        element.sendKeys(text);
    }
    // Clears and Enters text to WebElement
    protected void enterTextWithClear(By locator, String text) {
        element = waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM);
        element.clear();
        element.sendKeys(text);
    }
    // Returns text from WebElement
    protected String getTextFromElement(By locator) {
        element = waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM);
        return element.getText();
    }
    // Returns Element attribute's text
    protected String getAttributeValueFromElement(By locator, String attribute) {
        element = waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM);
        return element.getAttribute(attribute);
    }
    // Waits for Select and selects option by text
    public void selectOptionByVisibleText(By locator, String option) {
        select = new Select(waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM));
        select.selectByVisibleText(option);
    }
    // Waits for Select and selects option by attribute value
    public void selectOptionByValue(By locator, String value) {
        select = new Select(waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM));
        select.selectByValue(value);
    }
    // Waits for Select and selects option by index
    public void selectOptionByIndex(By locator, int index) {
        select = new Select(waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM));
        select.selectByIndex(index);
    }
    // Returns number of all options from select box
    public int getAllOptions(By locator) {
        select = new Select(waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM));
        return select.getOptions().size();
    }
    // Returns Double from elements text
    protected Double getDoubleFromWebElement(By locator) {
        return Double.parseDouble(waitForVisible(locator, CommonStrings.TIMEOUT_MEDIUM).getText().replaceAll("\\D+",""));
    }
}
