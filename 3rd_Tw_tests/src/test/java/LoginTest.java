import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WelcomePage;

import java.net.MalformedURLException;

public class LoginTest {
    private LoginPage loginPage;
    private final BaseTest baseTest = new BaseTest();
    private BasePage basePage;

    public LoginTest() throws MalformedURLException {
    }

    @BeforeEach
    public void setup() throws MalformedURLException {
        basePage = BasePage.getInstanceOfBasePage();
        basePage.setup();
    }

    @Test
    public void login() throws MalformedURLException {
        baseTest.loginToJira();
        basePage.getDriver().navigate().to("https://jira.codecool.codecanvas.hu/secure/ViewProfile.jspa");
        ProfilePage profilePage = new ProfilePage();
        Assertions.assertEquals(System.getenv("USER_NAME"), profilePage.getProfileName().toLowerCase());
    }

    @Test
    public void loginWithInvalidUsername() throws MalformedURLException {
        loginPage = new LoginPage();
        loginPage.logIntoJira("invalidUser", System.getenv("PW"));
        loginPage.checkError();
    }

    @Test
    public void logout() throws MalformedURLException {
        loginPage = new LoginPage();
        loginPage.logIntoJira(System.getenv("USER_NAME"), System.getenv("PW"));
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.logOutOfJira();
    }

    @AfterEach
    public void close() {
        basePage.closeDriver();
    }
}
