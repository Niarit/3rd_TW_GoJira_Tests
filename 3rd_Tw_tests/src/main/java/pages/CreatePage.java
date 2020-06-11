package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePage {

    private final String[] issueTypes = {"Bug", "Task", "Story"};
    private final WebDriver driver;
    private final By byProjectName = By.id("project-field");
    private final By byIssueType = By.id("issuetype-field");
    private final By bySummary = By.id("summary");
    private final By createBtn = By.id("create-issue-submit");
    private final By cancelBtn = By.xpath("//a[@class='cancel']");
    private final By errorMsg = By.className("error");
    private final By projectOptions = By.id("project-options");
    private final By createIssueDialog = By.id("create-issue-dialog");
    private final By newIssueLink = By.xpath("//a[@class='issue-created-key issue-link']");
    private final By moreOptions = By.id("opsbar-operations_more");
    private final By deleteIssue = By.xpath("//aui-item-link[@id='delete-issue']//a");
    private final By deleteConfirm = By.id("delete-issue-submit");

    public CreatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillProjectName(String projectName) {
        driver.findElement(byProjectName).click();
        driver.findElement(byProjectName).sendKeys(Keys.DELETE);
        driver.findElement(byProjectName).sendKeys(projectName);
        //driver.findElement(byProjectName).sendKeys(Keys.ENTER);
    }

    public void fillIssueType(String issueType) {
        driver.findElement(byIssueType).click();
        driver.findElement(byIssueType).sendKeys(Keys.DELETE);
        driver.findElement(byIssueType).sendKeys(issueType);
        driver.findElement(byIssueType).sendKeys(Keys.ENTER);
    }

    public void fillSummary(String summary) {
        driver.findElement(bySummary).click();
        driver.findElement(bySummary).sendKeys(Keys.DELETE);
        driver.findElement(bySummary).sendKeys(summary);


    }

    public void createIssue() {
        driver.findElement(createBtn).click();
    }

    public void clickCreateDialog() {
        driver.findElement(createIssueDialog).click();
    }

    public void cancelCreation() {
        driver.findElement(cancelBtn).click();
        driver.switchTo().alert().accept();
    }

    public boolean isProjectAvailable(String testedProjectName) {
        return driver.findElement(byProjectName).getAttribute("aria-activedescendant").contains(testedProjectName);
    }

    public void clickNewIssueLink() {
        driver.findElement(newIssueLink).click();
    }

    public void clickMoreOptions() {
        driver.findElement(moreOptions).click();
    }

    public void clickDeleteBtn() {
        driver.findElement(deleteIssue).click();
    }

    public void confirmDelete() {
        driver.findElement(deleteConfirm).click();
    }

    public String getProjectValidationName() {
        int length = driver.findElement(byProjectName).getAttribute("aria-activedescendant").indexOf("-");
        return driver.findElement(byProjectName).getAttribute("aria-activedescendant").substring(0,length);
    }

    public void tryIssueTypes() {
        for (String issueType : issueTypes) {
            driver.findElement(createIssueDialog).click();
            driver.findElement(byIssueType).click();
            driver.findElement(byIssueType).sendKeys(Keys.DELETE);
            driver.findElement(byIssueType).sendKeys(issueType);
            if (!driver.findElement(byIssueType).getAttribute("aria-activedescendant").equals("null")) {
                driver.findElement(byIssueType).sendKeys(Keys.ENTER);
                driver.findElement(createIssueDialog).click();
            }
        }
    }



}
