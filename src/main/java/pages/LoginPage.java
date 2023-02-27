package pages;

import constants.CommonStrings;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseActions;

public class LoginPage extends BaseActions {
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By usernameInput = By.xpath("//input[@id='user-name']");
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By errorMessageBox = By.xpath("//h3[@data-test='error']");
    private final By burgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");

    public void loginSuccess(String username, String password) {
        enterTextWithClear(usernameInput, username);
        enterTextWithClear(passwordInput, password);
        clickOnElement(loginButton);
        verifyProductsPage();
        comment("user successfully logged in");
    }

    public void loginFail(String username, String password, String error)  {
        enterTextWithClear(usernameInput, username);
        enterTextWithClear(passwordInput, password);
        clickOnElement(loginButton);
        Assert.assertEquals(getTextFromElement(errorMessageBox), error);
        comment("user failed to log in");
    }

    public void verifyProductsPage() {
        waitToBeVisible(burgerMenu, CommonStrings.TIMEOUT_MEDIUM);
    }

}
