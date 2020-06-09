package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BrowsIssueTest {
    private WebDriver driver;
    private final String driverPath = System.getenv("DRIVER_PATH");
    private final String driverName = System.getenv("DRIVER");
    private final String browserName = System.getenv("BROWSER");
    private LoginPage loginPage;
    private TestIssuePage testIssuePage;
    private WelcomePage welcomePage;
    private IssuesPage issuesPage;
    private ProjectIssuePages projectIssuePages;


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
        loginPage = new LoginPage(driver);
        loginPage.logIntoJira(System.getenv("USER_NAME"),System.getenv("PW"));
    }

    @Test
    public void accessAnIssuesPage(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/browse/MTP-123?jql=key%20%3D%20MTP-123");
        testIssuePage = new TestIssuePage(driver);
        Assertions.assertEquals("MTP-123", testIssuePage.getIssueName());
    }

    @Test
    public void accessAvailableIssues(){
        welcomePage = new WelcomePage(driver);
        welcomePage.navigateToIssuePage();
        issuesPage = new IssuesPage(driver);
        Assertions.assertEquals("Search", issuesPage.getPageName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issuePages.csv", numLinesToSkip = 1)
    public void accessGivenIssues(String pageURL, String issueName){
        driver.navigate().to(pageURL);
        projectIssuePages = new ProjectIssuePages(driver);
        Assertions.assertEquals(issueName, projectIssuePages.getIssueName());
    }


    @AfterEach
    public void quit(){
        driver.quit();
    }
}
