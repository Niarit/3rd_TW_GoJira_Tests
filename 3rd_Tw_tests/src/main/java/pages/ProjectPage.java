package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

    private final WebDriver driver;
    private String projectUrl;
    @FindBy(id = "project-name-val") private WebElement ProjectName;
    private final By ProjectName = By.id("project-name-val");
    private final By summary = By.id("summary-val");

    public ProjectPage(WebDriver driver, String projectUrl) {
        this.driver = driver;
        this.projectUrl = projectUrl;
    }

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToProjectPage() {
        driver.navigate().to(projectUrl);
    }

    public String getProjectName() {
        return ProjectName.getText();
    }
}
