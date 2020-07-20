import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainTestingProjectPage;
import pages.ProjectIssuePages;

public class EditIssueTest {
    private MainTestingProjectPage mainTestingProjectPage;
    private final BaseTest baseTest = new BaseTest();


    @BeforeEach
    public void setup(){
        baseTest.setup();
        baseTest.loginToJira();
    }

    @Test
    public void inlineEditTest(){
        mainTestingProjectPage = new MainTestingProjectPage(baseTest.getDriver());
        mainTestingProjectPage.navigateToMTP1Issue();
        mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple - test");
        Assertions.assertEquals("sfdg, a fine juicy apple - test", mainTestingProjectPage.getSummaryText());
        mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1} )
    public void editIssueOnEditScreen(int option){
        mainTestingProjectPage = new MainTestingProjectPage(baseTest.getDriver());
        mainTestingProjectPage.navigateToIssuesEditPage();
        mainTestingProjectPage.setSummeryOnEditScreen("sfdg, a fine juicy apple - test");
        if (option == 1){
            mainTestingProjectPage.clickUpdate();
            Assertions.assertEquals("sfdg, a fine juicy apple - test", mainTestingProjectPage.getSummaryText());
            mainTestingProjectPage.setSummaryTo("sfdg, a fine juicy apple");
        } else if(option == 0){
            mainTestingProjectPage.clickCancel();
            WebDriverWait wait = new WebDriverWait(baseTest.getDriver(), 5);
            wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert");
            //Todo ask about "IPDL protocol error: Handler returned error code!"
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/editIssueData.csv", numLinesToSkip = 1)
    public void checkEditOnGivenIssues(String issueUrl){
        baseTest.getDriver().navigate().to(issueUrl);
        ProjectIssuePages projectIssuePages = new ProjectIssuePages(baseTest.getDriver());
        projectIssuePages.isEditBtnPresent();
    }

    @AfterEach
    public void quit(){
        baseTest.close();
    }
}
