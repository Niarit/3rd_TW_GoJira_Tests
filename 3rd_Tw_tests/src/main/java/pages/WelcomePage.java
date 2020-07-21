package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class WelcomePage {

    private BasePage basePage;
    @FindBy(xpath = "//span[@class='aui-avatar aui-avatar-small']") private WebElement profilePic;
    @FindBy(id = "log_out") private WebElement logoutBtn;
    @FindBy(id = "find_link") private WebElement issuesDrpd;
    @FindBy(id = "issues_new_search_link_lnk") private WebElement searchForIssue;
    @FindBy(id = "create_link") private WebElement createBtn;
    private WebDriverWait wait;

    public WelcomePage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public void logOutOfJira(){
        profilePic.click();
        logoutBtn.click();
    }

    public void navigateToIssuePage(){
        wait = new WebDriverWait(basePage.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("find_link")));
        issuesDrpd.click();
        searchForIssue.click();
    }

    public void waitForProfilePic(){
        wait = new WebDriverWait(basePage.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
    }

    public void clickCreateBtn() {
        createBtn.click();
    }
}
