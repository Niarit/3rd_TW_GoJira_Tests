package pages;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static BasePage instanceOfBasePage = null;

    private WebDriver driver;

    public void setup() throws MalformedURLException {
        System.setProperty(System.getenv("DRIVER"), System.getenv("DRIVER_PATH"));
        DesiredCapabilities capability;
        switch (System.getenv("BROWSER")){
            case "chrome":
                capability = DesiredCapabilities.chrome();
                break;
            case "firefox":
                capability = DesiredCapabilities.firefox();
                break;
            case "internetExplorer":
                capability = DesiredCapabilities.internetExplorer();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + System.getenv("BROWSER"));
        }
        capability.setBrowserName(System.getenv("BROWSER"));
        capability.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(System.getenv("GRID_URL")), capability);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(System.getenv("BASE_URL") + "/secure/Dashboard.jspa");
    }

    public static BasePage getInstanceOfBasePage() throws MalformedURLException {
        if(instanceOfBasePage==null){
            instanceOfBasePage = new BasePage();
        }
        return instanceOfBasePage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver(){driver.quit();}
    public void closeTab(){driver.close();}
}
