package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class ReleasesPage {
    private BasePage basePage;
    private WebDriverWait wait;
    @FindBy(xpath = "//input[@placeholder='Version name']") private WebElement versionNameField;
    @FindBy(xpath = "//input[@placeholder='Start date (optional)']") private WebElement startDateField;
    @FindBy(xpath = "//input[@placeholder='Release date (optional)']") private WebElement releaseDateField;
    @FindBy(xpath = "//input[@placeholder='Description (optional)']")private WebElement descriptionField;
    @FindBy(xpath = "//button[@class='aui-button aui-button-primary']") private WebElement addBtn;
    @FindBy(xpath = "//a[@class='aui-button aui-button-subtle aui-button-compact aui-dropdown2-trigger aui-dropdown2-trigger-arrowless aui-style-default details-button']")
    private WebElement actionsBtn;
    @FindBy(xpath = "//a[@class='project-config-operations-delete']") private WebElement deleteBtn;
    @FindBy(id = "submit") private WebElement confirmBtn;
    @FindBy(xpath = "//a[@class='version-edit-dialog']") private WebElement editBtn;
    @FindBy(id = "version-name") private WebElement editNameField;
    @FindBy(id = "version-save-submit") private WebElement confirmEdit;

    public ReleasesPage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public void addVersionName(String name){
        versionNameField.sendKeys(name);
    }

    public void clickAddBtn(){
        addBtn.click();
    }

    public void deleteRelease(){
        actionsBtn.click();
        deleteBtn.click();
        wait = new WebDriverWait(basePage.getDriver(), Integer.parseInt(System.getenv("WAIT")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        confirmBtn.click();
    }

    public void clickEdit(){
        wait = new WebDriverWait(basePage.getDriver(), Integer.parseInt(System.getenv("WAIT")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='aui-button aui-button-subtle aui-button-compact aui-dropdown2-trigger aui-dropdown2-trigger-arrowless aui-style-default details-button']")));
        actionsBtn.click();
        editBtn.click();
    }

    public void renameVersion(String msg){
        wait = new WebDriverWait(basePage.getDriver(), Integer.parseInt(System.getenv("WAIT")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("version-name")));
        editNameField.sendKeys(Keys.DELETE);
        editNameField.sendKeys(msg);
    }

    public void confirmEdit(){
        confirmEdit.click();
    }

    public void navigateToPP1ReleasePage(){
        basePage.getDriver().navigate().to(System.getenv("BASE_URL") + "/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
    }

}
