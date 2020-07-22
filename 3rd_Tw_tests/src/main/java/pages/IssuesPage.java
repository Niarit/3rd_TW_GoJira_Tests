package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;


public class IssuesPage {
    private BasePage basePage;
    @FindBy(xpath = "//h1[@class='search-title']") private WebElement pageName;

    public IssuesPage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public String getPageName(){
        return pageName.getText();
    }
}

