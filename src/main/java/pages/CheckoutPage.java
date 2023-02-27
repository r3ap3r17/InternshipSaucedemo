package pages;

import org.openqa.selenium.By;
import utils.BaseActions;

public class CheckoutPage extends BaseActions {

    private final By firstNameField = By.xpath("//input[@id='first-name']");
    private final By lastNameField = By.xpath("//input[@id='last-name']");
    private final By postCodeField = By.xpath("//input[@id='postal-code']");
    private final By continueButton = By.xpath("//input[@id='continue']");

    private final By errorMessage = By.xpath("//div[contains(@class,'error')]");

    public void fillCheckoutForm(String firstName,String lastName,String postCode) {
        enterText(firstNameField, firstName);
        comment("user typed to first name input");
        enterText(lastNameField, lastName);
        comment("user typed to last name input");
        enterText(postCodeField, postCode);
        comment("user typed to zip/postal code input");
        clickOnElement(continueButton);
        comment("user clicked continue");
    }
}
