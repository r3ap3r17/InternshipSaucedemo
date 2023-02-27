import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ProductsPage;

public class HeaderSelectBoxTest {
    LoginPage loginpage = new LoginPage();
    ProductsPage productPage = new ProductsPage();
    @Before
    public void initDriver() {
        loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
    }

    @Test
    public void headerSelectBoxAlphabeticallyTest()  {
        loginpage.loginSuccess(CommonStrings.STANDARD_USER, CommonStrings.PASSWORD);
        productPage.selectAlphabetically();
    }
    @Test
    public void headerSelectBoxReverseAlphabeticallyTest() {
        loginpage.loginSuccess(CommonStrings.STANDARD_USER, CommonStrings.PASSWORD);
        productPage.selectReverseAlphabetically();
    }

    @Test
    public void headerSelectBoxLowToHigh() {
        loginpage.loginSuccess(CommonStrings.STANDARD_USER, CommonStrings.PASSWORD);
        productPage.selectPricesLowToHigh();
    }

    @Test
    public void headerSelectBoxHighToLow() {
        loginpage.loginSuccess(CommonStrings.STANDARD_USER, CommonStrings.PASSWORD);
        productPage.selectPricesHighToLow();
    }

    @After
    public void closeDriver() {
        loginpage.quitDriver();
    }
}
