import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AllProjectsPage;
import pages.ProjectPage;
import tests.BaseTest;

public class BrowseProjectTest {
    private final BaseTest baseTest = new BaseTest();

    @BeforeEach
    public void setup(){
        baseTest.setup();
        baseTest.loginToJira();
    }

    @Test
    public void browseAllProjects() {
        AllProjectsPage allProjectsPage = new AllProjectsPage(baseTest.getDriver());
        ProjectPage projectPage = new ProjectPage(baseTest.getDriver());
        allProjectsPage.navigateToAllProjects();
        Assertions.assertEquals("Main Testing Project", projectPage.getProjectName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"https://jira.codecool.codecanvas.hu/projects/TOUCAN", "https://jira.codecool.codecanvas.hu/projects/JETI", "https://jira.codecool.codecanvas.hu/projects/COALA"})
    public void browseProject(String projectUrl){
        ProjectPage projectPage = new ProjectPage(baseTest.getDriver(), projectUrl);
        projectPage.navigateToProjectPage();
        String projectName = projectUrl.substring(45);
        Assertions.assertTrue(projectPage.getProjectName().contains(projectName));
    }

    @AfterEach
    public void close() {
        baseTest.close();
    }
}
