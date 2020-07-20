import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.CreatePage;
import pages.ProjectPage;
import pages.WelcomePage;
import tests.BaseTest;

public class CreateIssueTest {

    private final BaseTest baseTest = new BaseTest();

    @BeforeEach
    public void setup(){
        baseTest.setup();
        baseTest.loginToJira();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CreateIssueData.csv", numLinesToSkip = 1)
    public void createPlainIssue(String projectName, String issueType, String summary) {
        CreatePage createPage = new CreatePage(baseTest.getDriver());
        WelcomePage welcomePage = new WelcomePage(baseTest.getDriver());
        ProjectPage projectPage = new ProjectPage(baseTest.getDriver());
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
    public void cancelCreation(String projectName, String issueType, String summary) {
        CreatePage createPage = new CreatePage(baseTest.getDriver());
        WelcomePage welcomePage = new WelcomePage(baseTest.getDriver());
        welcomePage.clickCreateBtn();
        createPage.fillSummary(summary);
        createPage.clickCreateDialog();
        createPage.cancelCreation();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ProjectData.csv", numLinesToSkip = 1)
    public void createIssueForProject(String projectName, String projectShortName) {
        CreatePage createPage = new CreatePage(baseTest.getDriver());
        WelcomePage welcomePage = new WelcomePage(baseTest.getDriver());
        welcomePage.clickCreateBtn();
        createPage.fillProjectName(projectName);
        Assertions.assertEquals(projectShortName, createPage.getProjectValidationName());
        createPage.clickCreateDialog();
        createPage.tryIssueTypes();
    }



    @AfterEach
    public void close() {
        baseTest.close();
    }
}
