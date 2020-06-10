package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// POM for the specified projects' issue pages

public class ProjectIssuePages {
    private final WebDriver driver;
    private final By issueName = By.id("key-val");
    private final By editBtn = By.id("edit-issue");

    public ProjectIssuePages(WebDriver driver) {
        this.driver = driver;
    }

    public String getIssueName(){
        return driver.findElement(issueName).getText();
    }

    public void isEditBtnPresent(){
        Assertions.assertEquals(1, driver.findElements(editBtn).size());
    }
}
