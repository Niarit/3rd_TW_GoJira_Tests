package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class PrivateProjectPage {
    private final WebDriver driver;
    private final By browseProjectPermission = By.xpath("//div[@id='project-config-panel-permissions']//div[1]//table[1]//tbody[1]//tr[2]//td[2]//dl[1]//dd[1]");
    private final By createIssuePermission = By.xpath("//div[@class='aui-page-panel']//div[2]//table[1]//tbody[1]//tr[4]//td[2]//dl[1]//dd[1]");
    private final By editIssuePermission = By.xpath("//div[@class='aui-page-panel']//div[2]//table[1]//tbody[1]//tr[6]//td[2]//dl[1]//dd[1]");

    public PrivateProjectPage(WebDriver driver) {
        this.driver = driver;
    }


    public List<String> getPermissions(){
        return Arrays.asList(driver.findElement(browseProjectPermission).getText(),
                driver.findElement(createIssuePermission).getText(),
                driver.findElement(editIssuePermission).getText());
    }

    public void navigateToPP1Permissions(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/plugins/servlet/project-config/PP1/permissions");
    }

}
