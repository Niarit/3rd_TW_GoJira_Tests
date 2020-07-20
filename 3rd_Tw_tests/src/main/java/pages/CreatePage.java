package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class CreatePage {

    private final String[] issueTypes = {"Bug", "Task", "Story"};
    private final WebDriver driver;
    @FindBy(id = "project-field") private WebElement byProjectName;
    @FindBy(id = "issuetype-field") private WebElement byIssueType;
    @FindBy(id = "summary") private WebElement bySummary;
    @FindBy(id = "create-issue-submit") private WebElement createBtn;
    @FindBy(xpath = "//a[@class='cancel']") private WebElement cancelBtn;
    @FindBy(className = "error") private WebElement errorMsg;
    @FindBy(id = "project-options") private WebElement projectOptions;
    @FindBy(id = "create-issue-dialog") private WebElement createIssueDialog;
    @FindBy(xpath = "//a[@class='issue-created-key issue-link']") private WebElement newIssueLink;
    @FindBy(id = "opsbar-operations_more") private WebElement moreOptions;
    @FindBy(xpath = "//aui-item-link[@id='delete-issue']//a") private WebElement deleteIssue;
    @FindBy(id = "delete-issue-submit") private WebElement deleteConfirm;


    public CreatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillProjectName(String projectName) {
        byProjectName.click();
        byProjectName.sendKeys(Keys.DELETE);
        byProjectName.sendKeys(projectName);
        //driver.findElement(byProjectName).sendKeys(Keys.ENTER);
    }

    public void fillIssueType(String issueType) {
        byIssueType.click();
        byIssueType.sendKeys(Keys.DELETE);
        byIssueType.sendKeys(issueType);
        byIssueType.sendKeys(Keys.ENTER);
    }

    public void fillSummary(String summary) {
        bySummary.click();
        bySummary.sendKeys(Keys.DELETE);
        bySummary.sendKeys(summary);


    }

    public void createIssue() {
        createBtn.click();
    }

    public void cancelCreation() {
        cancelBtn.click();
        driver.switchTo().alert().accept();
    }

    public boolean isProjectAvailable(String testedProjectName) {
        return byProjectName.getAttribute("aria-activedescendant").contains(testedProjectName);
    }

    public void clickNewIssueLink() {
        newIssueLink.click();
    }

    public void clickMoreOptions() {
        moreOptions.click();
    }

    public void clickDeleteBtn() {
        deleteIssue.click();
    }

    public void confirmDelete() {
        deleteConfirm.click();
    }

    public String getProjectValidationName() {
        int length = byProjectName.getAttribute("aria-activedescendant").indexOf("-");
        return byProjectName.getAttribute("aria-activedescendant").substring(0,length);
    }

    public void tryIssueTypes() {
        for (String issueType : issueTypes) {
            createIssueDialog.click();
            byIssueType.click();
            byIssueType.sendKeys(Keys.DELETE);
            byIssueType.sendKeys(issueType);
        }
    }


    public void clickCreateDialog() {
        createIssueDialog.click();
    }
}
