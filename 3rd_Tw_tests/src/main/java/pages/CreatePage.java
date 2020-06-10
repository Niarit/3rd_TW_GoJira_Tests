package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatePage {

    private final WebDriver driver;
    private final By byProjectName = By.id("project-field");
    private final By byIssueType = By.id("issuetype-field");
    private final By bySummary = By.id("summary");
    private final By createBtn = By.id("create-issue-submit");
    private final By cancelBtn = By.className("cancel");
    private final By errorMsg = By.className("error");
    private final By projectOptions = By.id("project-options");

    private String projectName;
    private String issueType;
    private String summary;

    public CreatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFieldsOfNewIssue() {
        driver.findElement(byProjectName).sendKeys(projectName);
        driver.findElement(byIssueType).sendKeys(issueType);
        driver.findElement(bySummary).sendKeys(summary);
    }

    public void createIssue() {
        driver.findElement(createBtn).click();
    }

    public void cancelCreation() {
        driver.findElement(cancelBtn).click();
    }

    public boolean isProjectAvailable(String testedProjectName) {
        return driver.findElement(byProjectName).getAttribute("aria-activedescendant").contains(testedProjectName);
    }
}
