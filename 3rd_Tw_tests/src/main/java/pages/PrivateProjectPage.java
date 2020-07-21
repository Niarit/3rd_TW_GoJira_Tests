package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

public class PrivateProjectPage {
    private BasePage basePage;
    @FindBy(xpath = "//tr[@data-permission-key='BROWSE_PROJECTS']/td[@data-headers='security-type']/dl[@class='types']/dd") private WebElement browseProjectPermission;
    @FindBy(xpath = "//tr[@data-permission-key='CREATE_ISSUES']/td[@data-headers='security-type']/dl[@class='types']/dd") private WebElement createIssuePermission;
    @FindBy(xpath = "//tr[@data-permission-key='EDIT_ISSUES']/td[@data-headers='security-type']/dl[@class='types']/dd") private WebElement editIssuePermission;

    public PrivateProjectPage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(),this);
    }


    public List<String> getPermissions(){
        return Arrays.asList(browseProjectPermission.getText(),
                createIssuePermission.getText(),
                editIssuePermission.getText());
    }

    public void navigateToPP1Permissions(){
        basePage.getDriver().navigate().to("https://jira.codecool.codecanvas.hu/plugins/servlet/project-config/PP1/permissions");
    }

}
