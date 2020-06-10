package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

    private final WebDriver driver;
    private final By profilePic = By.xpath("//span[@class='aui-avatar aui-avatar-small']");
    private final By logoutBtn = By.id("log_out");
    private final By issuesDrpd = By.id("find_link");
    private final By searchForIssue = By.id("issues_new_search_link_lnk");
    private WebDriverWait wait;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOutOfJira(){
        driver.findElement(profilePic).click();
        driver.findElement(logoutBtn).click();
    }

    public void navigateToIssuePage(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(issuesDrpd));
        driver.findElement(issuesDrpd).click();
        driver.findElement(searchForIssue).click();
    }
}
