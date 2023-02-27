import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginSuccessfulTest {
    LoginPage loginpage = new LoginPage();
    @Before
    public void initDriver() {
        loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
    }

    @Test
    public void loginSuccessfulTest() {
        loginpage.loginSuccess(CommonStrings.STANDARD_USER, CommonStrings.PASSWORD);
    }

    @After
    public void closeDriver() {
        loginpage.quitDriver();
    }
}
