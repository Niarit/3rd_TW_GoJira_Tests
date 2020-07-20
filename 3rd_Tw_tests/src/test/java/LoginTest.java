import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WelcomePage;
import tests.BaseTest;

public class LoginTest {
    private LoginPage loginPage;
    private final BaseTest baseTest = new BaseTest();

    @BeforeEach
    public void setup(){
       baseTest.setup();

    }

    @Test
    public void login(){
        baseTest.loginToJira();
        baseTest.getDriver().navigate().to("https://jira.codecool.codecanvas.hu/secure/ViewProfile.jspa");
        ProfilePage profilePage = new ProfilePage(baseTest.getDriver());
        Assertions.assertEquals(System.getenv("USER_NAME"), profilePage.getProfileName().toLowerCase());
    }

    @Test
    public void loginWithInvalidUsername(){
        loginPage = new LoginPage(baseTest.getDriver());
        loginPage.logIntoJira("invalidUser", System.getenv("PW"));
        loginPage.checkError();
    }

    @Test
    public void logout(){
        loginPage = new LoginPage(baseTest.getDriver());
        loginPage.logIntoJira(System.getenv("USER_NAME"), System.getenv("PW"));
        WelcomePage welcomePage = new WelcomePage(baseTest.getDriver());
        welcomePage.logOutOfJira();
    }



    @AfterEach
    public void close() {
        baseTest.close();
    }
}
