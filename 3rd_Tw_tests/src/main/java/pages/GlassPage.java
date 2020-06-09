package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GlassPage {
    private WebDriver driver;
    private By glassPermissionsTab = By.xpath("//a[contains(text(),'Permissions')]");
    private By browseProjectGlassPermission = By.xpath("//div[@id='glass-permissions-panel']//tr[5]//td[3]//div[1]");
    private By createIssueGlassPermission = By.xpath("//tr[8]//td[3]//div[1]");
    private By editIssueGlassPermission = By.xpath("//tr[18]//td[3]//div[1]");
    private By versionsTab = By.xpath("//a[@id='aui-uid-1']");


    public GlassPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToGlassPermissions(){
        driver.findElement(glassPermissionsTab).click();
    }

    public void navigateToGlassVersions(){
        driver.findElement(versionsTab).click();
    }

    public String getGlassPermissionForBrowseProject(){
        if (driver.findElement(browseProjectGlassPermission).getAttribute("class").equals("glass-true-icon")){
            return "Any logged in user";
        }
        return "Administrators";
    }

    public String getGlassPermissionForCreateIssue(){
        if (driver.findElement(createIssueGlassPermission).getAttribute("class").equals("glass-true-icon")){
            return "Any logged in user";
        }
        return "Administrators";
    }

    public String getGlassPermissionForEditIssue(){
        if (driver.findElement(editIssueGlassPermission).getAttribute("class").equals("glass-true-icon")){
            return "Any logged in user";
        }
        return "Administrators";
    }
}
