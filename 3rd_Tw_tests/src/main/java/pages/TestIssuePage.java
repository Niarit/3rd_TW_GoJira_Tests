package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class TestIssuePage {
    private BasePage basePage;
    @FindBy(xpath = "//a[@id='key-val']") private WebElement issuesName;

    public TestIssuePage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public String getIssueName(){
        return issuesName.getText();
    }

    public void navigateToTestIssuePage(){
        basePage.getDriver().navigate().to(System.getenv("BASE_URL") + "/browse/MTP-123?jql=key%20%3D%20MTP-123");
    }
}
