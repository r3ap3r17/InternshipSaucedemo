import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class HeaderBurgerResetStateLinkTest {
    LoginPage loginpage = new LoginPage();
    ProductsPage productPage = new ProductsPage();
    @Before
    public void initDriver() {
        loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
    }

    // Test is supposed to fail, because when app is restarted All item buttons should restart
    @Test
    public void headerBurgerResetStateLinkTest()  {
        loginpage.loginSuccess(CommonStrings.STANDARD_USER, CommonStrings.PASSWORD);
        productPage.clickResetAppState();
    }

    @After
    public void closeDriver() {
        loginpage.quitDriver();
    }
}
