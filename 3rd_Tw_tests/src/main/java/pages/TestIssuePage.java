package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestIssuePage {
    private WebDriver driver;
    @FindBy(xpath = "//a[@id='key-val']") private WebElement issuesName;

    public TestIssuePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getIssueName(){
        return issuesName.getText();
    }

    public void navigateToTestIssuePage(){
        driver.navigate().to("https://jira.codecool.codecanvas.hu/browse/MTP-123?jql=key%20%3D%20MTP-123");
    }
}
