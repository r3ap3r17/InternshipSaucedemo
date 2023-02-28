package pages;

import constants.CommonStrings;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends BaseActions {
    private final By filterSelect = By.xpath("//select[@data-test='product_sort_container']");
    private final By inventoryContainer = By.xpath("//div[@id='inventory_container']");
    private final By loginForm  =By.xpath("//div[@id='login_button_container']");
    private final By burgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    private final By closeBurgerMenu = By.xpath("//button[@id='react-burger-cross-btn']");
    private final By menuContainer = By.xpath("//div[@class='bm-menu-wrap']");
    private final By allItemsLink = By.xpath("//a[@id='inventory_sidebar_link']");
    private final By aboutLink = By.xpath("//a[@id='about_sidebar_link']");
    private final By logoutLink = By.xpath("//a[@id='logout_sidebar_link']");
    private final By resetAppStateLink = By.xpath("//a[@id='reset_sidebar_link']");
    private final By addToCartButton1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private final By addToCartButton2 = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    private final By cartIconSpan = By.xpath("//span[@class='shopping_cart_badge']");
    private final By cartIcon = By.xpath("//a[@class='shopping_cart_link']");

    // Clicks cart button
    public void goToCart() {
        clickOnElement(addToCartButton1);
        clickOnElement(addToCartButton2);
        clickOnElement(cartIcon);
    }
    // Clicks select item option with [int option] being index of that option
    public void clickSelectOption(int option) {
        selectOptionByIndex(filterSelect, option);
    }
    // Goes through all options and clicks every single one of them
    public void clickAllOptions()  {
        for (int i = 0; i < getAllOptions(filterSelect); i++) {
            clickSelectOption(i);
            comment("user clicked select option" + "[" + i + "]");
        }
    }
    // Clicks burger Menu and check if its 'aria-hidden' attribute == false
    public void clickBurgerMenu() {
        clickOnElement(burgerMenu);
        comment("user clicked on burger menu");
        Assert.assertEquals(getAttributeValueFromElement(menuContainer, "aria-hidden"), "false");
    }
    // Clicks burger Menu and check if menu is not visible
    public void clickCloseBurgerMenu() {
        clickBurgerMenu();
        clickOnElement(closeBurgerMenu);
        comment("user clicked on close burger menu");
        waitNotToBeVisible(menuContainer, CommonStrings.TIMEOUT_MEDIUM);
    }
    // Click all items link and checks and verifies products page
    public void clickAllItemLink() {
        clickBurgerMenu();
        clickOnElement(allItemsLink);
        comment("user clicked All items link");
        waitToBeVisible(inventoryContainer, CommonStrings.TIMEOUT_MEDIUM);
    }
    // Click About link and checks if url changed
    public void clickAboutLink() {
        clickBurgerMenu();
        clickOnElement(aboutLink);
        comment("user clicked on about link");
        waitForUrlChange(CommonStrings.SAUCE_LABS_WEBSITE, CommonStrings.TIMEOUT_LONG);
    }
    // Clicks Logout link and checks and verifies login page form
    public void clickLogoutLink() {
        clickBurgerMenu();
        clickOnElement(logoutLink);
        comment("user clicked on logout link");
        waitToBeVisible(loginForm, CommonStrings.TIMEOUT_LONG);
    }
    // Clicks reset app state and checks if cart icons apn still exists
    public void clickResetAppState() {
        clickOnElement(addToCartButton1);
        clickBurgerMenu();
        clickOnElement(resetAppStateLink);
        comment("user clicked on reset app state link");
        waitNotToBeVisible(cartIconSpan, CommonStrings.TIMEOUT_MEDIUM);
        waitToBeVisible(addToCartButton1, CommonStrings.TIMEOUT_MEDIUM); // this reproduces a bug
    }
}
