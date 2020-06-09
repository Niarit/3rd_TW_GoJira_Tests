package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainTestingProjectPage;
import pages.ProjectIssuePages;

import java.util.concurrent.TimeUnit;

public class EditIssueTest {
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
    public void inlineEditTest(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/browse/MTP-1");
        mainTestingProjectPage = new MainTestingProjectPage(driver);
        mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple - test");
        Assertions.assertEquals("sfdg, a fine juicy apple - test", mainTestingProjectPage.getSummaryText());
        mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,0} )
    public void editIssueOnEditScreen(int option){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/secure/EditIssue!default.jspa?id=10033");
        mainTestingProjectPage = new MainTestingProjectPage(driver);
        mainTestingProjectPage.setSummeryOnEditScreen("sfdg, a fine juicy apple - test");
        if (option == 1){
            mainTestingProjectPage.clickUpdate();
            Assertions.assertEquals("sfdg, a fine juicy apple - test", mainTestingProjectPage.getSummaryText());
            mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple");
        } else if(option == 0){
            mainTestingProjectPage.clickCancel();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert");
            //Todo ask about "IPDL protocol error: Handler returned error code!"
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/editIssueData.csv", numLinesToSkip = 1)
    public void checkEditOnGivenIssues(String issueUrl){
        driver.navigate().to(issueUrl);
        ProjectIssuePages projectIssuePages = new ProjectIssuePages(driver);
        projectIssuePages.isEditBtnPresent();
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }
}
