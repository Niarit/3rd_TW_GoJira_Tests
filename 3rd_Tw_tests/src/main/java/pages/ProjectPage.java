package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {

    private final WebDriver driver;
    private String projectUrl;
    private String projectName;
    private final By byProjectName = By.linkText(projectName);


    public ProjectPage(WebDriver driver, String projectUrl, String projectName) {
        this.driver = driver;
        this.projectUrl = projectUrl;
        this.projectName = projectName;
    }

    public ProjectPage(WebDriver driver, String projectName) {
        this.driver = driver;
        this.projectName = projectName;
    }

    public void navigateToProjectPage() {
        driver.navigate().to(projectUrl);
    }


}
