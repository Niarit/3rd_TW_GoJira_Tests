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

public class GlassVersionTest extends tests.Test {
    private MainTestingProjectPage mainTestingProjectPage;

    @BeforeEach
    public void start(){
//        System.setProperty(driverName, driverPath);
//        if (browserName.equals("Firefox")){
//            driver = new FirefoxDriver();
//        } else if(browserName.equals("Chrome")){
//            driver = new ChromeDriver();
//        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa");
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.logIntoJira(System.getenv("USER_NAME"),System.getenv("PW"));
        setup();
    }

    @Test
    public void addNewVersionWithName(){
        getDriver().navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        ReleasesPage releasesPage = new ReleasesPage(getDriver());
        releasesPage.addVersionName("GoJira Test");
        releasesPage.clickAddBtn();
        getDriver().navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.codecanvas.glass:glass");
        GlassPage glassPage = new GlassPage(getDriver());
        glassPage.navigateToGlassVersions();
        Assertions.assertEquals("GoJira Test", glassPage.getLatestReleaseName());
        getDriver().navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.deleteRelease();
    }

    @Test
    public void editExistingRelease(){
        getDriver().navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        ReleasesPage releasesPage = new ReleasesPage(getDriver());
        releasesPage.addVersionName("GoJira Test");
        releasesPage.clickAddBtn();
        releasesPage.clickEdit();
        releasesPage.renameVersion("GoJira Test v1.0");
        releasesPage.confirmEdit();
        getDriver().navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.codecanvas.glass:glass");
        GlassPage glassPage = new GlassPage(getDriver());
        glassPage.navigateToGlassVersions();
        Assertions.assertEquals("GoJira Test v1.0", glassPage.getLatestReleaseName());
        getDriver().navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.deleteRelease();
    }

    @AfterEach
    public void quit(){
        getDriver().quit();
    }

}
