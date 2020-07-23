import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

import java.net.MalformedURLException;


public class BrowsIssueTest {
    private final BaseTest baseTest = new BaseTest();
    private BasePage basePage;

    public BrowsIssueTest() throws MalformedURLException {
    }


    @BeforeEach
    public void setup() throws MalformedURLException {
        basePage = BasePage.getInstanceOfBasePage();
        basePage.setup();
        baseTest.loginToJira();
    }

    @Test
    public void accessAnIssuesPage() throws MalformedURLException {
        TestIssuePage testIssuePage = new TestIssuePage();
        testIssuePage.navigateToTestIssuePage();
        Assertions.assertEquals("MTP-123", testIssuePage.getIssueName());
    }

    @Test
    public void accessAvailableIssues() throws MalformedURLException {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.navigateToIssuePage();
        IssuesPage issuesPage = new IssuesPage();
        Assertions.assertEquals("Search", issuesPage.getPageName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issuePages.csv", numLinesToSkip = 1)
    public void accessGivenIssues(String pageURL, String issueName) throws MalformedURLException {
        basePage.getDriver().navigate().to(pageURL);
        ProjectIssuePages projectIssuePages = new ProjectIssuePages();
        if(projectIssuePages.checkForPageTitle()){
            Assertions.assertEquals(issueName, projectIssuePages.getIssueName());
        } else {
            Assertions.assertTrue(projectIssuePages.checkForPageTitle());
        }
    }


    @AfterEach
    public void quit(){
        basePage.closeDriver();
    }
}
