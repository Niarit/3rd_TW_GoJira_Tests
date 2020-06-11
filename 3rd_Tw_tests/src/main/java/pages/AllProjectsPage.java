package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProjectsPage {
    @FindBy(xpath = "//*[@id='browse_link']") private WebElement projects;
    @FindBy(id = "project_view_all_link_lnk") private WebElement allProjects;
    @FindBy(linkText = "Main Testing Project") private WebElement mainTestingProject;

    public AllProjectsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToAllProjects() {
        projects.click();
        allProjects.click();
        mainTestingProject.click();
    }
}
