package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {

    private final WebDriver driver;
    private String projectUrl;
    private final By ProjectName = By.id("project-name-val");

    public ProjectPage(WebDriver driver, String projectUrl) {
        this.driver = driver;
        this.projectUrl = projectUrl;
    }

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToProjectPage() {
        driver.navigate().to(projectUrl);
    }

    public String getProjectName() {
        return driver.findElement(ProjectName).getText();
    }
}
