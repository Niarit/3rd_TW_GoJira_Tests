package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage {

    private final WebDriver driver;
    @FindBy(id = "project-field") private WebElement byProjectName;
    @FindBy(id = "issuetype-field") private WebElement byIssueType;
    @FindBy(id = "summary") private WebElement bySummary;
    @FindBy(id = "create-issue-submit") private WebElement createBtn;
    @FindBy(className = "cancel") private WebElement cancelBtn;
    @FindBy(className = "error") private WebElement errorMsg;
    @FindBy(id = "project-options") private WebElement projectOptions;

    private String projectName;
    private String issueType;
    private String summary;

    public CreatePage(WebDriver driver, String projectName, String issueType, String summary) {
        this.driver = driver;
        this.projectName = projectName;
        this.issueType = issueType;
        this.summary = summary;
        PageFactory.initElements(driver, this);
    }

    public void fillFieldsOfNewIssue() {
        byProjectName.sendKeys(projectName);
        byIssueType.sendKeys(issueType);
        bySummary.sendKeys(summary);
    }

    public void createIssue() {
        createBtn.click();
    }

    public void cancelCreation() {
        cancelBtn.click();
    }

    public boolean isProjectAvailable(String testedProjectName) {
        return byProjectName.getAttribute("aria-activedescendant").contains(testedProjectName);
    }
}
