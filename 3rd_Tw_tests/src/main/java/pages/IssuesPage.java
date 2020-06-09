package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class IssuesPage {
    private final WebDriver driver;
    private final By pageName = By.xpath("//h1[@class='search-title']");

    public IssuesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageName(){
        return driver.findElement(pageName).getText();
    }
}
