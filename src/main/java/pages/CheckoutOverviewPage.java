package pages;

import constants.CommonStrings;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseActions;

import java.util.List;

public class CheckoutOverviewPage extends BaseActions {
    private Double total = 0.0;
    private final By cartList = By.xpath("//div[@class='inventory_item_price']");
    private final By taxDiv = By.xpath("//div[@class='summary_tax_label']");
    private final By totalDiv = By.xpath("//div[@class='summary_total_label']");

    // Checks if all item prices when summed ar equal to total price
    public void checkTotalPrice() {
        total += sumOfAllPrices(getTextFromWebElements(cartList, CommonStrings.TIMEOUT_MEDIUM));
        System.out.println("Total before tax: " + total);
        total += getDoubleFromWebElement(taxDiv) / 100;
        Double expectedTotal = getDoubleFromWebElement(totalDiv) / 100;
        total = Math.round(total * 100.0) / 100.0;
        System.out.println("Total after tax: " + total);
        Assert.assertEquals(expectedTotal, total);
    }
    // Returns Sum of all items from List
    private Double sumOfAllPrices(List<Double> list) {
        Double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
