package pages;

import org.openqa.selenium.By;
import utils.BaseActions;

public class CartPage extends BaseActions {
    private final By checkoutButton = By.xpath("//button[@id='checkout']");
    public void goToCheckout() {
        clickOnElement(checkoutButton);
    }
}
