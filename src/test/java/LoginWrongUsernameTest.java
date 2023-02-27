import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginWrongUsernameTest {
    LoginPage loginpage = new LoginPage();
    @Before
    public void initDriver() {
        loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
    }

    @Test
    public void loginWrongUsernameTest() {
        loginpage.loginFail(CommonStrings.STANDARD_USER + "123", CommonStrings.PASSWORD, CommonStrings.WRONG_USERNAME_ERROR);
    }

    @After
    public void closeDriver() {
        loginpage.quitDriver();
    }
}
