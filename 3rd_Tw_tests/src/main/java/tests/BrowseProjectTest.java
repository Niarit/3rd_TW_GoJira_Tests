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
import pages.AllProjectsPage;
import pages.LoginPage;
import pages.ProjectPage;

import java.util.concurrent.TimeUnit;

public class BrowseProjectTest {

    private WebDriver driver;
    private final String driverPath = System.getenv("DRIVER_PATH");
    private final String driverName = System.getenv("DRIVER");
    private final String browserName = System.getenv("BROWSER");

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
        LoginPage loginpage = new LoginPage(driver);
        loginpage.logIntoJira(System.getenv("USER_NAME"),System.getenv("PW"));
    }

    @Test
    public void browseAllProjects() {
        AllProjectsPage allProjectsPage = new AllProjectsPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);
        allProjectsPage.navigateToAllProjects();
        Assertions.assertEquals("Main Testing Project", projectPage.getProjectName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"https://jira.codecool.codecanvas.hu/projects/TOUCAN/", "https://jira.codecool.codecanvas.hu/projects/JETI/", "https://jira.codecool.codecanvas.hu/projects/COALA/"})
    public void browseProject(String projectUrl) {
        ProjectPage projectPage = new ProjectPage(driver, projectUrl);
        projectPage.navigateToProjectPage();
    }

    @AfterEach
    public void close() {
        driver.quit();
    }
}
