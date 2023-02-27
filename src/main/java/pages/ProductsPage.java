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

    public void clickSelectOption(int option) {
        selectOptionByIndex(filterSelect, option);
    }

    public void clickAllOptions()  {
        for (int i = 0; i < getAllOptions(filterSelect); i++) {
            clickSelectOption(i);

        }
    }

}
