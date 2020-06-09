package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllProjectsPage {
    private final WebDriver driver;
    private final By projects = By.xpath("//*[@id='browse_link']");
    private final By allProjects = By.id("project_view_all_link_lnk");
    private final By mainTestingProject = By.linkText("Main Testing Project");

    public AllProjectsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAllProjects() {
        driver.findElement(projects).click();
        driver.findElement(allProjects).click();
        driver.findElement(mainTestingProject).click();
    }
}
