package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static BasePage instanceOfBasePage = null;

    private WebDriver driver;

    public void setup() throws MalformedURLException {
        switch (System.getenv("BROWSER")){
            case "chrome":
                driver = new RemoteWebDriver(new URL(System.getenv("GRID_URL")), new ChromeOptions());
                break;
            case "firefox":
                driver = new RemoteWebDriver(new URL(System.getenv("GRID_URL")), new FirefoxOptions());
                break;
            case "internetExplorer":
                driver = new RemoteWebDriver(new URL(System.getenv("GRID_URL")), new InternetExplorerOptions());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + System.getenv("BROWSER"));
        }

        driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getenv("WAIT")), TimeUnit.SECONDS);
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
