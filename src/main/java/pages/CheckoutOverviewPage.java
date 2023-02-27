package pages;

import constants.CommonStrings;
import org.openqa.selenium.By;
import utils.BaseActions;

public class CheckoutOverviewPage extends BaseActions {
    private final By cartList = By.xpath("//div[@class='inventory_item_price']");

    public void checkTotalPrice() {
        getTextFromWebElementsVoid(cartList, CommonStrings.TIMEOUT_MEDIUM);
    }
}
