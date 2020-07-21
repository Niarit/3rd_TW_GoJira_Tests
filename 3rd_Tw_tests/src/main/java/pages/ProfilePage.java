package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class ProfilePage {
    private BasePage basePage;
    @FindBy(id = "up-user-title-name") private WebElement profileName;

    public ProfilePage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public String getProfileName(){
        return profileName.getText();
    }

}
