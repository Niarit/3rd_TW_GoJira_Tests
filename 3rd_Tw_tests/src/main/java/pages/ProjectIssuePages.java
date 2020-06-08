package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectIssuePages {
    private WebDriver driver;
    private By projetcName = By.id("project-name-val");

    public ProjectIssuePages(WebDriver driver) {
        this.driver = driver;
    }

    public void checkProjectName(String expectedName){
        String actualName = driver.findElement(projetcName).getText();
        Assertions.assertEquals(expectedName, actualName);
    }
}
