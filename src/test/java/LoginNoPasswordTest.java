import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginNoPasswordTest {
    LoginPage loginpage = new LoginPage();
    @Before
    public void initDriver() {
        loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
    }

    @Test
    public void loginNoPasswordTest() {
        loginpage.loginFail(CommonStrings.STANDARD_USER, "", CommonStrings.NO_PASSWORD_ERROR);
    }

    @After
    public void closeDriver() {
        loginpage.quitDriver();
    }
}
