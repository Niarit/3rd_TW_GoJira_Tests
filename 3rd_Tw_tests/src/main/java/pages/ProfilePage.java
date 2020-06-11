package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    @FindBy(id = "up-user-title-name") private WebElement profileName;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProfileName(){
        return profileName.getText();
    }

}
