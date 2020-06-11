package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IssuesPage {
    @FindBy(xpath = "//h1[@class='search-title']") private WebElement pageName;

    public IssuesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPageName(){
        return pageName.getText();
    }
}
