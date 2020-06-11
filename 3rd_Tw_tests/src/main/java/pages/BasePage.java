package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
    private static BasePage instanceOfBasePage = null;

    private WebDriver driver;

    private BasePage(){
        String driverPath = System.getenv("DRIVER_PATH");
        String driverName = System.getenv("DRIVER");
        System.setProperty(driverName, driverPath);
        String browserName = System.getenv("BROWSER");
        if (browserName.equals("Firefox")){
            driver = new FirefoxDriver();
        } else if(browserName.equals("Chrome")){
            driver = new ChromeDriver();
        }
    }

    public static BasePage getInstanceOfBasePage(){
        if(instanceOfBasePage==null){
            instanceOfBasePage = new BasePage();
        }
        return instanceOfBasePage;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
