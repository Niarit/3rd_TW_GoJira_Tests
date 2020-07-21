import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.WelcomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public void loginToJira() throws MalformedURLException {
        LoginPage loginpage = new LoginPage();
        loginpage.logIntoJira(System.getenv("USER_NAME"),System.getenv("PW"));
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.waitForProfilePic();
    }
}
