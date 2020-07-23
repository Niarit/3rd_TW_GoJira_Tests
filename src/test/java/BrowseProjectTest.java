import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AllProjectsPage;
import pages.BasePage;
import pages.ProjectPage;

import java.net.MalformedURLException;

public class BrowseProjectTest {
    private BasePage basePage;
    private final BaseTest baseTest = new BaseTest();

    public BrowseProjectTest() throws MalformedURLException {
    }

    @BeforeEach
    public void setup() throws MalformedURLException {
        basePage = BasePage.getInstanceOfBasePage();
        basePage.setup();
        baseTest.loginToJira();
    }

    @Test
    public void browseAllProjects() throws MalformedURLException {
        AllProjectsPage allProjectsPage = new AllProjectsPage();
        ProjectPage projectPage = new ProjectPage();
        allProjectsPage.navigateToAllProjects();
        Assertions.assertEquals("Main Testing Project", projectPage.getProjectName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"https://jira.codecool.codecanvas.hu/projects/TOUCAN", "https://jira.codecool.codecanvas.hu/projects/JETI", "https://jira.codecool.codecanvas.hu/projects/COALA"})
    public void browseProject(String projectUrl) throws MalformedURLException {
        ProjectPage projectPage = new ProjectPage();
        projectPage.navigateToProjectPage(projectUrl);
        String projectName = projectUrl.substring(45);
        Assertions.assertTrue(projectPage.getProjectName().contains(projectName));
    }

    @AfterEach
    public void close() {
        basePage.closeDriver();
    }
}
