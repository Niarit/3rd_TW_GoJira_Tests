package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class AllProjectsPage {
    private BasePage basePage;
    @FindBy(xpath = "//*[@id='browse_link']") private WebElement projects;
    @FindBy(id = "project_view_all_link_lnk") private WebElement allProjects;
    @FindBy(linkText = "Main Testing Project") private WebElement mainTestingProject;

    public AllProjectsPage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public void navigateToAllProjects() {
        projects.click();
        allProjects.click();
        mainTestingProject.click();
    }

}
