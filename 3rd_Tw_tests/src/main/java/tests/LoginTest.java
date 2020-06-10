package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WelcomePage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private final String driverPath = System.getenv("DRIVER_PATH");
    private final String driverName = System.getenv("DRIVER");
    private final String browserName = System.getenv("BROWSER");
    private LoginPage loginPage;

    @BeforeEach
    public void setup(){
        System.setProperty(driverName, driverPath);
        if (browserName.equals("Firefox")){
            driver = new FirefoxDriver();
        } else if(browserName.equals("Chrome")){
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa");

    }

    @Test
    public void login(){
        loginPage = new LoginPage(driver);
        loginPage.logIntoJira(System.getenv("USER_NAME"),System.getenv("PW"));
        driver.navigate().to("https://jira.codecool.codecanvas.hu/secure/ViewProfile.jspa");
        ProfilePage profilePage = new ProfilePage(driver);
        Assertions.assertEquals(System.getenv("USER_NAME"), profilePage.getProfileName().toLowerCase());
    }

    @Test
    public void loginWithInvalidUsername(){
        loginPage = new LoginPage(driver);
        loginPage.logIntoJira("invalidUser", System.getenv("PW"));
        loginPage.checkError();
    }

    @Test
    public void logout(){
        loginPage = new LoginPage(driver);
        loginPage.logIntoJira(System.getenv("USER_NAME"), System.getenv("PW"));
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.logOutOfJira();
    }



    @AfterEach
    public void close() {
        driver.quit();
    }
}
