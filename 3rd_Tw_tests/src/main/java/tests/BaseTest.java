package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.WelcomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    private final String driverPath = System.getenv("DRIVER_PATH");
    private final String driverName = System.getenv("DRIVER");
    private final String browserName = System.getenv("BROWSER");


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

    public void loginToJira(){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.logIntoJira(System.getenv("USER_NAME"),System.getenv("PW"));
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.waitForProfilePic();
    }

    public void close() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
