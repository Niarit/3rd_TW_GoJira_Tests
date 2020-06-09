package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.GlassPage;
import pages.LoginPage;
import pages.MainTestingProjectPage;
import pages.PrivateProjectPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GlassPermissionTest {
    private WebDriver driver;
    private final String driverPath = System.getenv("DRIVER_PATH");
    private final String driverName = System.getenv("DRIVER");
    private final String browserName = System.getenv("BROWSER");
    private MainTestingProjectPage mainTestingProjectPage;

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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIntoJira(System.getenv("USER_NAME"),System.getenv("PW"));
    }

    @Test
    public void checkPermissions(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/plugins/servlet/project-config/PP1/permissions");
        PrivateProjectPage privateProjectPage = new PrivateProjectPage(driver);
        List<String> permissions = privateProjectPage.getPermissions();
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.codecanvas.glass:glass");
        GlassPage glassPage = new GlassPage(driver);
        glassPage.navigateToGlassPermissions();
        List<String> glassPermissions = glassPage.getGlassPermissions();
        Assertions.assertEquals(permissions,glassPermissions);
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }
}
