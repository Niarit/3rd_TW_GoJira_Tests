package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GlassPage;
import pages.LoginPage;
import pages.MainTestingProjectPage;
import pages.ReleasesPage;

import java.util.concurrent.TimeUnit;

public class GlassVersionTest {
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
    public void addNewVersionWithName(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        ReleasesPage releasesPage = new ReleasesPage(driver);
        releasesPage.addVersionName("GoJira Test");
        releasesPage.clickAddBtn();
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.codecanvas.glass:glass");
        GlassPage glassPage = new GlassPage(driver);
        glassPage.navigateToGlassVersions();
        Assertions.assertEquals("GoJira Test", glassPage.getLatestReleaseName());
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.deleteRelease();
    }

    @Test
    public void editExistingRelease(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        ReleasesPage releasesPage = new ReleasesPage(driver);
        releasesPage.addVersionName("GoJira Test");
        releasesPage.clickAddBtn();
        releasesPage.clickEdit();
        releasesPage.renameVersion("GoJira Test v1.0");
        releasesPage.confirmEdit();
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.codecanvas.glass:glass");
        GlassPage glassPage = new GlassPage(driver);
        glassPage.navigateToGlassVersions();
        Assertions.assertEquals("GoJira Test v1.0", glassPage.getLatestReleaseName());
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.deleteRelease();
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }

}
