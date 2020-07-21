package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class MainTestingProjectPage {
    private BasePage basePage;
    @FindBy(xpath = "//h1[@id='summary-val']//span[@class='overlay-icon aui-icon aui-icon-small aui-iconfont-edit']") private WebElement summeryEditBtn;
    @FindBy(id = "summary-val") private WebElement summery;
    @FindBy(id = "edit-issue") private WebElement editBtn;
    @FindBy(id = "summary") private WebElement editScreenSummery;
    @FindBy(xpath = "//input[@id='issue-edit-submit']") private WebElement updateBtn;
    @FindBy(id = "issue-edit-cancel") private WebElement cancel;
    @FindBy(xpath = "//button[@class='aui-button submit']") private WebElement editScreenSubmit;

    public MainTestingProjectPage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public void setSummaryTo(String msg){
        WebDriverWait wait = new WebDriverWait(basePage.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary-val")));
        summeryEditBtn.click();
        editScreenSummery.sendKeys(Keys.DELETE);
        editScreenSummery.sendKeys(msg);
        editScreenSubmit.click();
    }

    public String getSummaryText(){
        return summery.getText();
    }

    public void clickEdit(){
        editBtn.click();
    }

    public void setSummeryOnEditScreen(String msg){
        editScreenSummery.sendKeys(Keys.DELETE);
        editScreenSummery.sendKeys(msg);
    }

    public void clickUpdate(){
        updateBtn.click();
    }

    public void clickCancel(){
        cancel.click();
    }

    public void navigateToMTP1Issue(){
       basePage.getDriver().navigate().to("https://jira.codecool.codecanvas.hu/browse/MTP-1");
    }

    public void navigateToIssuesEditPage(){
        basePage.getDriver().navigate().to("https://jira.codecool.codecanvas.hu/secure/EditIssue!default.jspa?id=10033");
    }

}
