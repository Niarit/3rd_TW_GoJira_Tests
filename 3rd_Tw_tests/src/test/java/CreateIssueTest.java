import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.BasePage;
import pages.CreatePage;
import pages.ProjectPage;
import pages.WelcomePage;

import java.net.MalformedURLException;


public class CreateIssueTest {

    private final BaseTest baseTest = new BaseTest();
    private BasePage basePage;

    public CreateIssueTest() throws MalformedURLException {
    }

    @BeforeEach
    public void setup() throws MalformedURLException {
        basePage = BasePage.getInstanceOfBasePage();
        basePage.setup();
        baseTest.loginToJira();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CreateIssueData.csv", numLinesToSkip = 1)
    public void createPlainIssue(String projectName, String issueType, String summary) throws MalformedURLException {
        CreatePage createPage = new CreatePage();
        WelcomePage welcomePage = new WelcomePage();
        ProjectPage projectPage = new ProjectPage();
        welcomePage.clickCreateBtn();
        createPage.fillProjectName(projectName);
        createPage.clickCreateDialog();
        createPage.fillIssueType(issueType);
        createPage.clickCreateDialog();
        createPage.fillSummary(summary);
        createPage.createIssue();
        createPage.clickNewIssueLink();
        Assertions.assertEquals(summary, projectPage.getSummary());
        createPage.clickMoreOptions();
        createPage.clickDeleteBtn();
        createPage.confirmDelete();
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/CreateIssueData.csv", numLinesToSkip = 1)
    public void cancelCreation(String projectName, String issueType, String summary) throws MalformedURLException {
        CreatePage createPage = new CreatePage();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickCreateBtn();
        createPage.fillSummary(summary);
        createPage.clickCreateDialog();
        createPage.cancelCreation();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ProjectData.csv", numLinesToSkip = 1)
    public void createIssueForProject(String projectName, String projectShortName) throws MalformedURLException {
        CreatePage createPage = new CreatePage();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickCreateBtn();
        createPage.fillProjectName(projectName);
        Assertions.assertEquals(projectShortName, createPage.getProjectValidationName());
        createPage.clickCreateDialog();
        createPage.tryIssueTypes();
    }



    @AfterEach
    public void close() {
        basePage.closeDriver();
    }
}
