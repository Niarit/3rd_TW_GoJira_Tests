package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlassPage {
    private final WebDriver driver;
    private final By glassPermissionsTab = By.xpath("//a[contains(text(),'Permissions')]");
    private final By browseProjectGlassPermission = By.xpath("//div[@id='glass-permissions-panel']//tr[5]//td[3]//div[1]");
    private final By createIssueGlassPermission = By.xpath("//tr[8]//td[3]//div[1]");
    private final By editIssueGlassPermission = By.xpath("//tr[18]//td[3]//div[1]");
    private final By versionsTab = By.xpath("//a[@id='aui-uid-1']");
    private final By latestRelease = By.xpath("//div[@id='glass-general-versions-panel']//tr[2]//td[1]");


    public GlassPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToGlassPermissions(){
        driver.findElement(glassPermissionsTab).click();
    }

    public void navigateToGlassVersions(){
        driver.findElement(versionsTab).click();
    }

    public List<String> getGlassPermissions(){
        List<String> glassPermissions = Arrays.asList(driver.findElement(browseProjectGlassPermission).getAttribute("class"),
                driver.findElement(createIssueGlassPermission).getAttribute("class"),
                driver.findElement(editIssueGlassPermission).getAttribute("class"));
        List<String> translatedGlassPermissions = new ArrayList<String>();
        for (String permission :
                glassPermissions) {
            if (permission.equals("glass-true-icon")) {
                translatedGlassPermissions.add("Any logged in user");
            } else {
                translatedGlassPermissions.add("Administrator");
            }
        }
        return translatedGlassPermissions;
    }

    public String getLatestReleaseName(){
        return driver.findElement(latestRelease).getText();
    }

    public void navigateToGlassPage(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.codecanvas.glass:glass");
    }

}
