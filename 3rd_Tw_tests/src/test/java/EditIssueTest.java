import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.MainTestingProjectPage;
import pages.ProjectIssuePages;

import java.net.MalformedURLException;


public class EditIssueTest {
    private MainTestingProjectPage mainTestingProjectPage;
    private final BaseTest baseTest = new BaseTest();
    private BasePage basePage;

    public EditIssueTest() throws MalformedURLException {
    }


    @BeforeEach
    public void setup() throws MalformedURLException {
        basePage = BasePage.getInstanceOfBasePage();
        basePage.setup();
        baseTest.loginToJira();
    }

    @Test
    public void inlineEditTest() throws MalformedURLException {
        mainTestingProjectPage = new MainTestingProjectPage();
        mainTestingProjectPage.navigateToMTP1Issue();
        mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple - test");
        Assertions.assertEquals("sfdg, a fine juicy apple - test", mainTestingProjectPage.getSummaryText());
        mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1} )
    public void editIssueOnEditScreen(int option) throws MalformedURLException {
        mainTestingProjectPage = new MainTestingProjectPage();
        mainTestingProjectPage.navigateToIssuesEditPage();
        mainTestingProjectPage.setSummeryOnEditScreen("sfdg, a fine juicy apple - test");
        if (option == 1){
            mainTestingProjectPage.clickUpdate();
            Assertions.assertEquals("sfdg, a fine juicy apple - test", mainTestingProjectPage.getSummaryText());
            mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple");
        } else if(option == 0){
            mainTestingProjectPage.clickCancel();
            WebDriverWait wait = new WebDriverWait(basePage.getDriver(), 5);
            wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert");
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/editIssueData.csv", numLinesToSkip = 1)
    public void checkEditOnGivenIssues(String issueUrl) throws MalformedURLException {
        basePage.getDriver().navigate().to(issueUrl);
        ProjectIssuePages projectIssuePages = new ProjectIssuePages();
        projectIssuePages.isEditBtnPresent();
    }

    @AfterEach
    public void quit(){
        basePage.closeDriver();
    }
}
