package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesPage {
    private final WebDriver driver;
    private final By pageName = By.xpath("//h1[@class='search-title']");
    private final By editBtn = By.id("edit-issue");

    public IssuesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkPageName(){
        String pageTitle = driver.findElement(pageName).getText();
        Assertions.assertEquals("Search", pageTitle);
    }

    public void isEditBtnPresent(){
        Assertions.assertEquals(1, driver.findElements(editBtn).size());
    }
}
