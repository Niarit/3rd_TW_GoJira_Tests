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

    public void navigateToTestIssuePage(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/browse/MTP-123?jql=key%20%3D%20MTP-123");
    }
}
