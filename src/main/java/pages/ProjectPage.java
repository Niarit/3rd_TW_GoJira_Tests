package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class ProjectPage {

    private BasePage basePage;
    private String projectUrl;
    @FindBy(id = "project-name-val") private WebElement ProjectName;
    @FindBy(id = "summary-val") private WebElement summary;

    public ProjectPage(String projectUrl) throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        this.projectUrl = projectUrl;
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public ProjectPage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public void navigateToProjectPage(String projectUrl) {
        basePage.getDriver().navigate().to(projectUrl);
    }

    public String getProjectName() {
        return ProjectName.getText();
    }


    public String getSummary() {
        return summary.getText();
    }
}

