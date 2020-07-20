import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;


public class BrowsIssueTest {
    private final BaseTest baseTest = new BaseTest();


    @BeforeEach
    public void setup(){
        baseTest.setup();
        baseTest.loginToJira();
    }

    @Test
    public void accessAnIssuesPage(){
        TestIssuePage testIssuePage = new TestIssuePage(baseTest.getDriver());
        testIssuePage.navigateToTestIssuePage();
        Assertions.assertEquals("MTP-123", testIssuePage.getIssueName());
    }

    @Test
    public void accessAvailableIssues(){
        WelcomePage welcomePage = new WelcomePage(baseTest.getDriver());
        welcomePage.navigateToIssuePage();
        IssuesPage issuesPage = new IssuesPage(baseTest.getDriver());
        Assertions.assertEquals("Search", issuesPage.getPageName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issuePages.csv", numLinesToSkip = 1)
    public void accessGivenIssues(String pageURL, String issueName){
        baseTest.getDriver().navigate().to(pageURL);
        ProjectIssuePages projectIssuePages = new ProjectIssuePages(baseTest.getDriver());
        Assertions.assertEquals(issueName, projectIssuePages.getIssueName());
    }


    @AfterEach
    public void quit(){
        baseTest.close();
    }
}
