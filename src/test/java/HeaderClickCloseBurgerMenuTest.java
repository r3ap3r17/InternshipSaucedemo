import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class HeaderClickCloseBurgerMenuTest {
    LoginPage loginpage = new LoginPage();
    ProductsPage productPage = new ProductsPage();
    @Before
    public void initDriver() {
        loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
    }

    @Test
    public void headerClickCloseBurgerMenuTest()  {
        loginpage.loginSuccess(CommonStrings.STANDARD_USER, CommonStrings.PASSWORD);
        productPage.clickCloseBurgerMenu();
    }

    @After
    public void closeDriver() {
        loginpage.quitDriver();
    }
}
