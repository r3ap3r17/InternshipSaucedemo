import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;

public class CheckoutOverviewSumOfPricesTest {
    LoginPage loginpage = new LoginPage();
    ProductsPage productPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    @Before
    public void initDriver() {
        loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
    }

    @Test
    public void headerClickBurgerMenuTest()  {
        loginpage.loginSuccess(CommonStrings.STANDARD_USER, CommonStrings.PASSWORD);
        productPage.goToCart();
        cartPage.goToCheckout();
        checkoutPage.fillCheckoutForm("Firstname", "Lastname", "34000");
        checkoutOverviewPage.checkTotalPrice();
    }

    @After
    public void closeDriver() {
        loginpage.quitDriver();
    }
}
