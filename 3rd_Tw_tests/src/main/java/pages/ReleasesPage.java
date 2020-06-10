package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReleasesPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    private final By versionNameField = By.xpath("//input[@placeholder='Version name']");
    private final By startDateField = By.xpath("//input[@placeholder='Start date (optional)']");
    private final By releaseDateField = By.xpath("//input[@placeholder='Release date (optional)']");
    private final By descriptionField = By.xpath("//input[@placeholder='Description (optional)']");
    private final By addBtn = By.xpath("//button[@class='aui-button aui-button-primary']");
    private final By actionsBtn = By.xpath("//a[@class='aui-button aui-button-subtle aui-button-compact aui-dropdown2-trigger aui-dropdown2-trigger-arrowless aui-style-default details-button']");
    private final By deleteBtn = By.xpath("//a[@class='project-config-operations-delete']");
    private final By confirmBtn = By.id("submit");
    private final By editBtn = By.xpath("//a[@class='version-edit-dialog']");
    private final By editNameField = By.id("version-name");
    private final By confirmEdit = By.id("version-save-submit");

    public ReleasesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addVersionName(String name){
        driver.findElement(versionNameField).sendKeys(name);
    }

    public void clickAddBtn(){
        driver.findElement(addBtn).click();
    }

    public void deleteRelease(){
        driver.findElement(actionsBtn).click();
        driver.findElement(deleteBtn).click();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBtn));
        driver.findElement(confirmBtn).click();
    }

    public void clickEdit(){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(actionsBtn));
        driver.findElement(actionsBtn).click();
        driver.findElement(editBtn).click();
    }

    public void renameVersion(String msg){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(editNameField));
        WebElement nameField = driver.findElement(editNameField);
        nameField.sendKeys(Keys.DELETE);
        nameField.sendKeys(msg);
    }

    public void confirmEdit(){
        driver.findElement(confirmEdit).click();
    }

    public void navigateToPP1ReleasePage(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
    }
}
