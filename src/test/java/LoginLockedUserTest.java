import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginLockedUserTest {
    LoginPage loginpage = new LoginPage();
    @Before
    public void initDriver() {
        loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
    }

    @Test
    public void loginLockedUserTest() {
        loginpage.loginFail(CommonStrings.LOCKED_USER, CommonStrings.PASSWORD, CommonStrings.LOCKED_USER_ERROR);
    }

    @After
    public void closeDriver() {
        loginpage.quitDriver();
    }
}
