package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameField = By.id("login-form-username");
    private final By passwordField = By.id("login-form-password");
    private final By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIntoJira(){
        driver.findElement(usernameField).sendKeys(System.getenv("USER_NAME"));
        driver.findElement(passwordField).sendKeys(System.getenv("PW"));
        driver.findElement(loginBtn).click();
    }
}
