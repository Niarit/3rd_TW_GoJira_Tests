package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {

    private WebDriver driver;
    private By profilePic = By.xpath("//span[@class='aui-avatar aui-avatar-small']");
    private By logoutBtn = By.id("log_out");

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOutOfJira(){
        driver.findElement(profilePic).click();
        driver.findElement(logoutBtn).click();
    }
}
