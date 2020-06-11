package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlassPage {
    private final WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),'Permissions')]") private WebElement glassPermissionsTab;
    @FindBy(xpath = "//div[@id='glass-permissions-panel']//tr[5]//td[3]//div[1]") private WebElement browseProjectGlassPermission;
    @FindBy(xpath = "//tr[8]//td[3]//div[1]") private WebElement createIssueGlassPermission;
    @FindBy(xpath = "//tr[18]//td[3]//div[1]") private WebElement editIssueGlassPermission;
    @FindBy(xpath = "//a[@id='aui-uid-1']") private WebElement versionsTab;
    @FindBy(xpath = "//div[@id='glass-general-versions-panel']//tr[2]//td[1]") private WebElement latestRelease;


    public GlassPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToGlassPermissions(){
        glassPermissionsTab.click();
    }

    public void navigateToGlassVersions(){
        versionsTab.click();
    }

    public List<String> getGlassPermissions(){
        List<String> glassPermissions = Arrays.asList(browseProjectGlassPermission.getAttribute("class"),
                createIssueGlassPermission.getAttribute("class"),
                editIssueGlassPermission.getAttribute("class"));
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
        return latestRelease.getText();
    }

    public void navigateToGlassPage(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.codecanvas.glass:glass");
    }

}
