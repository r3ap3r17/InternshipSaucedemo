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
    private final By filterSelect = By.xpath("//select[contains(@class,'sort')]");
    private final By productNames = By.xpath("//div[@class='inventory_item_name']");
    private final By productPrices = By.xpath("//div[@class='inventory_item_price']");
    private List<WebElement> productNameElements = new ArrayList<WebElement>();
    private List<WebElement> productPriceElements = new ArrayList<WebElement>();

    Select select;

    // Asserts if all titles are sorted A to Z
    public void selectAlphabetically() {
        selectOptionByValue(filterSelect, "az");
        productNameElements = waitForVisibleElements(productNames, CommonStrings.TIMEOUT_MEDIUM);

        List<String> productNamesList = new ArrayList<String>();
        for (int i = 0;i < productNameElements.size();i++) {
            productNamesList.add(productNameElements.get(i).getText());
        }
        Assert.assertTrue(isAlphabeticallySorted(productNamesList));
    }
    // Asserts if all titles are sorted Z to A
    public void selectReverseAlphabetically() {
        selectOptionByValue(filterSelect, "za");
        productNameElements = waitForVisibleElements(productNames, CommonStrings.TIMEOUT_MEDIUM);

        List<String> productNamesList = new ArrayList<String>();
        for (int i = 0;i < productNameElements.size();i++) {
            productNamesList.add(productNameElements.get(i).getText());
        }
        Assert.assertTrue(isAlphabeticallyReverseSorted(productNamesList));
    }
    // Asserts if products are sorted low to high
    public void selectPricesLowToHigh() {
        selectOptionByValue(filterSelect, "lohi");
        productPriceElements = waitForVisibleElements(productPrices, CommonStrings.TIMEOUT_MEDIUM);

        List<Double> productPricesList = new ArrayList<Double>();
        for (int i = 0; i < productPriceElements.size(); i++) {
            productPricesList.add(Double.parseDouble(productPriceElements.get(i).getText().substring(1)));
            System.out.println(productPriceElements.get(i).getText());
        }

        Assert.assertTrue(isSorted(productPricesList));
    }
    // Asserts if products are sorted high to low
    public void selectPricesHighToLow() {
        selectOptionByValue(filterSelect, "hilo");
        productPriceElements = waitForVisibleElements(productPrices, CommonStrings.TIMEOUT_MEDIUM);

        List<Double> productPricesList = new ArrayList<Double>();
        for (int i = 0; i < productPriceElements.size(); i++) {
            productPricesList.add(Double.parseDouble(productPriceElements.get(i).getText().substring(1)));
            System.out.println(productPriceElements.get(i).getText());
        }

        Assert.assertTrue(isReverseSorted(productPricesList));
    }
    // Returns array Sorted Low to High
    public boolean isSorted(List<Double> list) {
        List<Double> pomList = new ArrayList<Double>();
        pomList.addAll(list);
        Collections.sort(pomList);

        return list.equals(pomList);
    }
    // Returns array Sorted High to Low
    public boolean isReverseSorted(List<Double> list) {
        List<Double> pomList = new ArrayList<Double>();
        pomList.addAll(list);
        Collections.sort(pomList, Collections.reverseOrder());

        return list.equals(pomList);
    }
    // Returns array Alphabetically Sorted A to Z
    public boolean isAlphabeticallySorted(List<String> list) {
        List<String> pomList = new ArrayList<String>();
        pomList.addAll(list);
        Collections.sort(pomList);

        return list.equals(pomList);
    }
    // Returns array Alphabetically Sorted Z to A
    public boolean isAlphabeticallyReverseSorted(List<String> list) {
        List<String> pomList = new ArrayList<String>();
        pomList.addAll(list);
        Collections.sort(pomList, Collections.reverseOrder());

        return list.equals(pomList);
    }
}
