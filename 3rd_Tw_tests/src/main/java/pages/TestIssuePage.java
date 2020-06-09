package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestIssuePage {
    private WebDriver driver;
    private By issuesName = By.xpath("//a[@id='key-val']");

    public TestIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getIssueName(){
        return driver.findElement(issuesName).getText();
    }
}
