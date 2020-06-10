package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class PrivateProjectPage {
    private final WebDriver driver;
    private final By browseProjectPermission = By.xpath("//tr[@data-permission-key='BROWSE_PROJECTS']/td[@data-headers='security-type']/dl[@class='types']/dd");
    private final By createIssuePermission = By.xpath("//tr[@data-permission-key='CREATE_ISSUES']/td[@data-headers='security-type']/dl[@class='types']/dd");
    private final By editIssuePermission = By.xpath("//tr[@data-permission-key='EDIT_ISSUES']/td[@data-headers='security-type']/dl[@class='types']/dd");

    public PrivateProjectPage(WebDriver driver) {
        this.driver = driver;
    }


    public List<String> getPermissions(){
        System.out.println(driver.findElement(browseProjectPermission).getText());
        return Arrays.asList(driver.findElement(browseProjectPermission).getText(),
                driver.findElement(createIssuePermission).getText(),
                driver.findElement(editIssuePermission).getText());
    }

    public void navigateToPP1Permissions(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/plugins/servlet/project-config/PP1/permissions");
    }

}
