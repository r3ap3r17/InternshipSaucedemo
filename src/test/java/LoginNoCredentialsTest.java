import constants.CommonStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginNoCredentialsTest {
        LoginPage loginpage = new LoginPage();
        @Before
        public void initDriver() {
            loginpage.openUrl(CommonStrings.LOGIN_PAGE_URL);
        }

        @Test
        public void loginNoCredentialsTest() {
            loginpage.loginFail("", "", CommonStrings.NO_CREDS_ERROR);
        }

        @After
        public void closeDriver() {
            loginpage.quitDriver();
        }
}
