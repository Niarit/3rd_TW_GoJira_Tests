package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PermissionsPage {
    private WebDriver driver;
    private By browseProjectPermission = By.xpath("//div[@id='project-config-panel-permissions']//div[1]//table[1]//tbody[1]//tr[2]//td[2]//dl[1]//dd[1]");
    private By createIssuePermission = By.xpath("//div[@class='aui-page-panel']//div[2]//table[1]//tbody[1]//tr[4]//td[2]//dl[1]//dd[1]");
    private By editIssuePermission = By.xpath("//div[@class='aui-page-panel']//div[2]//table[1]//tbody[1]//tr[6]//td[2]//dl[1]//dd[1]");

    public PermissionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBrowseProjectPermission(){
        return driver.findElement(browseProjectPermission).getText();
    }

    public String getCreateIssuePermission(){
        return driver.findElement(createIssuePermission).getText();
    }

    public String getEditIssuePermission(){
        return driver.findElement(editIssuePermission).getText();
    }
}
